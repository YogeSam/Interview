package patterns.behaviorial.state;

public class OrderedState implements State {

	public void nextState(Package p) {
		// TODO Auto-generated method stub
		p.setState(new DeliveredState());

	}

	public void previousState(Package p) {
		// TODO Auto-generated method stub

	}
	
	public String toString(){
		return "Ordered State";
	}

}
