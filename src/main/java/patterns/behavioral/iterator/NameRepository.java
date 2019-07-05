package patterns.behavioral.iterator;

public class NameRepository {
	private String[] names = null;

	public NameRepository(String[] names) {
		super();
		this.names = names;
	}
	
	public String[] getNames(){
		return names;
	}
	
	public Iterator getIterator(){
		return new NameIterator(this);
	}
	
}
