package tests;

/**
 * SuitsAndRanksTest.java
 * 
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import solution.SuitsAndRanks;

import org.junit.Test;

/**
 * SuitsAndRanksTest contains JUnit tests for the SuitsAndRanks class. *
 * 
 * @author Mitch Parry
 * @version May 3, 2013
 */

public class SuitsAndRanksTest
{
    /**
     * CorrectRank is what the students should have provided verbatim.
     */
    protected enum CorrectRank
    {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, 
        JACK, QUEEN, KING, ACE
    };

    /**
     * CorrectSuit is what the students should have provided verbatim.
     */
    protected enum CorrectSuit
    {
        CLUBS, DIAMONDS, HEARTS, SPADES
    };

    /**
     * testRankEnum checks that the SuitsAndRanks class correctly implements the
     * enumerated Rank type.
     */
    @Test
    public void testRankEnum()
    {
        // correct enum
        SuitsAndRanks.Rank[] ranks = SuitsAndRanks.Rank.values();
        CorrectRank[] correctRanks = CorrectRank.values();
        if (ranks.length != correctRanks.length)
        {
            fail("Incorrect number of ranks in enumerated type.");
        }
        for (int i = 0; i < ranks.length; i++)
        {
            if (!ranks[i].toString().equals(correctRanks[i].toString()))
            {
                fail("Incorrect ranks.\n" + i + "-th rank should be "
                    + correctRanks[i].toString() + " not "
                    + ranks[i].toString());
            }
        }
        assertTrue(true);
    }

    /**
     * testRankArray checks that the array 'ranks' matches the correct rank
     * array from CorrectEnum.
     */
    @Test
    public void testRankArray()
    {
        // correct enum
        CorrectRank[] correctRanks = CorrectRank.values();
        SuitsAndRanks.Rank[] ranksArray = SuitsAndRanks.ranks;
        if (ranksArray.length != correctRanks.length)
        {
            fail("Incorrect number of ranks in enumerated type.");
        }
        for (int i = 0; i < ranksArray.length; i++)
        {
            String currRank = ranksArray[i].toString();
            String correctRank = correctRanks[i].toString();
            if (!currRank.equals(correctRank))
            {
                fail("Incorrect ranks.\n" + i + "-th rank should be "
                    + correctRank + " not " + currRank);

            }
        }
        assertTrue(true);
    }

    /**
     * testFetchRank tests the fetchRank method.
     */
    @Test
    public void testFetchRank()
    {
        CorrectRank[] correctRanks = CorrectRank.values();
        for (int i = 0; i < correctRanks.length; i++)
        {
            String rank = SuitsAndRanks.fetchRank(i).toString();
            String correctRank = correctRanks[i].toString();
            if (!rank.equals(correctRank))
            {
                fail("Incorrect ranks.\n" + i + "-th rank should be "
                    + correctRank + " not " + rank);
            }
        }
        assertTrue(true);
    }

    /**
     * testFetchRank tests that the 0-th rank is "TWO".
     */
    @Test
    public void testFetchRank2()
    {
        String s = SuitsAndRanks.fetchRank(0).toString();
        assertEquals("0-th rank should be TWO not " + s, s, "TWO");
    }

    /**
     * testSuitEnum checks that the SuitsAndRanks class correctly implements the
     * enumerated Suit type.
     */
    @Test
    public void testSuitEnum()
    {
        // correct enum
        SuitsAndRanks.Suit[] suits = SuitsAndRanks.Suit.values();
        CorrectSuit[] correctSuits = CorrectSuit.values();
        if (suits.length != correctSuits.length)
        {
            fail("Incorrect number of suits in enumerated type.");
        }
        for (int i = 0; i < suits.length; i++)
        {
            if (!suits[i].toString().equals(correctSuits[i].toString()))
            {
                fail("Incorrect suits.\n" + i + "-th suits should be "
                    + correctSuits[i].toString() + " not "
                    + suits[i].toString());
            }
        }
        assertTrue(true);
    }

    /**
     * testSuitArray checks that the array 'suits' matches the correct suit
     * array from CorrectEnum.
     */
    @Test
    public void testSuitArray()
    {
        // correct enum
        CorrectSuit[] correctSuits = CorrectSuit.values();
        SuitsAndRanks.Suit[] suitsArray = SuitsAndRanks.suits;
        if (suitsArray.length != correctSuits.length)
        {
            fail("Incorrect number of suits in enumerated type.");
        }
        for (int i = 0; i < suitsArray.length; i++)
        {
            String currSuit = suitsArray[i].toString();
            String correctSuit = correctSuits[i].toString();
            if (!currSuit.equals(correctSuit))
            {
                fail("Incorrect suits.\n" + i + "-th suit should be "
                    + correctSuit + " not " + currSuit);

            }
        }
        assertTrue(true);
    }

    /**
     * testFetchSuit tests the fetchSuit method.
     */
    @Test
    public void testFetchSuit()
    {
        CorrectSuit[] correctSuits = CorrectSuit.values();
        for (int i = 0; i < correctSuits.length; i++)
        {
            String suit = SuitsAndRanks.fetchSuit(i).toString();
            String correctSuit = correctSuits[i].toString();
            if (!suit.equals(correctSuit))
            {
                fail("Incorrect suits.\n" + i + "-th suit should be "
                    + correctSuit + " not " + suit);
            }
        }
        assertTrue(true);
    }

}
