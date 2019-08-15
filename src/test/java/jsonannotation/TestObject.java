package jsonannotation;

import com.google.gson.annotations.Expose;


@JSONSerializable

public class TestObject {
	@Expose
	public int n;
	@Expose
	public String name;

	public TestObject(int n, String name) {
		// TODO Auto-generated constructor stub
		this.n = n;
		this.name = name;
	}

}