package mailmerge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {

    // FILE INTAKE
    public static ArrayList<String> readFile(String filename) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bfr = new BufferedReader(fr);
            String line;
            // collect every line
            while (null != (line = bfr.readLine())) {
                line = line.trim();
                lines.add(line);
                // System.out.println(line);
            }
            bfr.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.err.println("ERROR> File not found");
        } catch (IOException e) {
            System.err.println("ERROR> Unable to read file");
            // e.printStackTrace();
        }

        return lines;
    }

    // CSV FILE INTAKE
    public static List<Map<String, String>> getAllCustomers(String csvfilename) {
        List<Map<String, String>> customerList = new ArrayList<>();
        List<String> dataList = readFile(csvfilename);

        // GET HEADERS
        String headers = dataList.get(0);
        dataList.remove(0);
        // System.out.println(headers);

        for (String data : dataList) {
            // System.out.println(data);
            Map<String, String> customer = makeCustomer(headers, data);
            customerList.add(customer);
        }

        return customerList;
    }

    // PARSE EACH ROW INTO ITS OWN MAP
    public static Map<String, String> makeCustomer(String headers, String datas) {
        Map<String, String> customer = new HashMap<>();
        List<String> headerList = Arrays.asList(headers.split(","));
        List<String> dataList = Arrays.asList(datas.split(","));

        for (int i=0; i<headerList.size(); i++) {
            customer.put(headerList.get(i).trim(), dataList.get(i).trim());
        }
        return customer;
    }

}
