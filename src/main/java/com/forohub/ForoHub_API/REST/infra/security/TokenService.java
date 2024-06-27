package com.forohub.ForoHub_API.REST.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.forohub.ForoHub_API.REST.domain.usuarios.UserAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Value("${api.security.secret}")
    private String apiSecret;
    public String generateToken(UserAPI user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("forohub")
                    .withSubject(user.getLogin())
                    .withClaim("id", user.getId())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Invalid Signing configuration / Couldn't convert Claims.");
        }
    }

    public String getSubject(String token) {
        if (token == null){
            throw new RuntimeException();
        }
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("forohub")
                    .build()
                    .verify(token);
            verifier.getSubject();

        } catch (JWTVerificationException exception) {
            System.out.println(exception.toString());
        }
        if (verifier == null || verifier.getSubject() == null){
            throw new RuntimeException("Token invalid");
        }
        return verifier.getSubject();

    }
}
