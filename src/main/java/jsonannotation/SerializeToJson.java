package jsonannotation;


import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import crosscuttingconcern.ChainCrossCuttingConcern;
import validateoutputannotation.ValidateDataOutput;

public class SerializeToJson implements ChainCrossCuttingConcern{

	public String serialize(Object o){
		doConcern(o);
		Gson g = new GsonBuilder()
				  .excludeFieldsWithoutExposeAnnotation()
				  .create();
		return g.toJson(o);
	}
	
	public void doConcern(Object object) {
		new ValidateDataOutput().doConcern(object);
		
	    if (Objects.isNull(object)) {
	        throw new JsonSerializationException("The object to serialize is null");
	    }
	         
	    Class<?> clazz = object.getClass();
	    if (!clazz.isAnnotationPresent(JSONSerializable.class)) {
	        throw new JsonSerializationException("The class "
	          + clazz.getSimpleName() 
	          + " is not annotated with JsonSerializable");
	    }
	}	
}
