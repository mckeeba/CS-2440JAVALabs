package tests;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.junit.Test;

import solution.MazeGame2;

/**
 * Class to test the backtracking algorithm to solve the Maze game.
 * 
 * @author Mitch Parry
 * @version 2015-06-02
 * 
 */
public class MazeGame2Test
{
    
    private static final int WIDTH = 99;
    private static final int HEIGHT = 99;

    /**
     * Reads the game board from a file.
     * 
     * @param mapFile
     *            The text file with the game board.
     * @return A 2D boolean array indicating where the walls are.
     * @throws FileNotFoundException
     *             if the mapFile does not exist.
     */
    public static boolean[][] getBoard(String mapFile) 
        throws FileNotFoundException
    {
        boolean[][] map = new boolean[HEIGHT][WIDTH];
        FileReader fr = new FileReader(mapFile);
        Scanner input = new Scanner(fr);
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                if (input.next().equals("1"))
                {
                    map[i][j] = true;
                }
            }
        }
        input.close();
        return map;
    }

    /**
     * Converts the board into a string representation.
     * 
     * @param board
     *            The game board.
     * @return the string representation.
     */
    public static String getMapString(boolean[][] board)
    {
        String b = "";
        for (boolean[] row : board)
        {
            for (boolean col : row)
            {
                if (col)
                {
                    b += "X ";
                }
                else
                {
                    b += "  ";
                }
            }
            b += "\n";
        }
        return b;
    }

    /**
     * Checks to see if the moves in scanner win the game in board.
     * 
     * @param scan
     *            The scanner of moves.
     * @param board
     *            The board game.
     * @return whether or not the moves win the game.
     */
    public static boolean winsGame(Scanner scan, boolean[][] board)
    {
        int r = 0;
        int c = 0;
        while (scan.hasNext())
        {
            char cmd = scan.next().toLowerCase().charAt(0);
            c += cmd == 'l' ? -1 : 0;
            c += cmd == 'r' ? 1 : 0;
            r += cmd == 'u' ? -1 : 0;
            r += cmd == 'd' ? 1 : 0;
            if (cmd != 'l' && cmd != 'r' && cmd != 'u' && cmd != 'd')
            {
                throw new IllegalArgumentException("command starts w/ " + cmd);
            }
            if (c < 0 || c >= WIDTH || r < 0 || r >= HEIGHT)
            {
                throw new IllegalArgumentException("Moved off board");
            }
            if (board[r][c])
            {
                throw new IllegalArgumentException("Moved into wall");
            }
        }
        return r == HEIGHT - 1 && c == WIDTH - 1;
    }

    /**
     * Checks the solution of the game described in the mapFile by playing the
     * game to see if it succeeds.
     * 
     * @param mapFile
     *            The game map file.
     * @param solution
     *            The sequence of moves (left, right, up, or down).
     * @throws FileNotFoundException
     *             if the map file does not exist.
     */
    public static void checkSolution(String mapFile, String solution)
        throws FileNotFoundException
    {
        if (solution != null)
        {

            boolean[][] board = getBoard(mapFile);

            Scanner scan = new Scanner(solution);
            if (!winsGame(scan, board))
            {
                scan.close();
                String b = getMapString(board);
                fail("Sequence of moves does not win the game.\nboard: \n" + b
                        + "moves: \n" + solution);
            }
            scan.close();
        }
        else
        {
            boolean[][] board = getBoard(mapFile);
            String b = getMapString(board);
            throw new NullPointerException(mapFile
                    + " : solution should not be null.\n" + b);
        }
    }

    /**
     * Tests a game.
     * 
     * @throws FileNotFoundException
     *             if the file does not exist.
     */
    @Test
    public void test1() throws FileNotFoundException
    {
        String mapFile = "data/mazeA1.txt";
        MazeGame2 game = new MazeGame2(mapFile);
        String solution = game.findSolution();
        checkSolution(mapFile, solution);
    }

    /**
     * Tests a game.
     * 
     * @throws FileNotFoundException
     *             if the file does not exist.
     */
    @Test
    public void test2() throws FileNotFoundException
    {
        String mapFile = "data/mazeA2.txt";
        MazeGame2 game = new MazeGame2(mapFile);
        String solution = game.findSolution();
        checkSolution(mapFile, solution);
    }

    /**
     * Tests a game.
     * 
     * @throws FileNotFoundException
     *             if the file does not exist.
     */
    @Test
    public void test3() throws FileNotFoundException
    {
        String mapFile = "data/mazeB1.txt";
        MazeGame2 game = new MazeGame2(mapFile);
        String solution = game.findSolution();
        checkSolution(mapFile, solution);
    }

    /**
     * Tests a game.
     * 
     * @throws FileNotFoundException
     *             if the file does not exist.
     */
    @Test
    public void test4() throws FileNotFoundException
    {
        String mapFile = "data/mazeB2.txt";
        MazeGame2 game = new MazeGame2(mapFile);
        String solution = game.findSolution();
        checkSolution(mapFile, solution);
    }

    /**
     * Tests a game.
     * 
     * @throws FileNotFoundException
     *             if the file does not exist.
     */
    @Test
    public void test5() throws FileNotFoundException
    {
        String mapFile = "data/mazeC1.txt";
        MazeGame2 game = new MazeGame2(mapFile);
        String solution = game.findSolution();
        checkSolution(mapFile, solution);
    }

    /**
     * Tests a game.
     * 
     * @throws FileNotFoundException
     *             if the file does not exist.
     */
    @Test
    public void test6() throws FileNotFoundException
    {
        String mapFile = "data/mazeC2.txt";
        MazeGame2 game = new MazeGame2(mapFile);
        String solution = game.findSolution();
        checkSolution(mapFile, solution);
    }

    /**
     * Tests a game.
     * 
     * @throws FileNotFoundException
     *             if the file does not exist.
     */
    @Test
    public void test7() throws FileNotFoundException
    {
        String mapFile = "data/mazeD1.txt";
        MazeGame2 game = new MazeGame2(mapFile);
        String solution = game.findSolution();
        assertNull("The file " + mapFile + " does not contain a solution.\n"
                + "findSolution should return null.", solution);
    }

    /**
     * Tests a game.
     * 
     * @throws FileNotFoundException
     *             if the file does not exist.
     */
    @Test
    public void test8() throws FileNotFoundException
    {
        String mapFile = "data/mazeD2.txt";
        MazeGame2 game = new MazeGame2(mapFile);
        String solution = game.findSolution();
        assertNull("The file " + mapFile + " does not contain a solution.\n"
                + "findSolution should return null.", solution);
    }

    /**
     * Tests a game.
     * 
     * @throws FileNotFoundException
     *             if the file does not exist.
     */
    @Test
    public void test9() throws FileNotFoundException
    {
        boolean[] noSolution = {false, true, false, false, false};
        for (int i = 1; i <= 2; i++)
        {
            String mapFile = "data/maze" + i + ".txt";
            MazeGame2 game = new MazeGame2(mapFile);
            String solution = game.findSolution();
            if (noSolution[i - 1])
            {
                assertNull("The file " + mapFile
                        + " does not contain a solution.\n"
                        + "findSolution should return null.", solution);
            }
            else
            {
                checkSolution(mapFile, solution);
            }
        }
    }

    /**
     * Tests a game.
     * 
     * @throws FileNotFoundException
     *             if the file does not exist.
     */
    @Test
    public void test10() throws FileNotFoundException
    {
        boolean[] noSolution = {true, false, true, false, true};
        for (int i = 5; i <= 6; i++)
        {
            String mapFile = "data/maze" + i + ".txt";
            MazeGame2 game = new MazeGame2(mapFile);
            String solution = game.findSolution();
            if (noSolution[i - 5])
            {
                assertNull("The file " + mapFile
                        + " does not contain a solution.\n"
                        + "findSolution should return null.", solution);
            }
            else
            {
                checkSolution(mapFile, solution);
            }
        }
    }

}
