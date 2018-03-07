package producerConsumer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//import java.util.concurrent.Semaphore;

public class Consumer extends Thread {
	private final Lock mutex = new ReentrantLock(true);

	public void run() {

		while (true) {
			mutex.lock();
			if (!Main.lista.isEmpty()) {
				Main.lista.remove();
			}
			mutex.unlock();
			System.out.println("A scos " + Main.lista.size());
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
