import java.util.Random;

public class Game_components {
	static int size = 6;
    static int num_traps = 6;
    static char[][] grid = new char[size][size];
    static boolean[][] traps = new boolean[size][size];
    
    //Player 1
    static int player1Row;
    static int player1col;
     static boolean  player1Alive;

//Player2
static int player2Row;
static int player2col;
static boolean  player2Alive;


    static boolean gameOver;

    static void printInstructions() {
        System.out.println("=== Pressure Grid Game Instructions ===");
        System.out.println("1. You start at 'S' (top-left) and must reach 'E' (bottom-right).");
        System.out.println("2. There are hidden traps (X) on the grid.");
        System.out.println("3. Moves: U = Up, D = Down, L = Left, R = Right.");
        System.out.println("4. Numbers on the grid show how many traps are nearby.");
        System.out.println("5. Step on a trap and you lose. Reach the exit to win.");
        System.out.println("======================================\n");
    }


    static void initializeGame() {
        player1Row = 0;
        player1col = 0;
        player2Row = 0;
        player2col = 0;
        player1Alive = true;
        player2Alive = true;
        gameOver = false;

        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '_';
                traps[i][j] = false;
            }
        }
        grid[0][0] = 'S';
        grid[size - 1][size - 1] = 'E';

        
        Random random = new Random();
        int placed = 0;
        while (placed < num_traps) {
            int r = random.nextInt(size);
            int c = random.nextInt(size);
            if ((r == 0 && c == 0) || (r == size - 1 && c == size - 1)) continue;
            if (!traps[r][c]) {
                traps[r][c] = true;
                placed++;
            }
        }
    }

    
    static void printGrid() {
        System.out.println("\n=== Pressure Grid ===");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == player1Row && j == player1col && player1Alive) {
                    System.out.print("[ P1 ]");
                }else if ( i== player2Row && j == player2col && player2Alive){
                    System.out.print("[P2]");
                
                
                } else {
                    System.out.print("[ " + grid[i][j] + " ]");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

