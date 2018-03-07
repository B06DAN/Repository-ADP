package producerConsumer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//import java.util.concurrent.Semaphore;

public class Producer extends Thread {
	private final Lock mutex = new ReentrantLock(true);
	

	public void run() {

		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			mutex.lock();
			if (Main.lista.size() < 5) {
				Main.lista.add(Main.lista.size());
			}
			mutex.unlock();
			System.out.println("A produs " + Main.lista.size());
		}
	}
}
