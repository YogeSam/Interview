package patterns.behavioral.chainofresponsibility;

public class ErrorLogger extends Logger {

	public ErrorLogger(Logger logger) {
		// TODO Auto-generated constructor stub
		this.logger = logger;
	}

	@Override
	public void print(int loglevel, String message) {
		// TODO Auto-generated method stub
		if(loglevel <= Logger.ERROR){
			console.printLine("ERROR:" + message);
		}
		
		super.print(loglevel, message);
	}

}
