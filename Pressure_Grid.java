import java.util.*;

public class Pressure_Grid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {
            // Setup game
            Game_components.printInstructions();
            Game_components.initializeGame();

            int currentPlayer = 1;

            while (!Game_components.gameOver) {
                Game_components.printGrid();

                // Ask for move
                System.out.print("Player " + currentPlayer + " Move (U/D/L/R): ");
                String move = scanner.nextLine().toUpperCase();

                int newRow, newCol;

                if (currentPlayer == 1) {
                    newRow = Game_components.player1Row;
                    newCol = Game_components.player1col;
                } else {
                    newRow = Game_components.player2Row;
                    newCol = Game_components.player2col;
                }

                if (move.equals("U")) newRow--;
                else if (move.equals("D")) newRow++;
                else if (move.equals("L")) newCol--;
                else if (move.equals("R")) newCol++;
                else {
                    System.out.println("Invalid input! Use U/D/L/R.");
                    continue;
                }

                // Check boundaries
                if (newRow < 0 || newRow >= Game_components.size || newCol < 0 || newCol >= Game_components.size) {
                    System.out.println("Invalid move! Stay inside the grid.");
                    continue;
                }

                // Update player position
                if (currentPlayer == 1) {
                    Game_components.player1Row = newRow;
                    Game_components.player1col = newCol;
                } else {
                    Game_components.player2Row = newRow;
                    Game_components.player2col = newCol;
                }

                // Trap check
                if (Game_components.traps[newRow][newCol]) {
                    Game_components.printGrid();
                    System.out.println("Player " + currentPlayer + " hit a trap! Game Over!");
                    Game_components.gameOver = true;
                    continue;
                }

                // Exit check
                if (newRow == Game_components.size - 1 && newCol == Game_components.size - 1) {
                    Game_components.printGrid();
                    System.out.println(" Player " + currentPlayer + " reached the exit safely! Winner!");
                    Game_components.gameOver = true;
                    continue;
                }

                // Otherwise calculate pressure
                int pressure = 0;
                for (int i = newRow - 1; i <= newRow + 1; i++) {
                    for (int j = newCol - 1; j <= newCol + 1; j++) {
                        if (i >= 0 && i < Game_components.size &&
                            j >= 0 && j < Game_components.size &&
                            Game_components.traps[i][j]) {
                            pressure++;
                        }
                    }
                }

                // Mark player’s position instead of just pressure number
                if (currentPlayer == 1) {
                    Game_components.grid[newRow][newCol] = '1'; // Player 1
                } else {
                    Game_components.grid[newRow][newCol] = '2'; // Player 2
                }

                // Switch turn at the end
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
            }

            // After game ends, ask to replay
            System.out.print("Do you want to play again? (Y/N): ");
            String answer = scanner.nextLine().toUpperCase();
            if (!answer.equals("Y")) {
                playAgain = false;
                System.out.println("Thanks for playing!");
            }
        }

        scanner.close();
    }
}
