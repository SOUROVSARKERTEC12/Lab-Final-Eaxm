import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

//		Check arguments
        if (args[0].equals(Constants.ShowAll)) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.StudentList)));
                String string = bufferedReader.readLine();
                String split[] = string.split(",");
                for (String printList : split) {
                    System.out.println(printList);
                }
            } catch (Exception e) {
                System.out.println("Excepton :"+e.toString());
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals(Constants.ShowRandom)) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.StudentList)));
                String string = bufferedReader.readLine();
                String split[] = string.split(",");
                Random random = new Random();
                System.out.println(split[random.nextInt(4)]);
            } catch (Exception e) {
                System.out.println("Excepton :"+e.toString());
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains(Constants.AddEntry)) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Constants.StudentList, true));
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a");
                bufferedWriter.write(", " + args[0].substring(1) +"\nList last updated on " + dateFormat.format(date));
                bufferedWriter.close();
            } catch (Exception e) {
                System.out.println("Excepton :"+e.toString());
            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains(Constants.FindEntry)) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.StudentList)));
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
                System.out.println("Excepton :"+e.toString());
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains(Constants.ShowCount)) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.StudentList)));
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
                System.out.println("Excepton :"+e.toString());
            }
            System.out.println("Data Loaded.");
        }
        
    }

}