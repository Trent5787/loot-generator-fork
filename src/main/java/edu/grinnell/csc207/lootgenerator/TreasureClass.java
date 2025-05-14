package edu.grinnell.csc207.lootgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author trent
 */
public class TreasureClass {
    private String TC; //the treasure class for the monster

    public TreasureClass(String TC) {
        this.TC = TC;
    }

    /**
     * This method creates stores each line of the path as an arrayList, 
     * containing arrayLists of strings that are the treasure class data 
     * @param path
     * @return an arrayList of arrayList of strings
     * @throws FileNotFoundException
     * @throws Exception
     */
    public ArrayList<ArrayList<String>> TreasureClassLoader(File path) throws FileNotFoundException, Exception {
        ArrayList<ArrayList<String>> arrList
                = new ArrayList<>();

        Scanner scanner = new Scanner(path);
        ArrayList<String> line = new ArrayList<>();
        String str;
        int i = 0;
        int j = 0;

        while (scanner.hasNextLine()) {
            while (!"/n".equals(scanner.next())) {
                str = scanner.next();
                line.set(i, str);
                i++;
            }
            i = 0;
            arrList.set(j, line);
            j++;
        }
        return arrList;

    }
    
    /**
     * Recursively goes through the ArrayList of ArrayLists, going each layer
     * further down until an actual value (and not a treasure class), is found.
     * @param outerArrList
     * @param value The treasure class entry position
     * @return
     */
    public String itemPickerR (ArrayList<ArrayList<String>> outerArrList, String value) {
        //first, find the tc on first run, if it doesn't exist return the value
        Random random = new Random();
       
        for (ArrayList<String> innerList : outerArrList) {
            if ((innerList.get(0)).equals(value)) {
                int size = innerList.size();
                int index = random.nextInt(1,size);
                return itemPickerR(outerArrList, innerList.get(index));
            }
        }
        return value;
 
    }
}



