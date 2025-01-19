# Foro Hub

Foro Hub es una API REST desarrollada en Java utilizando Spring Boot. Este proyecto permite gestionar tópicos de un foro, con funcionalidades para crear, leer, actualizar y eliminar tópicos, además de implementar autenticación segura con tokens JWT.

## Tecnologías utilizadas
- **Java 17**
- **Spring Boot** (con dependencias como Spring Security, Spring Data JPA, Flyway, entre otras)
- **PostgreSQL**
- **IntelliJ IDEA**
- **Maven**

## Características principales

1. **Gestor de tópicos:**
   - Creación de nuevos tópicos con validación de unicidad por título y mensaje.
   - Listado de todos los tópicos.
   - Obtención de detalles de un tópico específico mediante su ID.
   - Actualización de tópicos existentes, con validación de cambios duplicados.
   - Eliminación de tópicos.

2. **Autenticación segura:**
   - Inicio de sesión mediante un endpoint de autenticación que genera un token JWT.
   - Validación de tokens para garantizar acceso seguro a recursos protegidos.

3. **Migraciones:**
   - Las tablas de la base de datos se gestionan mediante Flyway para garantizar la consistencia en los cambios de esquemas.

## Endpoints principales

### Tópicos
- **POST /topicos:** Registrar un nuevo tópico.
- **GET /topicos:** Obtener una lista de todos los tópicos.
- **GET /topicos/{id}:** Obtener los detalles de un tópico específico.
- **PUT /topicos/{id}:** Actualizar un tópico existente.
- **DELETE /topicos/{id}:** Eliminar un tópico por su ID.

### Autenticación
- **POST /login:** Autenticar un usuario y recibir un token JWT.

## Configuración de seguridad
La configuración de seguridad se realiza mediante Spring Security. El sistema utiliza:
- **Tokens JWT** generados con HMAC256 para autenticación de usuarios.
- Filtros de seguridad personalizados para validar tokens en cada solicitud.

## Ejecución del proyecto
1. Clona el repositorio y abre el proyecto en IntelliJ IDEA.
2. Configura PostgreSQL y asegúrate de que Flyway pueda aplicar las migraciones.
3. Establece las propiedades en el archivo `application.properties` para conectar a tu base de datos.
4. Ejecuta la aplicación y utiliza herramientas como Insomnia o Postman para probar los endpoints.

## Contribuciones
Si deseas contribuir a este proyecto, realiza un fork del repositorio, realiza los cambios y abre un Pull Request para su revisión.

**Autor:** Ana Paula Toledo Videla
