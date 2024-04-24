import java.util.*;


public class Main {


    private static int ROW = 10;
    private static int COL = 10;


    private static String[][] board = new String[ROW][COL];

    public static void main(String[] args) {
        ClearBoard();

        placeShip(1);
        placeShip(2);
        placeShip(3);
        placeShip(4);
        display();

    }

    private static void ClearBoard() {


        for (int row = 0; row < ROW; row++) {

            for (int col = 0; col < COL; col++) {

                board[row][col] = "-";

            }
        }


    }

    private static void display() {
// making the board
        String wave = "\uD83C\uDF0A";
        String boat = "\u26F5";
        System.out.print("     ");
        System.out.print("\uFF21" + " "); //A

        System.out.print("\uFF22" + " "); //B

        System.out.print("\uFF23" + " "); //C

        System.out.print("\uFF24" + " "); //D

        System.out.print("\uFF25" + " "); //E

        System.out.print("\uFF26" + " "); //F

        System.out.print("\uFF27" + " "); //G

        System.out.print("\uFF28" + " "); //H

        System.out.print("\uFF29" + " "); //I

        System.out.print("\uFF2A"); //J

        System.out.println();
        for (int row = 0; row < ROW; row++) {
            //the different rows
            System.out.print("|");
            if (row == 9) {
                System.out.print(row + 1 + "  ");

            } else {
                System.out.print(row + 1 + "   ");
            }

            //doing the emojis
            for (int col = 0; col < COL; col++) {

                if (board[row][col].equals("-")){
                    System.out.print(wave+ " ");
                }
                else {
                    System.out.print(boat+ " ");
                }


            }
            System.out.println();

        }
    }


    private static void placeShip(int ship) {
        //placing the ships
        Random rnd = new Random();

        int vertOrHorz = rnd.nextInt(2);

        int validCounter = 0;
        int row = 0;
        int col = 0;

        if (vertOrHorz == 0) {
            //checking to see if you can move there
            do {
                validCounter = 0;
                row = rnd.nextInt(10 - ship);
                col = rnd.nextInt(10 - ship + 1);
                System.out.println("Verticaly placing boat" + ship + " in postion " + row + " " + col);
                for (int i = 0; i <= ship; i++) {
                    if (board[row + i][col].equals("-")) {
                        validCounter++;

                    }
                }
            } while (validCounter != (ship + 1));

            for (int i = 0; i <= ship; i++) {
                board[row + i][col] = "ship";

            }

        } else {
            //doing a move if vertical
            do {
                validCounter = 0;
                row = rnd.nextInt(10 - ship + 1);
                col = rnd.nextInt(10 - ship);
                System.out.println("Horazonaily placing boat" + ship + " in postion " + row + "" + col);

                for (int i = 0; i <= ship; i++) {
                    if (board[row][col + i].equals("-")) {
                        validCounter++;
                    }
                }


            } while (validCounter != (ship + 1));
            for (int i = 0; i <= ship; i++) {
                board[row][col + i] = "ship";

            }

        }
    }
}
