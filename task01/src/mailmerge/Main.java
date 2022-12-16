package mailmerge;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // >>> java -cp classes mailmerge.Main <csvfile> <templatefile>
        if (args.length != 2) {
            System.err.println("USAGE>>> java -cp classes mailmerge.Main <csvfile> <templatefile>");
            return;
        }
        // CLEAR SCREEN
        System.out.print("\033[H\033[2J");
        System.out.flush();
        // FILENAMES
        String csvfilename = args[0];
        String templatefilename = args[1];
        // PRINT LETTERS
        List<Map<String, String>> CustomerList = Customer.getAllCustomers(csvfilename);
        Letters.printLetters(templatefilename, CustomerList);
    }
}