/*
 *  UCF COP3330 Fall 2021 Assignment 43 Solution
 *  Copyright 2021 Nick Cook
 */



// external imports
import java.io.*;
import java.util.*;

//public class
public class E43 {


    // its main!
    public static void main(String[] args)
    {
        // scanning the file
        Scanner scan = new Scanner(System.in);

        // creating the variable strings
        String path;
        String name;
        String site;

        //creating the char variables
        char javascript;
        char c;

        //print out site name
        System.out.print("Site name: ");
        site = scan.nextLine();

        //print out author name
        System.out.print("Author: ");
        name = scan.nextLine();

        System.out.print("Do you want a folder for JavaScript? ");
        javascript = scan.next().charAt(0);

        System.out.print("Do you want a folder for CSS? ");
        c = scan.next().charAt(0);


        path = System.getProperty("user.dir");
        path += "\\"+site;


        File website = new File(path);
        boolean websiteCreated = website.mkdir();

        // checking if website was created
        if(websiteCreated)
        {
            // was created
            System.out.println("Created " + path);
            try
            {
                //printing out everything
                FileWriter skeletonWriter = new FileWriter(path+"\\index.html");
                skeletonWriter.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
                skeletonWriter.write("\t<meta author=\""+name+"\">\n");
                skeletonWriter.write("\t<title>"+site+"</title>\n");
                skeletonWriter.write("</head>\n<body>\n\n</body>\n</html>");
                skeletonWriter.close();
                System.out.println("Created " + path+"\\index.html");

                // if y or Y do
                if(javascript == 'y' || javascript == 'Y')
                {
                    File jsFolder = new File(path+"\\js");
                    boolean jsCreated = jsFolder.mkdir();
                    if(jsCreated)
                    {
                        // if created, print folder
                        System.out.println("Created " + jsFolder+"\\");
                    }
                    else
                    {
                        // if not Y or y print
                        System.out.println("Js folder not created!");
                    }
                }
                // if y or Y
                if(c == 'y' || c == 'Y')
                {
                    // create the file
                    File cssFolder = new File(path+"\\css");
                    boolean cssCreated = cssFolder.mkdir();
                    if(cssCreated)
                    {
                        // if created, print folder
                        System.out.println("Created " + cssFolder+"\\");
                    }
                    else
                    {
                        // if not Y or y print not created
                        System.out.println("CSS folder not created!");
                    }
                }
            }
            //catch the exception and print
            catch(IOException e)
            {
                System.out.println("index.html not created as required!");
            }
        }
        //print the folder is not created
        else
        {
            System.out.println("Website folder not created!");
        }
        scan.close();
    }
}

