package patterns.behavioral.intepreter;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import patterns.behavioral.intepreter.PostFixPattern;

public class PostFixPatternShould {

	@Test
	public void test() {
		InterpretPattern postFix = new PostFixPattern();
		assertThat(postFix.convert("2+3"), equalTo("23+"));
		
		assertThat(postFix.convert("2+3*6"), equalTo("236*+"));
		
		assertThat(postFix.convert("2+3*6-4"), equalTo("2364-*+"));
		
	}

}
