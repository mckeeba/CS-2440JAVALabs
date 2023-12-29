package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

import org.junit.Before;
import org.junit.Test;

import solution.Calculator2;

/**
 * This class tests the Calculator2 GUI.
 *
 * @author Mitch Parry
 * @version 2013-11-05
 *
 */
public class Calculator2Test
{
    private Calculator2 calc;

    /**
     * This launches a calculator GUI before each test.
     *
     * @throws Exception
     *             if it fails.
     */
    @Before
    public void begin() throws Exception
    {
        calc = new Calculator2();
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
     * Test calculate button is visible.
     */
    @Test
    public void testCalculateVisible()
    {
        testFrameVisible();
        JButton button = getPanelComponent(JButton.class, "calculateButton");
        assertTrue(button.isVisible());
    }

    /**
     * Test calculate button is visible.
     */
    @Test
    public void testClearVisible()
    {
        testFrameVisible();
        JButton button = getPanelComponent(JButton.class, "clearButton");
        assertTrue(button.isVisible());
    }

    /**
     * Test result label is visible.
     */
    @Test
    public void testResultVisible()
    {
        testFrameVisible();
        JLabel resultLabel = getPanelComponent(JLabel.class, "resultLabel");
        assertTrue(resultLabel.isVisible());
    }

    /**
     * Test infix expression text field is visible.
     */
    @Test
    public void testInfixFieldVisible()
    {
        testFrameVisible();
        JTextField field =
            getPanelComponent(JTextField.class, "infixExpression");
        assertTrue(field.isVisible());
    }

    /**
     * Test infix expression text field width.
     */
    @Test
    public void testInfixFieldLabel()
    {
        testFrameVisible();
        JTextField field =
            getPanelComponent(JTextField.class, "infixExpression");
        assertTrue(field.getColumns() > 5);
    }

    /**
     * Test clear button.
     */
    @Test
    public void testClearButton1()
    {
        testFrameVisible();
        JTextField field =
            getPanelComponent(JTextField.class, "infixExpression");
        JButton clearButton = getPanelComponent(JButton.class, "clearButton");

        field.setText("Hello");
        clearButton.doClick();
        assertTrue(field.getText().equals(""));

    }

    /**
     * Test clear button.
     */
    @Test
    public void testClearButton2()
    {
        testClearButton1();
    }

    /**
     * Test clear button.
     */
    @Test
    public void testClearButton3()
    {
        testClearButton1();
    }

    /**
     * Test calculate button.
     */
    @Test
    public void testCalculate1()
    {
        final double CORRECT = 28.0;
        final double EPS = 1e-6;
        JTextField field =
            getPanelComponent(JTextField.class, "infixExpression");
        JLabel resultLabel = getPanelComponent(JLabel.class, "resultLabel");
        JButton calculateButton =
            getPanelComponent(JButton.class, "calculateButton");

        String infix = "3 + 5 * 10 / 2";
        field.setText(infix);
        calculateButton.doClick();

        Scanner scan = new Scanner(resultLabel.getText());
        double result = Double.NaN;
        while (scan.hasNext())
        {
            if (scan.hasNextDouble())
            {
                result = scan.nextDouble();
            }
            else
            {
                assertFalse("The result label indicates an error but this "
                    + "expression does not contain one:\n" + infix
                    + "\n", scan.next().toLowerCase().contains("error"));
            }
        }
        scan.close();
        assertEquals(CORRECT, result, EPS);
    }

    /**
     * Test calculate button.
     */
    @Test
    public void testCalculate2()
    {
        final double CORRECT = 40.0;
        final double EPS = 1e-6;
        JTextField field =
            getPanelComponent(JTextField.class, "infixExpression");
        JLabel resultLabel = getPanelComponent(JLabel.class, "resultLabel");
        JButton calculateButton =
            getPanelComponent(JButton.class, "calculateButton");

        String infix = "(3 + 5) * 10 / 2";
        field.setText(infix);
        calculateButton.doClick();

        Scanner scan = new Scanner(resultLabel.getText());
        double result = Double.NaN;
        while (scan.hasNext())
        {
            if (scan.hasNextDouble())
            {
                result = scan.nextDouble();
            }
            else
            {
                assertFalse("The result label indicates an error but this "
                    + "expression does not contain one:\n" + infix
                    + "\n", scan.next().toLowerCase().contains("error"));
            }
        }
        scan.close();
        assertEquals(CORRECT, result, EPS);
    }

    /**
     * Test calculate button.
     */
    @Test
    public void testCalculate3()
    {
        final double CORRECT = 51.0;
        final double EPS = 1e-6;
        JTextField field =
            getPanelComponent(JTextField.class, "infixExpression");
        JLabel resultLabel = getPanelComponent(JLabel.class, "resultLabel");
        JButton calculateButton =
            getPanelComponent(JButton.class, "calculateButton");

        String infix = "3 + 5 * 10 - 2";
        field.setText(infix);
        calculateButton.doClick();

        Scanner scan = new Scanner(resultLabel.getText());
        double result = Double.NaN;
        while (scan.hasNext())
        {
            if (scan.hasNextDouble())
            {
                result = scan.nextDouble();
            }
            else
            {
                assertFalse("The result label indicates an error but this "
                    + "expression does not contain one:\n" + infix
                    + "\n", scan.next().toLowerCase().contains("error"));
            }
        }
        scan.close();
        assertEquals(CORRECT, result, EPS);
    }

    /**
     * Test error message.
     */
    @Test
    public void testError1()
    {
        JTextField field =
            getPanelComponent(JTextField.class, "infixExpression");
        JLabel resultLabel = getPanelComponent(JLabel.class, "resultLabel");
        JButton calculateButton =
            getPanelComponent(JButton.class, "calculateButton");

        String infix = "3 + 5 * 10 - 2 *";
        field.setText(infix);
        calculateButton.doClick();

        Scanner scan = new Scanner(resultLabel.getText());
        while (scan.hasNext())
        {
            if (scan.next().toLowerCase().contains("error"))
            {
                // success!
                scan.close();
                return;
            }
        }
        scan.close();
        fail("This expression contains an error but the result label does not "
            + "report one:\n" + infix);
    }

    /**
     * Test error message.
     */
    @Test
    public void testError2()
    {
        JTextField field =
            getPanelComponent(JTextField.class, "infixExpression");
        JLabel resultLabel = getPanelComponent(JLabel.class, "resultLabel");
        JButton calculateButton =
            getPanelComponent(JButton.class, "calculateButton");

        String infix = "(3 + 5) (10 / 2)";
        field.setText(infix);
        calculateButton.doClick();

        Scanner scan = new Scanner(resultLabel.getText());
        while (scan.hasNext())
        {
            if (scan.next().toLowerCase().contains("error"))
            {
                // success!
                scan.close();
                return;
            }
        }
        scan.close();
        fail("This expression contains an error but the result label does not "
            + "report one:\n" + infix);
    }

    /**
     * Test error message.
     */
    @Test
    public void testError3()
    {
        JTextField field =
            getPanelComponent(JTextField.class, "infixExpression");
        JLabel resultLabel = getPanelComponent(JLabel.class, "resultLabel");
        JButton calculateButton =
            getPanelComponent(JButton.class, "calculateButton");

        String infix = "- (3 + 5) * (10 / 2)";
        field.setText(infix);
        calculateButton.doClick();

        Scanner scan = new Scanner(resultLabel.getText());
        while (scan.hasNext())
        {
            if (scan.next().toLowerCase().contains("error"))
            {
                // success!
                scan.close();
                return;
            }
        }
        scan.close();
        fail("This expression contains an error but the result label does not "
            + "report one:\n" + infix);
    }
}
