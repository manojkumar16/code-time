package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FuturesA {

	public static void run() throws Exception {
		ExecutorService executor = new ThreadPoolExecutor(4, 4, 1,
				TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());

		Long t1 = System.currentTimeMillis();
		Future<String> f1 = executor.submit(new CallToRemoteServiceA());
		Future<String> f2 = executor.submit(new CallToRemoteServiceB());

		System.out.println(f1.get() + " - " + f2.get());
		Long t2 = System.currentTimeMillis();
		Long t = t2 - t1;
		System.out.println(t);
	}

	public static void main(String args[]) {
		try {
			run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final class CallToRemoteServiceA implements Callable<String> {
		@Override
		public String call() throws Exception {
			// simulate fetching data from remote service
			Thread.sleep(3000);
			return "responseA";
		}
	}

	private static final class CallToRemoteServiceB implements Callable<String> {
		@Override
		public String call() throws Exception {
			// simulate fetching data from remote service
			Thread.sleep(4000);
			return "responseB";
		}
	}

}
