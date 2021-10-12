/*
 *  UCF COP3330 Fall 2021 Assignment 45 Solution
 *  Copyright 2021 Nick Cook
 */


// external imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// public class
public class E45 {

    // its main!
    public static void main(String[] args) throws IOException {

        //scanning
        Scanner scan = new Scanner(System.in);

        //print out
        System.out.print("\nEnter the output file : ");

        // outfile is next scan
        String outfile = scan.next();

        // refile1 is new file
        ReFile readfile1 = new ReFile();

        //read file
        readfile1.readily();

        // making an array of strings
        ArrayList<String> list = readfile1.gdata();

        // writing file
        WriteFile writefile1 = new WriteFile(outfile, list);

        //writing file
        writefile1.writable();

        //print out files
        System.out.println("\nThe Number of Modifications are : "+writefile1.getcount());


    }

}

class ReFile{

    // variables!
    private final ArrayList<String> list;
    private final Scanner scan;

    // read file function
    public ReFile() throws FileNotFoundException {

        // variables
        list = new ArrayList<>();

        // files!
        File file = new File("C:\\Users\\Nick\\Desktop\\exercise45_input.txt");
        scan = new Scanner(file);
    }

    //readily function
    public void readily() {

        // try loop
       // try
        //{
            // while loop to check next scan
            while( scan.hasNext() )
            {

                // string flex is next scan
                String flex = scan.nextLine();
                // string is added to list
                list.add(flex);
            }
            // closing file
            scan.close();

    }
    // array list function
    public ArrayList<String> gdata() {

        return list;

    }

}
// writing file class
class WriteFile{

    // variables!
    private final FileWriter writer;
    private int count_Modification;
    private final ArrayList<String> list;

    // writefile function
    public WriteFile(String name, ArrayList<String> list) throws IOException {

        // setting variables
        writer = new FileWriter("C:\\Users\\Nick\\Desktop\\"+name);
        this.list = list;


    }

    // writable function
    public void writable() throws IOException {

        // loop string
        for (String tr : list) {


            String string = "utilize";

            int index = 0;

            // while loop is true, continue
            while (true) {
                index = tr.indexOf(string, index);
                if (index != -1) {
                    int count1 = 0;
                    count1++;
                    index += string.length();

                    // if not true, end loop and break;
                } else {
                    break;
                }
            }

            //setting the string to
            tr = tr.replaceAll("utilize", "use");

            // new line
            writer.write(tr + "\n");


        }
        //closing writer
        writer.close();

    }


    public int getcount() {

        int count1 = 0;

        return count1;

    }


}
