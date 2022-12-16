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
        String csvfilename = args[0];
        String templatefilename = args[1];

        List<Map<String, String>> CustomerList = Customer.getAllCustomers(csvfilename);
        Letters.printLetters(templatefilename, CustomerList);
    }
}