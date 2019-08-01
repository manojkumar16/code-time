package etc.two;

public class A {
	public A() {
		System.out.println("A const");
	}

	public A(int i) {
		System.out.println("A const:"+i);
	}

	void f1() {
		System.out.println("in A");
	}
}
