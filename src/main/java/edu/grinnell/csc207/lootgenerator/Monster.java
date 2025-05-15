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
public class Monster {

    public Monster() {
    }

    private int size(ArrayList<String> monsters) {
        return monsters.size();
    }

    /**
     * Creates a new arraylist and uses a scanner to parse through the file and
     * assign each index of the Arraylist to the string representation of each
     * other lines of text in the monster file.
     *
     * @param path File path
     * @return The arraylist populated, each index being the string
     * representation of one of the lines of text in the monster file.
     * @throws FileNotFoundException
     */
    public ArrayList<String> monsterToArrayList(String path) throws FileNotFoundException {
        ArrayList<String> monsters = new ArrayList();
        Scanner scanner = new Scanner(new File(path));
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            monsters.add(line);
        }
        return monsters;
    }

    /**
     * Creates a random number no larger than the size of the arrayList and gets
     * a monster at the index being the random number that was made.
     *
     * @param monsters an arraylist of strings that are monsters
     * @return A random monster as a string
     */
    public String monsterPicker(ArrayList<String> monsters) {
        Random random = new Random();
        int rand = random.nextInt(size(monsters));
        return (monsters.get(rand));
    }

    /**
     * Gets the strings we want (name and treasure class) from the main string
     *
     * @param monster
     * @return String[]
     */
    public String[] vals(String monster) {
        //Declaration of variables
        String[] vals = new String[2];
        int checker = 0;
        ArrayList<Character> monst = new ArrayList<>();
        ArrayList<Character> treasure = new ArrayList<>();

        //Goes through whole string and grabs what we want
        for (int i = 0; i < monster.length(); i++) {
            if (monster.charAt(i) == '\t') {
                checker++;
            }
            if (checker == 0) {
                monst.add(monster.charAt(i));
            }
            if (checker == 3) {
                treasure.add(monster.charAt(i));
            }
        }

        //Converts the ArrayLists of chars into strings
        StringBuilder sb1 = new StringBuilder();
        for (Character c : monst) {
            sb1.append(c);
        }
        String strMonst = sb1.toString();

        StringBuilder sb2 = new StringBuilder();
        for (Character d : treasure) {
            sb2.append(d);
        }
        String strTreasure = sb2.toString();

        //Adds those strings into our array
        vals[0] = strMonst;
        vals[1] = strTreasure;

        //Return the array of strings of the values we care about
        return vals;
    }

    /**
     * Calls all helper functions above to get the monster name and treasure
     * class to return
     *
     * @param path
     * @return String array of the monster name and its treasure class
     * @throws FileNotFoundException
     */
    public String[] pickMonster(String path) throws FileNotFoundException {
        return (vals(monsterPicker(monsterToArrayList(path))));
    }
}
