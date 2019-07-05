package patterns.behaviorial.state;

public class Package {
	State state = new OrderedState();

	public void setState(State s) {
		this.state = s;
	}
	
	public String toString(){
		return state.toString();
	}

	public void nextState() {
		state.nextState(this);
	}

	public void previousState() {
		state.previousState(this);
	}
	
	
}
