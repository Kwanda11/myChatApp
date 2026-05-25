/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;

import java.util.Scanner;

//This class runs the main program
public class MainApp {

    public static void main(String[] args) {

        //Scanner for user input
        Scanner input = new Scanner(System.in);

        //Create Login object
        Login login = new Login();

        //========== REGISTRATION SECTION ==========

        //Get first name
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();
        
        //Get last name
        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();
        
        //Get username
        System.out.print("Enter a username(must contain _ and be no more than 5 characters): ");
        String username = input.nextLine();

        //Get password
        System.out.print("Enter a password(8+ characters, capital letter, number, special character): ");
        String password = input.nextLine();

        //Get phone number
        System.out.print("Enter your South African phone number (+27...): ");
        String phone = input.nextLine();

        //Register user
        String response = login.registerUser(firstName, lastName, username, password, phone);

        //Display registration result
        System.out.println(response);

        //========== LOGIN SECTION ==========

        System.out.println("\n=== USER LOGIN ===");

        //Get login username
        System.out.print("Enter your username(must contain _ and be no more than 5 characters): ");
        String loginUsername = input.nextLine();

        //Get login password
        System.out.print("Enter your password(8+ characters, capital letter, number, special character): ");
        String loginPassword = input.nextLine();

        //Check login
        boolean loggedIn = login.loginUser(loginUsername, loginPassword);

        //Display login result
        String loginMessage = login.returnLoginStatus(loggedIn);

        System.out.println(loginMessage);
    }
}