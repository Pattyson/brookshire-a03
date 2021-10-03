/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Patrick Brookshire
 */

import java.util.Random;
import java.util.Scanner;

public class Solution33 {

    public static void main(String[] args) {

        String[] responses = {"Yes","No","Maybe","Ask again later"};
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        System.out.println("What's your question?");
        String question = input.nextLine();//get the question

        int randomResponseIndex = random.nextInt(responses.length);

        String response = responses[randomResponseIndex];
        System.out.println();
        System.out.println(response);
        System.out.println();
    }
}
