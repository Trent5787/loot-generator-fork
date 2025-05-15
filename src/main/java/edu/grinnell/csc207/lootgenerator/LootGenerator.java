package edu.grinnell.csc207.lootgenerator;

import java.io.FileNotFoundException;

public class LootGenerator {

    /**
     * The path to the dataset (either the small or large set).
     */
    private static final String DATA_SET = "data/small";

    public static void main(String[] args) throws FileNotFoundException, Exception {
        //gets our monster and its treasure class
        Monster monst = new Monster();
        String[] monstAndTreas;
        monstAndTreas = monst.pickMonster(DATA_SET + "/monstats.txt");

        //gets an item from the provided treasure class
        TreasureClass tc = new TreasureClass();
        String item;
        item = tc.fetchTreasureClass(DATA_SET + "/TreasureClassEx.txt", monstAndTreas[1]);

        //this should not be printing out Cow(H) but it is...
        System.out.println("Item is:" + item);
    }
}
