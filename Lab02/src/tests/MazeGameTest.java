package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import solution.MazeGame;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the MazeGame Lab (Lab 2).
 * 
 * @author Mitch Parry
 * @author Christopher Waldon
 * @version 2014-01-21
 */
public class MazeGameTest
{

    final static private String EASY_MAP = "data/easy.txt";
    final static private String EASY_MAP_OUTPUT = "data/easy_output.txt";
    final static private String EASY_WIN_CRUMBS = "data/easy_win_crumbs.txt";
    final static private String EASY_LOSE_CRUMBS = "data/easy_lose_crumbs.txt";
    final static private String MAP_1 = "data/hard.txt";
    final static private String MAP_1_OUTPUT = "data/hard_output.txt";
    final static private int HEIGHT = 19;
    final static private int WIDTH = 39;

    final static private boolean[][] EASY_MAP_DATA = {
        {
            false, true, false, false, false, false, false, false, false, 
            false, false, false, false, true, false, false, false, false, 
            false, true, false, false, false, false, false, false, false, 
            false, false, true, false, false, false, false, false, false, 
            false, false, false
        }, {
            false, true, true, true, false, true, true, true, false, 
            true, true, true, false, true, false, true, true, true, 
            false, true, false, true, true, true, true, true, true, 
            true, false, true, false, true, true, true, true, true, 
            false, true, false
        }, {
            false, false, false, true, false, false, false, true, false, 
            true, false, true, false, true, false, true, false, true, 
            false, true, false, false, false, true, false, false, false, 
            true, false, true, false, true, false, false, false, false, 
            false, true, false
        }, {
            true, true, false, true, true, true, true, true, false, 
            true, false, true, false, true, false, true, false, true, 
            false, true, true, true, false, true, false, true, false, 
            true, false, true, false, true, false, true, true, true, 
            true, true, false
        }, {
            false, true, false, false, false, true, false, false, false, 
            true, false, true, false, false, false, true, false, true, 
            false, false, false, false, false, true, false, true, false, 
            false, false, true, false, true, false, true, false, false, 
            false, true, false
        }, {
            false, true, true, true, false, true, false, true, true, 
            true, false, true, true, true, true, true, false, true, 
            true, true, true, true, true, true, false, true, true, 
            true, true, true, true, true, false, true, false, true, 
            true, true, false
        }, {
            false, false, false, true, false, true, false, false, false, 
            true, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, true, false, false, false, 
            false, false, true, false, false, false, true, false, false, 
            false, false, false
        }, {
            true, true, false, true, false, true, false, true, false, 
            true, false, true, false, true, true, true, true, true, 
            true, true, true, true, false, true, true, true, true, 
            true, false, true, false, true, true, true, false, true, 
            true, true, true
        }, {
            false, false, false, true, false, true, false, true, false, 
            true, false, true, false, false, false, false, false, true, 
            false, false, false, false, false, true, false, false, false, 
            true, false, true, false, true, false, false, false, false, 
            false, false, false
        }, {
            false, true, true, true, false, true, true, true, false, 
            true, true, true, false, true, true, true, false, true, 
            true, true, true, true, false, true, true, true, false, 
            true, false, true, false, true, true, true, true, true, 
            true, true, false
        }, {
            false, false, false, true, false, false, false, true, false, 
            false, false, true, false, false, false, true, false, false, 
            false, false, false, true, false, false, false, false, false, 
            true, false, true, false, false, false, true, false, false, 
            false, true, false
        }, {
            false, true, false, true, true, true, false, true, true, 
            true, false, true, true, true, false, true, true, true, 
            true, true, false, true, true, true, false, true, true, 
            true, false, true, false, true, false, true, false, true, 
            false, true, true
        }, {
            false, true, false, true, false, false, false, true, false, 
            false, false, true, false, false, false, true, false, false, 
            false, true, false, true, false, true, false, true, false, 
            false, false, true, false, true, false, false, false, true, 
            false, false, false
        }, {
            false, true, false, true, false, true, true, true, false, 
            true, true, true, false, true, true, true, true, true, 
            false, true, false, true, false, true, false, true, false, 
            true, true, true, true, true, true, true, true, true, 
            true, true, false
        }, {
            false, true, false, false, false, true, false, false, false, 
            true, false, true, false, false, false, false, false, false, 
            false, true, false, true, false, false, false, true, false, 
            true, false, false, false, true, false, false, false, false, 
            false, true, false
        }, {
            false, true, true, true, true, true, false, true, true, 
            true, false, true, true, true, true, true, true, true, 
            false, true, false, true, true, true, false, true, false, 
            true, false, true, false, true, false, true, true, true, 
            false, true, false
        }, {
            false, false, false, false, false, true, false, false, false, 
            true, false, false, false, false, false, true, false, false, 
            false, true, false, false, false, true, false, true, false, 
            false, false, true, false, true, false, false, false, true, 
            false, false, false
        }, {
            true, true, true, true, false, true, true, true, false, 
            true, false, true, true, true, false, true, false, true, 
            true, true, true, true, false, true, true, true, true, 
            true, true, true, false, true, true, true, false, true, 
            true, true, false
        }, {
            false, false, false, false, false, false, false, false, false, 
            true, false, false, false, true, false, false, false, false, 
            false, false, false, true, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, true, 
            false, false, false
        }
    };

    private static final String MOVE_INPUT = "down\ndown\nright\nright\ndown\n"
        + "down\nright\nright\ndown\ndown\ndown\ndown\ndown\ndown\nright\n"
        + "right\ndown\ndown\nleft\nleft\ndown\ndown\nleft\nleft\nup\nup\nup\n"
        + "up\nleft\nleft\ndown\ndown\ndown\ndown\ndown\ndown\nright\nright\n"
        + "right\nright\ndown\ndown\nright\nright\nright\nright\nup\nup\n"
        + "left\nleft\nup\nup\nright\nright\nup\nup\nright\nright\nup\nup\n"
        + "left\nleft\nup\nup\nup\nup\nleft\nleft\nup\nup\nright\nright\nup\n"
        + "up\nup\nup\nright\nright\nright\nright\ndown\ndown\ndown\ndown\n"
        + "right\nright\nup\nup\nup\nup\nright\nright\nright\nright\ndown\n"
        + "down\ndown\ndown\nright\nright\nright\nright\nup\nup\nleft\nleft\n"
        + "up\nup\nright\nright\nright\nright\nright\nright\nright\nright\n"
        + "down\ndown\ndown\ndown\nleft\nleft\nup\nup\nleft\nleft\ndown\ndown"
        + "\ndown\ndown\nright\nright\nright\nright\ndown\ndown\ndown\ndown\n"
        + "down\ndown\nleft\nleft\ndown\ndown\ndown\ndown\nright\nright\nup\n"
        + "up\nright\nright\ndown\ndown\ndown\ndown\nright\nright\nright\n"
        + "right\nup\nup\nleft\nleft\nup\nup\nright\nright\nright\nright\n"
        + "down\ndown\nright\nright\nup\nup\nup\nup\nleft\nleft\nup\nup\n"
        + "left\nleft\ndown\ndown\nleft\nleft\nup\nup\nleft\nleft\nup\nup\n"
        + "up\nup\nright\nright\nup\nup\nup\nup\nright\nright\nright\nright\n"
        + "up\nup\nright\nright\ndown\ndown\ndown\ndown\ndown\ndown\nleft\n"
        + "left\nleft\nleft\ndown\ndown\nright\nright\nright\nright\ndown\n"
        + "down\n";

    private static final String LOSE_INPUT = "down\ndown\nright\nright\ndown\n"
        + "down\nright\nright\ndown\ndown\ndown\ndown\ndown\ndown\nright\n"
        + "right\ndown\ndown\nleft\nleft\ndown\ndown\nleft\nleft\nup\nup\nup\n"
        + "up\nleft\nleft\nup\nup\nright\nright\nup\nup\nleft\nleft\nup\nup\n"
        + "quit\n";

    /**
     * A single reference to the game being tested.
     */
    private static MazeGame game;

    /**
     * Creates a MazeGame.
     * 
     * @throws Exception
     *             if something goes wrong during setup
     */
    @Before
    public void setUp() throws Exception
    {
    }

    /**
     * Checks to see if the map matches the correct 2D array.
     * 
     * @param correct
     *            The correct 2d array
     * @param blocked
     *            The blocked 2d array from the maze.
     */
    private void checkMaze(boolean[][] correct, boolean[][] blocked)
    {
        assertEquals("The map has the wrong number of rows.", correct.length,
            blocked.length);
        for (int i = 0; i < correct.length; i++)
        {
            // assertArrayEquals("Row " + i + " of the map is incorrect.", 
            // correct[i], map[i]);
            assertTrue("Row " + i + " of the maze is incorrect.", 
                Arrays.equals(correct[i],  blocked[i]));
        }
    }

    /**
     * Checks the one argument constructor.
     * 
     * @throws FileNotFoundException
     *             if EASY_MAP does not exist.
     */
    @Test
    public void testOneArgConstructor() throws FileNotFoundException
    {
        game = new MazeGame(EASY_MAP);
        assertNotNull("One argument constructor fails to create maze.",
            game.getMaze());
        assertNotNull("One argument constructor fails to create userInput.",
            game.getMoveScanner());
        assertEquals("One argument constructor fails to initialize userRow.",
            0, game.getUserRow());
        assertEquals("One argument constructor fails to initialize userCol.",
            0, game.getUserCol());
        checkMaze(EASY_MAP_DATA, game.getMaze());
    }

    /**
     * Checks the two argument constructor.
     * 
     */
    @Test
    public void testConstructor() 
    {
        Scanner scan = new Scanner(System.in);
        game = new MazeGame(EASY_MAP, scan);
        assertNotNull("Two argument constructor fails to create map.",
            game.getMaze());
        assertNotNull("Two argument constructor fails to create userInput.",
            game.getMoveScanner());
        assertEquals("Two argument constructor fails to initialize userRow.",
            0, game.getUserRow());
        assertEquals("Two argument constructor fails to initialize userCol.",
            0, game.getUserCol());
        assertEquals("Two argument constructor fails to set input.", scan,
            game.getMoveScanner());
        checkMaze(EASY_MAP_DATA, game.getMaze());
    }

    /**
     * Checks setter and getter for userRow.
     * 
     * @throws FileNotFoundException
     *             if EASY_MAP does not exist
     */
    @Test
    public void testSetGetUserRow() throws FileNotFoundException
    {
        game = new MazeGame(EASY_MAP);
        game.setUserRow(3);
        int r = game.getUserRow();
        assertEquals("After setUserRow(3), getUserRow() = " + r, 3, r);
    }

    /**
     * Checks setter and getter for userCol.
     * 
     * @throws FileNotFoundException
     *             if EASY_MAP does not exist
     */
    @Test
    public void testSetGetUserCol() throws FileNotFoundException
    {
        game = new MazeGame(EASY_MAP);
        game.setUserCol(3);
        int c = game.getUserCol();
        assertEquals("After setUserCol(3), getUserCol() = " + c, 3, c);
    }

    /**
     * Checks get and set map.
     * 
     * @throws FileNotFoundException
     *             if EASY_MAP does not exist
     */
    @Test
    public void testSetGetMap() throws FileNotFoundException
    {
        game = new MazeGame(EASY_MAP);
        game.setMaze(EASY_MAP_DATA);
        boolean[][] map = game.getMaze();
        assertNotNull("Map must not be null.", map);
        checkMaze(EASY_MAP_DATA, game.getMaze());
    }

    /**
     * Checks get and set input.
     * 
     */
    @Test
    public void testSetGetInput() 
    {
        game = new MazeGame(EASY_MAP);
        Scanner scan = new Scanner(System.in);
        game.setMoveScanner(scan);
        assertNotNull("Set/Get input fails: input should not be null",
            game.getMoveScanner());
        assertEquals("Set/Get input fails.", scan, game.getMoveScanner());
    }

    /**
     * Tests whether the student's printMap() method correctly outputs the map.
     * 
     * @throws FileNotFoundException
     *             if the map file is not found.
     */
    @Test
    public void testPrintMap() throws FileNotFoundException
    {
        // Create output redirects
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream stdout = System.out;
        // Set System to use redirects
        System.setOut(new PrintStream(outContent));

        // Capture the output of the printMap()
        game = new MazeGame(EASY_MAP);
        game.printMaze();

        // Return System output to normal
        System.setOut(stdout);

        // Prepare to parse output
        String output = outContent.toString();
        System.out.println(output);
        Scanner outputScan = new Scanner(output);
        Scanner file = null;
        try
        {
            file = new Scanner(new FileReader(EASY_MAP_OUTPUT));
        }
        catch (FileNotFoundException e)
        {
            outputScan.close();
            fail(EASY_MAP_OUTPUT + " not found.");
        }

        compareOutputToSource(outputScan, file);

        file.close();
        outputScan.close();
    }

    /**
     * Compares one line from the correct string to one line from the output
     * string.
     * 
     * @param correct
     *            The correct string
     * @param read
     *            The program output string for comparison
     */
    private void compareLines(String correct, String read)
    {
        // Create Line Scanners
        Scanner fileLine = new Scanner(correct);
        Scanner outputLine = new Scanner(read);
        while (fileLine.hasNext() && outputLine.hasNext())
        {
            String fileToken = fileLine.next();
            //.replaceAll("[^0-9]", "x");
            String outputToken = outputLine.next();
            //.replaceAll("[^0-9]", "x");
            if (!fileToken.equals(outputToken))
            {
                fileLine.close();
                outputLine.close();
                fail("Print output did not match file "
                    + "('x' means any non number):\n\tcorrect token: "
                    + correct + "\n\tstudent token: " + read + "\n");
            }
        }
        if (outputLine.hasNext() && !fileLine.hasNext()
            || !outputLine.hasNext() && fileLine.hasNext())
        {
            fileLine.close();
            outputLine.close();
            fail("Number of tokens does not match: \n\tcorrect line: "
                + correct + "\n\tstudent line: " + read + "\n");
        }
        fileLine.close();
        outputLine.close();
    }

    /**
     * Compares a scanner moving through program out put to a source file,
     * checking whether the output matches the source.
     * 
     * @param outputScanner
     *            Scanner pointed at output
     * @param file
     *            Scanner pointed at comparison file
     */
    private void compareOutputToSource(Scanner outputScanner, Scanner file)
    {
        // Compare source file to output
        while (file.hasNextLine())
        {
            compareLines(file.nextLine(), outputScanner.nextLine());
        }
        if (outputScanner.hasNextLine())
        {
            fail("output has too many lines: \"" + outputScanner.nextLine()
                + "\"");
        }
    }

    /**
     * Tests whether the student's printMap() method correctly outputs the map.
     * 
     * @throws FileNotFoundException
     *             if the map file is not found.
     */
    @Test
    public void testPrintMap2() throws FileNotFoundException
    {
        // Create output redirects
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream stdout = System.out;
        // Set System to use redirects
        System.setOut(new PrintStream(outContent));

        // Capture the output of the printMap()
        game = new MazeGame(MAP_1);
        game.setUserRow(2);
        game.setUserCol(7);
        game.printMaze();

        // Return System output to normal
        System.setOut(stdout);

        // Prepare to parse output
        String output = outContent.toString();
        Scanner outputScan = new Scanner(output);
        Scanner file = null;
        try
        {
            file = new Scanner(new FileReader(MAP_1_OUTPUT));
        }
        catch (FileNotFoundException e)
        {
            outputScan.close();
            fail(MAP_1_OUTPUT + " not found.");
        }

        compareOutputToSource(outputScan, file);

        file.close();
        outputScan.close();
    }

    /**
     * Helper method.
     * 
     * @param method
     *            the method name
     * @param row
     *            the start row
     * @param correctRow
     *            the expected row
     * @param newRow
     *            the observed row
     */
    private void testRow(String method, int row, int correctRow, int newRow)
    {
        assertEquals("Starting at row = " + row + ", after " + method 
            + " row should be " + correctRow + " not " + newRow, 
            correctRow, newRow);
    }

    /**
     * Helper method.
     * 
     * @param method
     *            the method name
     * @param col
     *            the start col
     * @param correctCol
     *            the expected col
     * @param newCol
     *            the observed col
     */
    private void testCol(String method, int col, int correctCol,
        int newCol)
    {
        assertEquals("Starting at col = " + col + ", after " + method 
            + " col should be " + correctCol + " not " + newCol, 
            correctCol, newCol);
    }

    /**
     * Test the student's program for proper movement upwards.
     * (Boundary)
     */
    @Test
    public void testMakeMoveUp()
    {
        int row = 2;
        int col = 1;
        game = new MazeGame(EASY_MAP);
        game.setUserRow(row);
        game.setUserCol(col);
        game.makeMove("up");
        int newRow = game.getUserRow();
        int newCol = game.getUserCol();
        int correctRow = row;
        int correctCol = col;
        testRow("makeMove(\"up\")", row, correctRow, newRow);
        testCol("makeMove(\"up\")", col, correctCol, newCol);
    }

    /**
     * Test the student's program for proper movement upwards.
     * (Blocked)
     */
    @Test
    public void testMakeMoveUp2()
    {
        int row = 2;
        int col = 1;
        game = new MazeGame(EASY_MAP);
        game.setUserRow(row);
        game.setUserCol(col);
        game.makeMove("up");
        int newRow = game.getUserRow();
        int newCol = game.getUserCol();
        int correctRow = row;
        int correctCol = col;
        testRow("makeMove(\"up\")", row, correctRow, newRow);
        testCol("makeMove(\"up\")", col, correctCol, newCol);
    }

    /**
     * Test the student's program for proper movement upwards.
     * (Open)
     */
    @Test
    public void testMakeMoveUp3()
    {
        int row = 3;
        int col = 2;
        game = new MazeGame(EASY_MAP);
        game.setUserRow(row);
        game.setUserCol(col);
        game.makeMove("up");
        int newRow = game.getUserRow();
        int newCol = game.getUserCol();
        int correctRow = row - 1;
        int correctCol = col;
        testRow("makeMove(\"up\")", row, correctRow, newRow);
        testCol("makeMove(\"up\")", col, correctCol, newCol);
    }

    /**
     * Test the student's program for proper movement downwards.
     * (Boundary)
     */
    @Test
    public void testMakeMoveDown()
    {
        int row = HEIGHT - 1;
        int col = 5;
        game = new MazeGame(EASY_MAP);
        game.setUserRow(row);
        game.setUserCol(col);
        game.makeMove("down");
        int newRow = game.getUserRow();
        int newCol = game.getUserCol();
        int correctRow = row;
        int correctCol = col;
        testRow("makeMove(\"down\")", row, correctRow, newRow);
        testCol("makeMove(\"down\")", col, correctCol, newCol);
    }

    /**
     * Test the student's program for proper movement downwards.
     * (Blocked)
     */
    @Test
    public void testMakeMoveDown2()
    {
        int row = 0;
        int col = 2;
        game = new MazeGame(EASY_MAP);
        game.setUserRow(row);
        game.setUserCol(col);
        game.makeMove("down");
        int newRow = game.getUserRow();
        int newCol = game.getUserCol();
        int correctRow = row;
        int correctCol = col;
        testRow("makeMove(\"down\")", row, correctRow, newRow);
        testCol("makeMove(\"down\")", col, correctCol, newCol);
    }

    /**
     * Test the student's program for proper movement downwards.
     * (Open)
     */
    @Test
    public void testMakeMoveDown3()
    {
        int row = 0;
        int col = 4;
        game = new MazeGame(EASY_MAP);
        game.setUserRow(row);
        game.setUserCol(col);
        game.makeMove("down");
        int newRow = game.getUserRow();
        int newCol = game.getUserCol();
        int correctRow = row + 1;
        int correctCol = col;
        testRow("makeMove(\"down\")", row, correctRow, newRow);
        testCol("makeMove(\"down\")", col, correctCol, newCol);
    }

    /**
     * Test the student's program for proper movement to the left.
     * (Boundary)
     */
    @Test
    public void testMakeMoveLeft()
    {
        int row = 10;
        int col = 0;
        game = new MazeGame(EASY_MAP);
        game.setUserRow(row);
        game.setUserCol(col);
        game.makeMove("left");
        int newRow = game.getUserRow();
        int newCol = game.getUserCol();
        int correctRow = row;
        int correctCol = col;
        testRow("makeMove(\"left\")", row, correctRow, newRow);
        testCol("makeMove(\"left\")", col, correctCol, newCol);
    }

    /**
     * Test the student's program for proper movement to the left.
     * (Blocked)
     */
    @Test
    public void testMakeMoveLeft2()
    {
        int row = 9;
        int col = 4;
        game = new MazeGame(EASY_MAP);
        game.setUserRow(row);
        game.setUserCol(col);
        game.makeMove("left");
        int newRow = game.getUserRow();
        int newCol = game.getUserCol();
        int correctRow = row;
        int correctCol = col;
        testRow("makeMove(\"left\")", row, correctRow, newRow);
        testCol("makeMove(\"left\")", col, correctCol, newCol);
    }

    /**
     * Test the student's program for proper movement to the left.
     * (Open)
     */
    @Test
    public void testMakeMoveLeft3()
    {
        int row = 2;
        int col = 2;
        game = new MazeGame(EASY_MAP);
        game.setUserRow(row);
        game.setUserCol(col);
        game.makeMove("left");
        int newRow = game.getUserRow();
        int newCol = game.getUserCol();
        int correctRow = row;
        int correctCol = col - 1;
        testRow("makeMove(\"left\")", row, correctRow, newRow);
        testCol("makeMove(\"left\")", col, correctCol, newCol);
    }

    /**
     * Test the student's program for proper movement to the right.
     * (Boundary)
     */
    @Test
    public void testMakeMoveRight()
    {
        int row = 1;
        int col = WIDTH - 1;
        game = new MazeGame(EASY_MAP);
        game.setUserRow(row);
        game.setUserCol(col);
        game.makeMove("right");
        int newRow = game.getUserRow();
        int newCol = game.getUserCol();
        int correctRow = row;
        int correctCol = col;
        testRow("makeMove(\"right\")", row, correctRow, newRow);
        testCol("makeMove(\"right\")", col, correctCol, newCol);
    }

    /**
     * Test the student's program for proper movement to the right.
     * (Blocked)
     */
    @Test
    public void testMakeMoveRight2()
    {
        int row = 1;
        int col = 4;
        game = new MazeGame(EASY_MAP);
        game.setUserRow(row);
        game.setUserCol(col);
        game.makeMove("right");
        int newRow = game.getUserRow();
        int newCol = game.getUserCol();
        int correctRow = row;
        int correctCol = col;
        testRow("makeMove(\"right\")", row, correctRow, newRow);
        testCol("makeMove(\"right\")", col, correctCol, newCol);
    }

    /**
     * Test the student's program for proper movement to the right.
     * (Open)
     */
    @Test
    public void testMakeMoveRight3()
    {
        int row = 2;
        int col = 4;
        game = new MazeGame(EASY_MAP);
        game.setUserRow(row);
        game.setUserCol(col);
        game.makeMove("right");
        int newRow = game.getUserRow();
        int newCol = game.getUserCol();
        int correctRow = row;
        int correctCol = col + 1;
        testRow("makeMove(\"right\")", row, correctRow, newRow);
        testCol("makeMove(\"right\")", col, correctCol, newCol);
    }

    /**
     * Test the student's program for handling invalid move.
     */
    @Test
    public void testMakeMoveInvalid()
    {
        int row = 7;
        int col = 6;
        game = new MazeGame(EASY_MAP);
        game.setUserRow(row);
        game.setUserCol(col);
        game.makeMove("what");
        int newRow = game.getUserRow();
        int newCol = game.getUserCol();
        int correctRow = row;
        int correctCol = col;
        testRow("makeMove(\"someInvalidCommand\")", row, correctRow, newRow);
        testCol("makeMove(\"someInvalidCommand\")", col, correctCol, newCol);
    }

    /**
     * Test the student's program for handling invalid move.
     * 
     * @throws FileNotFoundException
     *             if the map file is not found.
     */
    @Test
    public void testMakeMoveInvalid2() throws FileNotFoundException
    {
        int row = 4;
        int col = 7;
        game = new MazeGame(EASY_MAP);
        game.setUserRow(row);
        game.setUserCol(col);
        game.makeMove("hello");
        int newRow = game.getUserRow();
        int newCol = game.getUserCol();
        int correctRow = row;
        int correctCol = col;
        testRow("makeMove(\"someInvalidCommand\")", row, correctRow, newRow);
        testCol("makeMove(\"someInvalidCommand\")", col, correctCol, newCol);
    }

    /**
     * Checks whether the playerAtGoal() method correctly evaluates for the 
     * goal and for non-goal spaces.
     */
    @Test
    public void testPlayerAtGoal()
    {
        game = new MazeGame(EASY_MAP);

        // goal
        int goalRow = 10;
        int goalCol = WIDTH - 1;
        game.setUserRow(goalRow);
        game.setUserCol(goalCol);
        assertTrue("playerAtGoal incorrect for (" + goalRow + "," + goalCol 
            + ")", game.playerAtGoal());
        
        // not goals
        int[] notGoalRows = {0, WIDTH - 1, 10};
        int[] notGoalCols = {0, 10, 7};
        for (int i = 0; i < notGoalRows.length; i++)
        {
            game.setUserRow(notGoalRows[i]);
            game.setUserCol(notGoalCols[i]);
            assertFalse("playerInCorner incorrect for (" + notGoalRows[i] + ","
                + notGoalCols[i] + ")", game.playerAtGoal());
        }
    }

    /**
     * Tests that the game loop is working for a winning game.
     */
    @Test
    public void testWinPlayGame() 
    {
        Scanner scan = new Scanner(MOVE_INPUT);
        game = new MazeGame(EASY_MAP, scan);
        game.playGame();
        scan.close();
        assertTrue("After winning the game by making a sequence of commands, "
            + "the player should be in the corner.", game.playerAtGoal());
    }

    /**
     * Ensures that the game loop is working for a losing game.
     */
    @Test
    public void testLosePlayGame()
    {
        Scanner scan = new Scanner(LOSE_INPUT);
        game = new MazeGame(EASY_MAP, scan);
        game.playGame();
        int r = game.getUserRow();
        int c = game.getUserCol();
        scan.close();
        assertEquals("After losing the game by making a sequence of commands "
            + "terminated by a 'quit' command, the row should " + "be 4 not "
            + r, 4, r);
        assertEquals("After losing the game by making a sequence of commands "
            + "terminated by a 'quit' command, the column should "
            + "be 0 not " + c, 0, c);
    }

    /**
     * Helper method to check that the right bread crumbs are printed.
     * @param moves The list of moves.
     * @param mazeFile The input maze file.
     * @param correctOutputFile The file containing the correct output.
     */
    private void breadCrumbHelper(String moves, String mazeFile, 
        String correctOutputFile)
    {
        Scanner scan = new Scanner(moves);
        game = new MazeGame(mazeFile, scan);
        game.playGame();
        scan.close();
        
        // Create output redirects
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream stdout = System.out;
        // Set System to use redirects
        System.setOut(new PrintStream(outContent));

        // Capture the output of the printMap()        
        game.printMaze();

        // Return System output to normal
        System.setOut(stdout);

        // Prepare to parse output
        String output = outContent.toString();
        System.out.println(output);
        Scanner outputScan = new Scanner(output);
        Scanner file = null;
        try
        {
            file = new Scanner(new FileReader(correctOutputFile));
        }
        catch (FileNotFoundException e)
        {
            outputScan.close();
            fail(EASY_MAP_OUTPUT + " not found.");
        }

        compareOutputToSource(outputScan, file);

        file.close();
        outputScan.close();        
    }
    
    /**
     * Tests whether the student's printMap() method correctly outputs the map 
     * with bread crumbs.
     */
    @Test
    public void testBreadCrumbs()
    {
        breadCrumbHelper(MOVE_INPUT, EASY_MAP, EASY_WIN_CRUMBS);
    }

    /**
     * Tests whether the student's printMap() method correctly outputs the map 
     * with bread crumbs.
     */
    @Test
    public void testBreadCrumbs2()
    {
        breadCrumbHelper(LOSE_INPUT, EASY_MAP, EASY_LOSE_CRUMBS);
    }

}
