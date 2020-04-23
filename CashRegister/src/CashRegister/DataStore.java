package CashRegister;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private static DataStore single_instance = null;

    String neededFiles[] = {"products.csv", "employees.csv", "paymentMethods.csv", "transactions.csv", "audit.csv"};

    public DataStore(){
        for (int i = 0; i < neededFiles.length; i++) {
            if (!Files.exists(Paths.get(neededFiles[i]))){
                writeUsingBufferedWriter("", neededFiles[i]);
            }
        }
    }

    public static DataStore getInstance()
    {
        if (single_instance == null)
            single_instance = new DataStore();

        return single_instance;
    }

    public static void writeUsingBufferedWriter(String text, String fileName) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(fileName, true))) {
            buffer.write(text);
            buffer.newLine();
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void overWriteUsingBufferedWriter(String text, String fileName) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(fileName))) {
            buffer.write(text);
            buffer.newLine();
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readUsingBufferedWriter(String fileName) {
        List<String> lines = new ArrayList<String>();

        try (BufferedReader buffer = new BufferedReader(new FileReader(fileName))) {

            String line = buffer.readLine();
            while (line != null) {
                if (line.length() > 0)
                {
                    //System.out.println(line);
                    lines.add(line);
                }
                line = buffer.readLine();
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

}
