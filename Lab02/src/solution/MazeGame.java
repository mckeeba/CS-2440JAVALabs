package solution;

import java.io.FileNotFoundException;

//import java.io.NullPointerException;
import java.io.FileReader;
//import java.io.File;
import java.util.Scanner;

/**
 * A maze game.
 * 
 * @author
 * @version
 *
 */
public class MazeGame
{
    /**
     * The size of each side of the game map.
     */
    private final static int HEIGHT = 19;
    private final static int WIDTH = 39;

    /**
     * The game map, as a 2D array of ints.
     */
    private boolean[][] blocked = new boolean[HEIGHT][WIDTH];

    private boolean[][] lastAt;

    /**
     * The current location of the player vertically.
     */
    // TODO: add field here.
    int userCol;

    /**
     * The current location of the player horizontally.
     */
    // TODO: add field here.
    int userRow;

    /**
     * The scanner from which each move is read.
     */
    // TODO: add field here.
    Scanner moveScanner;

    /**
     * The row and column of the goal.
     */
    // TODO: add fields here.
    int goalRow;
    int goalCol;

    /**
     * The row and column of the start.
     */
    // TODO: add fields here.
    int startRow;
    int startCol;

    public void setBlocked(boolean[][] block)
    {
        this.blocked = block;
    }

    public boolean[][] getBlocked()
    {
        return blocked;
    }

    public void setLastAt(boolean[][] lat)
    {
        this.lastAt = lat;
    }

    public boolean[][] getLastAt()
    {
        return lastAt;
    }

    /**
     * setUserCol, sets the user column for testing
     * 
     * @param userCol
     */
    public void setUserCol(int userCol)
    {
        this.userCol = userCol;
    }

    /**
     * getUserCol, returns a copy of the user column for testing
     * 
     * @return userCol
     */
    public int getUserCol()
    {
        return userCol;
    }

    /**
     * setUserRow, sets the user row for testing
     * 
     * @param userRow
     */
    public void setUserRow(int userRow)
    {
        this.userRow = userRow;
    }

    /**
     * getUserRow, returns a copy of the user row for testing
     * 
     * @return userRow
     */
    public int getUserRow()
    {
        return userRow;
    }

    /**
     * setMoveScanner, set the move scanner for testing
     * 
     * @param moveScanner
     */
    public void setMoveScanner(Scanner moveScanner)
    {
        this.moveScanner = moveScanner;
    }

    /**
     * getMoveScanner returns a copy of the moveScanner for testing
     * 
     * @return moveScanner
     */
    public Scanner getMoveScanner()
    {
        return moveScanner;
    }

    public void setGoalRow(int goalRow)
    {
        this.goalRow = goalRow;
    }

    public int getGoalRow()
    {
        return goalRow;
    }

    public void setGoalCol(int goalCol)
    {
        this.goalCol = goalCol;
    }

    public int getGoalCol()
    {
        return goalRow;
    }

    public void setStartRow(int startRow)
    {
        this.startRow = startRow;
    }

    public int getStartRow()
    {
        return startRow;
    }

    public void setStartCol(int startCol)
    {
        this.startCol = startCol;
    }

    public int getStartCol()
    {
        return startCol;
    }

    /**
     * Constructor initializes the maze with the data in 'mazeFile'.
     * 
     * @param mazeFile
     *            the input file for the maze
     */
    public MazeGame(String mazeFile)
    {
        // loads 2D maze using loadMaze method
        loadMaze(mazeFile);

        // sets move scanner to read from user input.
        moveScanner = new Scanner(System.in);

    }

    /**
     * Constructor initializes the maze with the 'mazeFile' and the move scanner
     * with 'moveScanner'.
     * 
     * @param mazeFile
     *            the input file for the maze
     * @param moveScanner
     *            the scanner object from which to read user moves
     */
    public MazeGame(String mazeFile, Scanner moveScanner)
    {
        // loads 2D maze using loadMaze method.
        loadMaze(mazeFile);

        /**
         * moveScanner is initalized to MazeGame's input parameter(* Scanner
         * moveScanner), which is itself, so use "this" keyword.
         */
        this.moveScanner = moveScanner;
    }

    /**
     * getMaze returns a copy of the current maze for testing purposes.
     * 
     * @return the grid
     */
    public boolean[][] getMaze()
    {
        if (blocked == null)
        {
            return null;
        }
        boolean[][] copy = new boolean[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                copy[i][j] = blocked[i][j];
            }
        }
        return copy;
    }

    /**
     * setMaze sets the current map for testing purposes.
     * 
     * @param maze
     *            another maze.
     */
    public void setMaze(boolean[][] maze)
    {
        this.blocked = maze;
    }

    /**
     * Function loads the data from the maze file and creates the 'blocked' 2D
     * array.
     * 
     * @param mazeFile
     *            the input maze file.
     */
    private void loadMaze(String mazeFile)
    {
        Scanner fileIn = null;

        lastAt = new boolean[HEIGHT][WIDTH];

        blocked = new boolean[HEIGHT][WIDTH];
        
        /*
        for (int i = 0; i < lastAt.length - 1; ++i) {
            for (int j = 0; j < lastAt.length -1 ; ++j) {
                lastAt[i][j] = false;
            }
        }*/

        try
        {
            fileIn = new Scanner(new FileReader(mazeFile));

            for (int i = 0; i < HEIGHT && fileIn.hasNext(); i++)
            {
                for (int j = 0; j < WIDTH; j++)
                {
                    switch (fileIn.next().charAt(0))
                    {
                        case '1':
                            blocked[i][j] = true;

                            break;

                        case '0':
                            blocked[i][j] = false;

                            break;

                        case 'S':
                            startRow = i;
                            startCol = j;
                            blocked[i][j] = false;
                            break;

                        case 'G':
                            goalRow = i;
                            goalCol = j;
                            blocked[i][j] = false;

                            break;

                        default:

                            break;

                    }
                }
            }

        }

        catch (FileNotFoundException ioe)
        {

            System.out.println("Cannot open the INPUT file :) ");
            System.exit(0);

        }

        fileIn.close();
    }

    /**
     * Actually plays the game.
     */
    public void playGame()
    {
        String uIn = "";
        int totalMoves = 0;

        while (!(uIn.equals("quit")) && playerAtGoal() == false)
        {
            printMaze();
            System.out.println("Please make a move!");

            uIn = moveScanner.nextLine();

            makeMove(uIn);

            if (makeMove(uIn.toLowerCase()))
            {
                totalMoves++;

            }

        }

        System.out.println("This is your total Moves do better " + totalMoves);

        System.out.println("Congrats u did it lol");

    }

    /**
     * Checks to see if the player has won the game.
     * 
     * @return true if the player has won.
     */
    public boolean playerAtGoal()
    {
        boolean s = userRow == goalRow;
        boolean g = userCol == goalCol;

        return s && g;
    }

    /**
     * Makes a move based on the String.
     * 
     * @param move
     *            the direction to make a move in.
     * @return whether the move was valid.
     */
    public boolean makeMove(String move)
    {

        int i = userRow;
        int j = userCol;

        char m = move.charAt(0);

        if (m == 'u' || m == 'U')
        {
            // checks if user row is out of bounds and if its blocked
            if (i - 1 >= 0 && !blocked[i - 1][j])
            {
                userRow--;
                lastAt[userRow][userCol] = true;
                return true;
            }
        }
        else if (m == 'd' || m == 'D')
        {
            if (!(i + 1 >= HEIGHT || blocked[i + 1][j]))
            {
                userRow++;
                lastAt[userRow][userCol] = true;
                return true;
            }
        }
        else if (m == 'l' || m == 'L')
        {
            if (j - 1 >= 0 && !blocked[i][j - 1])
            {
                userCol--;
                lastAt[userRow][userCol] = true;
                return true;
            }
        }
        else if (m == 'r' || m == 'R')
        {
            if (!(j + 1 >= WIDTH || blocked[i][j + 1]))
            {
                userCol++;
                lastAt[userRow][userCol] = true;
                return true;
            }
        }
        // TODO
        return false;
    }

    /**
     * Prints the map of the maze.
     */

    public void printMaze()
    {
        // boolean[][] blocked = new boolean[HEIGHT][WIDTH];
        System.out.println("*---------------------------------------*");

        for (int i = 0; i < HEIGHT; i++)
        {
            System.out.print('|');

            for (int j = 0; j < WIDTH; j++)
            {
                if (!blocked[i][j])
                {

                    if (i == userRow && j == userCol)
                    {
                        System.out.print('@');
                    }

                    else if (i == startRow && j == startCol)
                    {
                        System.out.print('S');
                    }

                    else if (i == goalRow && j == goalCol)
                    {
                        System.out.print('G');
                    }

                    // bread crumb condition statement
                    else if (lastAt[i][j] == true)
                    {
                        System.out.print('.');
                    }

                    else if (blocked[i][j] == false)

                    {
                        System.out.print(' ');
                    }
                }
                else
                {
                    System.out.print('X');
                }
            }
            System.out.println('|');

        }
        System.out.println("*---------------------------------------*");

    }

    /**
     * Creates a new game, using a command line argument file name, if one is
     * provided.
     * 
     * @param args
     *            the command line arguments
     */

    public static void main(String[] args)
    {
        String mapFile = "data/easy.txt";
        Scanner scan = new Scanner(System.in);
        MazeGame game = new MazeGame(mapFile, scan);

        // testing print
        // game.loadMaze(mapFile);

        // game.printMaze();

        game.playGame();

        // game.loadMaze(mapFile);

    }
}
