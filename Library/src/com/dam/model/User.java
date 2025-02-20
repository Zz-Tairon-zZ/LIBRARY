package com.dam.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private List<Loan> activeLoans;
    private List<Loan> loanHistory;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.activeLoans = new ArrayList<>();
        this.loanHistory = new ArrayList<>();
    }

    public boolean canBorrow() {
        return activeLoans.size() < 3;
    }

    public void addLoan(Loan loan) {
        if (canBorrow()) {
            activeLoans.add(loan);
        } else {
            System.out.println("El usuario ha alcanzado el límite de préstamos.");
        }
    }

    public void removeLoan(Loan loan) {
        if (activeLoans.remove(loan)) {
            loan.setReturnDate(LocalDateTime.now());
            loanHistory.add(loan);
        }
    }

    public Loan getActiveLoan(Book book) {
        for (Loan loan : activeLoans) {
            if (loan.getBook().equals(book)) {
                return loan;
            }
        }
        return null;
    }

    public void borrowBook(Book book) {
        if (canBorrow() && book.isAvailable()) {
            Loan loan = new Loan(this, book, LocalDateTime.now(), null);
            addLoan(loan);
            book.borrowBook();
        }
    }

    public void returnBook(Book book) {
        Loan loanToReturn = getActiveLoan(book);
        if (loanToReturn != null) {
            removeLoan(loanToReturn);
            book.returnBook();
        } else {
            System.out.println("Este usuario no tiene prestado este libro.");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Loan> getActiveLoans() {
        return activeLoans;
    }

    public void setActiveLoans(List<Loan> activeLoans) {
        this.activeLoans = activeLoans;
    }

    public List<Loan> getLoanHistory() {
        return loanHistory;
    }

    public void setLoanHistory(List<Loan> loanHistory) {
        this.loanHistory = loanHistory;
    }
}
