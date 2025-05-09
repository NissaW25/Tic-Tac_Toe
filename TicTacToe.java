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

        int[][] board = new int[3][3];
        int moves = 0; // tracks number of moves during game
        int x, y;
        // currentPlayer should be set to 1 or 2
        int currentPlayer = 1;
        double mx;
        double my;
        double bx;
        double by;
        boolean gameWon = false;

        StdDraw.setCanvasSize(500, (int) (500 * 1.3));
        StdDraw.setXscale(-0.1, 3.1);
        StdDraw.setYscale(-0.1, 4.1);

        StdDraw.setPenRadius(0.005);

        drawBoard(); // displays board when running


        // Announce that it's player 1's turn
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(1.5, 3.75, "Player " + currentPlayer + ": your turn");


        while (moves < 9) { // allowing enough moves within the board
            if (StdDraw.isMousePressed()) {
                mx = StdDraw.mouseX();
                my = StdDraw.mouseY();
                bx = (int) mx + 0.5;
                by = (int) my + 0.5;


                if (mx >= 0 && mx <= 3 && my >= 0 && my <= 3) {
                    x = (int) mx;
                    y = (int) my;

                    if (board[x][y] == 0) {
                        board[x][y] = currentPlayer;


                        if (currentPlayer == 1) {
                            StdDraw.setPenColor(Color.PINK); // drawing o's
                            StdDraw.circle(bx, by, 0.5);
                        } else {
                            StdDraw.setPenColor(Color.GRAY); // drawing x's
                            StdDraw.line(bx + 0.5, by - 0.5, bx - 0.5, by + 0.5);
                            StdDraw.line(bx - 0.5, by - 0.5, bx + 0.5, by + 0.5);
                        }
                        moves++;

                        // Checking for and declaring winner
                        if (winnerCheck(board, currentPlayer)) {
                            StdDraw.setPenColor(Color.white);
                            StdDraw.filledRectangle(1.5, 3.75, 1, 0.2);
                            StdDraw.setPenColor(Color.GREEN);
                            StdDraw.text(1.5, 3.75, "Player " + currentPlayer + " wins!");
                            gameWon = true;
                            break;
                        }

                        currentPlayer = (currentPlayer == 1) ? 2 : 1;

                        StdDraw.setPenColor(Color.white);
                        StdDraw.filledRectangle(1.5, 3.75, 1, 0.2);
                        StdDraw.setPenColor(Color.black);
                        StdDraw.text(1.5, 3.75, "Player " + currentPlayer + ": your turn");
                        StdDraw.pause(300);
                    }
                }
            }


        }

        // Declares a draw
        if(!gameWon) {
            StdDraw.setPenColor(Color.white);
            StdDraw.filledRectangle(1.5, 3.75, 1, 0.2);
            StdDraw.setPenColor(Color.BLUE);
            StdDraw.text(1.5, 3.75, "It's a draw!");
        }


    }

        //draws a 3 x 3 tic tac toe board
        private static void drawBoard () {
            StdDraw.setPenColor(Color.BLACK);
            for (int i = 0; i < 4; i++) {
                StdDraw.line(0, i, 3, i);
                StdDraw.line(i, 0, i, 3);
            }

        }

        private static boolean winnerCheck(int[][] board, int player) {
            // Check rows and columns
            for (int i = 0; i < 3; i++) {
                if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                        (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                    return true;
                }
            }
            // Check diagonals
            return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                    (board[0][2] == player && board[1][1] == player && board[2][0] == player);
        }



}
