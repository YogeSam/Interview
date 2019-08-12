package patterns.behavioral.command;

public class AddOperation implements Operation {

	public int perform(int num1, int num2) {

		return num1 + num2;
	}

}
