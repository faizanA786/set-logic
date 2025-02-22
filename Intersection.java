import java.util.HashMap;

public class Intersection {
    public static String[] eval(String[] set1, String[] set2) {
        HashMap<Integer, String> items = new HashMap();
        
        for (int i=0; i<set1.length; i++) {
            if (!items.containsValue(set1[i])) {
                items.put(i, set1[i]);
            }
        }

        int size = utils.getArrSize(set2, items, 0);
        String[] intersection = new String[size];
        int nextFree = 0;

        for (String j: set1) {
            for (String k: set2) {
                if (j.equals(k)) {
                    intersection[nextFree] = j;
                    nextFree++;
                    break;
                }
            }
        }



        return intersection;
    }

}
