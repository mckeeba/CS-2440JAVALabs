package tests;

/**
 * PlayingCardTest.java
 * 
 */

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import solution.PlayingCard;
import solution.SuitsAndRanks;

import org.junit.Test;

/**
 * PlayingCardTest tests the PlayingCard class.
 * 
 * @author Mitch Parry
 * @version May 3, 2013
 */
public class PlayingCardTest
{
    /**
     * testPlayingCard tests the PlayingCard constructor.
     */
    @Test
    public void testPlayingCard()
    {
        SuitsAndRanks.Rank[] ranks = SuitsAndRanks.Rank.values();
        SuitsAndRanks.Suit[] suits = SuitsAndRanks.Suit.values();
        for (int i = 0; i < ranks.length; i++)
        {
            for (int j = 0; j < suits.length; j++)
            {
                PlayingCard card = new PlayingCard(ranks[i], suits[j]);
                if (card.getRank() != ranks[i])
                {
                    fail("Problem with PlayingCard constructor"
                        + " and/or getRank.\n" + i + "-th rank should be "
                        + ranks[i] + " not " + card.getRank());
                }
            }
        }
        assertTrue(true);
    }

    /**
     * testSetRank tests the setRank method.
     */
    @Test
    public void testSetRank()
    {
        PlayingCard card =
            new PlayingCard(SuitsAndRanks.Rank.ACE, SuitsAndRanks.Suit.HEARTS);
        SuitsAndRanks.Rank[] ranks = SuitsAndRanks.Rank.values();
        for (int i = 0; i < ranks.length; i++)
        {
            card.setRank(ranks[i]);
            if (card.getRank() != ranks[i])
            {
                fail("Problem with PlayingCard setRank and/or getRank.\n" + i
                    + "-th rank should be " + ranks[i] + " not "
                    + card.getRank());
            }
        }
        assertTrue(true);
    }

    /**
     * testSetSuit tests the setSuit method.
     */
    @Test
    public void testSetSuit()
    {
        PlayingCard card =
            new PlayingCard(SuitsAndRanks.Rank.ACE, SuitsAndRanks.Suit.HEARTS);
        SuitsAndRanks.Suit[] suits = SuitsAndRanks.Suit.values();
        for (int i = 0; i < suits.length; i++)
        {
            card.setSuit(suits[i]);
            if (card.getSuit() != suits[i])
            {
                fail("Problem with PlayingCard setSuit and/or getSuit.\n" + i
                    + "-th suit should be " + suits[i] + " not "
                    + card.getSuit());
            }
        }
        assertTrue(true);
    }

}
