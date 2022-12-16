package mailmerge;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // >>> java -cp classes mailmerge.Main <csvfile> <templatefile>
        if (args.length != 2) {
            System.err.println("USAGE>>> java -cp classes mailmerge.Main <csvfile> <templatefile>");
            return;
        }

        // FILENAMES
        String csvfilename = args[0];
        String templatefilename = args[1];

        // PRINT LETTERS
        try {
            List<Map<String, String>> CustomerList = Customer.getAllCustomers(csvfilename);
            Letters.printLetters(templatefilename, CustomerList);
        } catch (FileNotFoundException e) {
            System.err.println("ERROR> File not found");
        } catch (IOException e) {
            System.err.println("ERROR> Unable to read file");
            // e.printStackTrace();
        }

    }
}