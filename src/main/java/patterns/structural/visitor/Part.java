package patterns.structural.visitor;

public abstract class Part {
	public String accept(Visitor v){
		return v.visit(this);
	}
}
