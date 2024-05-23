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
            int hitCount = 0;
            ClearBoard();
            do {
                //placing the ships on the display
                placeShip(1);
                placeShip(2);
                placeShip(3);
                placeShip(4);
                display();

                //starting gameplay loop
                do {
                    hit = playerMove();
                    System.out.println(hit);
                    //setting a hit to the playermove action
                    if (hit == false){
                        //if you miss it add one to the misscount
                        missCount ++;
                        if (missCount == 5){
                            //checks to see if misscount is 3 then adding 1 strike
                            Strike ++;
                            missCount = 0;
                            System.out.println("your strike is up too " + Strike);
                            if (Strike == 3){
                                break;
                                //once Strike reaches 3 then it breaks and ends the loop to end the game
                            }
                        }

                    }
                    if (hit == true){
                        missCount = 0;
                        hitCount ++;
                        //restests the miss amount then adds one to the hit counter
                        if(hitCount == 14){
                            //once the hit count reachs 14 (which is the total amount of ship amount) then it breaks and ends the game
                            break;
                        }
                    }
                    //telling you what you miss amount and stike amount is after each play
                    System.out.println("your miss amount is " + missCount);
                    System.out.println("your Stike total is " + Strike);
                    //add to hit total
                    //add to stick total
                    display();

                }while(!finshMove);

                if(Strike == 3){
                    //displaying the lose after reaching 3 strikes
                    safeInput.prettyHeader("You lose");
                    gameOver = true;
                    Strike = 0;
                    hitCount = 0;
                    //resteting all Strikes and hits after gameover
                } else if (hitCount==14) {
                    //displaying the win after reaching 3 strikes
                    safeInput.prettyHeader("you win");
                    gameOver = true;
                    Strike = 0;
                    hitCount = 0;
                    //resteting all Strikes and hits after gameover
                }


            }while(!gameOver);

            done = safeInput.getYNConfirm(in,"do you want to play again?");


        }while(done);
    }


//just restating the board to all - after a game is over
    private static void ClearBoard() {


        for (int row = 0; row < ROW; row++) {

            for (int col = 0; col < COL; col++) {

                board[row][col] = "-";

            }
        }


    }

    private static void display() {
        // making the board
        // setting each varibale to an emjio
        String miss = "\uD83D\uDCA7"; //water drop
        String hit = "\uD83D\uDD25";  //fire
        String wave = "\uD83C\uDF0A";   //wave
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
          //checking to see if the thing that was choosen is a - or a ship if a ship
          if (board[row][col].equals("-")){
              board[row][col] = "miss";
              System.out.println("Thats was a miss");
              isHit = false;
              return isHit;
                //sending the input back up to the gameplay loop that the hit as false and to add one to the miss counter
          }
          else if (board[row][col].equals("ship")){
              board[row][col] = "hit";
              System.out.println("Thats was a Hit");
              isHit = true;
              return isHit;
              //sending the input back up to the gameplay loop that the hit as true and to add one to the hit counter
          }
          else {
              System.out.println("something has already happened in that spot");
          }

       }while(true);
















   }

    private static void placeShip(int ship) {
        //placing the ships
        Random rnd = new Random();
        //random number to see if vertical or horzontal
        int vertOrHorz = rnd.nextInt(2);

        int validCounter = 0;
        int row = 0;
        int col = 0;

        if (vertOrHorz == 0) {
            //seeing if its vertical or horazonal by 1 or 0
            //checking to see if you can move there
            do {
                //making sure you can place a ship in that spot
                validCounter = 0;
                //random placement on ether side of the ship
                row = rnd.nextInt(10 - ship);
                col = rnd.nextInt(10 - ship + 1);
                //telling me were there at so i can test can be removed
                System.out.println("Verticaly placing boat " + ship + " in postion " + row + " " + col);
                //were a ship is not at its placing a - symbol
                for (int i = 0; i <= ship; i++) {
                    if (board[row + i][col].equals("-")) {
                        validCounter++;

                    }
                }
            } while (validCounter != (ship + 1));
            //were a ship is decided to place it puts string word
            for (int i = 0; i <= ship; i++) {
                board[row + i][col] = "ship";

            }

        } else {
            //doing a move if vertical
            do {
                validCounter = 0;
                row = rnd.nextInt(10 - ship + 1);
                col = rnd.nextInt(10 - ship);
                //random placement on ether side of the ship
                System.out.println("Horazonaily placing boat " + ship + " in postion " + row + " " + col);
                //were a ship is not at its placing a - symbol
                //if its placed then add 1 to vaild counter
                for (int i = 0; i <= ship; i++) {
                    if (board[row][col + i].equals("-")) {
                        validCounter++;
                    }
                }

                //were a ship is decided to place it puts string word
            } while (validCounter != (ship + 1));
            for (int i = 0; i <= ship; i++) {
                board[row][col + i] = "ship";

            }

        }
    }
}
