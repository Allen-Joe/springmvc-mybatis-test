package container.stack;

import java.util.Stack;

public class StackDemo {
	
	public static void printStack(Stack stack){
		while(!stack.isEmpty()){
		;System.out.print(stack.pop()+" ");
		}
	}
	
	public static void main(String[] args) {
		Stack<String> stack=new Stack<String>();
		for (String str : "bron to sau rus".split(" ")) {
			stack.push(str);
		}
		printStack(stack);
	}

}
