package etc2;

public class ABMain {

	public static void main(String[] args) {
		A a1 = new A(2);
		A a2 = new B(2);
		a1.f1();
		a2.f1();
		((B) a2).f2();
		
		System.out.println(Double.MIN_VALUE);
		/*		ClassA a1 = new ClassA();
		ClassA a2 = new ClassB();
		ClassB b1 = new ClassB();
		
		a2.methodFour(4); //A
		a2.methodTwo(2); //B
		b1.methodTwo(22); //B
		b1.methodFour(44); //B
*/
	}

}
