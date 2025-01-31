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

}
