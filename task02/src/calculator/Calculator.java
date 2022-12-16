package calculator;

import java.io.Console;

public class Calculator {
    public static void startShell() {
        Double $last = 0d;
        Console cons = System.console();

        while (true) {
            String userInput = cons.readLine("> ");
            // EXIT
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }
            if (userInput.contains("$last")) {
                userInput.replace("$last", Double.toString($last));
            }
            String[] parameters = userInput.split(" ");
            Double num1 = Double.parseDouble(parameters[0]);
            Double num2 = Double.parseDouble(parameters[2]);
            String operator = parameters[1];

            switch (operator) {
                case "+":
                    break;
                case "-":
                    break;
                case "*":
                    break;
                case "/":
                    break;
                default:
                    System.err.println("ERROR> Unsupported operator");
            }
        }
    }
}
