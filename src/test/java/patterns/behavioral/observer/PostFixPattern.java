package patterns.behavioral.observer;

import java.util.Stack;

import patterns.behavioral.intepreter.InterpretPattern;

public class PostFixPattern implements InterpretPattern {
	private static final char SUBOP = '-';
	private static final char MULOP = '*';
	private static final char ADDOP = '+';
	Stack<String> stack = new Stack();
	
	public String convert(String expression) {
		String postFixExpression = "";
		for(int i=0; i<expression.length(); i++){
			char c = expression.charAt(i);
			if(isOperator(c)){
				pushOperatorOnStack(c);
			}else{
				postFixExpression += c;
			}
		}
		postFixExpression += popOperatorsToEnd();
		return postFixExpression;
	}

	private void pushOperatorOnStack(char c) {
		stack.push(String.valueOf(c));
	}

	private String popOperatorsToEnd() {
		String postFixOperators = "";
		while(isStackEmpty()){
			postFixOperators += stack.pop();
		}
		return postFixOperators;
	}

	private boolean isStackEmpty() {
		return stack.size() > 0;
	}

	private boolean isOperator(char c) {
		return c == PostFixPattern.ADDOP || c == PostFixPattern.MULOP || c == PostFixPattern.SUBOP;
	}

}
