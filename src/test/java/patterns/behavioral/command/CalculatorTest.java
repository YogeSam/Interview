package patterns.behavioral.command;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void test() {
		Calculator c = new Calculator();
		assert(c.doAdd(1, 1) == 2);
		assert(c.doSum(2, 1) == 1);
		assert(c.doMul(2, 1) == 2);
	}

}
