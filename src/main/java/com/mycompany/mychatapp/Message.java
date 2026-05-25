/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

//This class handles all message features
public class Message {

    //Variables for message details
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;

    //Tracks total messages sent
    private static int totalMessages = 0;

    //Constructor
    public Message(int messageNumber, String recipient, String message) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;

        //Generate message ID
        this.messageID = generateMessageID();

        //Increase total messages
        totalMessages++;
    }

    //Generate random 10 digit message ID
    private String generateMessageID() {

        Random random = new Random();

        long number =
                1000000000L
                + (long) (random.nextDouble()
                * 9000000000L);

        return String.valueOf(number);
    }

    //Check if message ID is not more than 10 characters
    public boolean checkMessageID() {

        return messageID.length() <= 10;
    }

    //Check recipient cellphone number
    public boolean checkRecipientCell() {

        return recipient.startsWith("+27")
                && recipient.length() <= 12;
    }

    //Check message length
    public String checkMessageLength() {

        if (message.length() <= 250) {

            return "Message ready to send.";

        } else {

            int excess = message.length() - 250;

            return "Message exceeds 250 characters by "
                    + excess
                    + ", please reduce the size.";
        }
    }
     
    //Create message hash
    public String createMessageHash() {

        String[] words =
                message.trim().split(" ");

        String firstWord = words[0];
        String lastWord =
                words[words.length - 1];

        return messageID.substring(0, 2)
                + ":"
                + messageNumber
                + ":"
                + firstWord.toUpperCase()
                + lastWord.toUpperCase();
    }

    //Send message options
    public String sentMessage(int choice) {

        if (choice == 1) {

            return "Message successfully sent.";

        } else if (choice == 2) {

            return "Press 0 to delete the message.";

        } else if (choice == 3) {

            storeMessage();

            return "Message successfully stored.";

        } else {

            return "Invalid option.";
        }
    }

    //Store message in JSON file
    public void storeMessage() {

        try {

            FileWriter file =
                    new FileWriter(
                            "storedMessages.json",
                            true);

            file.write("{\n");

            file.write("\"MessageID\":\""
                    + messageID + "\",\n");
            
            file.write("\"MessageHash\":\"" + createMessageHash() + "\",\n");

            file.write("\"Recipient\":\""
                    + recipient + "\",\n");

            file.write("\"Message\":\""
                    + message + "\"\n");

            file.write("}\n\n");

            file.close();

        } catch (IOException e) {

            System.out.println(
                    "Error storing message.");
        }
    }

    //Display message details
    public String printMessages() {

        return "Message ID: "
                + messageID
                + "\nMessage Hash: "
                + createMessageHash()
                + "\nRecipient: "
                + recipient
                + "\nMessage: "
                + message;
    }

    //Returns total messages
    public static int returnTotalMessages() {

        return totalMessages;
    }

    //Getter for message ID
    public String getMessageID() {

        return messageID;
    }

    //Getter for message hash
    public String getMessageHash() {

        return createMessageHash();
    }

    //Getter for recipient
    public String getRecipient() {

        return recipient;
    }

    //Getter for message
    public String getMessage() {

        return message;
    }
    public static void resetTotalMessages() {
        
        totalMessages = 0;
    }
}
