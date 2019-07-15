package patterns.behavioral.template;

public abstract class Game {

	public Game() {
		super();
	}

	public abstract void end();

	public abstract void start();

	public abstract void init();

	public void play() {
		// TODO Auto-generated method stub
		init();
		start();
		end();
	}

}