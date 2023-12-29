package util;
/**
 * Algorithms.java
 */
import java.util.Random;

/**
 * Algorithms contains several algorithms with different complexities.
 * 
 * @author Mitch Parry
 * @version June 7, 2013
 */
public class Algorithms
{

    /**
     * alg1 does something; what is its complexity?
     * O(n)
     * @param n
     *            The size of the problem
     * @param rand
     *            A random number generator
     * @return The sum
     */
    public static int alg1(int n, Random rand)
    {
        final int A = 2;
        final int B = 1;
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            if (rand.nextInt() % A != B)
            {
                sum++;
            }
        }
        return sum;
    }

    /**
     * alg2 does something; what is its complexity?
     * O (n^3)
     * @param n
     *            The size of the problem
     * @param rand
     *            A random number generator
     * @return The sum
     */
    public static int alg2(int n, Random rand)
    {
        final int A = 2;
        final int B = 1;
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n * n; j++)
            {
                if (rand.nextInt() % A != B)
                {
                    sum++;
                }
            }
        }
        return sum;
    }

    /**
     * alg3 does something; what is its complexity?
     * O(n^2)
     * 
     * @param n
     *            The size of the problem
     * @param rand
     *            A random number generator
     * @return The sum
     */
    public static int alg3(int n, Random rand)
    {
        final int A = 2;
        final int B = 1;
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (rand.nextInt() % A == B)
                {
                    sum++;
                }
            }
        }
        return sum;
    }

    /**
     * alg4 does something; what is its complexity?
     * O(n^2)
     * @param n
     *            The size of the problem
     * @param rand
     *            A random number generator
     * @return The sum
     */
    public static int alg4(int n, Random rand)
    {
        final int A = 2;
        final int B = 1;
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (rand.nextInt() % A == B)
                {
                    sum++;
                }
            }
        }
        return sum;
    }

    /**
     * alg5 does something; what is its complexity?
     * 
     * O(n^5)
     * @param n
     *            The size of the problem
     * @param rand
     *            A random number generator
     * @return The sum
     */
    public static int alg5(int n, Random rand)
    {
        final int A = 2;
        final int B = 1;
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < i * i; j++)
            {
                for (int k = 0; k < j; k++)
                {
                    if (rand.nextInt() % A == B)
                    {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    /**
     * alg6 does something; what is its complexity?
     * 
     * O(n^4)
     * @param n
     *            The size of the problem
     * @param rand
     *            A random number generator
     * @return The sum
     */
    public static int alg6(int n, Random rand)
    {
        final int A = 2;
        final int B = 1;
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < i * i; j++)
            {
                if (j % i == 0)
                {
                    for (int k = 0; k < j; k++)
                    {
                        if (rand.nextInt() % A != B)
                        {
                            sum++;
                        }
                    }
                }
            }
        }
        return sum;
    }

}
