import java.util.HashMap;

public class Complement {
    public static String[] eval(String[] set1, String[] set2) {
        HashMap<Integer, String> items = new HashMap();
        for (int i=0; i<set2.length; i++) {
            if (!items.containsValue(set2[i])) {
                items.put(i, set2[i]);
            }
        }

        int size = utils.getArrSize(set1, items, 1);
        String[] complement = new String[size];
        int nextFree = 0;

        for (String n: set1) {
            if (!items.containsValue(n)) {
                complement[nextFree] = n;
                nextFree++;
            }
        }
        return complement;
    }
}
