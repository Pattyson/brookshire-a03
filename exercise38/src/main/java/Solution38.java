/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Patrick Brookshire
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution38 {

    private static final Scanner input = new Scanner(System.in);

    public static char[] stringToArray(String numString){
        return numString.toCharArray();
    }

    public static List<Character> filterEvenNumbers(char[] numArr){
        List<Character> evenNumList = new ArrayList<>();
        for (int i = 0; i < numArr.length; i++){
            if (Character.getNumericValue(numArr[i])%2 == 0){
                evenNumList.add(numArr[i]);
            }
        }
        return evenNumList;
    }
    public static void output(List<Character> evenNumList){
        System.out.print("The even numbers are ");
        for (int i = 0; i < evenNumList.size(); i++){
            System.out.print(String.format("%c ", evenNumList.get(i)));
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter a list of numbers, separated by spaces: ");
        String numString = input.nextLine();
        output(filterEvenNumbers(stringToArray(numString)));
    }

}
