/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Patrick Brookshire
 */

import java.util.*;
import java.lang.*;

public class Solution26 {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        System.out.print("What is your balance? ");
        double b = Double.parseDouble(in.nextLine());

        System.out.print("What is the APR in the card (as a percent)? ");
        double apr = Double.parseDouble(in.nextLine());

        System.out.print("What is the monthly payment you can make? ");
        double p = Double.parseDouble(in.nextLine());

        double i = apr/(365*100);
        double temp = b/p;
        double temp1 = Math.pow((1+i),30);
        double temp2 = Math.log(1+i);
        double temp3 = Math.log(1 + temp *(1 - temp1));

        int n = (int)Math.ceil((-1 * temp3) / (temp2*30));

        System.out.println("It will take you " + n + " months to pay off this card.");
    }

}
