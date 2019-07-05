package patterns.behaviorial.memento;

import java.util.ArrayList;
import java.util.List;

public class Keeper implements Memento {

	List<Object> list = new ArrayList<Object>();
	
	public void setState(Object o) {
		// TODO Auto-generated method stub
		list.add(o);

	}

	public Object getState() {
		// TODO Auto-generated method stub
		Object o = null;
		int size = list.size(); 
		if(size > 0){
			o = list.get(size-1);
			list.remove(size-1);
		}
		return o;
	}

}
