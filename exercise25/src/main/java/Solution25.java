/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Patrick Brookshire
 */

import java.util.Scanner;

public class Solution25 {

    public static void main(String[] args) {

        String Password;


        Scanner input = new Scanner(System.in);
        int i, j = 0;
        int x = 0;
        String passwordreal = " ";
        String[] response = {"Enter Password", ""};

        String ans = "";

        for(i=0; i<2; i++){
            System.out.println(response[i] + ans);

            if(i!=0)
                break;
            passwordreal = input.next();
            ans = passwordValidator(passwordreal);
        }



    }

    public static String passwordValidator(String password) {

        String str1 = password;
        Scanner input = new Scanner(System.in);

        boolean hasLetter = false;
        boolean hasDigit = false;
        int choice = 1;
        String ans = "bruh";

        if (str1.length() > 0) {
            for (int i = 0; i < str1.length(); i++) {
                char x = password.charAt(i);
                if (Character.isLetter(x)) {

                    hasLetter = true;
                } else if (Character.isDigit(x)) {

                    hasDigit = true;
                }
                if (hasLetter && hasDigit) {

                    break;
                }
            }


        }

        if (hasDigit && str1.length() < 8)
            ans = "This is a very weak password.";
        else if (hasDigit && str1.length() >= 8)
            ans = "This is a weak password.";
        if (hasLetter && str1.length() < 8)
            ans = "This is a weak password.";
        else if(hasLetter && str1.length() >= 8)
            ans = "This is a weak password.";
        if (hasDigit && hasLetter && str1.length() < 8)
            ans = "This is a strong password.";
        if (hasDigit && hasLetter && str1.length() >= 8)
            ans = "This is a very strong password.";

        return ans;

    }
}
