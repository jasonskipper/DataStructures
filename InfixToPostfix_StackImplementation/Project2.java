//Michael Skipper, N01162792, Data Structures 
import java.util.Scanner;

public class Project2 {
	
	public static void main(String args[]) {
		String infixExp;
		String postfixExp;
		Stack st = new Stack();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter an infix expression: ");
		infixExp = scan.next();
		System.out.println("The expression in postfix notation is " + infixToPostfix(infixExp));
	}
	public static int prec(char ch) {
		switch(ch) {
		case '+': 
			return 1;
		case '*': 
		case '/': 
			return 2;
		}
		return -1;
	}
	public static String infixToPostfix(String exp) 
    { 
        String a = new String(""); 
        Stack<Character> theStack = new Stack<>(); 
        for (int i = 0; i < exp.length(); ++i) 
        { 
            char c = exp.charAt(i);             
            if (Character.isLetterOrDigit(c)) {
            	a += c;
            	System.out.format("%c:   %-30s%-30s\n", c, a, theStack.printCharStack());
            }
            else if (c == '(') {
            	theStack.stackPush(c);
            	System.out.format("%c:   %-30s%-30s\n", c, a, theStack.printCharStack());
            }
            else if (c == ')') 
            { 
                while (!theStack.stackEmpty() && theStack.stackTop() != '(') 
                    a += theStack.stackPop(); 
                theStack.stackPop(); 
            	System.out.format("%c:   %-30s%-30s\n", c, a, theStack.printCharStack());
            } 
            else 
            { 
                while (!theStack.stackEmpty() && prec(c) <= prec(theStack.stackTop())){ 
                    a += theStack.stackPop(); 
                	System.out.format("%c:   %-30s%-30s\n", c, a, theStack.printCharStack());

                } 
                theStack.stackPush(c); 
            	System.out.format("%c:   %-30s%-30s\n", c, a, theStack.printCharStack());
            } 
        } 
        while (!theStack.stackEmpty()){ 
            a += theStack.stackPop(); 
            System.out.format("%c    %-30s%-30s\n", ' ', a, theStack.printCharStack());
         } 
        return a; 
        }
} 