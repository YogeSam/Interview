package patterns.behavioral.observer;

import java.util.ArrayList;

public class Observed {
	
	private ArrayList<Observable> listOfObservers = new ArrayList();


	public void callEvent(String event) {
		for(Observable o: listOfObservers){
			o.notified(event);
		}
		
	}

	public void addObserver(Observable observable) {
		// TODO Auto-generated method stub
		listOfObservers .add(observable);		
	}

}
