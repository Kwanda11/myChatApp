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
     //========== PART 2 ==========

        //Only allow access if login is successful
        if (loggedIn) {

            System.out.println("\nWelcome to QuickChat.");

            //Ask user how many messages they want to send
            System.out.print("How many messages would you like to send? ");
            int totalMessages = input.nextInt();
            input.nextLine();

            int option = 0;

            //While loop runs until user quits
            while (option != 3) {

                //Display menu
                System.out.println("\n=== QUICKCHAT MENU ===");
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");

                System.out.print("Choose an option: ");
                option = input.nextInt();
                input.nextLine();

                //OPTION 1
                if (option == 1) {

                    //For loop for number of messages
                    for (int i = 1; i <= totalMessages; i++) {

                        System.out.println("\nMessage " + i);

                        //Get recipient number
                        System.out.print("Enter recipient number: ");
                        String recipient = input.nextLine();

                        //Get message
                        System.out.print("Enter your message: ");
                        String messageText = input.nextLine();

                        //Create Message object
                        Message message = new Message(i,
                                recipient,
                                messageText);

                        //Check recipient
                        if (message.checkRecipientCell()) {

                            System.out.println(
                                    "Cell phone number successfully captured.");

                        } else {

                            System.out.println(
                                    "Cell phone number is incorrectly formatted "
                                    + "or does not contain international code.");
                        
                            continue;
                        }

                        //Check message length
                        System.out.println(
                                message.checkMessageLength());

                        //Display message ID
                        System.out.println(
                                "Message ID generated: "
                                + message.getMessageID());

                        //Display message hash
                        System.out.println(
                                "Message Hash: "
                                + message.createMessageHash());

                        //Send message options
                        System.out.println("\nChoose an option:");
                        System.out.println("1) Send Message");
                        System.out.println("2) Disregard Message");
                        System.out.println("3) Store Message");

                        int messageChoice = input.nextInt();
                        input.nextLine();

                        //Display message status
                        System.out.println(
                                message.sentMessage(messageChoice));

                        //Display full message details
                        System.out.println("\n"
                                + message.printMessages());
                    }

                //OPTION 2
                } else if (option == 2) {

                    System.out.println("Coming Soon.");

                //OPTION 3
                } else if (option == 3) {

                    System.out.println("Thank you for using QuickChat.");

                } else {

                    System.out.println("Invalid option.");
                }
            }

        } else {

            System.out.println(
                    "You must log in successfully to continue.");
        }
    }
}

