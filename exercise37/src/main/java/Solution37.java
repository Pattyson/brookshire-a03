/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Patrick Brookshire
 */

import java.util.*;
import java.util.ArrayList;
import java.util.Random;

public class Solution37 {

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        List<Character> special = new ArrayList<>();
        String specialChars = "!@#&()–[{}]:;'?/*$^+=<>";
        Random random = new Random();
        for(char ch: specialChars.toCharArray()){
            special.add(ch);
        }

        String nums = "0123456789";
        for(char ch: specialChars.toCharArray()){
            special.add(ch);
        }
        List<Character> numbers = new ArrayList<>();
        for(char ch: nums.toCharArray()){
            numbers.add(ch);
        }

        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        List<Character> alphabets = new ArrayList<>();
        for(char ch: letters.toCharArray()){
            alphabets.add(ch);
        }

        System.out.print("What's the minimum length? ");
        int n = scan.nextInt();
        System.out.print("How many special characters? ");
        int specialCount = scan.nextInt();
        System.out.print("How many numbers? ");
        int numCount = scan.nextInt();

        String password = "";

        for(int i=0;i<n-specialCount-numCount;i++){
            password+= alphabets.get(random.nextInt(alphabets.size()));
        }

        for(int i=0;i<specialCount;i++){
            password+= special.get(random.nextInt(special.size()));
        }

        for(int i=0;i<numCount;i++){
            password+=numbers.get(random.nextInt(numbers.size()));
        }

        char arr[] = password.toCharArray();
        for(int i=arr.length-1;i>0;i--){
            int j = random.nextInt(i+1);
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        password = new String(arr);

        System.out.println("Your password is "+password);
    }

}
