package calculator;

import java.io.Console;

public class Calculator {
    public static void startShell() {
        Double last = 0.0d;
        Console cons = System.console();

        while (true) {
            String userInput = cons.readLine("> ");
            // EXIT
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }
            // SUB IN LAST NUMBER
            if (userInput.contains("$last")) {
                userInput = userInput.replace("$last", Double.toString(last));
                // System.out.println(userInput);
            }

            // GETTING PARAMETERS
            Double num1 = 0.0d;
            Double num2 = 0.0d;
            String[] parameters = userInput.trim().split("\\s+");
            if (parameters.length != 3) {
                System.err.println("ERROR> Invalid numbers/usage\nUsage>>> 1 + 1");
            } else {
                try {
                    num1 = Double.parseDouble(parameters[0]);
                    num2 = Double.parseDouble(parameters[2]);
                    switch (parameters[1]) {
                        case "+":
                            last = num1 + num2;
                            break;
                        case "-":
                            last = num1 - num2;
                            break;
                        case "*":
                            last = num1 * num2;
                            break;
                        case "/":
                            last = num1 / num2;
                            break;
                        default:
                            System.err.println("ERROR> Unsupported operator");
                    }
                    if (last % 1 == 0) {
                        System.out.println(Math.round(last));
                    } else {
                        System.out.println(last);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("ERROR> Invalid numbers/usage\nUsage>>> 1 + 1");
                }
            } // end if
        }
    }
}
