package com.dam.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Users {
    // Fields (follow Java naming conventions: camelCase)
    private final UUID userID = UUID.randomUUID();
    private String userDni;
    private String userEmail;
    private final String userName;
    private final String userFullName;
    private final LocalDateTime inscriptionDateTime = LocalDateTime.now();
    private final List<String> loanedBooks; // Use List interface for flexibility

    // Constructor with essential fields (email as required)
    public Users(String userDni, String userName, String userFullName, String userEmail) {
        this.userDni = userDni;
        this.userName = userName;
        this.userFullName = userFullName;
        this.userEmail = userEmail;
        this.loanedBooks = new ArrayList<>(); // Initialize to avoid null
    }

    //--- Getters ---//
    public String getUserDni() { return userDni; }
    public String getUserEmail() { return userEmail; }
    public String getUserName() { return userName; }
    public String getUserFullName() { return userFullName; }
    public LocalDateTime getInscriptionDateTime() { return inscriptionDateTime; }
    public List<String> getLoanedBooks() { return new ArrayList<>(loanedBooks); } // Return copy for encapsulation

    //--- Setters with validation ---//
    public void setUserDni(String userDni) {
        Objects.requireNonNull(userDni, "DNI cannot be null");
        if(userDni.length() != 9) throw new IllegalArgumentException("Invalid DNI format");
        this.userDni = userDni;
    }

    public void setUserEmail(String userEmail) {
        if(!isValidEmail(userEmail)) throw new IllegalArgumentException("Invalid email format");
        this.userEmail = userEmail;
    }

    //--- Business logic methods ---//
    public boolean hasActiveLoans() {
        return !loanedBooks.isEmpty();
    }

    public void addLoanedBook(String bookId) {
        Objects.requireNonNull(bookId, "Book ID cannot be null");
        loanedBooks.add(bookId);
    }

    public boolean removeLoanedBook(String bookId) {
        return loanedBooks.remove(bookId);
    }

    //--- Helper methods ---//
    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$");
    }

    @Override
    public String toString() {
        return "User [ID=" + userID + ", Name=" + userFullName + ", Email=" + userEmail + ", Loans=" + loanedBooks.size() + "]";
    }
}