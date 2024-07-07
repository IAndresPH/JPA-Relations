# Spring Boot JPA Relationships

 .--.             _               .---.       .-.         .-.  _
: .--'           :_;              : .; :      : :        .' `.:_;
`. `. .---. .--. .-.,-.,-. .--.   :   .' .--. : :   .--. `. .'.-. .--. ,-.,-. .--.
 _`, :: .; `: ..': :: ,. :' .; :  : :.`.' '_.': :_ ' .; ; : : : :' .; :: ,. :`._-.'
`.__.': ._.':_;  :_;:_;:_;`._. ;  :_;:_;`.__.'`.__;`.__,_;:_; :_;`.__.':_;:_;`.__.'
      : :                  .-. :
      :_;                  `._.'

Este proyecto de Spring Boot demuestra cómo manejar las relaciones básicas de JPA (Java Persistence API) en una base de datos relacional. Incluye ejemplos de relaciones uno a uno, uno a muchos, muchos a uno y muchos a muchos.

## Estructura del Proyecto

### Entidades

1. **Association**
    - Representa una asociación deportiva.
    - Relación uno a muchos con `Club`.

2. **Club**
    - Representa un club deportivo.
    - Relación uno a uno con `Coach`.
    - Relación uno a muchos con `Player`.
    - Relación muchos a uno con `Association`.
    - Relación muchos a muchos con `Competition`.

3. **Coach**
    - Representa un entrenador.
    - Relación uno a uno con `Club`.

4. **Player**
    - Representa un jugador.
    - Relación muchos a uno con `Club`.

5. **Competition**
    - Representa una competición deportiva.
    - Relación muchos a muchos con `Club`.

### Relaciones

- **Uno a Uno**: `Club` y `Coach`.
- **Uno a Muchos**: `Association` y `Club`.
- **Muchos a Uno**: `Player` y `Club`.
- **Muchos a Muchos**: `Club` y `Competition`.

## Configuración del Proyecto

### Prerrequisitos

- Java 17
- Maven 3.6.0 o superior
- Base de datos MySQL (o cualquier base de datos relacional de tu elección)

### Configuración de la Base de Datos

Asegúrate de tener una base de datos configurada y actualiza `application.properties` con tus credenciales de la base de datos:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Ejecución del Proyecto

Clona el repositorio:

   ```bash
   git clone https://github.com/tu_usuario/spring-boot-jpa-relationships.git
   cd spring-boot-jpa-relationships
   ```

### Dependencias

El proyecto utiliza las siguientes dependencias, especificadas en el archivo `pom.xml`:

- `spring-boot-starter-data-jpa`
- `spring-boot-starter-web`
- `mysql-connector-j`
- `lombok`
- `spring-boot-starter-test`

### Información Adicional

- **Spring Boot Version**: 3.2.7
- **Java Version**: 17
