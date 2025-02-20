package com.dam.view;

import com.dam.controller.LibraryManager;
import com.dam.model.Book;
import com.dam.model.Genre;
import com.dam.model.User;

import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        // Creación de libros
        Book book1 = new Book("9788445003022", "El Señor de los Aniello", "Tolkien", 1954, "Minotauro", Genre.FANTASIA, 5);
        Book book2 = new Book("9788498382662", "Harry Potter y la piedra filosofal", "J.K. Rowling", 2010, "Salamandra Bolsillo", Genre.FANTASIA, 4);
        Book book3 = new Book("9780140449136", "Moby Dick", "Herman Melville", 1851, "Penguin Classics", Genre.NOVELA, 3);

        // Creación de usuarios
        User user1 = new User(1, "Carlos Pérez");
        User user2 = new User(2, "Jose Miguel Hernán");
        User user3 = new User(3, "Ana Rodríguez");

        // Agregar libros y usuarios a la biblioteca
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.registerUser(user1);
        library.registerUser(user2);
        library.registerUser(user3);

        int option;
        do {
            System.out.println("\n--- Menú Biblioteca ---");
            System.out.println("1. Prestar un libro");
            System.out.println("2. Devolver un libro");
            System.out.println("3. Mostrar préstamos activos");
            System.out.println("4. Mostrar historial de préstamos de un usuario");
            System.out.println("5. Salir");
            System.out.println("-----------------------");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese ID del usuario: ");
                    int userId = scanner.nextInt();
                    System.out.print("Ingrese ISBN del libro: ");
                    String isbn = scanner.next();
                    User user = library.getUserById(userId);
                    if (user != null) {
                        library.loanBook(user, library.getBookByIsbn(isbn));
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese ID del usuario: ");
                    userId = scanner.nextInt();
                    System.out.print("Ingrese ISBN del libro: ");
                    isbn = scanner.next();
                    user = library.getUserById(userId);
                    if (user != null) {
                        library.returnBook(user, library.getBookByIsbn(isbn));
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 3:
                    library.showActiveLoans();
                    break;
                case 4:
                    System.out.print("Ingrese ID del usuario: ");
                    userId = scanner.nextInt();
                    user = library.getUserById(userId);
                    if (user != null) {
                        library.showUserHistory(userId);
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (option != 5);

        scanner.close();
    }
}
