/*
 *  UCF COP3330 Fall 2021 Assignment 41 Solution
 *  Copyright 2021 Nick Cook
 */



// external imports
import java.io.*;
import java.util.*;

//public class
public class E41 {





    // its main!
    public static void main(String[] args) throws FileNotFoundException {

        //scanning files
        Scanner scan = new Scanner(new File("exercise4.txt"));

        // array names
        ArrayList<String> names = new ArrayList<>();

        //calling function readnames
        readNames(scan, names);


        names.sort(String.CASE_INSENSITIVE_ORDER);

        // closing the file
        scan.close();


        try {
            outputNames(names);
        }
        //catching the exception and printing it out
        catch (Exception e) {
            System.out.println();
        }
    }

    // outputting the names function
    public static void outputNames(ArrayList<String> names) throws IOException {

        // the file
        FileWriter output = new FileWriter("exercise41_output.txt");

        // writing in the file
        output.write("Total of " + names.size() + " names\n");
        // writing in the file
        output.write("--------------------\n");


        // loop to loop through the names and printing
        for (String i : names) {

            output.write(i + "\n");

        }

        // closing the file
        output.close();

    }

    // function readnames!
    public static void readNames(Scanner input, ArrayList<String> names) {

        //loop to add the names
        while (input.hasNextLine()) {


            names.add(input.nextLine());
        }
    }

}
