package tests;

/**
 * DeckTest.java
 * 
 * @author Mitch Parry
 * @version May 6, 2013
 */

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Scanner;

import solution.Deck;
import solution.PlayingCard;
import solution.SuitsAndRanks;

import org.junit.Test;

/**
 * DeckTest tests the Deck class.
 * 
 * @version May 31, 2013
 * @author Mitch Parry
 */
public class DeckTest
{
    static final int NUM_CARDS = 52;
    static final int NUM_RANKS = 13;

    /**
     * CorrectRank provides the correct enumeration for the ranks.
     */
    protected enum CorrectRank
    {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, 
        JACK, QUEEN, KING, ACE
    };

    /**
     * Suit provides the correct enumeration for the suits.
     */
    protected enum CorrectSuit
    {
        CLUBS, DIAMONDS, HEARTS, SPADES
    };

    protected CorrectRank[] ranks = CorrectRank.values();
    protected CorrectSuit[] suits = CorrectSuit.values();

    /**
     * Tests the Deck constructor.
     */
    @Test
    public void testDeck()
    {
        final int SEED = 123456789;
        Deck deck = new Deck(SEED);
        int k = 0;
        for (int j = 0; j < ranks.length; j++)
        {
            String r0 = ranks[j].toString();
            for (int i = 0; i < suits.length; i++)
            {
                String s0 = suits[i].toString();
                String r1 = deck.getCard(k).getRank().toString();
                String s1 = deck.getCard(k).getSuit().toString();
                if (!r1.equals(r0) || !s1.equals(s0))
                {
                    fail("Initial deck in wrong order. The resulting order "
                        + "should be\n"
                        + "TWO CLUBS, TWO DIAMONDS, TWO HEARTS, "
                        + "TWO SPADES, THREE CLUBS, ..., ACE SPADES");
                }
                k++;
            }
        }
        assertTrue(true);
    }

    /**
     * Tests the deck shuffle method.
     */
    /*
     * @Test public void testShuffleDeck() {
     * 
     * // test seed so that every program should shuffle the same way. final int
     * TEST_SEED = 123456789; Deck deck = new Deck(TEST_SEED);
     * deck.shuffleDeck(); ArrayList < PlayingCard > correctDeck =
     * getCorrectShuffledDeck(); for (int i = 0; i < correctDeck.size(); i++) {
     * SuitsAndRanks.Rank r0 = correctDeck.get(i).getRank(); SuitsAndRanks.Rank
     * r1 = deck.getCard(i).getRank(); SuitsAndRanks.Suit s0 =
     * correctDeck.get(i).getSuit(); SuitsAndRanks.Suit s1 =
     * deck.getCard(i).getSuit(); if (r0 != r1 || s0 != s1) {
     * fail("Deck.shuffleDeck does not shuffle correctly.\n" + i +
     * "-th card should be " + r0 + " " + s0 + " not " + r1 + " " + s1); } }
     * assertTrue(true); }
     */
    /**
     * Helper method for testing the shuffle method.
     * 
     * @param counts
     *            The 2D array of counts for each position in the deck and each
     *            card
     * @param trials
     *            Number of trials to run
     */
    private void collectCounts(int[][] counts, int trials)
    {
        for (int i = 0; i < trials; i++)
        {
            Deck deck = new Deck();
            deck.shuffleDeck();
            for (int j = 0; j < NUM_CARDS; j++)
            {
                PlayingCard card = deck.getCard(j);
                int index =
                    NUM_RANKS * card.getSuit().ordinal()
                        + card.getRank().ordinal();
                counts[index][j]++;
            }
        }
    }

    /**
     * Helper method to compute chi2 statistic.
     * 
     * @param counts
     *            The 2D array of counts for each position in the deck and each
     *            card
     * @param expectedCount
     *            Expected number of cards in each position in deck
     * @return the chi-squared statistic
     */
    private double getChi2(int[][] counts, double expectedCount)
    {
        double chi2 = 0;
        for (int j = 0; j < NUM_CARDS; j++)
        {
            for (int i = 0; i < NUM_CARDS; i++)
            {
                double diff = counts[i][j] - expectedCount;
                chi2 += (diff * diff) / expectedCount;
            }
        }
        return chi2;
    }

    /**
     * Tests the deck shuffle method.
     */
    @Test
    public void testShuffleDeck()
    {
        /**
         * test seed so that every program should shuffle the same way.
         */
        final int NUM_TRIALS = 100000;
        final double MAX_TIME = 12000.0;
        final double NANOSECONDS_PER_MILLISECOND = 1000000.0;
        // alpha = 0.01, df = 51*51.
        final double THRESH = 2.771722954569520e+03;
        int[][] counts = new int[NUM_CARDS][NUM_CARDS];
        long start = System.currentTimeMillis();
        collectCounts(counts, NUM_TRIALS);
        long totalTime = System.currentTimeMillis() - start;
        double timePerShuffle =
            NANOSECONDS_PER_MILLISECOND * totalTime / NUM_TRIALS;

        double expectedCount = ((double) NUM_TRIALS) / ((double) NUM_CARDS);
        double chi2 = getChi2(counts, expectedCount);
        System.out.println(chi2);
        System.out.println(timePerShuffle);

        assertTrue("shuffleDeck produces a significantly nonuniform. A"
            + " truly uniform random shuffle algorithm should produce "
            + "this result 1 out of 100 times.", chi2 < THRESH);
        assertTrue("shuffleDeck takes too long.  It should take fewer than "
            + MAX_TIME + " nanoseconds but takes " + timePerShuffle,
            timePerShuffle < MAX_TIME);
    }

    /**
     * Tests the Deck toString method.
     */
    @Test
    public void testToString()
    {
        Deck deck = new Deck();
        String s = deck.toString();
        ArrayList<PlayingCard> correctDeck = getCorrectInitialDeck();
        Scanner scan = new Scanner(s);
        for (int i = 0; i < correctDeck.size(); i++)
        {
            if (!scan.hasNext())
            {
                fail("Deck.toString prints only " + i + " cards.");
            }
            String rank = scan.next();
            if (!scan.hasNext())
            {
                fail("Deck.toString prints only " + i + " cards.");
            }
            String suit = scan.next();
            String correctRank = correctDeck.get(i).getRank().toString();
            String correctSuit = correctDeck.get(i).getSuit().toString();
            if (!correctRank.equals(rank) || !correctSuit.equals(suit))
            {
                scan.close();
                fail("Deck.toString fails on initial deck.\n" + i + "-th card"
                    + " should be " + correctRank + " " + correctSuit + " not "
                    + rank + " " + suit);
            }
        }
        scan.close();
    }

    /**
     * Helper method to test the correct initial sorted deck.
     * 
     * @return ArrayList of sorted PlayingCards.
     */
    private ArrayList<PlayingCard> getCorrectInitialDeck()
    {
        final int NUM_CARDS = 52;
        ArrayList<PlayingCard> deck = new ArrayList<PlayingCard>(NUM_CARDS);
        for (int i = 0; i < SuitsAndRanks.NUMRANKS; i++)
        {
            SuitsAndRanks.Rank rank = SuitsAndRanks.fetchRank(i);
            for (int j = 0; j < SuitsAndRanks.NUMSUITS; j++)
            {
                SuitsAndRanks.Suit suit = SuitsAndRanks.fetchSuit(j);
                PlayingCard card = new PlayingCard(rank, suit);
                deck.add(card);
            }
        }
        return deck;
    }

}
