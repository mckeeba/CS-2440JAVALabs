package solution;

/**
 * BigOh.java
 */
import java.util.Random;
import java.util.Scanner;
import util.Algorithms;

/**
 * Contains methods to analyze time complexity of algorithms.
 * 
 * @author Gus Mckee
 * @version
 * 
 */
public class BigOh
{
    private static final double MILLISECONDS_PER_SECOND = 1000.0;
    
    private Random rand;
   // private int n;
   
    /**
     * No-args constructor initializes the random using current time.
     */
    public BigOh()
    {
        rand = new Random();
    }

    /**
     * Constructor takes an Random object to initialize the randomness of the
     * algorithms.
     * 
     * @param rand
     *            the random number generator
     */
    public BigOh(Random rand)
    {
        this.rand = rand;
    }

    /**
     * robustTimeAlgorithm returns the minimum time it takes to run the chosen
     * algorithm over 5 trials.
     * 
     * @param choice
     *            The index of the algorithm to use
     * @param n
     *            The size of the problem
     * @return the time in seconds
     */
    public double robustTimeAlgorithm(int choice, int n)
    {
        // TODO
        double time1 = timeAlgorithm(choice, n);
        for(int i = 0; i < 4; i++) 
        {
          double time2 = timeAlgorithm(choice, n);
          if(time2 < time1) 
          {
              time1 = time2;
          }
        }
        return time1;
    }

    /**
     * timeAlgorithm returns the time it takes to run the algorithm once.
     * 
     * @param choice
     *            The index of the algorithm to use
     * @param n
     *            The size of the problem
     * @return the time in seconds
     */
    public double timeAlgorithm(int choice, int n)
    {
        // make sure that the garbage collector doesn't run
        // during timing. (Do this first.)
        System.gc();
        long start = System.currentTimeMillis();
        runAlgorithm(choice, n);
        long end = System.currentTimeMillis();
            
        double result = (double) (end - start) / MILLISECONDS_PER_SECOND;
        // TODO
        return result;
    }

    /**
     * runAlgorithm selects the algorithm to run based on <code>choice</code>.
     * 
     * @param choice
     *            The number representing the algorithm choice
     * @param numElements
     *            The size of the problem
     * @return The result of the algorithm
     */
    public int runAlgorithm(int choice, int numElements)
    {
       // TODO (be sure to change return statement too)
        switch(choice)
        {
            case 1: 
            {
             
             return Algorithms.alg1(numElements, rand);
            }
            
            
            case 2:
            {
               
              return Algorithms.alg2(numElements, rand);
            }
            
            case 3:
            {
                
                return Algorithms.alg3(numElements, rand);
            }
            
            case 4:
            {
               
                
                return Algorithms.alg4(numElements, rand);
            }
            
            case 5:
            {
                
              return Algorithms.alg5(numElements, rand);
            }
            
            case 6:
            {
              
               return Algorithms.alg6(numElements, rand);
            }
            
            default:
                break;
        }    
                
           return -1;
                
           
         }

    /**
     * bigOhFunc returns the Big-Oh function for algorithm and problem size
     * parameters.
     * 
     * @param choice
     *            The number representing the algorithm choice
     * @param n
     *            The problem size.
     * @return The Big-Oh function for problem size, n.
     */
    public double bigOhFunc(int choice, double n)
    {
        switch(choice)
        {
            case 1: 
            {
             
             return n;
            }
            
            
            case 2:
            {
               
              return Math.pow(n,3);
            }
            
            case 3:
            {
                
                return Math.pow(n,2);
            }
            
            case 4:
            {
               
                
                return Math.pow(n,2);
            }
            
            case 5:
            {
                
              return Math.pow(n,5);
            }
            
            case 6:
            {
              
               return Math.pow(n,4);
            }
            
            default:
                
            return -1 * 4;
            }
    }

    /**
     * estimateTiming takes an algorithm choice, problem size and timing, and
     * estimates the timing for a second problem size.
     * 
     * @param choice
     *            The number representing the algorithm choice
     * @param n1
     *            The first problem size
     * @param t1
     *            The first timing
     * @param n2
     *            The second problem size
     * @return The estimated timing for the second problem size
     */
    public double estimateTiming(int choice, int n1, double start, int n2)
    {
        // TODO
      double func1 = bigOhFunc(choice,n1);
      double func2 = bigOhFunc(choice,n2);
      
      
        return (start * func2)/ func1;
    }

    /**
     * percentError returns the percent error in an estimate.
     * 
     * @param correct
     *            the correct value
     * @param estimate
     *            the estimated value
     * @return the percent error
     */
    public double percentError(double correct, double estimate)
    {
       
       
        
        double percentError =  (estimate - correct)/correct;
        // TODO
        //return -1 * 16;
       
        return percentError;
    }

    /**
     * computePercentError takes an algorithm choice, and two problem sizes and
     * computes the error in estimating the timing of the second problem using
     * the timing of the first.
     * 
     * @param choice
     *            The number representing the algorithm choice
     * @param n1
     *            The first problem size
     * @param n2
     *            The second problem size
     * @return the percent error in estimating t2 given n1 and n2.
     */
    public double computePercentError(int choice, int n1, int n2)
    {
        // TODO
        
        double start = timeAlgorithm(choice, n1);
        double end = timeAlgorithm(choice, n2);
        double estimateEnd = estimateTiming(choice, n1, start, n2);
        
        return percentError(end, estimateEnd);
    }

    /**
     * Main method.
     * 
     * @param args
     *            Command line arguments not used.
     */
    public static void main(String[] args)
    {
        int choice;
        int numElements = 0;
        Scanner keyInput = new Scanner(System.in);
        BigOh bo = new BigOh();

        // run the fragments
        choice = menu(keyInput);
        while (choice != 7)
        {
            if (choice >= 1 && choice <= 6)
            {
                System.out.print("How many elements: ");
                numElements = keyInput.nextInt();
                double time = bo.timeAlgorithm(choice, numElements);
                long milliseconds = (long) (time * MILLISECONDS_PER_SECOND);
                System.out.println("The time for alg" + choice + " with n="
                    + numElements + " is " + milliseconds + " ms.\n\n");
            }
            choice = menu(keyInput);
        }
        System.out.println("Quitting");
    }

    /**
     * Prints the menu and prompts for input.
     * 
     * @param keyInput
     *            The scanner to read input
     * @return the number read
     */
    public static int menu(Scanner keyInput)
    {
        int choice = -1;

        System.out.println();
        System.out.println("       1.  Method #1 ");
        System.out.println("       2.  Method #2 ");
        System.out.println("       3.  Method #3 ");
        System.out.println("       4.  Method #4 ");
        System.out.println("       5.  Method #5 ");
        System.out.println("       6.  Method #6 ");
        System.out.println("       7.  Quit \n");
        System.out.print("Enter your choice: ");
        choice = keyInput.nextInt();
        return choice;
    }
}
