package solution;


import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Stack;

/**
 * 
 * @author Gus Mckee
 * 
 * @version July 21st
 * 
 */
public class ExpressionEvaluator
{

    public static final Pattern UNSIGNED_DOUBLE =
        Pattern.compile("((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?");
    public static final Pattern CHARACTER = Pattern.compile("\\S.*?");

    /**
     * Takes an infix expression and converts it to postfix.
     * 
     * @param expression
     *            The infix expression.
     * @return the postfix expression.
     */
    public String toPostfix(String expression)
    {
        // ... other local variables
        Scanner input = new Scanner(expression);
        String next;
        char symbol = ' ';
        char lastSymbol = ' ';
        String postfixExpression = "";

        Stack<Character> myStack = new Stack<Character>();

        while (input.hasNext())
        {
            if (input.hasNext(UNSIGNED_DOUBLE))
            {
                next = input.findInLine(UNSIGNED_DOUBLE);
                // TODO: do what you want to with a String that
                // holds a number
                postfixExpression += next + " ";
            }
            else
            {
                lastSymbol = symbol;
                next = input.findInLine(CHARACTER);
               
                symbol = next.charAt(0);
         

                // TODO: do what you want to with a symbol
                // such as (, ), *, /, +, -

                if (symbol == '(')
                {
                    if(lastSymbol != ')')
                    {
                    myStack.push(symbol);
                    }
                    else
                    {
                        return "error";
                    }
                }
                else if (symbol == '*' || symbol == '/' || symbol == '+'
                    || symbol == '-')
                {
                    while (!myStack.isEmpty() && myStack.peek() != '('
                        && check(myStack.peek()) >= check(symbol))
                    {
                        postfixExpression += myStack.pop() + " ";
                    }
                    myStack.push(symbol);
                }
                else if (symbol == ')')
                {
                    while (!myStack.isEmpty() && myStack.peek() != '(')
                    {
                        postfixExpression += myStack.pop() + " ";
                    }
                    myStack.pop();
                    // myStack.remove('(');

                }

                else
                {
                    return "error";
                }

            }

        }
        while (!myStack.isEmpty())
        {
            postfixExpression += myStack.pop() + " ";

        }
        input.close();
        return postfixExpression;
    }

    // Method to check precidence of(* && / vs + && -)
    public int check(char c)
    {
        if (c == '*' || c == '/')
        {
            return 10;
        }
        else if (c == '+' || c == '-')
        {
            return 1;
        }

        else
        {
            return 0;
        }
    }

    /**
     * Evaluates a postfix expression and returns the result.
     * 
     * @param postfixExpression
     *            The postfix expression.
     * @return The result of the expression.
     */
    public double evaluate(String postfixExpression)
    {
        // other local variables you may need
        Scanner input = new Scanner(postfixExpression);
        String next;
        char operator;
        double answer = Double.NaN;

     Stack<Double> myStack = new Stack<>();
     
        while (input.hasNext())
        {
            if (input.hasNext(UNSIGNED_DOUBLE))
            {
                next = input.findInLine(UNSIGNED_DOUBLE);
                // TODO: do what you want to with a String that
                // holds a number
             
                
                myStack.push(Double.parseDouble(next));

                            }
            else
            {
                next = input.findInLine(CHARACTER);
                operator = next.charAt(0);

                // TODO: do what you want to with an operator
                // such as *, /, +, -
                double num2 = myStack.pop();
                double num1 = myStack.pop();
                
                 
                switch (operator)
                {
                

                    case ('*'):
                        answer = num1 * num2;
                      
                       
                        break;

                    case ('/'):
                      
                        if(num2 == 0) 
                       {
                           answer = Double.NaN; 
                       }
                       else 
                       {
                           answer = num1 / num2;
                       }
                      
                        
                        break;
                        
                    case ('+'):
                        answer = num1 + num2;
                    
                        break;
                        
                        
                    case ('-'):
                        answer = num1 - num2;
                    
                        break;

                    
                      default: 
                          answer = Double.NaN;
                          break;
                }
                myStack.push(answer);
            }
        
       

    }
        input.close();
        return answer;
}
}
