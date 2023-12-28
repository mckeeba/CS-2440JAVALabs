package solution;
/**
 * SuitsAndRanks.java
 * 
 */


/**
 * This is a utility class containing the enumeration and storage of
 * Suits, as well as a fetch method to return a Suit. Your job is
 * to add code wherever you see a TODO marker to implement the same
 * functionality for Rank.
 * 
 * @author Gus
 */
public class SuitsAndRanks 
{
    /**
     * Provides the enumerated suits for playing cards in order of 
     * <a href="http://en.wikipedia.org/wiki/Suit_%28cards%29">
     * increasing importance for the game of bridge.</a>
     */
    //TODO: Create enum for Suit (i.e., CLUBS, DIAMONDS, HEARTS, SPADES)
    public enum Rank 
    {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }
    public enum Suit 
    {
        CLUBS, DIAMONDS, HEARTS, SPADES
    };

    /**
     * Provides the enumerated ranks for playing cards in ascending
     * order.
     */
    // TODO: Create enum for Rank (ie TWO, THREE, ..., ACE)

    // TODO: Create a public static array of Suits named 'suits' 
    // containing all the suits.
    public static Suit[] suits = Suit.values();
    
    //TODO: Create a public static constant for the number of Suits.
    public static final int NUMSUITS = 4;    
    
    // TODO: Create a public static array of Ranks named 
    // 'ranks' containing all ranks.
    public static Rank[] ranks = Rank.values();
    //TODO: Create a public static constant for the number of Ranks.
    public static final int NUMRANKS = 13;


    /**
     * fetchSuit returns the Suit at a given index.
     * If the index is greater than the number of suits,
     * wrap the index back to zero using the mod operator.
     * 
     * @param index Index into the 'suits' array
     * @return  The Suit at that index
     */
    //TODO: Create a public static method named 'fetchSuit'
    public static Suit fetchSuit(int index) 
    {
        return suits[index % NUMSUITS];
    }
    
    /**
     * fetchRank returns the Rank at a given index.
     * If the index is greater than the number of suits,
     * wrap the index back to zero using the mod operator.
     * 
     * @param index Index into the 'ranks' array
     * @return  The Rank at that index
     */
    //TODO: Create a public static method named 'featchRank'
    public static Rank fetchRank(int index) 
    {
        return ranks[index % NUMRANKS];
    }
}
