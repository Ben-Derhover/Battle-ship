import java.util.*;


public class Main {


    private static int ROW = 10;
    private static int COL = 10;


    private static String[][] board = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        boolean done = false;
        boolean gameOver = false;
        boolean finshMove = false;

        do {
            //starting the game verables
            boolean hit;
            int missCount = 0;
            int Strike = 0;
            ClearBoard();
            do {
                placeShip(1);
                placeShip(2);
                placeShip(3);
                placeShip(4);
                display();

                //starting gameplay loop
                do {
                    hit = playerMove();
                    System.out.println(hit);

                    if (hit == false){
                        missCount ++;
                        if (missCount == 5){
                            Strike ++;
                            missCount = 0;
                            System.out.println("your strike is up too " + Strike);
                            if (Strike == 3){
                                gameOver = true;
                            }
                        }

                    }
                    if (hit == true){
                        missCount = 0;
                    }
                    System.out.println("your miss amount is " + missCount);
                    System.out.println("your Stike total is " + Strike);
                    //add to hit total
                    //add to stick total
                    display();

                }while(!finshMove);



            }while(!gameOver);


        }while(done);
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
        String miss = "\uD83D\uDCA7";
        String hit = "\uD83D\uDD25";
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

                //checking if the guess hit a boat
                if (board[row][col].equals("hit")) {
                    System.out.print(hit+ " ");

                }
                //checking to see if miss
                else if (board[row][col].equals("miss")) {
                    System.out.print(miss + " ");
                }
                //means youve alr gone in this space
                else{
                    System.out.print(wave+ " ");
                }


            }
            System.out.println();

        }
    }
   private static boolean playerMove(){
        boolean isHit;
        int row;
        String alphaCol = "";
       Scanner in = new Scanner (System.in);
       do{
            //asking for input on row
           System.out.println("whats your move?");
          row = safeInput.getRangedInt(in,"Row:", 1, 10);
          row --;
          //asking input for column
          System.out.println("whats your column move?");
          alphaCol = safeInput.getRegExString(in, "Col: ", "[AaBbCcDdEeFfGgHhIiJj]");
          alphaCol = alphaCol.toUpperCase();
          int col =0;
          //turning the horzontal letters in to numbers
          switch (alphaCol) {
              case "A":
                  col = 0;
                  break;
              case "B":
                  col = 1;
                  break;
              case "C":
                  col = 2;
                  break;
              case "D":
                  col = 3;
                  break;
              case "E":
                  col = 4;
                  break;
              case "F":
                  col = 5;
                  break;
              case "G":
                  col = 6;
                  break;
              case "H":
                  col = 7;
                  break;
              case "I":
                  col = 8;
                  break;
              case "J":
                  col = 9;
                  break;
          }
          if (board[row][col].equals("-")){
              board[row][col] = "miss";
              System.out.println("Thats was a miss");
              isHit = false;
              return isHit;

          }
          else if (board[row][col].equals("ship")){
              board[row][col] = "hit";
              System.out.println("Thats was a Hit");
              isHit = true;
              return isHit;

          }
          else {
              System.out.println("something has already happened in that spot");
          }

       }while(true);
















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
                System.out.println("Verticaly placing boat " + ship + " in postion " + row + " " + col);
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
