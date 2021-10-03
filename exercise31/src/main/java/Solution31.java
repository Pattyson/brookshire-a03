/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Patrick Brookshire
 */

import java.util.*;
import java.lang.*;

public class Solution31 {

    public static void main (String[] args)
    {
        int restingHR,age;
        Scanner input = new Scanner(System.in);
        restingHR = input.nextInt();
        age = input.nextInt();

        System.out.println("Resting Pulse: " + restingHR + " Age: " + age);

        int intensity = 55;
        System.out.println("Intensity | Rate ");
        System.out.println("------------------------");

        while(intensity<96){
            int Target = (((220 - age) - restingHR) * intensity) + restingHR;
            System.out.println(intensity+"% | "+Target +"bpm");
            intensity+=5;
        }
    }

}
