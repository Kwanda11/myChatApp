/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;


/**
 *
 * @author kwanda
 */
//This class is used for user registration and login functions
public class Login {
            //These are variables that store the users data
            String firstName;
            String lastName;
            String username;
            String password;
            String phoneNumber;
            
            
            
            //Constructer sets default values for user data
            public Login() {
                this.firstName = "";
                this.lastName = "";
                this.username = "";
                this.password = "";
                this.phoneNumber = "";
                
            }
            
            //This returns stored username
            public String getUsername() {
                return username;
            }
            
            //This returns stored password
            public String getPassword() {
                return password;
            }
            //Returns stored cellphone number
            public String getPhoneNumber() {
                return phoneNumber;
            }
            
            /*this checks if username is valid (Must contain "_" and a
            maximum of 5 characters
            */
            public  boolean checkUserName(String username) {
                return username.contains("_") && username.length() <=5;
            }
           
            //Check if password is suitable/strong
            /*it should contain a capital letters, 8 or more characters and 
            a special character
            */
            public boolean checkPasswordComplexity(String password) {
                boolean hasCapital = false;
                boolean hasNumber = false;
                boolean hasSpecial = false;
                
                for (int i = 0; i < password.length(); i++) {
                    char c = password.charAt(i);
                    
                    if (Character.isUpperCase(c)) {
                        hasCapital = true;
                    } else if (Character.isDigit(c)) {
                        hasNumber = true;
                    } else if (!Character.isLetterOrDigit(c)) {
                        hasSpecial = true;
                    }
                }
                
                return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
            }
            
            /*Next step checks if user cellphone number is valid, it must start
            +27 and be 12 characters long 
            */
           
            public boolean checkCellPhoneNumber(String phone) {
                return phone.startsWith("+27") && phone.length() <= 12;
            }
            
            //Register user when all details are correct
            public String registerUser(String firstName, String lastName, String username, String password, String phoneNumber) {
                if (!checkUserName(username)) {
                    return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
                }
                
                if (!checkPasswordComplexity(password)) {
                    return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
                }
                
                if (!checkCellPhoneNumber(phoneNumber)) {
                    return "Cell phone number incorrectly formatted or does not contain international code.";
                }
                //store user detail
                this.firstName = firstName;
                this.lastName = lastName;
                this.username = username;
                this.password = password;
                this.phoneNumber = phoneNumber;
                
                return "User registered successfully.";
            }
            
            //This checks if login detail matches stored data
            public boolean loginUser(String username, String password) {
                return this.username.equals(username) && this.password.equals(password);
            }
            
            
            //This returns login message depending on success or failure
            public String returnLoginStatus(boolean success) {
                if (success) {
                    return "Welcome " + firstName + " " + lastName + " it is great to see you again.";
                } else {
                    return "Username or password incorrect, please try again.";
                }
            }
}
