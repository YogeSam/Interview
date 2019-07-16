package patterns.behavioral.chainofresponsibility;

public class AllLogger extends Logger {


	@Override
	public void print(int loglevel, String message) {
		// TODO Auto-generated method stub
		if(loglevel <= Logger.ALL){
			console.printLine("ALL:" + message);
		}
		
		super.print(loglevel, message);
	}
}
