import java.util.Stack; 

public class stack {
    
        Stack <Character> operator = new Stack();
        Stack <Integer> operand = new Stack();
    
    public int evaluate(String expression,String type)
    {
       
        char[] input = expression.toCharArray(); //converts expression to char array
        
        
        for(int i=0; i<input.length; i++)
        {
           
           if (input[i] >= '0' && input[i] <= '9')//if char is a number
           {
                StringBuffer sbuf = new StringBuffer();
               
                while (i < input.length && input[i] >= '0' && input[i] <= '9')//checks if its multiple number
                sbuf.append(input[i++]);
                i--;
                if(type == "")
                {
                operand.push(Integer.parseInt(sbuf.toString()));//push value
                }
                else
                {
                     operand.push(Integer.parseInt(sbuf.toString(),2));//push value as decimal
                }
                
            }
            else if(input[i] == '(')
            {
                operator.push(input[i]);
            }
            else if(input[i]==')')
            {
                while(operator.peek() != '(')
                {
                    operand.push(execute(operator.pop(),operand.pop(),operand.pop()));//execute data in parenthesis
                }
                operator.pop();
            }
            else if(input[i]=='/' || input[i] =='*' || input[i]=='%' || input[i]=='+'|| input[i]=='-')
            {
                while(!operator.empty() && precedence(input[i],operator.peek()))//while operator stack is not empty and has precedence
                {
                     operand.push(execute(operator.pop(),operand.pop(),operand.pop()));//gets values stores them into operand
                }
               operator.push(input[i]);
            }
        }
        
        while(!operator.empty())//while operator is not empty
        {
            operand.push(execute(operator.pop(),operand.pop(),operand.pop()));//calculate
        }
        return operand.pop();//return answer
        
         
    }
    
     public boolean precedence(char op1, char op2) //if op1 has precednce of op2
     {
        if (op2 == '(' || op2 == ')') 
            return false; 
        if ((op1 == '*' || op1 == '/'|| op1 == '%') && (op2 == '+' || op2 == '-')) 
            return false; 
        else
            return true; 
     }
     public static int execute(char op, int b, int a) //calculate equation
    { 
        switch (op) 
        { 
        case '+': 
            return a + b; 
        case '-': 
            return a - b; 
        case '*': 
            return a * b; 
        case '%': 
            return a % b;
        case '/': 
            if (b == 0) 
                throw new
                UnsupportedOperationException("Cannot divide by zero"); 
            return a / b; 
    
        } 
        return 0; 
    } 
     
    

    

} 
    
