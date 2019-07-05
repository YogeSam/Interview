package patterns.behavioral.iterator;

public class NameIterator implements Iterator {

	private int index = 0;
	private NameRepository n;
	
	public NameIterator(NameRepository n) {
		super();
		this.n = n;
		index = 0;
		
	}

	public boolean hasNext() {
		return (index < n.getNames().length);
	}

	public String next() {
		String names[] = n.getNames();
		return names[index++];
	}

}
