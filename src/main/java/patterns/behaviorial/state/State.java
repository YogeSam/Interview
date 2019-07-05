package patterns.behaviorial.state;

public interface State {
	public void nextState(Package p);
	public void previousState(Package p);
	public String toString();
}
