/*
 *  UCF COP3330 Fall 2021 Assignment 44 Solution
 *  Copyright 2021 Nick Cook
 */



// external imports

import java.io.*;

//public class
public class E44 {

    // its main!
    public static void main(String[] args) throws IOException
    {
        // creating the variables
        File file1 = new File("input.txt");
        String[] w;
        FileReader fr = new FileReader(file1);
        BufferedReader buff = new BufferedReader(fr);
        String string;
        String input="Java";
        int count=0;

        // check is string is not null
        while((string=buff.readLine())!=null)
        {
            w = string.split(" ");
            for (String word : w)
            {
                // checks if input = word
                if (word.equals(input))
                {
                    //if it is, add to the counter
                    count++;
                }
            }
        }
        //if count is not 0, print out count
        if(count!=0)
        {
            System.out.println("The given word is present for "+count+ " Times in the file");
        }
        //if it is 0, print
        else
        {
            System.out.println("The given word is not present in the file");
        }

        //close file!
        fr.close();
    }
}
