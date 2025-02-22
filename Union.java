public class Union {
    public static String[] eval(String[] set1, String[] set2) {
        String[] union = new String[set1.length + set2.length];
        int i;
        for (i=0; i<set1.length; i++) {
            union[i] = set1[i];
        }
        for (String n: set2) {
            union[i] = n;
            i++;
        }
        
       return utils.removeDuplicate(union);
    }
}
