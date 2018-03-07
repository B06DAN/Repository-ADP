package producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
//import java.util.concurrent.Semaphore;

public class Main {
	public static Queue<Integer> lista = new LinkedList<Integer>();
//	public static Semaphore semFree = new Semaphore(5);
//	public static Semaphore semFull = new Semaphore(0);

	public static void main(String[] args) {

		Producer prod = new Producer();
		Consumer cons = new Consumer();

		prod.start();
		cons.start();

	}

}
