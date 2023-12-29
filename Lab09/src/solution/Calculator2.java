package solution;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.EmptyStackException;

public class Calculator2 implements ActionListener
{
    private JTextField infixExpression;
    private JFrame calculatorFrame;
    private JLabel resultLabel;

    private JButton calculateButton;
    private JButton clearButton;

    private JPanel infixPanel;
    private JPanel resultPanel;
    private JPanel buttonPanel;

    public JFrame getFrame()
    {
        return this.calculatorFrame;
    }

    public Calculator2()
    {
        // JFrame calculatorFrame;
        calculatorFrame = new JFrame();
        calculatorFrame.setLocation(100, 100);
        calculatorFrame.setSize(400, 400);
        calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorFrame.setTitle("CalcuAnator Calculator");
        calculatorFrame.setBackground(Color.BLACK);

        initializeComponents();

        calculatorFrame.pack();
        calculatorFrame.setVisible(true);

    }

    public static void main(String[] args)
    {
        Calculator2 obj = new Calculator2();
    }

    public void initializeComponents()
    {
        infixPanel = new JPanel();
        resultPanel = new JPanel();
        buttonPanel = new JPanel();

        // users input expression
        infixExpression = new JTextField(100);
        infixExpression.setName("infixExpression");
        infixPanel.add(infixExpression);

        // result Label for calculator
        resultLabel = new JLabel("Result = ");
        resultLabel.setName("resultLabel");
        resultPanel.add(resultLabel);

        // calculate button

        calculateButton = new JButton("Calculate");
        calculateButton.setName("calculateButton");
        buttonPanel.add(calculateButton);

        // clear button
        clearButton = new JButton("Clear");
        clearButton.setName("clearButton");
        buttonPanel.add(clearButton);

        //
        calculatorFrame.add(buttonPanel, BorderLayout.SOUTH);
        calculatorFrame.add(resultPanel, BorderLayout.CENTER);
        calculatorFrame.add(infixPanel, BorderLayout.NORTH);

        // Action listener for calculate button
        calculateButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ExpressionEvaluator obj;
                try
                {
                    obj = new ExpressionEvaluator();

                    double postfixEx =
                        obj.evaluate(obj.toPostfix(infixExpression.getText()));

                    if(postfixEx != Double.NaN)
                    {

                        resultLabel.setText("Result = " + postfixEx);
                            
                    }
                    else
                    {
                        resultLabel.setText("Result = ERROR");
                    }

                }
                catch (EmptyStackException e1)

                {
                    resultLabel.setText("Result = ERROR");
                }
            }

        }

        );

        // Action listener for clear button.

        clearButton.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {

                infixExpression.setText("");
                resultLabel.setText("Result = ");

            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // TODO Auto-generated method stub

    }

}
