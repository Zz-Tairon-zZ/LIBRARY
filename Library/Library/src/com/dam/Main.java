package com.dam;

import com.dam.model.Users;

class Main{
    public static void main(String[] args) {
        Users User1 = new Users(1, "79407161Y", "Alex", "Alejandro Hernández Ravelo");

        System.out.printf(User1.getUserDNI());

    }
}