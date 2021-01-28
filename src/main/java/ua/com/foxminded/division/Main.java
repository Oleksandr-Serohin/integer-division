package ua.com.foxminded.division;

import ua.com.foxminded.division.math.*;
import ua.com.foxminded.division.model.Result;
import ua.com.foxminded.division.text.*;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.printf( "You need to enter two values. Example: java Main 78945 4");
            System.exit(1);
        }
        Integer dividend = Integer.parseInt(String.valueOf(630440));
        Integer divisor = Integer.parseInt(String.valueOf(610));
        Divider divider = new Divider();
        Result result = divider.divide(dividend, divisor);
        Formatter formatter = new Formatter();
        String output = formatter.format(result);
        System.out.printf(output);
    }
}