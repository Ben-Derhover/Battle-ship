import java.util.Scanner;

public class safeInput {


    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }


    public static int getInt(Scanner pipe, String prompt) {

        int returnInt = 0;
        String trash = "";
        while (true) {
            System.out.println(prompt);
            if (pipe.hasNextInt()) {
                returnInt = pipe.nextInt();
                System.out.println();
                return returnInt;
            } else {
                trash = pipe.nextLine();
                System.out.println("Incorrect Type, try again.");
            }

        }

    }


    public static int getRangedInt(Scanner pipe, String prompt, int low, int high){

        int returnInt = 0;
        String trash = "";
        while (true) {
            System.out.println(prompt);
            if (pipe.hasNextInt()) {
                returnInt = pipe.nextInt();
                if (returnInt >= low && returnInt <= high) {
                    System.out.println();
                    return returnInt;
                }
                else{
                    System.out.println("Out of range");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("Incorrect Type, try again.");
            }

        }



    }
    public static double getDouble(Scanner pipe, String prompt) {

        double returnInt = 0;
        String trash = "";
        while (true) {
            System.out.println(prompt);
            if (pipe.hasNextDouble()) {
                returnInt = pipe.nextDouble();
                System.out.println();
                return returnInt;
            } else {
                trash = pipe.nextLine();
                System.out.println("Incorrect Type, try again.");
            }

        }

    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high){
        double returnDouble = 0;
        String trash = "";
        while (true) {
            System.out.println(prompt);
            if (pipe.hasNextDouble()) {
                returnDouble = pipe.nextDouble();
                if (returnDouble >= low && returnDouble <= high) {
                    System.out.println();
                    return returnDouble;
                }
                else{
                    System.out.println("Out of range");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("Incorrect Type, try again.");
            }

        }


    }
    public static boolean getYNConfirm(Scanner pipe, String prompt){
        boolean retYN = false;
        String YN = "";
        while(true) {
            System.out.println(prompt);
            YN = pipe.next();
            if (YN.equalsIgnoreCase("y")) {
                return retYN = true;
            } else if (YN.equalsIgnoreCase("n")) {
                return retYN = false;
            } else {
                System.out.println("Incorrect Type, try again.");
            }
        }


    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx){
        String userInput = "";

        while(true) {

            System.out.println(prompt);
            userInput = pipe.nextLine();
            if (userInput.matches(regEx)) {
                System.out.println();
                return userInput;

            } else {
                System.out.println("Incorrect input");
            }
        }
    }




    public static void prettyHeader(String msg){

        int totalSpaces = 60 - 6 - msg.length();
        int leftSpace;
        int rightSpace;

        if(totalSpaces % 2 ==0){
            leftSpace = rightSpace = totalSpaces / 2;

        }
        else {

            rightSpace = totalSpaces/2;
            leftSpace = rightSpace +1;
        }
        //print top border
        for(int i = 0; i <= 61; i++){
            System.out.print("*");
        }
        System.out.println();
        //first 3 *
        System.out.print("***");
        //left 3
        for (int i =0; i <=leftSpace; i++){
            System.out.print(" ");
        }
        //the message
        System.out.print(msg);
        // right 3
        for (int i =0; i <=rightSpace; i++){
            System.out.print(" ");
        }
        System.out.print("***");
        System.out.println();

        for(int i = 0; i <= 61; i++){
            System.out.print("*");
        }
        System.out.println();


        return;
    }
}
