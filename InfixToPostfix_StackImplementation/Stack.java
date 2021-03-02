//Michael Skipper, N01162792, Data Structures
public class Stack<E> {
	private int count;
	private int top = -1;
	public static final int MAXSIZE = 1000;
	private E[ ] array;  
	public Stack( ) { this(MAXSIZE); }
	public Stack(int capacity) { 
		array = (E[ ]) new Object[capacity]; 
	}
	public int stackCount( ) { 
		//return count; 
		return top + 1;
	}
	public boolean stackEmpty( ) { 
		return (top == -1); 
}
	public void stackPush(E element) throws IllegalStateException {
		if (stackCount() == array.length) throw new IllegalStateException("Stack is full");
		array[++top] = element; 
	}
	public E stackTop( ) {
		if (stackEmpty( )) return null;
		return array[top];
	}
	public E stackPop( ) {
		if (stackEmpty( )) return null;
		E answer = array[top];
		array[top] = null; 
		top--;
		return answer;
	}
	public String toString() {
		String temp = "<";
		for (int i = 0; i < stackCount(); i++) {
			//temp += array[i] + " , ";
			temp += " " + array[i];
		}
		temp += ">";
		return temp;
	}
	public String printCharStack() {
		String temp = "< ";
		//char character = (char) temp;
		for (int i = 0; i < stackCount(); i++) {
			//temp += (char)array[i] + " , ";
			temp += (char) array[i] + " ";
		}
		temp += ">";
		return temp;
	} 
}