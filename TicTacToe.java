import java.util.Objects;
import java.util.Scanner;
import java.util.Random;
public class TicTacToe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[][] gameBoard = {{"1", "|", "2", "|", "3"},
                {"—", "+", "—", "+", "—"},
                {"4", "|", "5", "|", "6"},
                {"—", "+", "—", "+", "—"},
                {"7", "|", "8", "|", "9"}};

        String winner = null;

        printGameBoard(gameBoard);
        System.out.println("Select enter a capital X or a capital O: ");
        String playerSymbol = in.next();
        String cpuSymbol = " ";
        if (playerSymbol.equals("X")) {
            cpuSymbol = "O";
        } else {
            cpuSymbol = "X";
        }

        while (winner == null) {
            int userInput;
            int cpuInput;
            System.out.println("Enter a number from 1-9: ");
            userInput = in.nextInt();
            placePiece(gameBoard, userInput, playerSymbol);
            winner = checkWinner(gameBoard, null);

            Random rand = new Random();
            cpuInput = rand.nextInt(9) + 1;
            placePiece(gameBoard, cpuInput, cpuSymbol);
            winner = checkWinner(gameBoard, null);
        }


    }

    public static void printGameBoard(String[][] gameBoard) {
        for (String[] row : gameBoard) {
            for (String c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(String[][] gameBoard, int selection, String symbol) {
        if (selection == 1) {
            if (Objects.equals(gameBoard[0][0], "1")) {
                gameBoard[0][0] = symbol;
            } else {
                System.out.println("Invalid piece placement");
            }
        }
        if (selection == 2) {
            if (Objects.equals(gameBoard[0][2], "2")) {
                gameBoard[0][2] = symbol;
            } else {
                System.out.println("Invalid piece placement");
            }
        }
        if (selection == 3) {
            if (Objects.equals(gameBoard[0][4], "3")) {
                gameBoard[0][4] = symbol;
            } else {
                System.out.println("Invalid piece placement");
            }
        }
        if (selection == 4) {
            if (Objects.equals(gameBoard[2][0], "4")) {
                gameBoard[2][0] = symbol;
            } else {
                System.out.println("Invalid piece placement");
            }
        }
        if (selection == 5) {
            if (Objects.equals(gameBoard[2][2], "5")) {
                gameBoard[2][2] = symbol;
            } else {
                System.out.println("Invalid piece placement");
            }
        }
        if (selection == 6) {
            if (Objects.equals(gameBoard[2][4], "6")) {
                gameBoard[2][4] = symbol;
            } else {
                System.out.println("Invalid piece placement");
            }
        }
        if (selection == 7) {
            if (Objects.equals(gameBoard[4][0], "7")) {
                gameBoard[4][0] = symbol;
            } else {
                System.out.println("Invalid piece placement");
            }
        }
        if (selection == 8) {
            if (Objects.equals(gameBoard[4][2], "8")) {
                gameBoard[4][2] = symbol;
            } else {
                System.out.println("Invalid piece placement");
            }
        }
        if (selection == 9) {
            if (Objects.equals(gameBoard[4][4], "9")) {
                gameBoard[4][4] = symbol;
            } else {
                System.out.println("Invalid piece placement");
            }
        }
        printGameBoard(gameBoard);
        System.out.println(" ");
    }

    static String checkWinner(String[][] board, String winner) {
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> board[0][0] + board[0][2] + board[0][4];
                case 1 -> board[2][0] + board[2][2] + board[2][4];
                case 2 -> board[4][0] + board[4][2] + board[4][4];
                case 3 -> board[0][0] + board[2][0] + board[4][0];
                case 4 -> board[0][2] + board[2][2] + board[4][2];
                case 5 -> board[0][4] + board[2][4] + board[4][4];
                case 6 -> board[0][0] + board[2][2] + board[4][4];
                case 7 -> board[0][4] + board[2][2] + board[4][0];
                default -> null;
            };

            if (line.equals("XXX")) {
                System.out.println("Game over, X wins");
                return winner = "X";
            } else if (line.equals("OOO")) {
                System.out.println("Game over, O wins");
                return winner = "O";
            }


        }
        return null;



    }
}
