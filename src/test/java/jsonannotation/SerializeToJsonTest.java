package jsonannotation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import com.interview.example.junitmavenexample.model.print.PrintError;



public class SerializeToJsonTest {

	@Test(expected = JsonSerializationException.class)
	public void testSerializeExceptionWithoutAnnotation() {
		class TestObject1{
			int n;
			String name;
		};
		new SerializeToJson().serialize(new TestObject1());
	}
	
	@Test
	public void testSerialize() {
		assert(new SerializeToJson().serialize(new TestObject(1, "Test")).indexOf("Test") >= 0);
	}
	

}
