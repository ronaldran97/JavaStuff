package WritePackage;

import java.io.*;

public class WriteFile {

    //for file output
    private String path;    //name and location of the file
    private boolean append_to_file = false;

    public WriteFile(String file_path){
        path = file_path;
    }

    public WriteFile(String file_path, boolean append_value) {
        path = file_path;
        append_to_file = append_value;
    }

    public void writeToFile( String textLine ) throws IOException {
        FileWriter write = new FileWriter(path, append_to_file);
        PrintWriter print_line = new PrintWriter(write);

        //%s means a string of characters of any length. The %n means a newline.
        //textLine is the line we want to take
        print_line.printf( "%s" + "%n" , textLine);
        print_line.close();
    }




}
