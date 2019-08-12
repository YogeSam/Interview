package validateoutputannotation;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidateOutputShould {

	@Test(expected = ValidateOutputAnnotationNotPresentException.class)
	public void throw_exception_if_validateoutput_not_present() {
		class TestObject{
			
		}
		new ValidateDataOutput().validate(new TestObject());
	}
	
	@Test(expected = ValidateOuputViolationException.class)
	public void throw_exception_if_field_not_a_WHOLENUMBER(){
		
		@ValidateOutput
		class TestObject {
			@ValidateWholeNumber
			String number = "-1";
		}
		new ValidateDataOutput().validate(new TestObject());
	}

	@Test(expected = ValidateOuputViolationException.class)
	public void throw_exception_if_field_WHOLENUMBER_outofrange(){
		
		@ValidateOutput
		class TestObject {
			@ValidateWholeNumber(min=1, max=10)
			String number = "12";
		}
		new ValidateDataOutput().validate(new TestObject());
	}

	
	@Test
	public void allow_a_field_with_WHOLENUMBER(){
		@ValidateOutput
		class TestObject {
			@ValidateWholeNumber
			String number = "1";
		}
		new ValidateDataOutput().validate(new TestObject());
	}	
	
	
}
