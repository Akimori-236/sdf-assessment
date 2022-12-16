package mailmerge;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Letters {
    
    // PRINTER
    public static void printLetters(String templatefilename, List<Map<String, String>> CustomerList) throws IOException {
        List<String> template = Customer.readFile(templatefilename);
        
        for (Map<String, String> customer : CustomerList) {
            System.out.println("====================Letter Start====================");
            for (String line : template) {
                if (!line.contains("<<")) {
                    System.out.println(line);
                } else {
                    String filledIn = fillIn(line, customer);
                    System.out.println(filledIn);
                }

            }
            System.out.println("====================Letter End====================");
        }
    }

    // REPLACE <<VALUES>>
    public static String fillIn(String data, Map<String, String> customer) {
        String completed = "";
        String line = data;

        // GET CUSTOMER VALUE
        int start = line.indexOf("<<");
        int end = line.indexOf(">>");
        String toBeReplaced = line.substring(start, end)
                .replace("<<", "")
                .replace(">>", "");
        String replacement = customer.get(toBeReplaced).replace("\\n", "\n");

        // BUILD OUTPUT STRING
        completed += line.substring(0,start);
        completed += replacement;
        completed += line.substring(end+2);

        // RECURSION, IF MORE <<VALUES>> FOUND
        if (completed.contains("<<")) {
            completed = fillIn(completed, customer);
        }

        return completed;
    }
}
