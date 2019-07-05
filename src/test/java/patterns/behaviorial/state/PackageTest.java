package patterns.behaviorial.state;

import static org.junit.Assert.*;

import org.junit.Test;

public class PackageTest {

	@Test
	public void testStateTransition() {
		Package p = new Package();
		assert(p.toString().equals("Ordered State"));
		p.previousState();
		assert(p.toString().equals("Ordered State"));
		p.nextState();
		assert(p.toString().equals("Delivered State"));
		p.previousState();
		assert(p.toString().equals("Ordered State"));
		p.nextState();
		assert(p.toString().equals("Delivered State"));
		p.nextState();
		assert(p.toString().equals("Received State"));
		p.nextState();
		assert(p.toString().equals("Received State"));
		p.previousState();
		assert(p.toString().equals("Delivered State"));
		
	}

}
