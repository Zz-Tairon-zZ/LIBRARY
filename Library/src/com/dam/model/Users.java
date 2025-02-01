package com.dam.model;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Users {
    private int UserID;
    private String UserDNI;
    private String UserName;
    private String UserFullName;
    private final LocalDateTime InscriptionDateTime = LocalDateTime.now();
    private boolean ActiveLoans;
    private ArrayList<String> LoanedBooks;

    public Users(int userID, String userDNI, String userName, String userFullName) {
        UserID = userID;
        UserDNI = userDNI;
        UserName = userName;
        UserFullName = userFullName;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserDNI() {
        return UserDNI;
    }

    public void setUserDNI(String userDNI) {
        UserDNI = userDNI;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserFullName() {
        return UserFullName;
    }

    public void setUserFullName(String userFullName) {
        UserFullName = userFullName;
    }

    public LocalDateTime getInscriptionDateTime() {
        return InscriptionDateTime;
    }

    public boolean isActiveLoans() {
        return ActiveLoans;
    }

    public void setActiveLoans(boolean activeLoans) {
        ActiveLoans = activeLoans;
    }

    public ArrayList<String> getLoanedBooks() {
        return LoanedBooks;
    }

    public void setLoanedBooks(ArrayList<String> loanedBooks) {
        LoanedBooks = loanedBooks;
    }
}
