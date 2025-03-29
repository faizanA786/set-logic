/*
 * Builder.java
 * Handles set creation
*/

package logic;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Builder {
    public static String buildSet(String[] divisibleBy) { // builds a set
        // boolean[] numSets = new boolean[2]; // where numSets[0]=N, numSets[1]=Z

        // for (String chr : numberSets) {
        //     if (chr.equals("N")) {
        //         numSets[0] = true;
        //     }
        //     else if (chr.equals("Z")) {
        //         numSets[1] = true;
        //     }
        // }

        ArrayList<String> output = new ArrayList<>();

        int i=1;
        output.add("0");
        while (output.size()<10 && i<1000) {
            try {
                boolean isFactor = true;
            
                for (int j=0; j<divisibleBy.length; j++) {
                    if (i % Integer.parseInt(divisibleBy[j]) != 0) {
                        isFactor = false;
                    }
                }
    
                if (isFactor) {
                    output.add(Integer.toString(i));
                }
                i++;
            }
            catch(Exception e) {
                return "Invalid: " + e.getMessage();
            }

        }

        return ("{" + output.stream().collect(Collectors.joining(",")) + "}");
        //END buildSet
    }
}