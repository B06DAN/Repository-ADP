package producerConsumer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;

public class Consumer extends Thread {
	private final Lock mutex = new ReentrantLock(true);

	public void run() {
		while (true) {
			try {
				Main.semFull.acquire();
				mutex.lock();
				if (!Main.lista.isEmpty()) {
					Main.lista.remove(0);
				}
				mutex.unlock();
				Main.semFree.release();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			System.out.println("A scos, Lista are " + Main.lista.size());
			try {
				Thread.sleep(3500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			

		}
	}
}
