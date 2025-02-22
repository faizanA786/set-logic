import java.util.Scanner;

class setlogic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        System.out.println("Union(o, set1 or set2), Intersection(a, set1 and set2), Complement(n, set1 not in set2),  Set Builder(b), Exit(e)");
        while (!input.equals("e")) { // e for exit

            if (input.equals("o") || input.equals("a") || input.equals("n")) {
                System.out.println("Enter your first set (seperate by commas): ");
                String firstSet = sc.nextLine();
                System.out.println("Enter your second set (seperate by commas): ");
                String secondSet = sc.nextLine();

                String[] set1 = firstSet.split(",");
                String[] set2 = secondSet.split(",");

                if (input.equals("o")) { // o for union
                    String[] union = Union.eval(set1, set2);
                    String newUnion = String.join(",", union);
                    System.out.println("Result : {" + newUnion + "}");          
                }
                else if (input.equals("a")) { // o for union
                    String[] intersection = Intersection.eval(set1, set2);
                    String newIntersection = String.join(",", intersection);
                    System.out.println("Result : {" + newIntersection + "}");          
                }
                else if (input.equals("n")) { //n for complement
                    String[] complement = Complement.eval(set1, set2);
                    String newComplement = String.join(",", complement);
                    System.out.println("Result : {" + newComplement + "}");   
                }
            }
            else if (input.equals("b")) {
                System.out.println("Number set(s), (seperate by commas)\nEg N(natural numbers),Z");
                String numberSets = sc.nextLine();

                System.out.println("Range: eg x>120, x<400");
                String ranges = sc.nextLine();

                System.out.println("Divisible by: eg 2,5");
                String divisibleBy = sc.nextLine();

                //String[] newSet = Builder.buildSet(numberSets, divisibleBy, ranges);
            }

            input = sc.nextLine();

        }

        sc.close();

    }


    


}