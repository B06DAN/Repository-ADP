package producerConsumer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;

public class Producer extends Thread {
	private final Lock mutex = new ReentrantLock(true);

	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				Main.semFree.acquire();
				mutex.lock();
				if (Main.lista.size() < 5) {
					Main.lista.add(Main.lista.size());
				}
				mutex.unlock();
				Main.semFull.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("A produs, Lista are  " + Main.lista.size());
		}
	}
}
