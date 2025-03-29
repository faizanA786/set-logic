/*
 * utils.java
 * Utilities used by other classes
*/

package logic;

import java.util.HashMap;

public class utils {

    // public static boolean isValidSet(String[] set) {

    // }
    
    public static String[] removeDuplicate(String[] set) { // removes duplicate vals in sets
        HashMap<Integer, String> items = new HashMap();

        for (int i=0; i<set.length; i++) {
            if (items.containsValue(set[i])) { // if seen before, mark the duplicate item
                set[i] = "X";
            }
            else {
                items.put(i, set[i]);
            }
        }

        String[] newSet = new String[items.size()];

        int n=0;
        for (int j=0; j<set.length; j++) {
            if (!set[j].equals("X")) {
                newSet[n] = set[j];
                n++;
            }
        }
        return newSet;
        //END removeDuplicate
    }

    public static int getArrSize(String[] set, HashMap<Integer, String> items, int type) { // (0) used by intersection (1) and complement
        int size = 0;
        for (String n: set) {
            if (items.containsValue(n) && type == 0) {
                size++;
            }
            else if (!items.containsValue(n) && type == 1) {
                size++;
            }
        }
        return size;
        //END getArrSize
    }
}
