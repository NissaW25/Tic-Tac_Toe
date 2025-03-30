/**********************************************************************
 * @file TicTacToe.java
 * @brief This program is meant to implement a regular game of Tic Tac Toe
 * @author Janissa Walker
 * @date: October 6th, 2022
 * @acknowledgement:
 ***********************************************************************/
import java.awt.*;

public class TicTacToe {
    public static void main(String[] args) {

        int moves = 0;
        int x, y;
        // currentPlayer should be set to 1 or 2
        int currentPlayer = 1;
        double mx;
        double my;
        double bx;
        double by;

        StdDraw.setCanvasSize(500, (int) (500 * 1.3));
        StdDraw.setXscale(-0.1, 3.1);
        StdDraw.setYscale(-0.1, 4.1);

        StdDraw.setPenRadius(0.005);

        drawBoard();


        // Announce that it's player 1's turn
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(1.5, 3.75, "Player " + currentPlayer + ": your turn");


        while (moves < 9) {
            if (StdDraw.isMousePressed() == true) {
                mx = StdDraw.mouseX();
                my = StdDraw.mouseY();
                bx = (int) mx + 0.5;
                by = (int) my + 0.5;


                if (mx >= 0 && mx <= 3 && my >= 0 && my <= 3) {

                    if (currentPlayer == 1) {
                        StdDraw.setPenColor(Color.PINK);
                        StdDraw.circle(bx, by, 0.5);
                        currentPlayer = 2;
                    }
                    else {
                        StdDraw.setPenColor(Color.GRAY);
                        StdDraw.line(bx + 0.5, by - 0.5, bx - 0.5, by + 0.5);
                        StdDraw.line(bx - 0.5, by - 0.5, bx + 0.5, by + 0.5);
                        currentPlayer = 1;
                    }
                    moves++;
                    StdDraw.setPenColor(Color.white);
                    StdDraw.filledRectangle(1.5, 3.75, 1,0.2);
                    StdDraw.setPenColor(Color.black);
                    StdDraw.text(1.5, 3.75, "Player " + currentPlayer + ": your turn");
                    StdDraw.pause(300);
                }
            }


        }

    }
        /*
         * draws a 3 x 3 tic tac toe board
         */
        private static void drawBoard () {
            StdDraw.setPenColor(Color.BLACK);
            for (int i = 0; i < 4; i++) {
                StdDraw.line(0, i, 3, i);
                StdDraw.line(i, 0, i, 3);
            }

        }



}
