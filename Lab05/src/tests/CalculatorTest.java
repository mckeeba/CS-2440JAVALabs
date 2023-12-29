package tests;
/**
 * CalculatorTest.java
 *  
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solution.Calculator;

/**
 * Test class for the calculator GUI.
 * 
 * @author Mitch Parry
 * @version 2014-01-33
 */
public class CalculatorTest
{
    private Calculator calc;

    /**
     * Set up the calculator before each test case.
     * 
     * @throws Exception
     *             when it fails
     */
    @Before
    public void begin() throws Exception
    {
        calc = new Calculator();
    }

    /**
     * Tear down the calculator after each test case.
     * 
     * @throws Exception
     *             when it fails
     */
    @After
    public void tearDown() throws Exception
    {

    }

    /**
     * Gets the subcomponent of root with the 'type' and 'name'.
     * 
     * @param <T>
     *            the return type
     * @param root
     *            the root component
     * @param type
     *            the type of the subcomponent
     * @param name
     *            the name of the subcomponent
     * @return the subcomponent or null if it does not exist.
     */
    @SuppressWarnings("unchecked")
    private <T extends Component> T getComponent(JComponent root,
        Class<T> type, String name)
    {
        for (Component c : root.getComponents())
        {
            if (c.getClass() == type)
            {
                if (((T) c).getName().equals(name))
                {
                    return (T) c;
                }
            }
        }
        fail("Could not find " + type + " with name = \"" + name + "\"");
        return null;
    }

    /**
     * @return the content pane for the calculator.
     */
    private JPanel getContentPane()
    {
        JFrame frame = calc.getFrame();
        assertNotNull(frame);
        JRootPane root = (JRootPane) frame.getRootPane();
        JLayeredPane layeredPane =
            getComponent(root, JLayeredPane.class, "null.layeredPane");
        JPanel contentPane =
            getComponent(layeredPane, JPanel.class, "null.contentPane");
        return contentPane;
    }

    /**
     * Gets the component within a panel of the frame of the calculator with the
     * specified name.
     * 
     * @param <T>
     *            used for the return value.
     * 
     * @param type
     *            The type of component to find.
     * @param name
     *            the name of the component.
     * @return the component or null if it wasn't found.
     */
    @SuppressWarnings("unchecked")
    private <T extends Component> T getPanelComponent(Class<T> type,
        String name)
    {
        JPanel contentPane = getContentPane();
        for (Component c : contentPane.getComponents())
        {
            if (c instanceof JPanel)
            {
                for (Component d : ((JPanel) c).getComponents())
                {
                    if (d.getClass() == type && d.getName().equals(name))
                    {
                        return (T) d;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Test whether a frame is visible.
     */
    @Test
    public void testFrameVisible()
    {
        JFrame frame = calc.getFrame();
        assertNotNull(frame);
        assertTrue(frame.isVisible());
    }

    /**
     * Test frame title.
     */
    @Test
    public void testFrameTitle()
    {
    	testFrameVisible();
        JFrame frame = calc.getFrame();
        assertNotNull(frame);
        String title = frame.getTitle();
        int index = title.toLowerCase().indexOf("calculator");
        assertTrue(index >= 0);
    }

    /**
     * Test add button is visible.
     */
    @Test
    public void testAddVisible()
    {
    	testFrameVisible();
        JButton button = getPanelComponent(JButton.class, "addButton");
        assertNotNull(button);
        assertTrue(button.isVisible());
    }

    /**
     * Test add button label.
     */
    @Test
    public void testAddLabel()
    {
    	testAddVisible();
        JButton button = getPanelComponent(JButton.class, "addButton");
        assertNotNull(button);
        assertEquals(button.getText(), "ADD");
    }

    /**
     * Test subtract button is visible.
     */
    @Test
    public void testSubVisible()
    {
    	testFrameVisible();
        JButton button = getPanelComponent(JButton.class, "subButton");
        assertNotNull(button);
        assertTrue(button.isVisible());
    }

    /**
     * Test add button label.
     */
    @Test
    public void testSubLabel()
    {
    	testSubVisible();
        JButton button = getPanelComponent(JButton.class, "subButton");
        assertNotNull(button);
        assertEquals(button.getText(), "SUB");
    }

    /**
     * Test multiply button is visible.
     */
    @Test
    public void testMultVisible()
    {
    	testFrameVisible();
        JButton button = getPanelComponent(JButton.class, "multButton");
        assertNotNull(button);
        assertTrue(button.isVisible());
    }

    /**
     * Test multiply button label.
     */
    @Test
    public void testMultLabel()
    {
    	testMultVisible();
        JButton button = getPanelComponent(JButton.class, "multButton");
        assertNotNull(button);
        assertEquals(button.getText(), "MULT");
    }

    /**
     * Test divide button is visible.
     */
    @Test
    public void testDivVisible()
    {
    	testFrameVisible();
        JButton button = getPanelComponent(JButton.class, "divButton");
        assertNotNull(button);
        assertTrue(button.isVisible());
    }

    /**
     * Test divide button label.
     */
    @Test
    public void testDivLabel()
    {
    	testDivVisible();
        JButton button = getPanelComponent(JButton.class, "divButton");
        assertNotNull(button);
        assertEquals(button.getText(), "DIV");
    }

    /**
     * Test result label is visible.
     */
    @Test
    public void testResultVisible()
    {
    	testFrameVisible();
        JLabel resultLabel = getPanelComponent(JLabel.class, "resultLabel");
        assertNotNull(resultLabel);
        assertTrue(resultLabel.isVisible());
    }

    /**
     * Test result label contains text.
     */
    @Test
    public void testResultLabel()
    {
    	testResultVisible();
        JLabel resultLabel = getPanelComponent(JLabel.class, "resultLabel");
        assertNotNull(resultLabel);
        assertTrue(resultLabel.getText().length() > 0);
    }

    /**
     * Test operator 1 text field is visible.
     */
    @Test
    public void testOp1Visible()
    {
    	testFrameVisible();
        JTextField field = getPanelComponent(JTextField.class, "leftOperand");
        assertNotNull(field);
        assertTrue(field.isVisible());
    }

    /**
     * Test operator 1 text field width.
     */
    @Test
    public void testOp1Label()
    {
    	testOp1Visible();
        JTextField field = getPanelComponent(JTextField.class, "leftOperand");
        assertNotNull(field);
        assertTrue(field.getColumns() > 5);
    }

    /**
     * Test operator 2 text field is visible.
     */
    @Test
    public void testOp2Visible()
    {
    	testFrameVisible();
        JTextField field = getPanelComponent(JTextField.class, "rightOperand");
        assertNotNull(field);
        assertTrue(field.isVisible());
    }

    /**
     * Test operator 1 text field width.
     */
    @Test
    public void testOp2Label()
    {
    	testOp2Visible();
        JTextField field = getPanelComponent(JTextField.class, "rightOperand");
        assertNotNull(field);
        assertTrue(field.getColumns() > 5);
    }

    /**
     * Simulates entering keyboard input to the field.
     * 
     * @param f
     *            The text field
     * @param s
     *            The string to type
     */
    private void keyString(JTextField f, String s)
    {
        f.setText(s);
    }

    /**
     * Simulates clicking the button.
     * 
     * @param b
     *            the button
     */
    private void click(JButton b)
    {
        b.doClick();
    }

    /**
     * Test buttons.
     * 
     * @param a
     *            Left operand
     * @param b
     *            Right operand
     * @param op
     *            Operator
     */
    private void clickOperation(int a, int b, char op)
    {
    	testOp1Visible();
    	testOp2Visible();
        JTextField op1Field =
            getPanelComponent(JTextField.class, "leftOperand");
        JTextField op2Field =
            getPanelComponent(JTextField.class, "rightOperand");
        keyString(op1Field, Integer.toString(a));
        keyString(op2Field, Integer.toString(b));
        switch (op)
        {
            case '+':
            	testAddVisible();
                click(getPanelComponent(JButton.class, "addButton"));
                break;
            case '-':
            	testSubVisible();
                click(getPanelComponent(JButton.class, "subButton"));
                break;
            case '*':
            	testMultVisible();
                click(getPanelComponent(JButton.class, "multButton"));
                break;
            case '/':
            	testDivVisible();
                click(getPanelComponent(JButton.class, "divButton"));
                break;
            default:
        }
    }

    /**
     * Click button with nonnumeric input.
     * 
     * @param op1
     *            Left operand
     * @param op2
     *            Right operand
     * @param op
     *            Operator
     */
    private void clickNonnumeric(String op1, String op2, char op)
    {
        testOp1Visible();
        testOp2Visible();
        JTextField op1Field =
            getPanelComponent(JTextField.class, "leftOperand");
        JTextField op2Field =
            getPanelComponent(JTextField.class, "rightOperand");
        keyString(op1Field, op1);
        keyString(op2Field, op2);
        switch (op)
        {
            case '+':
                testAddVisible();
                click(getPanelComponent(JButton.class, "addButton"));
                break;
            case '-':
                testSubVisible();
                click(getPanelComponent(JButton.class, "subButton"));
                break;
            case '*':
                testMultVisible();
                click(getPanelComponent(JButton.class, "multButton"));
                break;
            case '/':
                testDivVisible();
                click(getPanelComponent(JButton.class, "divButton"));
                break;
            default:
        }
    }

    /**
     * Get last number from string.
     * 
     * @param r
     *            The string
     * @return the last number as a string
     */
    private String getLastNumber(String r)
    {
        Scanner scan = new Scanner(r);
        String s = null;
        while (scan.hasNext())
        {
            if (scan.hasNextDouble())
            {
                s = scan.next();
            }
            else
            {
                scan.next();
            }
        }
        scan.close();
        return s;
    }

    /**
     * Compare current result.
     * 
     * @return The current result
     */
    private String getAnswer()
    {
        testResultVisible();
        JLabel resultLabel = getPanelComponent(JLabel.class, "resultLabel");
        return resultLabel.getText();
    }

    /**
     * Test add.
     * 
     * @param a
     *            Left operand
     * @param b
     *            Right operand
     */
    private void testAdd(int a, int b)
    {
        clickOperation(a, b, '+');
        String s = getLastNumber(getAnswer());
        int r = (int) Double.parseDouble(s);
        assertEquals("Add incorrect", a + b, r);
    }

    /**
     * Test subtract.
     * 
     * @param a
     *            Left operand
     * @param b
     *            Right operand
     */
    private void testSubtract(int a, int b)
    {
        clickOperation(a, b, '-');
        String s = getLastNumber(getAnswer());
        int r = (int) Double.parseDouble(s);
        assertEquals("Subtract incorrect", a - b, r);
    }

    /**
     * Test multiply.
     * 
     * @param a
     *            Left operand
     * @param b
     *            Right operand
     */
    private void testMultiply(int a, int b)
    {
        clickOperation(a, b, '*');
        String s = getLastNumber(getAnswer());
        int r = (int) Double.parseDouble(s);
        assertEquals("Multiply incorrect", a * b, r);
    }

    /**
     * Test divide.
     * 
     * @param a
     *            Left operand
     * @param b
     *            Right operand
     */
    private void testDivide(int a, int b)
    {
        clickOperation(a, b, '/');
        String s = getAnswer();
        if (b != 0)
        {
            int r = (int) Double.parseDouble(getLastNumber(s));
            assertEquals("Divide incorrect", a / b, r);
        }
        else
        {
            assertTrue(s.toLowerCase().indexOf("error") >= 0);
        }
    }

    /**
     * Test Nonnumeric.
     * 
     * @param a
     *            Left operand
     * @param b
     *            Right operand
     * @param op
     *            Operator
     */
    private void testNonnumeric(String a, String b, char op)
    {
        clickNonnumeric(a, b, op);
        String s = getAnswer();
        assertTrue(s.toLowerCase().indexOf("error") >= 0);
    }

    /**
     * Test the add button 1.
     */
    @Test
    public void testAdd1()
    {
        final int A = 6;
        final int B = 2;
        testAdd(A, B);
    }

    /**
     * Test the add button 2.
     */
    @Test
    public void testAdd2()
    {
        final int A = 6;
        final int B = -2;
        testAdd(A, B);
    }

    /**
     * Test the add button 3.
     */
    @Test
    public void testAdd3()
    {
        final int A = -6;
        final int B = 2;
        testAdd(A, B);
    }

    /**
     * Test the add button 4.
     */
    @Test
    public void testAdd4()
    {
        final int A = -6;
        final int B = -2;
        testAdd(A, B);
    }

    /**
     * Test the subtract button 1.
     */
    @Test
    public void testSubtract1()
    {
        final int A = 6;
        final int B = 2;
        testSubtract(A, B);
    }

    /**
     * Test the subtract button 2.
     */
    @Test
    public void testSubtract2()
    {
        final int A = 6;
        final int B = -2;
        testSubtract(A, B);
    }

    /**
     * Test the subtract button 3.
     */
    @Test
    public void testSubtract3()
    {
        final int A = -6;
        final int B = 2;
        testSubtract(A, B);
    }

    /**
     * Test the subtract button 4.
     */
    @Test
    public void testSubtract4()
    {
        final int A = -6;
        final int B = -2;
        testSubtract(A, B);
    }

    /**
     * Test the Multiply button 1.
     */
    @Test
    public void testMultiply1()
    {
        final int A = 6;
        final int B = 2;
        testMultiply(A, B);
    }

    /**
     * Test the Multiply button 2.
     */
    @Test
    public void testMultiply2()
    {
        final int A = 6;
        final int B = -2;
        testMultiply(A, B);
    }

    /**
     * Test the Multiply button 3.
     */
    @Test
    public void testMultiply3()
    {
        final int A = -6;
        final int B = 2;
        testMultiply(A, B);
    }

    /**
     * Test the Multiply button 4.
     */
    @Test
    public void testMultiply4()
    {
        final int A = -6;
        final int B = -2;
        testMultiply(A, B);
    }

    /**
     * Test the Divide button 1.
     */
    @Test
    public void testDivide1()
    {
        final int A = 6;
        final int B = 2;
        testDivide(A, B);
    }

    /**
     * Test the Divide button 2.
     */
    @Test
    public void testDivide2()
    {
        final int A = 6;
        final int B = -2;
        testDivide(A, B);
    }

    /**
     * Test the Divide button 3.
     */
    @Test
    public void testDivide3()
    {
        final int A = -6;
        final int B = 2;
        testDivide(A, B);
    }

    /**
     * Test the Divide button 4.
     */
    @Test
    public void testDivide4()
    {
        final int A = -6;
        final int B = -2;
        testDivide(A, B);
    }

    /**
     * Test Division by zero 1.
     */
    @Test
    public void testDivideZero1()
    {
        final int A = -6;
        final int B = 0;
        testDivide(A, B);
    }

    /**
     * Test Division by zero 2.
     */
    @Test
    public void testDivideZero2()
    {
        final int A = 6;
        final int B = 0;
        testDivide(A, B);
    }

    /**
     * Test Division by zero 3.
     */
    @Test
    public void testDivideZero3()
    {
        final int A = 0;
        final int B = 0;
        testDivide(A, B);
    }

    /**
     * Test Division by zero 4.
     */
    @Test
    public void testDivideZero4()
    {
        final int A = 1000;
        final int B = 0;
        testDivide(A, B);
    }

    /**
     * Test Nonnumeric operands 1.
     */
    @Test
    public void testNonnumeric1()
    {
        testNonnumeric("10", "nan", '+');
    }

    /**
     * Test Division by zero 2.
     */
    @Test
    public void testNonnumeric2()
    {
        testNonnumeric("nan", "5", '-');
    }

    /**
     * Test Nonnumeric operands 3.
     */
    @Test
    public void testNonnumeric3()
    {
        testNonnumeric("nan", "nan", '/');
    }

    /**
     * Test Nonnumeric operands 4.
     */
    @Test
    public void testNonnumeric4()
    {
        testNonnumeric("", "5", '*');
    }

    /**
     * Test layout with three panels.
     */
    @Test
    public void testLayout1()
    {
        JButton button = getPanelComponent(JButton.class, "addButton");
        JPanel buttonPanel = (JPanel) button.getParent();
        JPanel rootPanel = (JPanel) buttonPanel.getParent();
        assertEquals(rootPanel.getComponentCount(), 3);
    }

    /**
     * Test layout with textField panel at PAGE_START, NORTH, or
     * BEFORE_FIRST_LINE.
     */
    @Test
    public void testLayout2()
    {
        JTextField field = getPanelComponent(JTextField.class, "leftOperand");
        JPanel panel = (JPanel) field.getParent();
        JPanel rootPanel = (JPanel) panel.getParent();
        BorderLayout bl = (BorderLayout) rootPanel.getLayout();
        Component a = bl.getLayoutComponent(BorderLayout.PAGE_START);
        Component b = bl.getLayoutComponent(BorderLayout.NORTH);
        Component c = bl.getLayoutComponent(BorderLayout.BEFORE_FIRST_LINE);
        if (panel != a && panel != b && panel != c)
        {
            fail("Text field layout fails.");
        }
    }

    /**
     * Test layout with resultLabel panel at LINE_START, WEST,
     * BEFORE_LINE_BEGINS, CENTER, LINE_END, EAST, or AFTER_LINE_ENDS.
     */
    @Test
    public void testLayout3()
    {
        JLabel label = getPanelComponent(JLabel.class, "resultLabel");
        JPanel panel = (JPanel) label.getParent();
        JPanel rootPanel = (JPanel) panel.getParent();
        BorderLayout bl = (BorderLayout) rootPanel.getLayout();
        Component a = bl.getLayoutComponent(BorderLayout.LINE_START);
        Component b = bl.getLayoutComponent(BorderLayout.WEST);
        Component c = bl.getLayoutComponent(BorderLayout.BEFORE_LINE_BEGINS);
        Component d = bl.getLayoutComponent(BorderLayout.CENTER);
        Component e = bl.getLayoutComponent(BorderLayout.LINE_END);
        Component f = bl.getLayoutComponent(BorderLayout.EAST);
        Component g = bl.getLayoutComponent(BorderLayout.AFTER_LINE_ENDS);
        if (panel != a && panel != b && panel != c && panel != d
            && panel != e && panel != f && panel != g)
        {
            fail("Result label layout fails.");
        }
    }

    /**
     * Test layout with button panel at PAGE_END, SOUTH, or AFTER_LAST_LINE.
     */
    @Test
    public void testLayout4()
    {
        JButton button = getPanelComponent(JButton.class, "addButton");
        JPanel panel = (JPanel) button.getParent();
        JPanel rootPanel = (JPanel) panel.getParent();
        BorderLayout bl = (BorderLayout) rootPanel.getLayout();
        Component a = bl.getLayoutComponent(BorderLayout.PAGE_END);
        Component b = bl.getLayoutComponent(BorderLayout.SOUTH);
        Component c = bl.getLayoutComponent(BorderLayout.AFTER_LAST_LINE);
        if (panel != a && panel != b && panel != c)
        {
            fail("Button layout fails.");
        }
    }

}
