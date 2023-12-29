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





public class Calculator implements ActionListener
{
    private JFrame calculatorFrame;
    
    private JPanel calcButtonPanel;
    private JPanel calcResultPanel;
    private JPanel calcTextPanel;
    
    private JLabel resultLabel;
    
  

    private JTextField leftOp;
    private JTextField rightOp;

    private JButton jbAdd;
    private JButton jbSub;
    private JButton jbMult;
    private JButton jbDiv; 

    public JFrame getFrame() {
        return this.calculatorFrame;
    }
    
   
    public Calculator()
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
        Calculator calc = new Calculator();
        

    }

    public void initializeComponents()
    {
       
        calcButtonPanel = new JPanel();
        calcResultPanel = new JPanel();
        calcTextPanel = new JPanel();

        calcButtonPanel.setBackground(Color.BLUE);
        

        jbAdd = new JButton("ADD");
        jbSub = new JButton("SUB");
        jbMult = new JButton("MULT");
        jbDiv = new JButton("DIV");
        
        jbAdd.setBackground(Color.RED);
        jbAdd.setOpaque(true);
        
        jbSub.setBackground(Color.GREEN);
        jbSub.setOpaque(true);
        
        jbMult.setBackground(Color.YELLOW);
        jbMult.setOpaque(true);
        
        jbDiv.setBackground(Color.ORANGE);
        jbDiv.setOpaque(true);
        
        
        jbAdd.setName("addButton");
        jbSub.setName("subButton");
        jbMult.setName("multButton");
        jbDiv.setName("divButton");

        jbAdd.addActionListener(this);
        jbSub.addActionListener(this);
        jbMult.addActionListener(this);
        jbDiv.addActionListener(this);  
        
      
        
        
        
        
        calcButtonPanel.add(jbAdd);
        calcButtonPanel.add(jbSub);
        calcButtonPanel.add(jbMult);
        calcButtonPanel.add(jbDiv);
        
        resultLabel = new JLabel("Result = ");
        resultLabel.setName("resultLabel");
        calcResultPanel.add(resultLabel);
    
  
      leftOp = new JTextField(10);
      rightOp = new JTextField(10);
      leftOp.setName("leftOperand");
      rightOp.setName("rightOperand");
      calcTextPanel.add(leftOp);
      calcTextPanel.add(rightOp);
      
      
      
      calculatorFrame.add(calcButtonPanel, BorderLayout.SOUTH);
      calculatorFrame.add(calcResultPanel, BorderLayout.CENTER);
      calculatorFrame.add(calcTextPanel, BorderLayout.NORTH);
      
      
    
   
    
    jbAdd.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e) 
        {
            try 
            {
                double left = Double.parseDouble(leftOp.getText());
                double right = Double.parseDouble(rightOp.getText());
                double sum = left + right;
                resultLabel.setText(String.format("Result = %-10.2f", sum));
              
            }
            catch(NumberFormatException sum)
            {
              resultLabel.setText("Result = ERROR");  
            }
             
            
            
        }
    }
    );
    
    
    jbSub.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e) 
        {
            try 
            {
                double left = Double.parseDouble(leftOp.getText());
                double right = Double.parseDouble(rightOp.getText());
                double diff = left - right;
                resultLabel.setText(String.format("Result = %-10.2f", diff));
              
            }
            catch(NumberFormatException diff)
            {
              resultLabel.setText("Result = ERROR");  
            }
            
        }
    }
    );
    
    jbMult.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e) 
        {
            try 
            {
                double left = Double.parseDouble(leftOp.getText());
                double right = Double.parseDouble(rightOp.getText());
                double prod = left * right;
                resultLabel.setText(String.format("Result = %-10.2f", prod));
              
            }
            catch(NumberFormatException prod)
            {
              resultLabel.setText("Result = ERROR");  
            }  
        }
    }
    );
    
    
    jbDiv.addActionListener(new ActionListener()
    {
       public void actionPerformed(ActionEvent e) 
        {
           try 
           {
               double left = Double.parseDouble(leftOp.getText());
               double right = Double.parseDouble(rightOp.getText());
              
               double quot;
              
              if(right == 0)
               {
                  resultLabel.setText("Result = ERROR");    
               }
              else {
                 
                quot = left / right;
               resultLabel.setText(String.format("Result = %-10.2f", quot));
               
              }
             
           }
           catch(NumberFormatException quot)
           {
             resultLabel.setText("Result = ERROR");  
           } 
        }
    }
    );
    
    
}


     @Override
    public void actionPerformed(ActionEvent e)
    {
        // TODO Auto-generated method stub
        
    }
  
}
