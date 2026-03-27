# Sistema de Gestión para Consultorio Odontológico 🦷 (en proceso de desarrollo)

Este proyecto es una aplicación web desarrollada como trabajo final del curso de **Java Web (JSP + JPA)** de la plataforma **TodoCode**. Permite gestionar la operativa diaria de una clínica dental, desde la administración de profesionales hasta la asignación de turnos.

##  Arquitectura y Tecnologías
La aplicación sigue el patrón **MVC (Modelo-Vista-Controlador)** para asegurar una separación clara de responsabilidades:

* **Backend:** Java EE (Jakarta EE) con **Servlets** para el control de la lógica de negocio.
* **Persistencia:** **JPA (Java Persistence API)** con EclipseLink para el mapeo de objetos a una base de datos relacional.
* **Frontend:** **JSP (JavaServer Pages)** y JSTL para la generación de interfaces dinámicas, integrando plantillas de Bootstrap para un diseño responsivo.
* **Base de Datos:** MySQL / lógica de persistencia configurada mediante `persistence.xml`.

## 🛠️ Funcionalidades Principales
* **Gestión de Usuarios:** Sistema de Login y control de acceso para administradores.
* **Administración de Profesionales:** CRUD completo de Odontólogos (datos personales, especialidades). (en desarrollo)
* **Registro de Pacientes:** Gestión de la base de datos de pacientes de la clínica. (en desarrollo)
* **Control de Turnos:** Asignación de citas vinculando Odontólogos y Pacientes en fechas y horarios específicos. (en desarrollo)

## 📂 Estructura del Proyecto
* `logica/`: Contiene las clases de entidad (`Odontologo`, `Paciente`, `Turno`, `Usuario`) y las controladoras de lógica.
* `persistencia/`: Clases controladoras de persistencia y el archivo `persistence.xml`.
* `servlets/`: Manejadores de las peticiones HTTP que conectan la vista con la lógica.
* `webapp/`: Archivos JSP y recursos estáticos (CSS/JS) para la interfaz de usuario.

---
**Desarrollado por Erika Antonella Miño** *Estudiante de Informática - UNLP*
