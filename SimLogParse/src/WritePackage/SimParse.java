package WritePackage;

import com.sun.javaws.IconUtil;

import java.io.*;
import java.util.Scanner;
import java.lang.StringBuilder;

public class SimParse {



    public static void main(String[] args) throws IOException {
        readTime();

    }

    public static void readTime() throws IOException {

        //Read all the content of the file in one string
        String content = new Scanner(new
                File("/Users/ronaldtran/Desktop/simulation.log")).useDelimiter("\\Z").next();

        content = content.replaceAll("[^\\d]", " ");

        // Remove extra spaces from the beginning
        // and the ending of the string
        content = content.trim();

        // Replace all the consecutive white
        // spaces with a single space
        content = content.replaceAll(" +", " ");

        content = content.replaceAll(" +", ":");

        String time = "Time: ";

        // go through the entire string of content (which is all the ints in the file formatted)
        for (int i = 0; i < content.length(); i++) {

            // go through the last 17 ints which include the runtime
            // also append each int to the string
            if (i >= content.length() - 16) {

                char c = (char) content.charAt(i);
                time = time + c;

            }

            //once we hit the last two ints, which we do not need
            //we can stop it and change the last semicolon to a comma
            if (i == content.length() - 5) {
                StringBuilder newTime = new StringBuilder(time);
                newTime.setCharAt(14, ',');

                String newString = newTime.toString();

                String file_name = "/Users/ronaldtran/Desktop/output.txt";
                WriteFile data = new WriteFile(file_name);

                System.out.println(newString);
                data.writeToFile(newString);


            }


        }


    }




}
