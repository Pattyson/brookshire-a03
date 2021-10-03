/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Patrick Brookshire
 */

import java.util.Arrays;
import java.util.Scanner;

public class Solution24 {

    public static void main(String[] args){

        boolean end = true;
        while(end) {

            String word1;
            String word2;
            Scanner input = new Scanner(System.in);

            System.out.println("Welcome to the anagram machine.");
            System.out.println("What is your first word?");
            word1 = input.next();

            System.out.println("What is your second word?");
            word2 = input.next();

            isAnagram(word1, word2);

            String flag;
            System.out.println("Would you like to continue? Y/N");
            flag = input.next();

            if(flag.equals("y") || flag.equals("Y"))
                end = true;
            else
                end = false;
        }

    }


    public static void isAnagram(String word1, String word2) {

        String str1 = word1.replaceAll("\\s", "");
        String str2 = word2.replaceAll("\\s", "");
        boolean status = true;

        if (str1.length() != str2.length()) {
            status = false;
        } else {
            char[] ArrayS1 = str1.toLowerCase().toCharArray();
            char[] ArrayS2 = str2.toLowerCase().toCharArray();

            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);

            status = Arrays.equals(ArrayS1, ArrayS2);
        }
        if (status) {
            System.out.println(str1 + " and " + str2 + " are anagrams");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams");
        }
    }


}
