package edu.grinnell.csc207.lootgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author trent
 */
public class TreasureClass {

    public TreasureClass() {
    }

    /**
     * This method creates stores each line of the path as an arrayList,
     * containing arrayLists of strings that are the treasure class data
     *
     * @param path
     * @return an arrayList of arrayList of strings
     * @throws FileNotFoundException
     * @throws Exception
     */
    public ArrayList<ArrayList<String>> TreasureClassLoader(String path) throws FileNotFoundException, Exception {
        ArrayList<ArrayList<String>> arrList
                = new ArrayList<>();

        Scanner scanner = new Scanner(new File(path));
        ArrayList<String> line = new ArrayList<>();
        String str;

        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            line.add(str);
            arrList.add(line);

        }
        return arrList;

    }

    /**
     * Recursively goes through the ArrayList of ArrayLists, going each layer
     * further down until an actual value (and not a treasure class), is found.
     *
     * @param outerArrList
     * @param value The treasure class entry position
     * @return
     */
    public String itemPickerR(ArrayList<ArrayList<String>> outerArrList, String value) {
        //first, find the tc on first run, if it doesn't exist return the value
        Random random = new Random();

        for (ArrayList<String> innerList : outerArrList) {
            if ((innerList.get(0)).equals(value)) {
                int size = innerList.size();
                int index = random.nextInt(1, size);
                return itemPickerR(outerArrList, innerList.get(index));
            }
        }
        return value;

    }

    public String fetchTreasureClass(String path, String TC) throws Exception {
        return (itemPickerR((TreasureClassLoader(path)), TC));
    }
}
