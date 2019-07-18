import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

//		Check arguments
        if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.TEXT_FILE_NAME)));
                String string = bufferedReader.readLine();
                String split[] = string.split(",");
                for (String printList : split) {
                    System.out.println(printList);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.TEXT_FILE_NAME)));
                String string = bufferedReader.readLine();
                String split[] = string.split(",");
                Random random = new Random();
                int y = random.nextInt(4);
                System.out.println(split[y]);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Constants.TEXT_FILE_NAME, true));
                String substring = args[0].substring(1);
                Date date = new Date();
                String dateTime = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(dateTime);
                String format = dateFormat.format(date);
                bufferedWriter.write(", " + substring +"\nList last updated on " + format);
                bufferedWriter.close();
            } catch (Exception e) {
            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.TEXT_FILE_NAME)));
                String readLine = bufferedReader.readLine();
                String split[] = readLine.split(",");
                boolean done = false;
                String substring = args[0].substring(1);
                for (int idx = 0; idx < split.length && !done; idx++) {
                    if (split[idx].equals(substring)) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.TEXT_FILE_NAME)));
                String readLine = bufferedReader.readLine();
                char word[] = readLine.toCharArray();
                boolean in_word = false;
                int count = 0;
                for (char check : word) {
                    if (check == ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found ");
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        }

        else {

        }
    }

}