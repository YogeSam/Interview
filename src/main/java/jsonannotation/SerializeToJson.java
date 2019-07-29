package jsonannotation;

import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SerializeToJson {

	public String serialize(Object o){
		checkIfJSONSerializable(o);
		return createJSON(o);
	}

	private String createJSON(Object o) {
		Gson g = new GsonBuilder()
				  .excludeFieldsWithoutExposeAnnotation()
				  .create();
		return g.toJson(o);
	}
	
	private void checkIfJSONSerializable(Object object) {
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
