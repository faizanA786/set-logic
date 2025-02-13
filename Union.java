import java.util.HashMap;

public class Union {
    public static String eval(String[] sets, char[] operators) {
        String union = sets[0] + sets[1];
        String result = "{" + removeDuplicate(union) + "}";
        return result;        
    }

    public static String removeDuplicate(String union) {
        char[] c = union.toCharArray();
        HashMap<Integer, Character> items = new HashMap();
        for (int i=0; i<c.length; i++) {
            if (c[i] != ',' && items.containsValue(c[i])) { // mark the duplicate item
                c[i] = 'X';
            }
            else {
                items.put(i, c[i]);
            }
        }

        String newSet = "";
        for (int j=0; j<union.length(); j++) {
            if (c[j] != 'X') {
                newSet += c[j];
            }
        }
        return newSet;
    }
}
