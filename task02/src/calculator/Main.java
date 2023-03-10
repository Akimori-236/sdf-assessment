package calculator;

public class Main {
    public static void main(String[] args) {
        if (args.length != 0) {
            System.err.println("ERROR> This program takes in no command line arguments");
            return;
        }
        // CLEAR SCREEN
        System.out.print("\033[H\033[2J");
        System.out.flush();
        // START SHELL
        System.out.println("Welcome.");
        Calculator.startShell();
        System.out.println("Bye bye");
    }
}
