package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 11 Solution
 *  Copyright 2021 Tyler Coleman
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        System.out.println("How many euros are you exchanging?");
        String eurosS = in.nextLine();
        System.out.println("What is the exchange rate?");
        String exRateS = in.nextLine();
        double euros = Double.parseDouble(eurosS);
        double exRate = Double.parseDouble(exRateS);
        //Based on c_to / c_from = rate
        Double dollars = euros * exRate;
        BigDecimal result = new BigDecimal(dollars).setScale(3, RoundingMode.HALF_UP);
        NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(Locale.US);
        usdCostFormat.setMinimumFractionDigits(1);
        usdCostFormat.setMaximumFractionDigits(2);
        System.out.printf("%.02f euros at an exchange rate of %.02f is\n%s U.S. dollars.", euros, exRate, usdCostFormat.format(result.doubleValue()));
    }
}
