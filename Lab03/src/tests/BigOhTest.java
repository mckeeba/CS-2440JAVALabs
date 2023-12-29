package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import solution.BigOh;

/**
 * BigOhTest provides test cases for the BigOh class.
 * 
 * @author Mitch Parry
 * @version 2013-08-13
 */
public class BigOhTest
{
    public static final double EPS = 0.15;
    public static final double TOL = 1e-9;
    public static final long SEED = 1089575;
    public static final int[] N01 = {10000000, 204, 4248, 3130, 39, 50};
    public static final int[] N02 = {20000000, 258, 6000, 4400, 45, 100};
    public static final int[] N04 = {40000000, 325, 8500, 6260, 52, 132};
    public static final int[] N05 = {50000000, 350, 9500, 7000, 54, 140};
    public static final int[] N06 = {60000000, 372, 10400, 7668, 56, 147};
    public static final int[] N10 = {100000000, 500, 14000, 10000, 62, 165};
    public static final int[] N15 = {130000000, 515, 16500, 11500, 67, 180};
    public static final int[] N100 = {1000000000, 1000, 43000, 30000, 100, 295};
    private BigOh bo;

    /**
     * Creates a BigOh object.
     * 
     * @throws Exception
     *             if something goes wrong during setup
     */
    @Before
    public void setUp() throws Exception
    {
        bo = new BigOh(new Random(SEED));
    }

    /**
     * testAlgorithm1 tests the complexity estimate for alg 1.
     */
    @Test
    public void testAlgorithm1()
    {
        final int CHOICE = 1;
        final int N1 = N02[CHOICE - 1];
        final int N2 = N10[CHOICE - 1];
        double error = bo.computePercentError(CHOICE, N1, N2);
        double errorUp = (error + 1) * N1 / N2 - 1;
        double errorDown = (error + 1) * N2 / N1 - 1;
        System.out.println(errorUp);
        System.out.println(error);
        System.out.println(errorDown);
        assertTrue("Error is too large for algorithm " + CHOICE + " timing.",
            Math.abs(error) < Math.abs(errorUp));
        assertTrue("Error is too large for algorithm " + CHOICE + " timing.",
            Math.abs(error) < Math.abs(errorDown));
    }

    /**
     * testAlgorithm2 tests the complexity estimate for alg 2.
     */
    @Test
    public void testAlgorithm2()
    {
        final int CHOICE = 2;
        final int N1 = N02[CHOICE - 1];
        final int N2 = N06[CHOICE - 1];
        double error = bo.computePercentError(CHOICE, N1, N2);
        double errorUp = (error + 1) * N1 / N2 - 1;
        double errorDown = (error + 1) * N2 / N1 - 1;
        System.out.println(errorUp);
        System.out.println(error);
        System.out.println(errorDown);
        assertTrue("Error is too large for algorithm " + CHOICE + " timing.",
            Math.abs(error) < Math.abs(errorUp));
        assertTrue("Error is too large for algorithm " + CHOICE + " timing.",
            Math.abs(error) < Math.abs(errorDown));
    }

    /**
     * testAlgorithm3 tests the complexity estimate for alg 3.
     */
    @Test
    public void testAlgorithm3()
    {
        final int CHOICE = 3;
        final int N1 = N02[CHOICE - 1];
        final int N2 = N10[CHOICE - 1];
        double error = bo.computePercentError(CHOICE, N1, N2);
        double errorUp = (error + 1) * N1 / N2 - 1;
        double errorDown = (error + 1) * N2 / N1 - 1;
        System.out.println(errorUp);
        System.out.println(error);
        System.out.println(errorDown);
        assertTrue("Error is too large for algorithm " + CHOICE + " timing.",
            Math.abs(error) < Math.abs(errorUp));
        assertTrue("Error is too large for algorithm " + CHOICE + " timing.",
            Math.abs(error) < Math.abs(errorDown));
    }

    /**
     * testAlgorithm4 tests the complexity estimate for alg 4.
     */
    @Test
    public void testAlgorithm4()
    {
        final int CHOICE = 4;
        final int N1 = N02[CHOICE - 1];
        final int N2 = N10[CHOICE - 1];
        double error = bo.computePercentError(CHOICE, N1, N2);
        double errorUp = (error + 1) * N1 / N2 - 1;
        double errorDown = (error + 1) * N2 / N1 - 1;
        System.out.println(errorUp);
        System.out.println(error);
        System.out.println(errorDown);
        assertTrue("Error is too large for algorithm " + CHOICE + " timing.",
            Math.abs(error) < Math.abs(errorUp));
        assertTrue("Error is too large for algorithm " + CHOICE + " timing.",
            Math.abs(error) < Math.abs(errorDown));
    }

    /**
     * testAlgorithm5 tests the complexity estimate for alg 5.
     */
    @Test
    public void testAlgorithm5()
    {
        final int CHOICE = 5;
        final int N1 = N02[CHOICE - 1];
        final int N2 = N10[CHOICE - 1];
        double error = bo.computePercentError(CHOICE, N1, N2);
        double errorUp = (error + 1) * N1 / N2 - 1;
        double errorDown = (error + 1) * N2 / N1 - 1;
        System.out.println(errorUp);
        System.out.println(error);
        System.out.println(errorDown);
        assertTrue("Error is too large for algorithm " + CHOICE + " timing.",
            Math.abs(error) < Math.abs(errorUp));
        assertTrue("Error is too large for algorithm " + CHOICE + " timing.",
            Math.abs(error) < Math.abs(errorDown));
    }

    /**
     * testAlgorithm6 tests the complexity estimate for alg 6.
     */
    @Test
    public void testAlgorithm6()
    {
        final int CHOICE = 6;
        final int N1 = N02[CHOICE - 1];
        final int N2 = N10[CHOICE - 1];
        double error = bo.computePercentError(CHOICE, N1, N2);
        double errorUp = (error + 1) * N1 / N2 - 1;
        double errorDown = (error + 1) * N2 / N1 - 1;
        System.out.println(errorUp);
        System.out.println(error);
        System.out.println(errorDown);
        assertTrue("Error is too large for algorithm " + CHOICE + " timing.",
            Math.abs(error) < Math.abs(errorUp));
        assertTrue("Error is too large for algorithm " + CHOICE + " timing.",
            Math.abs(error) < Math.abs(errorDown));
    }

    /**
     * testRunAlgorithmInvalidChoice test runAlgorithm with an invalid choice
     * value.
     */
    @Test
    public void testRunAlgorithmInvalidChoice()
    {
        int ans = bo.runAlgorithm(-1, 10);
        assertTrue("runAlgorithm runs unexpected algorithm for choice = -1",
            ans < 0);
    }

    /**
     * testRunAlgorithm test runAlgorithm with valid choices.
     */
    @Test
    public void testRunAlgorithm()
    {
        final int[] ANSWERS = {7500077, 6366063, 2255973,
            2450983, 2110321, 547343};
        for (int i = 0; i < ANSWERS.length; i++)
        {
            int ans = bo.runAlgorithm(i + 1, N01[i]);
            assertEquals("runAlgorithm returns wrong result choice = "
                + (i + 1), ANSWERS[i], ans);
        }
    }

    /**
     * testTimeAlgorithm runs a basic check on the robustTimeAlgorithm method.
     * Checks that this algorithm runs in less than a second.
     */
    @Test
    public void testTimeAlgorithm()
    {
        final double MAX_TIME = 1.00;
        final double MIN_TIME = 0.01;
        final int CHOICE = 1;
        double time = bo.timeAlgorithm(CHOICE, N01[CHOICE - 1]);
        System.out.println(time);
        assertTrue(
            "timeAlgorithm(" + CHOICE + ", " + N01[CHOICE - 1]
                + ", rand) should be between " + MIN_TIME + " and "
                + MAX_TIME + " seconds: " + time + " seconds.",
            time > MIN_TIME && time < MAX_TIME);
    }

    /**
     * testRobustTimeAlgorithm runs a basic check on the robustTimeAlgorithm
     * method.
     */
    @Test
    public void testRobustTimeAlgorithm()
    {
        final int CHOICE = 1;
        final int TRIALS = 10;
        double average = 0.0;
        for (int i = 0; i < TRIALS; i++)
        {
            average += bo.timeAlgorithm(CHOICE, N02[CHOICE - 1]);
        }
        average /= TRIALS;
        double robust = Double.MAX_VALUE;
        for (int i = 0; i < 2; i++)
        {
            double r = bo.robustTimeAlgorithm(CHOICE, N02[CHOICE - 1]);
            if (r < robust)
            {
                robust = r;
            }
        }
        assertTrue(
            "robustTimeAlgorithm should be less than average "
                + "timeAlgorithm.\naverage = " + average
                + "; robust = " + robust
                + "\n",
            robust < average);
    }

    /**
     * testEstimateTiming checks that the function is correct.
     */
    @Test
    public void testEstimateTiming()
    {
        final int N1 = 1000000;
        final int N2 = 2000000;
        final double T1 = 0.5;
        final double CORRECT = 1.0;
        final int CHOICE = 1;
        double student = bo.estimateTiming(CHOICE, N1, T1, N2);
        assertEquals("estimateTiming equation is incorrect.",
            CORRECT, student, TOL);
    }

    /**
     * testPercentError checks the percentError method.
     */
    @Test
    public void testPercentError()
    {
        final int CORRECT_1 = 100;
        final int ESTIMATE_1 = 95;
        final double ERROR_1 = -0.05;
        final double CORRECT_2 = 2.0;
        final double ESTIMATE_2 = 2.5;
        final double ERROR_2 = 0.25;
        BigOh bo = new BigOh();
        double perc = bo.percentError(CORRECT_1, ESTIMATE_1);
        assertTrue("percentError has the wrong sign", perc < 0);
        assertEquals("percentError should be -0.05 when "
            + "correct = 100 and estimated = 95",
            ERROR_1, perc, TOL);
        perc = bo.percentError(CORRECT_2, ESTIMATE_2);
        assertTrue("percentError has the wrong sign", perc > 0);
        assertEquals("percentError should be 0.25 when "
            + "correct = 2 and estimated = 2.5",
            ERROR_2, perc, TOL);
    }

    /**
     * testComputePercentError checks the computePercentError method. As long as
     * you have analyzed algorithm 1 correctly, this should pass.
     */
    @Test
    public void testComputePercentError()
    {
        final int CHOICE = 1;
        final int N1 = 20000000;
        final int N2 = 40000000;
        double e1 = bo.computePercentError(CHOICE,
            N1, N2);
        assertEquals(
            "computePercentError: For alg1 doubling N should double time.",
            0, e1, EPS);
    }
}
