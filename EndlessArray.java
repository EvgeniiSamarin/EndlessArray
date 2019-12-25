import java.util.Scanner;

public class EndlessArray {
    public static void main(String[] args) {
        // write your code here
        EndlessArray ea = new EndlessArray();
        ea.init();
        ea.start();
    }
    private boolean started;


    private void init() {
        Scanner sc = new Scanner(System.in);
        started = true;
    }
    private void start(){
        EA array = new EA(2);
        Scanner sc = new Scanner(System.in);
        if(!started) {
            System.out.println("Please init.");
        }
        while(true) {


            System.out.print("Please enter command: ");
            String commandName = sc.nextLine().trim();
            switch(commandName.toLowerCase()){
                case "exit":
                    System.exit(0);
                    break;
                case "indexof":
                    System.out.println("Enter index of element");
                    String index = sc.nextLine().trim();
                    String index1 = addMember(index);
                    int i1 = Integer.parseInt(index1);
                    System.out.println(array.indexOf(i1));

                    break;
                case "addelement":
                    System.out.println("Enter element");
                    String element = sc.nextLine().trim();
                    String element1 = addMember(element);
                    int i = Integer.parseInt(element1);

                    array.put(i);
            }
            System.out.println("Size: " + array.getSize());
        }

    }
    public static String addMember(String s){
        Scanner sc = new Scanner(System.in);
        Integer v = tryParseInt(s);
        if ( v!= null  ) {
            return s;
        } else {
            System.out.println("Not a number, Enter number please.");
            String s1 = sc.nextLine();
            return addMember(s1);

        }

    }
    public static Integer tryParseInt(String s) {
        try {
            return new Integer(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
