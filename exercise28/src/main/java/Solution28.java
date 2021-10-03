/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Patrick Brookshire
 */

import java.util.*;
import java.lang.*;

public class Solution28 {

    public static void main (String[] args){

        Scanner sc=new Scanner(System.in);
        int count = 1;
        int sum = 0;
        int element;
        while(count <6){
            System.out.print("Enter the value: ");
            element =sc.nextInt();
            System.out.println(element);
            sum +=element;
            count++;
        }
        System.out.println("The total is " + sum);
    }
}
