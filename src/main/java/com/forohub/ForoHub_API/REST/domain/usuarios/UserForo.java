package com.forohub.ForoHub_API.REST.domain.usuarios;

import jakarta.persistence.*;
import lombok.*;
@Entity(name = "user_foro")
@Table(name = "users_foro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserForo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String userName;
    private String password;


}
