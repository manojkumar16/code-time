import java.lang.ref.WeakReference;

public class ReferenceTest {
	public static void main(String[] args) throws InterruptedException {

		WeakReference<String> r = new WeakReference<>(new String("I'm here"));
		WeakReference<String> sr = new WeakReference<>("I'm here");
		System.out.println("before gc: r=" + r.get() + ", static=" + sr.get());
		System.gc();
		Thread.sleep(100);

		// only r.get() becomes null
		System.out.println("after gc: r=" + r.get() + ", static=" + sr.get());

	}
}
