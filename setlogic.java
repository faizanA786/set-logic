import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class setlogic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        System.out.println("Union(o), Intersection(a), Complement(n),  Exit(e)");
        while (!input.equals("e")) { // e for exit

            if (input.equals("o")) { // o for union
                System.out.println("Enter your first set (seperate by commas): ");
                String firstSet = sc.nextLine();
                System.out.println("Enter your second set (seperate by commas): ");
                String secondSet = sc.nextLine();

                String[] set1 = firstSet.split(",");
                String[] set2 = secondSet.split(",");

                String[] union = Union.eval(set1, set2);
                String newUnion = String.join(",", union);
                System.out.println("Result : {" + newUnion + "}");          
            }

            input = sc.nextLine();

        }

        sc.close();

    }


    


}