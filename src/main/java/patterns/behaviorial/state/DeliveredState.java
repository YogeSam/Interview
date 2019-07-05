package patterns.behaviorial.state;

public class DeliveredState implements State {

	public void nextState(Package p) {
		// TODO Auto-generated method stub
		p.setState(new ReceivedState());

	}

	public void previousState(Package p) {
		// TODO Auto-generated method stub
		p.setState(new OrderedState());

	}
	
	public String toString(){
		return "Delivered State";
	}

}
