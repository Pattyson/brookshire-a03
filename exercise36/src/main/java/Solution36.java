/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Patrick Brookshire
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Solution36 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = 0;
        String str = "";
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; !str.equals("done"); i++) {
            System.out.print("Enter a number: ");
            str = input.nextLine();

            if (str.equals("done")) {
                break;
            }

            boolean isADigit = IsADigit(str);

            if (isADigit) {
                number = Integer.parseInt(str);
                arr.add(number);
            } else {
                System.out.println("Not a valid input. Try Again");
            }
        }

        System.out.print("Numbers:");
        for (int i = 0; i < arr.size(); i++) {
            if (i == arr.size() - 1) {
                System.out.print(" " + arr.get(i));
                break;
            }
            System.out.print(" " + arr.get(i) + ",");
        }

        System.out.printf("\nThe average is %.1f\n", Average(arr));
        System.out.println("The minimum is " + Minimum(arr));
        System.out.println("The maximum is " + Maximum(arr));
        System.out.printf("The standard deviation is %.2f\n", StandardDeviation(arr));
    }

    public static double Average(ArrayList<Integer> arr) {
        double sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        double average = sum / arr.size();
        return average;
    }

    public static int Minimum(ArrayList<Integer> arr) {
        int min = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (min > arr.get(i)) {
                min = arr.get(i);
            }
        }

        return min;
    }

    public static int Maximum(ArrayList<Integer> arr) {
        int max = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (max < arr.get(i)) {
                max = arr.get(i);
            }
        }

        return max;
    }

    public static double StandardDeviation(ArrayList<Integer> arr) {
        double sum = 0;
        double mean = 0;
        double std = 0;

        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }

        mean = sum / arr.size();

        for (int i = 0; i < arr.size(); i++) {
            std += Math.pow(arr.get(i) - mean, 2);
        }

        std = Math.sqrt(std / arr.size());

        return std;
    }

    public static boolean IsADigit(String str) {
        char[] digits =  str.toCharArray();
        boolean isADigit = true;
        for (int i = 0; i < digits.length; i++) {
            if (!Character.isDigit(digits[i])) {
                isADigit = false;
                break;
            }
        }
        return isADigit;
    }
}
