package tests;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import solution.ExpressionEvaluator;

/**
 * Test class for the ExpressionEvaluator class.
 * 
 * @author Mitch Parry
 * @version 2013-11-01
 * 
 */
public class ExpressionEvaluatorTest
{
    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFixParen1()
    {
        String infix = "(1)";
        final String CORRECT = "1";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFixParen2()
    {
        String infix = "(1 + 2)";
        final String CORRECT = "1 2 +";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFixParen3()
    {
        String infix = "(1 - 2)";
        final String CORRECT = "1 2 -";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFixParen4()
    {
        String infix = "((1 + 2) + 3)";
        final String CORRECT = "1 2 + 3 +";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFixParen5()
    {
        String infix = "(1 + (2 * 3))";
        final String CORRECT = "1 2 3 * +";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFixParen6()
    {
        String infix = "((1 + 2) * 3)";
        final String CORRECT = "1 2 + 3 *";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFixParen7()
    {
        String infix = "((52+((1+2)*4))-3)";
        final String CORRECT = "52 1 2 + 4 * + 3 -";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFixParen8()
    {
        String infix = "((3 + 5) / (2 / 4))";
        final String CORRECT = "3 5 + 2 4 / /";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFixParen9()
    {
        String infix = "((((52+1)+2)*4)-3)";
        final String CORRECT = "52 1 + 2 + 4 * 3 -";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFixParen10()
    {
        String infix = "(3 + ((4 * 5) / 6))";
        final String CORRECT = "3 4 5 * 6 / +";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFixParen11()
    {
        String infix = "(3 + (4 * (5 / 6)))";
        final String CORRECT = "3 4 5 6 / * +";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFixParen12()
    {
        String infix = "(((300 + 23)*(43 - 21))/(84 + 7))";
        final String CORRECT = "300 23 + 43 21 - * 84 7 + /";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFixParen13()
    {
        String infix = "(((4+8)*(6-5))/((3-2)*(2+2)))";
        final String CORRECT = "4 8 + 6 5 - * 3 2 - 2 2 + * /";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFixParen14()
    {
        String infix = "(((4)+(5))/((3)*(2)))";
        final String CORRECT = "4 5 + 3 2 * /";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFixParen15()
    {
        String infix = "((((4 + (8 * 6)) - (5 / 3)) - (2 * 2)) + 2)";
        final String CORRECT = "4 8 6 * + 5 3 / - 2 2 * - 2 +";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFix1()
    {
        String infix = "1";
        final String CORRECT = "1";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFix2()
    {
        String infix = "1 + 2";
        final String CORRECT = "1 2 +";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFix3()
    {
        String infix = "1 - 2";
        final String CORRECT = "1 2 -";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFix4()
    {
        String infix = "1 + 2 + 3";
        final String CORRECT = "1 2 + 3 +";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFix5()
    {
        String infix = "1 + 2 * 3";
        final String CORRECT = "1 2 3 * +";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFix6()
    {
        String infix = "3 * 1 + 2";
        final String CORRECT = "3 1 * 2 +";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFix7()
    {
        String infix = "52 + 1 + 2 * 4 - 3";
        final String CORRECT = "52 1 + 2 4 * + 3 -";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFix8()
    {
        String infix = "52*1+2*4-3";
        final String CORRECT = "52 1 * 2 4 * + 3 -";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFix9()
    {
        String infix = "52+1/2*4-3";
        final String CORRECT = "52 1 2 / 4 * + 3 -";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFix10()
    {
        String infix = "3 + 4 * 5 / 6";
        final String CORRECT = "3 4 5 * 6 / +";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFix11()
    {
        String infix = "3 + 4 / 5 * 6";
        final String CORRECT = "3 4 5 / 6 * +";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFix12()
    {
        String infix = "(300 + 23)*(43 - 21)/(84 + 7)";
        final String CORRECT = "300 23 + 43 21 - * 84 7 + /";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFix13()
    {
        String infix = "(4+8)*(6-5)/((3-2)*(2+2))";
        final String CORRECT = "4 8 + 6 5 - * 3 2 - 2 2 + * /";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFix14()
    {
        String infix = "((4)+(5))/((3)*(2))";
        final String CORRECT = "4 5 + 3 2 * /";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test toPostfix.
     */
    @Test
    public void testToPostFix15()
    {
        String infix = "4 + 8 * 6 - 5 / 3 - 2 * 2 + 2";
        final String CORRECT = "4 8 6 * + 5 3 / - 2 2 * - 2 +";
        ExpressionEvaluator e = new ExpressionEvaluator();
        String postfix = e.toPostfix(infix).trim();
        assertEquals("infix: " + infix + "\nCorrect postfix: " + CORRECT
                + "\nYour postfix: " + postfix + "\n", CORRECT, postfix);
    }

    /**
     * Test evaluate.
     */
    @Test
    public void testEvaluate1()
    {
        String postfix = "1";
        final double CORRECT = 1.0;
        final double EPS = 1e-6;
        ExpressionEvaluator e = new ExpressionEvaluator();
        double result = e.evaluate(postfix);
        assertEquals("postfix: " + postfix + "\nCorrect result: " + CORRECT
                + "\nYour result: " + result + "\n", CORRECT, result, EPS);
    }

    /**
     * Test evaluate.
     */
    @Test
    public void testEvaluate2()
    {
        String postfix = "1 2 +";
        final double CORRECT = 3.0;
        final double EPS = 1e-6;
        ExpressionEvaluator e = new ExpressionEvaluator();
        double result = e.evaluate(postfix);
        assertEquals("postfix: " + postfix + "\nCorrect result: " + CORRECT
                + "\nYour result: " + result + "\n", CORRECT, result, EPS);
    }

    /**
     * Test evaluate.
     */
    @Test
    public void testEvaluate3()
    {
        String postfix = "1 2 -";
        final double CORRECT = -1.0;
        final double EPS = 1e-6;
        ExpressionEvaluator e = new ExpressionEvaluator();
        double result = e.evaluate(postfix);
        assertEquals("postfix: " + postfix + "\nCorrect result: " + CORRECT
                + "\nYour result: " + result + "\n", CORRECT, result, EPS);
    }

    /**
     * Test evaluate.
     */
    @Test
    public void testEvaluate4()
    {
        String postfix = "1 2 3 + -";
        final double CORRECT = -4.0;
        final double EPS = 1e-6;
        ExpressionEvaluator e = new ExpressionEvaluator();
        double result = e.evaluate(postfix);
        assertEquals("postfix: " + postfix + "\nCorrect result: " + CORRECT
                + "\nYour result: " + result + "\n", CORRECT, result, EPS);
    }

    /**
     * Test evaluate.
     */
    @Test
    public void testEvaluate5()
    {
        String postfix = "1 2 3 * +";
        final double CORRECT = 7.0;
        final double EPS = 1e-6;
        ExpressionEvaluator e = new ExpressionEvaluator();
        double result = e.evaluate(postfix);
        assertEquals("postfix: " + postfix + "\nCorrect result: " + CORRECT
                + "\nYour result: " + result + "\n", CORRECT, result, EPS);
    }

    /**
     * Test evaluate.
     */
    @Test
    public void testEvaluate6()
    {
        String postfix = "1 2 + 3 *";
        final double CORRECT = 9.0;
        final double EPS = 1e-6;
        ExpressionEvaluator e = new ExpressionEvaluator();
        double result = e.evaluate(postfix);
        assertEquals("postfix: " + postfix + "\nCorrect result: " + CORRECT
                + "\nYour result: " + result + "\n", CORRECT, result, EPS);
    }

    /**
     * Test evaluate.
     */
    @Test
    public void testEvaluate7()
    {
        String postfix = "52 1 2 + 4 * + 3 -";
        final double CORRECT = 61.0;
        final double EPS = 1e-6;
        ExpressionEvaluator e = new ExpressionEvaluator();
        double result = e.evaluate(postfix);
        assertEquals("postfix: " + postfix + "\nCorrect result: " + CORRECT
                + "\nYour result: " + result + "\n", CORRECT, result, EPS);
    }

    /**
     * Test evaluate.
     */
    @Test
    public void testEvaluate8()
    {
        String postfix = "52 1 + 2 4 * + 3 -";
        final double CORRECT = 58.0;
        final double EPS = 1e-6;
        ExpressionEvaluator e = new ExpressionEvaluator();
        double result = e.evaluate(postfix);
        assertEquals("postfix: " + postfix + "\nCorrect result: " + CORRECT
                + "\nYour result: " + result + "\n", CORRECT, result, EPS);
    }

    /**
     * Test evaluate.
     */
    @Test
    public void testEvaluate9()
    {
        String postfix = "52 1 + 2 + 4 * 3 -";
        final double CORRECT = 217.0;
        final double EPS = 1e-6;
        ExpressionEvaluator e = new ExpressionEvaluator();
        double result = e.evaluate(postfix);
        assertEquals("postfix: " + postfix + "\nCorrect result: " + CORRECT
                + "\nYour result: " + result + "\n", CORRECT, result, EPS);
    }

    /**
     * Test evaluate.
     */
    @Test
    public void testEvaluate10()
    {
        String postfix = "3 4 5 * 6 / +";
        final double CORRECT = 6.333333;
        final double EPS = 1e-6;
        ExpressionEvaluator e = new ExpressionEvaluator();
        double result = e.evaluate(postfix);
        assertEquals("postfix: " + postfix + "\nCorrect result: " + CORRECT
                + "\nYour result: " + result + "\n", CORRECT, result, EPS);
    }

    /**
     * Test evaluate.
     */
    @Test
    public void testEvaluate11()
    {
        String postfix = "3 4 5 6 / * +";
        final double CORRECT = 6.333333;
        final double EPS = 1e-6;
        ExpressionEvaluator e = new ExpressionEvaluator();
        double result = e.evaluate(postfix);
        assertEquals("postfix: " + postfix + "\nCorrect result: " + CORRECT
                + "\nYour result: " + result + "\n", CORRECT, result, EPS);
    }

    /**
     * Test evaluate.
     */
    @Test
    public void testEvaluate12()
    {
        String postfix = "300 23 + 43 21 - * 84 7 + /";
        final double CORRECT = 78.087912;
        final double EPS = 1e-6;
        ExpressionEvaluator e = new ExpressionEvaluator();
        double result = e.evaluate(postfix);
        assertEquals("postfix: " + postfix + "\nCorrect result: " + CORRECT
                + "\nYour result: " + result + "\n", CORRECT, result, EPS);
    }

    /**
     * Test evaluate.
     */
    @Test
    public void testEvaluate13()
    {
        String postfix = "4 8 + 6 5 - * 3 2 - 2 2 + * /";
        final double CORRECT = 3.0;
        final double EPS = 1e-6;
        ExpressionEvaluator e = new ExpressionEvaluator();
        double result = e.evaluate(postfix);
        assertEquals("postfix: " + postfix + "\nCorrect result: " + CORRECT
                + "\nYour result: " + result + "\n", CORRECT, result, EPS);
    }

    /**
     * Test evaluate.
     */
    @Test
    public void testEvaluate14()
    {
        String postfix = "4 8 1 2 3 4 10 8 3 * - + / * * + -";
        final double CORRECT = -3.4;
        final double EPS = 1e-6;
        ExpressionEvaluator e = new ExpressionEvaluator();
        double result = e.evaluate(postfix);
        assertEquals("postfix: " + postfix + "\nCorrect result: " + CORRECT
                + "\nYour result: " + result + "\n", CORRECT, result, EPS);
    }

    /**
     * Test evaluate.
     */
    @Test
    public void testEvaluate15()
    {
        String postfix = "4 8 + 6 5 - * 3 2 - 2 2 + * /";
        final double CORRECT = 3.0;
        final double EPS = 1e-6;
        ExpressionEvaluator e = new ExpressionEvaluator();
        double result = e.evaluate(postfix);
        assertEquals("postfix: " + postfix + "\nCorrect result: " + CORRECT
                + "\nYour result: " + result + "\n", CORRECT, result, EPS);
    }
}
