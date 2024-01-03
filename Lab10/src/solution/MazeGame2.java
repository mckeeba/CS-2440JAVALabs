package solution;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * MazeGame2 is a backtracking version of MazeGame.
 * 
 * @author Mitch Parry
 * @version 2015-06-02
 */
public class MazeGame2
{
    /**
     * The size of each side of the game map.
     */
    private final static int HEIGHT = 99;
    private final static int WIDTH = 99;

    /**
     * The game map, as a 2D array of ints.
     */
    private boolean[][] wall;
    private boolean[][] visited;

    private final static int START = 0;
    private final static int GOAL = 98;

    /**
     * Constructor sets up the maps and the path list.
     * 
     * @param mazeFile
     *            - name of the file containing the map
     */
    public MazeGame2(String mazeFile)
    {
        loadMaze(mazeFile);
        visited = new boolean[HEIGHT][WIDTH];

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
        wall = new boolean[HEIGHT][WIDTH];
        Scanner mazeScanner;
        try
        {
            mazeScanner = new Scanner(new FileReader(mazeFile));
            for (int i = 0; i < HEIGHT; i++)
            {
                for (int j = 0; j < WIDTH; j++)
                {
                    if (mazeScanner.next().equals("1"))
                    {

                        wall[i][j] = true;

                    }
                }
            }
            mazeScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + mazeFile);
        }
    }

    /**
     * Non-recursive starter method for finding the path.
     * 
     * @return The path (no solution if null.)
     */
    public String findSolution()
    {
        // Call recursive method from here and return the string
        // representing the path.
        return backtrack(0, 0, "");
    }

    public Boolean validMove(int row, int col)
    {
        return (row >= START && row <= GOAL && col >= START && col <= GOAL
            && wall[row][col] == false);
    }

    /**
     * Recursive backtracking method for finding a path from a starting point.
     * 
     * @param row
     *            - row of starting point
     * @param col
     *            - column of starting point
     * @param pathSoFar
     *            - the current path so far.
     * @return whether a path was found
     */
    public String backtrack(int row, int col, String pathSoFar)
    {
        // TODO: write the recursive backtrack algorithm.
        // fix the return value!
        String result = "";

        visited[row][col] = true;
        if (row == GOAL && col == GOAL)
        {
            return pathSoFar;
        }

        else
        {
            // check for up
            if (validMove(row - 1, col) && visited[row - 1][col] == false)
            {
                result = backtrack(row - 1, col, pathSoFar + "up ");
                if (result != null)
                {
                    return result;
                }
            }

            // check for right
            if (validMove(row, col + 1) && visited[row][col + 1] == false)
            {
                result = backtrack(row, col + 1, pathSoFar + "right ");
                if (result != null)
                {
                    return result;
                }
            }

            // check for down
            if (validMove(row + 1, col) && visited[row + 1][col] == false)
            {
                result = backtrack(row + 1, col, pathSoFar + "down ");
                if (result != null)
                {
                    return result;
                }
            }

            // check for left
            if (validMove(row, col - 1) && visited[row][col - 1] == false)
            {
                result = backtrack(row, col - 1, pathSoFar + "left ");
                if (result != null)
                {
                    return result;
                }
            }

            // if none of these return null

            return null;

        }

    }

    /**
     * Prints the map.
     */
    public void printMap()
    {
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                if (wall[i][j])
                {
                    System.out.print("X");
                }
                else
                {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Creates a new TreasureHunt2 object and tries to find a solution.
     * 
     * @param args
     *            - command line arguments
     */
    public static void main(String[] args)
    {
        MazeGame2 t = new MazeGame2("data/maze0.txt");
        t.printMap();
        String solution = t.findSolution();
        t.printMap();
        if (solution != null)
        {
            System.out.println(solution);
        }
        else
        {
            System.out.println("There is no solution.");
        }
    }
}
