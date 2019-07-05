package patterns.behavioral.iterator;

public interface Iterator {
	public boolean hasNext();
	public <T> T next();
}
