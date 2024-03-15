# Fleet Management Software API

## Índice

* [1. Resumen del proyecto](#1-resumen-del-proyecto)
* [2. Estructura del Proyecto](#2-estructura-del-proyecto)
* [3. Cómo Ejecutar](#3-cómo-ejecutar)
* [4. Tecnologías Utilizadas](#4-tecnologías-utilizadas)
* [5. Objetivos de aprendizaje](#5-objetivos-de-aprendizaje)
* [6. Nota](#6-nota)
* [7. Colaboradores](#7-colaboradores)
* [8. Licencia](#8-licencia)

***

## 1. Resumen del proyecto
Este proyecto implementa un Sistema de Gestión de Flotas para el seguimiento de taxis y sus trayectorias. Incluye funcionalidades para recuperar información sobre taxis y sus trayectorias a través de APIs RESTful. El sistema está construido utilizando Java con el framework Spring Boot e integra Swagger para la documentación de la API.


## 2. Estructura del Proyecto

1. **Paquete Controller:** Contiene controladores REST para gestionar taxis y trayectorias.
    - `TaxiController.java`: Controlador para gestionar los endpoints relacionados con taxis.
    - `TrajectoryController.java`: Controlador para gestionar los endpoints relacionados con trayectorias.

2. **Paquete Model:** Incluye clases de entidad que representan taxis y trayectorias.
    - `Taxi.java`: Clase de entidad que representa un taxi.
    - `Trajectory.java`: Clase de entidad que representa la trayectoria de un taxi.

3. **Paquete Repository:** Contiene repositorios Spring Data JPA para operaciones de base de datos.
    - `TaxiRepository.java`: Repositorio para realizar operaciones CRUD en taxis.
    - `TrajectoryRepository.java`: Repositorio para acceder a datos de trayectorias.

4. **Paquete Service:** Incluye interfaces de servicio y sus implementaciones.
    - `TaxiService.java` & `TaxiServiceImpl.java`: Interfaz y implementación del servicio para gestionar taxis.
    - `TrajectoryService.java` & `TrajectoryServiceImpl.java`: Interfaz e implementación del servicio para gestionar trayectorias.

5. **Paquetes de Pruebas:** Contiene pruebas JUnit para las clases controladoras.
    - `TaxiControllerTest.java`: Pruebas JUnit para `TaxiController`.
    - `TrajectoryControllerTest.java`: Pruebas JUnit para `TrajectoryController`.

6. **Clase de Aplicación Principal:**
    - `FleetManagementApplication.java`: Clase principal para ejecutar la aplicación Spring Boot.


## 3. Cómo Ejecutar
Para ejecutar el Sistema de Gestión de Flotas, sigue estos pasos:

1. Asegúrate de tener Maven y Java instalados en tu sistema.
2. Clona el repositorio del proyecto.
3. Navega hasta el directorio del proyecto en tu terminal.
4. Ejecuta el siguiente comando para compilar e iniciar la aplicación:Este proyecto implementa un Sistema de Gestión de Flotas para el seguimiento de taxis y sus trayectorias. Incluye funcionalidades para recuperar información sobre taxis y sus trayectorias a través de APIs RESTful. El sistema está construido utilizando Java con el framework Spring Boot e integra Swagger para la documentación de la API.

```bash

mvn spring-boot:run

```

5. Accede a la interfaz de usuario de Swagger para la documentación de la API en [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).


## 4. Tecnologías Utilizadas
- Java
- Spring Boot
- Spring Data JPA
- Swagger
- Maven


## 5. Objetivos de aprendizaje

### Java

- [ ] **Modificadores de acesso (public, private, protected)**

- [ ] **Variables**

- [ ] **Uso de condicionales**

- [ ] **Uso de bucles (Loops)**

- [ ] **Primitivos**

- [ ] **Datos primitivos vs no primitivos**

- [ ] **Cadenas**

- [ ] **Arreglos**

- [ ] **ArrayList**

- [ ] **HashMap**

- [ ] **HashSet**

- [ ] **JUnit**

- [ ] **Mockito**

- [ ] **Beans**

- [ ] **Inversión de Control**

- [ ] **Anotaciones**

- [ ] **Initializr**

  <details><summary>Links</summary><p>

  * [Spring Initializr](https://start.spring.io/)
</p></details>

- [ ] **Spring Boot**

  <details><summary>Links</summary><p>

  * [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
</p></details>

- [ ] **Controladores**

- [ ] **Servicios**

- [ ] **Spring Data JPA**

  <details><summary>Links</summary><p>

  * [Spring Data JPA - Reference Documentation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
</p></details>

- [ ] **Entidad**

- [ ] **Repositorio**

- [ ] **RestController**

- [ ] **RequestMapping**

- [ ] **spring-framework/spring-web/request-param**

- [ ] **Spring Test**

- [ ] **Hamcrest**

- [ ] **Configuración**

- [ ] **Esquema**

- [ ] **Entidad**

- [ ] **Tabla**

- [ ] **Columna**

- [ ] **Identificadores**

- [ ] **Asociaciones**

- [ ] **Colecciones**

- [ ] **Persistencia**

- [ ] **Consultas**

### Programación Orientada a Objetos (OOP)

- [ ] **Clases**

- [ ] **Objetos**

- [ ] **Métodos**

- [ ] **Atributos**

- [ ] **Constructores**

- [ ] **Encapsulamiento**

- [ ] **Abstracción**

- [ ] **Composición**

- [ ] **Interfaces**

- [ ] **Herencia (super, extends, override)**

- [ ] **Lenguaje de Modelado Unificado (UML, class diagrams)**

### SQL

- [ ] **Creación y modificación de tablas**

  <details><summary>Links</summary><p>

  * [SQL CREATE TABLE Statement - w3schools (en inglés)](https://www.w3schools.com/sql/sql_create_table.asp)
  * [CREATE TABLE Statement - PostgreSQL Docs (en inglés)](https://www.postgresql.org/docs/9.1/sql-createtable.html)
  * [ALTER TABLE Statement - PostgreSQL Docs (en inglés)](https://www.postgresql.org/docs/9.1/sql-altertable.html)
</p></details>

- [ ] **Operaciones CRUD (Create-Read-Update-Delete)**

  <details><summary>Links</summary><p>

  * [INSERT](https://www.postgresql.org/docs/9.5/sql-insert.html)
  * [SELECT](https://www.postgresql.org/docs/9.5/sql-select.html)
  * [UPDATE](https://www.postgresql.org/docs/9.1/sql-update.html)
  * [DELETE](https://www.postgresql.org/docs/8.1/sql-delete.html)
</p></details>

- [ ] **Borrado de tablas o bases de datos enteras con DROP**

  <details><summary>Links</summary><p>

  * [DROP TABLE](https://www.postgresql.org/docs/8.2/sql-droptable.html)
  * [DROP DATABASE](https://www.postgresql.org/docs/8.2/sql-dropdatabase.html)
</p></details>

### Bases de datos

- [ ] **Modelado de datos**

- [ ] **Conexión**

- [ ] **Índices y limitaciones**

### PostgreSQL

- [ ] **Tipos de datos**

  <details><summary>Links</summary><p>

  * [Chapter 8. Data Types - Docs (en inglés)](https://www.postgresql.org/docs/14/datatype.html)
</p></details>

- [ ] **Índices**

  <details><summary>Links</summary><p>

  * [Chapter 11. Indexes - Docs (en inglés)](https://www.postgresql.org/docs/14/indexes.html)
</p></details>


## 6. Nota
- El proyecto utiliza la autoconfiguración de Spring Boot para establecer conexiones de base de datos. Asegúrate de que tus configuraciones de base de datos estén correctamente establecidas en `application.properties`.


## 7. Colaboradores
- Giselle Cifuentes como parte de un curso de up skills de Java en Laboratoria.


## 8. Licencia
Este proyecto está bajo la [Licencia MIT](LICENSE).


