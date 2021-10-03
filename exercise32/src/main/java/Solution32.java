/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Patrick Brookshire
 */

import java.util.Scanner;

public class Solution32 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int guesses = 1;

        System.out.print("Enter the difficulty level (1, 2, or 3): ");
        int difficulty = input.nextInt();

        int number = generateRandomNumber(difficulty);

        System.out.print("I have my number. What's your guess? ");
        int guess = input.nextInt();

        while (guess != number) {

            if (guess > number) {
                System.out.print("Too high. Guess again: ");
            }
            if (guess < number) {
                System.out.print("Too low. Guess again: ");
            }

            guess = input.nextInt();
            guesses++;
        }

        System.out.println("You got it in " + guesses + " guesses!");

    }

    public static int generateRandomNumber (int difficulty) {

        double rand = 0;

        if (difficulty == 1) {
            rand = (Math.random() * ((10 - 1) + 1));
        }
        if (difficulty == 2) {
            rand = (Math.random() * ((100 - 1) + 1));
        }
        if (difficulty == 3) {
            rand = (Math.random() * ((1000 - 1) + 1));
        }

        return (int) Math.round(rand);
    }

}
