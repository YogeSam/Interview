package patterns.behaviorial.state;

public class ReceivedState implements State {

	public void nextState(Package p) {
		// TODO Auto-generated method stub

	}

	public void previousState(Package p) {
		// TODO Auto-generated method stub
		p.setState(new DeliveredState());

	}
	
	public String toString(){
		return "Received State";
	}

}
