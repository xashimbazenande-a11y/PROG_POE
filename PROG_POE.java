package com.mycompany.prog_poe;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PROG_POE {
    Scanner input = new Scanner(System.in);
     
    //username method//
    public boolean checkUserName(String username, boolean correctUsername) {
            
        while(correctUsername = false) {            
            //checking username properties//
            System.out.println("Enter a username.\n"
                + "Username must contain an underscore and be "
                + "no more than five characters long");            
            username = input.nextLine();
            
            if (username.length() > 0 && username.length() <= 5 && username.contains("_")) {
                
                correctUsername = true;
                System.out.println("Username successfully captured");
            }
            else {
                System.out.println("Username is not correctly formatted.\n"
                    + "Please ensure that your username contains an"
                    + "underscore and is no more than five characters"
                    + "in length.");
            }
        }
        return correctUsername;
    }
    
    //password method//
    public boolean checkPasswordComplexity(String password, boolean correctPassword) {
        boolean passwordCapital = false;
        boolean passwordNumber = false;
        boolean passwordSpecialChar = true;
        char passwordChar;
        
        while (correctPassword = false) {          
            //checking password length//
            if (password.length() <= 8) {
                
                //checking for capital letter//
                for(int i = 0; i < password.length(); i++) {
                    passwordChar = password.charAt(i);
                    if (Character.isUpperCase(passwordChar)) {
                        passwordCapital = true;
                    }
                    //checking for number//
                    else if (Character.isDigit(passwordChar)) {
                        passwordNumber = true;
                    }
                    //checking for special character//
                    Pattern my_pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
                    Matcher my_match = my_pattern.matcher(password);
                    boolean check = my_match.find();
                    if (check) {
                        passwordSpecialChar = true;
                    }
                }
                
                if (passwordCapital == true && passwordNumber == true && passwordSpecialChar == true) {
                    correctPassword = true;
                    System.out.println("Password successfully captured.");
                }
                else {
                        System.out.println("Password is not correctly formatted.\n"
                        + "Please ensure that the password contains at least"
                        + "eight characters, a capital letter, a number, and "
                        + "a special character.");
                }
                
            }
            else {
                System.out.println("Password is not correctly formatted.\n"
                        + "Please ensure that the password contains at least"
                        + "eight characters, a capital letter, a number, and "
                        + "a special character.");
            }
        }
        return correctPassword;
    }
    
    //cellphone number method//
    public boolean checkCellPhoneNumber(String phoneNumber, boolean correctNumberFormat) {
        
        //entering phone number//
        while (correctNumberFormat = false) {
            //checking phone number format//
            if (phoneNumber.length() == 13 && phoneNumber.contains("+27")) {
                correctNumberFormat = true;
                System.out.println("Cell phone number successfully added");
            }
            else {
                System.out.println("Cell phone number incorrectly formatted"
                        + "or does not contain international code.");
            }
        }
        return correctNumberFormat;
    }
    
    //user registration message//
    public String registerUser(boolean correctPassword, boolean correctUsername) {
        String registrationMessage;
        
        if (correctPassword == true && correctUsername == true) {
            registrationMessage = "You have been successfully registered";
        }
        else if (correctPassword == true && correctUsername == false) {
            registrationMessage = "Your username has been formatted incorrectly.";
        }
        else if (correctUsername == true && correctPassword == false) {
            registrationMessage = "Your password is not complex enough.";
        }
        else {
            registrationMessage = "Your username and password have not been formatted correctly.";
        }
        return registrationMessage;
    }
    
    public boolean loginUser(String username, String password, String phoneNumber) {
        boolean correctDetails = false;
        return correctDetails;
    }
    public void main(String[] args) {
        PROG_POE account = new PROG_POE();
        
        String username;
        boolean correctUsername = false;
        String password;
         boolean correctPassword = false;
        String phoneNumber;
        boolean correctNumberFormat = false;
        
        //creating username//  
        
        checkUserName(username, correctUsername);
        
        //creating password//
        System.out.println("Create a password.\n"
            + "Password must be at least eight characters long"
            + "and contain a capital letter, a number, and"
            + "a special character.");            
        password = input.nextLine();
        
        checkPasswordComplexity(password, correctPassword);
        
        //entering phone number//  
        System.out.println("Enter a cellphone number.\n"
            + "The number should begin with \"+27\" and contain ten digits.");   
        phoneNumber = input.nextLine();
        
        checkCellPhoneNumber(phoneNumber, correctNumberFormat);
        
        //Displays registration message//
        registerUser(correctPassword, correctUsername);
        
        //User login//
        String loginUsername;
        String loginPassword;
        String loginPhoneNumber;
        
    }
}


