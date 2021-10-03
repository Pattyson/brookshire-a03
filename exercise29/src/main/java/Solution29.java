/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Patrick Brookshire
 */

import java.util.*;
import java.lang.*;


public class Solution29 {


    public static void main (String[] args) {

        Scanner sc=new Scanner(System.in);
        int value;
        while(true){
            System.out.print("What is the rate of return? ");
            value = sc.nextInt();
            System.out.println(value);
            if(value>=1 && value<=72){
                System.out.println("it will take "+(72/value)+" year to double your initial investment");
                break;
            }
            else
            {
                System.out.println("Sorry this is not a valid input");
            }
        }
    }
}
