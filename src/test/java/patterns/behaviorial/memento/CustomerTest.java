package patterns.behaviorial.memento;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void testMementoPattern() {
		Customer c = new Customer("Yogesh", 1);
		assert(c.getId() == 1);
		c.setId(2);
		assert(c.getId() == 2);
		c.undoState();
		assert(c.getId() == 1);
		c.setName("Piya");
		c.setName("Mou");
		c.setName("Shibi");
		assert(c.getName().equals("Shibi") );
		c.undoState();
		assert(c.getName().equals("Mou") );
		c.undoState();
		assert(c.getName().equals("Piya") );
		c.undoState();
		assert(c.getName().equals("Yogesh") );
		c.undoState();
		assert(c.getName().equals("Yogesh") );
		
	}

}
