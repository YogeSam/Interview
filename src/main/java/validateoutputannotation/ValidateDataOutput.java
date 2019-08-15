package validateoutputannotation;

import java.lang.reflect.Field;
import java.util.Objects;

import crosscuttingconcern.ChainCrossCuttingConcern;

public class ValidateDataOutput implements ChainCrossCuttingConcern {

	public void doConcern(Object object) {
		if (Objects.isNull(object)) {
	        throw new ValidateOutputAnnotationNotPresentException("The object to serialize is null");
	    }
	         
	    Class<?> clazz = object.getClass();
	    if (!clazz.isAnnotationPresent(ValidateOutput.class)) {
	    	return;
	    }
	    
	    validateWholeNumberField(object);
		
	}
	
	public void validateWholeNumberField(Object object) {
		try{
		Class<?> clazz = object.getClass();
		 for (Field field : clazz.getDeclaredFields()) {
		        if (field.isAnnotationPresent(ValidateWholeNumber.class)) {
		        	field.setAccessible(true); 
		        	ValidateWholeNumber validate = field.getDeclaredAnnotation(ValidateWholeNumber.class);
		        	String fieldName = field.getName();
		        	String value = (String) field.get(object);
		            int val = Integer.valueOf(value);
		            if(val < validate.min()  || val > validate.max())
		            	throw new ValidateOuputViolationException("Field " + fieldName + " value  is out of range for min: " + validate.min() + " and max: " + validate.max());
		            
		        }
	    }   
		}catch(IllegalAccessException e){
			throw new ValidateOuputViolationException(e.getMessage());
		}catch(Exception e){
			throw new ValidateOuputViolationException(e.getMessage());
		}
	 }	

}
