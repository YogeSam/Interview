package patterns.behavioral.iterator;

import static org.junit.Assert.*;

import org.junit.Test;

public class NameRepositoryTest {

	@Test
	public void testGetIterator() {
		String names[] = {"Yogesh","Nilesh"}; 
		NameRepository n = new NameRepository(names);
		Iterator it = n.getIterator();
		String nameString = "Names: ";
		while(it.hasNext()){
			nameString += " " + it.next();
		}
		assert(nameString.indexOf("Yogesh") >= 0);
		assert(nameString.indexOf("Nilesh") >= 0);
		
	}

}
