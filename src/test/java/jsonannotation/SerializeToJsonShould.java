package jsonannotation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import com.interview.example.junitmavenexample.model.print.PrintError;

public class SerializeToJsonShould {

	@Test(expected = JsonSerializationException.class )
	public void throw_SerializeException_when_object_not_annotated() {
		
		class TestObject1{
			int n;
			String name;
		};
		new SerializeToJson().serialize(new TestObject1());
	}
	
	@Test
	public void serialize_object_when_annotated() {
		assert(new SerializeToJson().serialize(new TestObject(1, "Test")).indexOf("Test") >= 0);
	}
	

}
