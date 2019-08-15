package patterns.structural.visitor;

public class AssemblyVisitor implements Visitor {

	
	private static final String MONITOR_ASSEMBLED = "Monitor Assembled";
	private static final String KEYBOARD_ASSEMBLED = "Keyboard  Assembled";
	private static final String MOUSE_ASSEMBLED = "Mouse Assembled";

	public String visit(MousePart a) {
		// TODO Auto-generated method stub
		return AssemblyVisitor.MOUSE_ASSEMBLED;

	}
	
	public String visit(KeyboardPart a) {
		// TODO Auto-generated method stub
		return AssemblyVisitor.KEYBOARD_ASSEMBLED;
	}
	
	public String visit(MonitorPart a) {
		// TODO Auto-generated method stub
		return AssemblyVisitor.MONITOR_ASSEMBLED;
	}

	public String visit(Part a) {
		// TODO Auto-generated method stub
		if(a instanceof MousePart){
			return visit((MousePart) a);
		}else if(a instanceof KeyboardPart){
			return visit((KeyboardPart) a);
		}else if(a instanceof MonitorPart){
			return visit((MonitorPart) a);
		}
		
		return "";
	}

	
	

}
