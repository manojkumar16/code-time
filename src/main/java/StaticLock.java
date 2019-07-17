
public class StaticLock {

	public static void main(String[] args) {
		new StaticLock().start();
	}

	private void start() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
			//	System.out.println("starting a");
				a();
			//	System.out.println("finished a");
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
			//	System.out.println("starting b");
				b();
				//System.out.println("finished b");
			}
		}).start();
	}

	public static void a(){
		System.out.println("a");
		sleep();
	}
	


	public static void b(){
		System.out.println("b");
		sleep();
	}
	
	private static void sleep() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
