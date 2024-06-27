# API Foro Hub

_ Un espacio donde todos los participantes de una plataforma pueden plantear sus preguntas y respuestas sobre determinados tópicos. este es mi proyecto, llamado ForoHub: en él, vamos a replicar este proceso a nivel de back end y, para eso, crearemos una API REST usando Spring.

Nuestra API se centrará específicamente en los tópicos y sus respuestas, y debe permitir a los usuarios:

Crear un nuevo tópico/ respuesta ;
Mostrar todos los tópicos/ respuestas creados;
Mostrar un tópico/ respuesta específico;
Actualizar un tópico/ respuesta;
Eliminar un tópico/ respuesta.
 CRUD* (CREATE, READ, UPDATE, DELETE)._

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._

Mira **Deployment** para conocer como desplegar el proyecto.


### Pre-requisitos 📋

_IntelliJ IDEa, Insomnia (para pruebas) , PgAdmin4._

```
https://www.jetbrains.com/es-es/idea/download/?section=windows
```
```
https://www.jetbrains.com/es-es/idea/download/?section=windows
```
```
https://www.postgresql.org/download/
```

### Instalación 🔧

_Una serie de ejemplos paso a paso que te dice lo que debes ejecutar para tener un entorno de desarrollo ejecutandose_

_Clone este repositorio_

```
https://github.com/SamuelVelascoH/ForoHub-API-REST.git
```

_Y abra el proyecto desde IntelliJ IDEA (Open new file) con la ruta de su repositorio local, debera iniciar el servicio.
las URI para las pruebas son las siguientes_

_Para crear un usuario de tipo UserForo (debera usar el metodo HTTP: POST, el cuerpo de tipo JSON y la URI) a continuacion:_
```
 http://localhost:8080/user
```
 ```
{
    "email" : "tu email" ,
	"userName" : "tu usuario" ,
	"password" : "tu contraseña"
}
```
_Para actualizar un usuario de tipo UserForo (debera usar el metodo HTTP: PUT, el cuerpo de tipo JSON y la URI) a continuacion:_
```
http://localhost:8080/user/{id}
```
```
{ "id" : "id del usuario" ,
	"email" : "tu nuevo email" ,
	"userName" : "tu nuevo usduario" ,
	"password" : "tu nueva contraseña"
}
```
_Para listar todos los usuarios de tipo UserForo (debera usar el metodo HTTP: GET y la URI) a continuacion::_
```
http://localhost:8080/user
```
_Para obtener un usuario de tipo UserForo por su ID (debera usar el metodo HTTP: GET la URI(el "id" apunta a el user a actualizar)) a continuacion:_
```
http://localhost:8080/user/{id}
```
_Para eliminar un usuario de tipo UserForo (debera usar el metodo HTTP: DELETE, el cuerpo de tipo JSON y la URI (el "id" apunta a el user a actualizar)) a continuacion:_
```
http://localhost:8080/user/{5}
```
_Para crear un Topico (debera usar el metodo HTTP: POST, el cuerpo de tipo JSON y la URI) a continuacion:_
```
http://localhost:8080/topics
```
```
{
	"title" : "tu titulo" ,
	"body" : "tu tema" ,
	"courseName" : "tu nombre de curso"
}
```
_Para actualizar un Topico (debera usar el metodo HTTP: PUT, el cuerpo de tipo JSON y la URI) a continuacion:_
```
http://localhost:8080/topics/{id}
```
```
{ "id" : "id del topico" , 
	"title" : "tu nuevo titulo" ,
	"body" : "tu nuevo tema" ,
	"courseName" : "nombre del curso"
}
```
_Para listar todos Topicos (debera usar el metodo HTTP: GET, el cuerpo de tipo JSON y la URI) a continuacion:_
```
http://localhost:8080/topics
```
_Para obtener un Topico por su ID (debera usar el metodo HTTP: GET, el cuerpo de tipo JSON y la URI) a continuacion:_
```
http://localhost:8080/topics/{id}
```
_Para eliminar un Topico (debera usar el metodo HTTP: DELETE, el cuerpo de tipo JSON y la URI) a continuacion:_
```
http://localhost:8080/topics/{id}
```
_Para crear una repuesta (el "id" apunta hacia el topico al que va dirigida la respuesta), (debera usar el metodo HTTP: POST, el cuerpo de tipo JSON y la URI) a continuacion_
```
http://localhost:8080/response/{id}
```
_Para actualizar una repuesta (el "id" apunta hacia la respuesta a actualizar), (debera usar el metodo HTTP: PUT, el cuerpo de tipo JSON y la URI) a continuacion_
```
http://localhost:8080/response/{id}
```
_Para listar todas las repuestas (debera usar el metodo HTTP: GET, el cuerpo de tipo JSON y la URI) a continuacion_
```
http://localhost:8080/response
```
_Para obtener una repuesta por su ID (debera usar el metodo HTTP: GET, el cuerpo de tipo JSON y la URI) a continuacion_
```
http://localhost:8080/response/{id}
```
_Para eliminar una respuesta (debera usar el metodo HTTP: DELETE, el cuerpo de tipo JSON y la URI) a continuacion_
```
http://localhost:8080/response/{id}
```

_Finaliza con un ejemplo de cómo obtener datos del sistema o como usarlos para una pequeña demo_

## Ejecutando las pruebas ⚙️

_Explica como ejecutar las pruebas automatizadas para este sistema_

### Analice las pruebas end-to-end 🔩

_Explica que verifican estas pruebas y por qué_

```
Da un ejemplo
```

### Y las pruebas de estilo de codificación ⌨️

_Explica que verifican estas pruebas y por qué_

```
Da un ejemplo
```

## Despliegue 📦

_Agrega notas adicionales sobre como hacer deploy_

## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - El framework web usado
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [ROME](https://rometools.github.io/rome/) - Usado para generar RSS

## Contribuyendo 🖇️

Por favor lee el [CONTRIBUTING.md](https://gist.github.com/villanuevand/xxxxxx) para detalles de nuestro código de conducta, y el proceso para enviarnos pull requests.

## Wiki 📖

Puedes encontrar mucho más de cómo utilizar este proyecto en nuestra [Wiki](https://github.com/tu/proyecto/wiki)

## Versionado 📌

Usamos [SemVer](http://semver.org/) para el versionado. Para todas las versiones disponibles, mira los [tags en este repositorio](https://github.com/tu/proyecto/tags).

## Autores ✒️

_Menciona a todos aquellos que ayudaron a levantar el proyecto desde sus inicios_

* **Andrés Villanueva** - *Trabajo Inicial* - [villanuevand](https://github.com/villanuevand)
* **Fulanito Detal** - *Documentación* - [fulanitodetal](#fulanito-de-tal)

También puedes mirar la lista de todos los [contribuyentes](https://github.com/your/project/contributors) quíenes han participado en este proyecto. 

## Licencia 📄

Este proyecto está bajo la Licencia (Tu Licencia) - mira el archivo [LICENSE.md](LICENSE.md) para detalles

## Expresiones de Gratitud 🎁

* Comenta a otros sobre este proyecto 📢
* Invita una cerveza 🍺 o un café ☕ a alguien del equipo. 
* Da las gracias públicamente 🤓.
* Dona con cripto a esta dirección: `0xf253fc233333078436d111175e5a76a649890000`
* etc.



---
⌨️ con ❤️ por [Villanuevand](https://github.com/Villanuevand) 😊
