package patterns.behavioral.command;

import java.util.Hashtable;

public class Calculator {
	
	private Hashtable<String, Operation> ops = new Hashtable<String, Operation>();

	public Calculator() {
		super();
		ops.put("+", new AddOperation());
		ops.put("-", new SubOperation());
		ops.put("*", new MulOperation());
	}
	
	public int doAdd(int num1, int num2){
		return ops.get("+").perform(num1, num2);
	}
	
	public int doSum(int num1, int num2){
		return ops.get("-").perform(num1, num2);
	}

	public int doMul(int num1, int num2) {
		// TODO Auto-generated method stub
		return ops.get("*").perform(num1, num2);
	}
	
}
