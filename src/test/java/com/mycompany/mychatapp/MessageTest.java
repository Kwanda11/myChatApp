/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//This class tests the Message class
public class MessageTest {

    //Test valid message length
    @Test
    public void testValidMessageLength() {

        Message message = new Message(
                1,
                "+27838968976",
                "Hello");

        assertEquals(
                "Message ready to send.",
                message.checkMessageLength());
    }

    //Test invalid message length
    @Test
    public void testInvalidMessageLength() {

        String longMessage =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        Message message = new Message(
                1,
                "+27838968976",
                longMessage);

        assertTrue(
                message.checkMessageLength()
                        .contains("Message exceeds 250 characters"));
    }

    //Test valid recipient number
    @Test
    public void testValidRecipientCell() {

        Message message = new Message(
                1,
                "+27838968976",
                "Hello");

        assertTrue(message.checkRecipientCell());
    }

    //Test invalid recipient number
    @Test
    public void testInvalidRecipientCell() {

        Message message = new Message(
                1,
                "08966553",
                "Hello");

        assertFalse(message.checkRecipientCell());
    }

    //Test message hash creation
    @Test
    public void testCreateMessageHash() {

        Message message = new Message(
                0,
                "+27838968976",
                "Hi tonight");

        String hash = message.createMessageHash();

        assertTrue(hash.contains(":0:HITONIGHT"));
    }

    //Test message ID
    @Test
    public void testMessageID() {

        Message message = new Message(
                1,
                "+27838968976",
                "Hello");

        assertTrue(message.checkMessageID());
    }

    //Test send message option
    @Test
    public void testSendMessageOption() {

        Message message = new Message(
                1,
                "+27838968976",
                "Hello");

        assertEquals(
                "Message successfully sent.",
                message.sentMessage(1));
    }

    //Test disregard option
    @Test
    public void testDisregardMessageOption() {

        Message message = new Message(
                1,
                "+27838968976",
                "Hello");

        assertEquals(
                "Press 0 to delete the message.",
                message.sentMessage(2));
    }

    //Test store message option
    @Test
    public void testStoreMessageOption() {

        Message message = new Message(
                1,
                "+27838968976",
                "Hello");

        assertEquals(
                "Message successfully stored.",
                message.sentMessage(3));
    }

    //Test total number of messages
    @Test
    public void testReturnTotalMessages() {

        Message.resetTotalMessages();

        new Message(1,
                "+27838968976",
                "Hello");

        new Message(2,
                "+27838968976",
                "Hello");

        new Message(3,
                "+27838968976",
                "Hello");

        new Message(4,
                "+27838968976",
                "Hello");

        new Message(5,
                "+27838968976",
                "Hello");

        assertEquals(
                5,
                Message.returnTotalMessages());
    }
}