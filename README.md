Proyecto de Biblioteca - MVC

 - Descripción

Este proyecto es una implementación de un sistema de gestión de biblioteca utilizando 
el patrón de diseño Modelo-Vista-Controlador (MVC) en Java. 

Permite gestionar usuarios, libros y préstamos de manera eficiente.

 - Tecnologías Utilizadas

    Lenguaje: Java
    
    Paradigma: Programación Oriental a Objetos (POO)
    
    Patrón de diseño: MVC

 - Estructura del Proyecto

proyecto-biblioteca/
│-- src/
│   ├── com/dam/model/                               # Modelos de datos (User, Book, Loan)
│       ├── com/dam/model/User.java
│       ├── com/dam/model/Book.java
│       ├── com/dam/model/Loan.java
│       ├── com/dam/model/Genre.java                 # enum usado por la clase Book.java
│   ├── com/dam/controller/                          # Controladores (LibraryManager)
│       ├── com/dam/controller/LibraryManager.java
│   ├── com/dam/view/                                # Vista en consola (Console)
│       ├── com/dam/view/console.java
│-- README.md

 - Funcionalidades Principales

1º Gestión de Libros:

    Agregar libros a la biblioteca

    Consultar disponibilidad de libros

    Control de copias disponibles

2º Gestión de Usuarios:

    Registrar nuevos usuarios

    Obtener usuario por ID

    Gestión de Préstamos:

    Prestar libros a usuarios (máximo 3 por usuario)

    Registrar fecha de inicio y fin del préstamo

    Devolver libros y agregarlos al historial

    Consultar préstamos activos

3º Interfaz en Consola:

    Menú interactivo para realizar operaciones

    Uso

    Clonar el repositorio o descargar el código fuente.

    Compilar y ejecutar Console.java para interactuar con el sistema.

    Seguir las instrucciones en pantalla para gestionar libros y usuarios.

- Futuras Mejoras

    Implementación de una base de datos para persistencia de datos.

    Interfaz gráfica con JavaFX o Swing.

    Funcionalidad de reservas de libros.

    Autor

    Desarrollado por Alejandro Hernández Ravelo, Martín Oliver Pallarés y Juan Felipe Pérez 
    como práctica de programación en Java.
