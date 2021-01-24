package ua.com.foxminded.integerdivision;

import java.util.Scanner;

/**
 * Date: Jan 23-2021
 * Class read at console sentence, give them on processed,
 * take processed sentence and print them.
 * @author Aleksandr Serogin
 * @version 1.0001
 */

public class Main {
    
    private static Scanner in = new Scanner(System.in); // create scanner

    /**
     * The main method off this application.
     * @param args array of string arguments.
     */

    public static void main(String[] args) {
        
        Division longDivision = new Division(); // create object class Division
        System.out.println("Write divident (max 10 digits):");
        int dividend = in.nextInt();  // write get nubers in divident
        System.out.println("Write division (max 10 digits):");
        int divisor = in.nextInt(); // write get nubers in division
        System.out.println("Result:");
        System.out.println(longDivision.makeDivision(dividend, divisor)); // print get result
     }

}
