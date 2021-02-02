package ua.com.foxminded.division;

import ua.com.foxminded.division.model.Result;
import ua.com.foxminded.division.text.Formatter;

/**
 * Date: Feb 01-2021 Class read at console sentence, give them on processed,
 * take processed sentence and print them.
 *
 * @author Aleksandr Serogin
 * @version 1.0001
 */

public class Main {

    /**
     * The main method off this application.
     *
     * @param args array of string arguments.
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.printf("You need to enter two values. Example: java Main 78945 4");
            System.exit(1);
        }
        Integer dividend = Integer.parseInt(args[0]);
        Integer divisor = Integer.parseInt(args[1]);
        Divider divider = new Divider();
        Result result = divider.divide(dividend, divisor);
        Formatter formatter = new Formatter();
        String output = formatter.format(result);
        System.out.printf(output);
    }
}