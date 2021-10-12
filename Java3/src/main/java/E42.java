/*
 *  UCF COP3330 Fall 2021 Assignment 42 Solution
 *  Copyright 2021 Nick Cook
 */



// external imports
import java.io.*;
import java.util.*;

//public class
public class E42 {

    // its output function!
    public static void outnames(ArrayList<String> names) throws IOException {

        // it's the file!
        FileWriter output = new FileWriter("exercise41_output.txt");

        // printing in the file
        output.write("Total of " + names.size() + " names\n");
        output.write("--------------------\n");


        // looping through the names and outputting
        for (String i : names) {
            output.write(i + "\n");
        }

        //file close
        output.close();
    }

    // its main!
    public static void main(String[] args) throws FileNotFoundException {

        // its the file
        Scanner inputFile = new Scanner(new File("exercise41_input.txt"));
        // creating the array list
        ArrayList<String> names = new ArrayList<>();

        //calling readnames function
        rnames(inputFile, names);

        //calling name sorts
        names.sort(String.CASE_INSENSITIVE_ORDER);

        //closing file
        inputFile.close();


        // loop to check if there's names
        try {
            outnames(names);
        }
        // if not catch exception and print error
        catch (Exception e) {
            System.out.println("Something went wrong while writing to the file");
        }
    }

    // read names function!
    public static void rnames(Scanner input, ArrayList<String> names) {

        // lopp to add the names!
        while (input.hasNextLine()) {

            names.add(input.nextLine());
        }
    }
}