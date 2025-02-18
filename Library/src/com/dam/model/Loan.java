package com.dam.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Loan {
    private User user;
    private Book book;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;


    public Loan(User user, Book book, LocalDateTime loanDate, LocalDateTime dueDate) {
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
    }

    public boolean isOverdue() {
        return LocalDateTime.now().isAfter(dueDate);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public void setReturnDate(LocalDateTime now) {
        this.dueDate = LocalDateTime.now().plusDays(30);
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return "Usuario: " + user.getName() + "\n" +
                "Libro: " + book.getTitle() + "\n" +
                "Fecha de préstamo: " + loanDate.format(dateFormat) + "\n" +
                "Fecha de vencimiento: " + dueDate.format(dateFormat) + "\n" +
                (isOverdue() ? "El préstamo está vencido." : "El préstamo está activo.") +
                "\n";
    }
}
