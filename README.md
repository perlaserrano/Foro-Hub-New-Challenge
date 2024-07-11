ForoHub

ForoHub es una aplicación de gestión de tópicos basada en Spring Boot que permite a los usuarios crear, leer, actualizar y eliminar tópicos en un sistema de foro.

Funcionalidades
Autenticación y Autorización: Implementación de autenticación de usuarios utilizando JSON Web Tokens (JWT).
Gestión de Tópicos: Operaciones CRUD para manejar tópicos, incluyendo creación, lectura, actualización y eliminación.
Seguridad: Configuración de Spring Security para proteger los endpoints y asegurar el acceso a las funcionalidades.
Tecnologías Utilizadas
Java
Spring Boot
Spring Security
Spring Data JPA
MySQL
JSON Web Tokens (JWT)

Uso
Una vez que la aplicación esté en funcionamiento, puedes interactuar con ella a través de Postman u otra herramienta similar para realizar peticiones HTTP a los diferentes endpoints proporcionados.

Ejemplo de Endpoints
POST /login: Inicia sesión y recibe un token JWT.
POST /topicos: Crea un nuevo tópico.
GET /topicos: Obtiene todos los tópicos.
PUT /topicos/{id}: Actualiza un tópico existente por su ID.
DELETE /topicos/{id}: Elimina un tópico por su ID.
Contribuciones
Las contribuciones al proyecto son bienvenidas. Si encuentras algún problema o tienes alguna mejora que proponer, por favor crea un issue o envía un pull request.

Licencia
Este proyecto está bajo la licencia MIT.
