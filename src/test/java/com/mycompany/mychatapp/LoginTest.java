/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mychatapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kwanda
 */
//This class is used to test the login class
public class LoginTest {
    
    //This creates an object that lets us use the login method
   Login login = new Login();

    //This tests if the correct username works
    @Test
    public void testValidUsername() {
        assertTrue(login.checkUserName("kyl_1"));
        //If the username is valid it should return true
    }
    
    //This tests if an incorrect username fails
    @Test
    public void testInvalidUsername() {
        assertFalse(login.checkUserName("kyle!!!!!!!"));
        //Since the username contains incorrect and invalid characters,it should return false
    }
    
    //This tests if the strong password works
    @Test
    public void testValidPassword() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
        //it should return true since all requirements for the password are met
    }
    
    //This tests if the weak password fails
    @Test
    public void testInvalidPassword() {
        assertFalse(login.checkPasswordComplexity("password"));
        //it should return false since the password is too simple
    }
    
    //This tests if the phone number is correct
    @Test
    public void testValidPhoneNumber() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
        /*It should return true since the phone number meets all requirements
        and is in the correct format
        */
    }
    
    //This tests if the wrong phone number fails
    @Test
    public void testInvalidPhoneNumber() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
        /*It should return false since the phone number doesnt meet the requirements
        and is not in the correct format
        */
    }
    
    //This tests if the User registers successfully with correct details
    @Test
    public void testValidRegisterUser() {
        
        String result = login.registerUser("Kwanda","Siyeka", "kyl_1", "Ch&&sec@ke99!","+27838968976" );
        assertEquals("User registered successfully." ,result);
       
    }
    
    //This tests if registration fails with incorrect details
    @Test
    public void testInvalidRegisterUser() {
        String result = login.registerUser("Kwanda","Siyeka", "kyle!!!!!!!", "password", "08966553");
        assertNotEquals("User registered successfully." ,result);
       
    }
   
    //This tests if login works with correct username and password
    @Test
    public void testValidLogInUser() {
        
        login.registerUser("Kwanda", "Siyeka", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        
        assertTrue(login.loginUser("kyl_1","Ch&&sec@ke99!"));
    }
    //This tests if login fails with incorrect username and password
    @Test
    public void testInvalidLogInUser() {
        login.registerUser("Kwanda", "Siyeka", "kyle!!!!!!!", "password", "08966553");
        
        assertFalse(login.loginUser("wrongUser","wrongPass"));
    }

    }