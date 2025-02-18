package com.dam.controller;

import com.dam.model.Book;
import com.dam.model.Loan;
import com.dam.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryManager {
    private final Map<Integer, User> users = new HashMap<>();
    private final Map<String, Book> books = new HashMap<>();
    private final List<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void registerUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUserById(int id) {
        return users.get(id);
    }

    public Book getBookByIsbn(String isbn) {
        return books.get(isbn);
    }

    public void loanBook(User user, Book book) {
        if (user == null || book == null) {
            System.out.println("Usuario o libro no encontrado.");
            return;
        }
        if (user.getActiveLoans().size() >= 3) {
            System.out.println("El usuario ha alcanzado el límite de préstamos.");
            return;
        }
        if (book.getAvailableCopies() <= 0) {
            System.out.println("No hay copias disponibles del libro.");
            return;
        }
        Loan loan = new Loan(user, book, LocalDateTime.now(), LocalDateTime.now().plusDays(30));
        loans.add(loan);
        user.addLoan(loan);
        book.decreaseAvailableCopies();
        System.out.println("Libro prestado con éxito a " + user.getName());
    }

    public void returnBook(User user, Book book) {
        if (user == null || book == null) {
            System.out.println("Usuario o libro no encontrado.");
            return;
        }
        Loan loanToReturn = user.getActiveLoan(book);
        if (loanToReturn == null) {
            System.out.println("Este usuario no tiene prestado este libro.");
            return;
        }
        loans.remove(loanToReturn);
        user.removeLoan(loanToReturn);
        book.increaseAvailableCopies();
        System.out.println("Libro devuelto con éxito.");
    }

    public void showActiveLoans() {
        System.out.println("\n--- Préstamos Activos ---");
        for (Loan loan : loans) {
            System.out.println(loan);
        }
    }

    public void showUserHistory(int userId) {
        User user = getUserById(userId);
        if (user != null) {
            System.out.println("\nHistorial de préstamos de " + user.getName() + ":");
            for (Loan loan : user.getLoanHistory()) {
                System.out.println(loan);
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }
}
