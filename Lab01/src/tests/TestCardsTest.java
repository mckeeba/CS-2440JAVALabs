package tests;

/**
 * TestCardsTest.java
 * 
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import solution.SuitsAndRanks;
import solution.TestCards;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TestCardsTest provides the JUnit test cases for TestCards.java.
 * 
 * @author Mitch Parry
 * @version May 3, 2013
 */
public class TestCardsTest
{
    private static PrintStream stdout = null;
    private static PrintStream stderr = null;
    private static SuitsAndRanks.Rank[] ranks;
    private static SuitsAndRanks.Suit[] suits;
    private final ByteArrayOutputStream outContent =
        new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent =
        new ByteArrayOutputStream();

    /**
     * setUp runs before any of the tests.
     * 
     * @throws Exception
     *             If an exception occurs
     */
    @Before
    public void setUp() throws Exception
    {
        stdout = System.out;
        stderr = System.err;
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        ranks = SuitsAndRanks.Rank.values();
        suits = SuitsAndRanks.Suit.values();
    }

    /**
     * tearDown runs after all of the tests.
     * 
     * @throws Exception
     *             If an exception occurs
     */
    @After
    public void tearDown() throws Exception
    {
        System.setOut(stdout);
        System.setErr(stderr);
    }

    /**
     * Tests whether the deck read by the scanner is in initial deck order.
     * 
     * @param scan
     *            A scanner ready to read a deck of cards.
     */
    private void testInitialPrint(Scanner scan)
    {
        int k = 0;
        // check initial printout of deck
        for (int j = 0; j < ranks.length; j++)
        {
            for (int i = 0; i < suits.length; i++)
            {
                String error = "Prints only " + k + " cards initially.";
                assertTrue(error, scan.hasNext());

                String sRank = scan.next();
                assertTrue(error, scan.hasNext());
                String sSuit = scan.next();

                if (!sRank.equals(ranks[j].toString())
                    || !sSuit.equals(suits[i].toString()))
                {
                    scan.close();
                    fail("Initial deck in wrong order.\n" + k + "-th card "
                        + "should be " + ranks[j] + " " + suits[i] + " not "
                        + sRank + " " + sSuit);
                }
                k++;
            }
        }
    }

    /**
     * Tests whether the deck read by the scanner is shuffled.
     * 
     * @param scan
     *            A scanner ready to read a shuffled deck of cards.
     */
    private void testShuffledPrint(Scanner scan)
    {
        boolean original = true;
        int k = 0;
        for (int j = 0; j < ranks.length; j++)
        {
            for (int i = 0; i < suits.length; i++)
            {
                String error = "Prints only " + k + " shuffled cards.";
                assertTrue(error, scan.hasNext());
                String sRank = scan.next();
                assertTrue("Invalid rank", rankContains(sRank));

                assertTrue(error, scan.hasNext());
                String sSuit = scan.next();
                assertTrue("Invalid suit", suitContains(sSuit));

                if (!sRank.equals(ranks[j].toString())
                    || !sSuit.equals(suits[i].toString()))
                {
                    original = false;
                }
                k++;
            }
        }
        scan.close();
        assertFalse("The second deck printed is not shuffled.", original);
    }

    /**
     * testMain tests the main method in the TestCards class.
     */
    @Test
    public void testMain()
    {
        TestCards.main(null);
        String output = outContent.toString();
        Scanner scan = new Scanner(output);
        // check shuffled deck
        testInitialPrint(scan);
        testShuffledPrint(scan);
    }

    /**
     * rankContains checks that the 'test' string is in the enumerated Rank
     * values.
     * 
     * @param test
     *            String representation of a Rank value.
     * @return true if the 'test' string is in the enumerated Rank values.
     */
    private static boolean rankContains(String test)
    {
        for (SuitsAndRanks.Rank r : SuitsAndRanks.Rank.values())
        {
            if (r.name().equals(test))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * suitContains checks that the 'test' string is in the enumerated Suit
     * values.
     * 
     * @param test
     *            String representation of a Suit value.
     * @return true if the 'test' string is in the enumerated Suit values.
     */
    private static boolean suitContains(String test)
    {
        for (SuitsAndRanks.Suit s : SuitsAndRanks.Suit.values())
        {
            if (s.name().equals(test))
            {
                return true;
            }
        }
        return false;
    }
}
