import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class setlogic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        System.out.println("Operation, Exit");
        while (!input.equals("e")) { // e for exit

            if (input.equals("o")) { // u for union
                System.out.println("Enter your set operation:");
                input = sc.nextLine();

                List<String> sets = splitSet(input);
                char[] operators = findOperator(input);

                int n = 0;
                for (int i=0; i< operators.length; i++) { 
                    if (operators[i] == '|') { // or/union
                        String union = Union.eval(new String[]{sets.get(0), sets.get(1)}, operators);
                        sets.set(0, union);
                        sets.remove(1);
                        operators[i] = '0';
                    }
                }

                System.out.println("Result: " + sets.get(0));
            }

            input = sc.nextLine();

        }

        sc.close();

    }

    public static char[] findOperator(String input) {
        String str = input.replaceAll("[^&|\\\\]", ""); // keep \&|
        str = str.toLowerCase();

        char[] operators = str.toCharArray();
        return operators;
    }

    public static List<String> splitSet(String input) {
        String str = input.replaceAll("[[A-Z\\s\\\\]+]+", ""); // remove white space and capital letters
        List<String> sets = new ArrayList<>();
        String set = "";

        char[] c = str.toCharArray();
        for (int i=1; i<c.length; i++) {
        
            if (Character.isDigit(c[i]) || Character.isLetter(c[i]) || c[i] == ',') {
                set += c[i];
            }
            else if (c[i] == '{') {
                set += ",";
            }
            else if (c[i] == '}') { // assume c[i] == {}
                sets.add(set);
                set = "";
            }
        }
        return sets;
    }


}