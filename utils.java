import java.util.HashMap;

public class utils {

    // public static boolean isValidSet(String[] set) {

    // }
    
    public static String[] removeDuplicate(String[] union) {
        HashMap<Integer, String> items = new HashMap();

        for (int i=0; i<union.length; i++) {
            if (items.containsValue(union[i])) { // if seen before, mark the duplicate item
                union[i] = "X";
            }
            else {
                items.put(i, union[i]);
            }
        }

        String[] newSet = new String[items.size()];

        int n=0;
        for (int j=0; j<union.length; j++) {
            if (!union[j].equals("X")) {
                newSet[n] = union[j];
                n++;
            }
        }
        return newSet;
    }
}
