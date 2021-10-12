/*
 *  UCF COP3330 Fall 2021 Assignment 46 Solution
 *  Copyright 2021 Nick Cook
 */



// external imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

//public class
public class E46 {

    // its main!
    public static void main(String[] args) throws FileNotFoundException {

        //setting filereader
        rfile  readfile1 = new rfile ();

        //calling function
        readfile1.readable();

        //setting hashmap to file
        HashMap<String, Integer> map = readfile1.getMap();

        Print printing = new Print(map);

        printing.print1();

    }

}
// class read input file
class rfile {

    // variables
    private final Scanner scan;
    private final HashMap<String, Integer> map;


    public rfile () throws FileNotFoundException {

        // variables
        File file = new File("C:\\Users\\Nick\\Desktop\\exercise46_input.txt");
        scan = new Scanner(file);
        map = new HashMap<>();

    }

    //readable function
    public void readable() {

        //while next scan loop
            while( scan.hasNext() )
            {
                //variables
                String input = scan.nextLine();
                String[] array1 = input.split(" ");

                //for loop for the keys
                for (String answer : array1) {
                    if (map.containsKey(answer)) {

                        int value = map.get(answer);

                        // adding +1 to values each increment
                        value++;

                        map.put(answer, value);
                    }

                    else {

                        map.put(answer, 1);
                    }
                }
            }

            scan.close();
        }



    public HashMap<String, Integer> getMap(){

        return map;

    }

}

class Print{

    private final HashMap<String, Integer> map;
    public Print( HashMap<String, Integer> map) {

        this.map = map;

    }


// print function
    public void print1() {

        //variables!!
        String[] answer1 = new String[map.size()];
        Integer[] values = new Integer[map.size()];
        int o=0;

        // for loop for getkeys
        for (Entry<String, Integer> entry : map.entrySet()) {

            answer1[o] = entry.getKey();

            values[o++] = entry.getValue();

        }

        //variables!
        int[] temples = new int[map.size()];
        String[] temples1 = new String[map.size()];

        // for loop to make values
        for(int i=0;i<values.length;i++) {

            temples[i] = values[i];

        }


        // calling the array sort function
        Arrays.sort(values, Collections.reverseOrder());

        // looping and putting value into values[i]
        for(int i=0; i<map.size();i++) {

            int value = values[i];

            //looping temples1 into keys
            for(int j=0; j<temples.length;j++) {

                if(value == temples[j]) {

                    temples1[i] = answer1[j];

                    break;

                }

            }

        }

        System.out.println();

        // for loop to put the value into the array
        for(int i=0;i<map.size();i++) {

            int value = map.get(temples1[i]);

            // print f with tab
            System.out.print(temples[i]+" : \t");

            //looping and printing *
            for(int j=0; j<value; j++) {

                System.out.print("*");

            }

            System.out.println();

        }
    }
}