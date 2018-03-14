package producerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;


public class Main {
	public static List<Integer> lista = new ArrayList<Integer>();
	public static Semaphore semFree = new Semaphore(5);
	public static Semaphore semFull = new Semaphore(0);
//	public static Object condProd = new Object();
//	public static Object condCons = new Object();
	

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			Producer prod = new Producer();
			prod.start();
		}
		for (int i = 0; i < 5; i++) {
			Consumer cons = new Consumer();
			cons.start();
		}
	}

}
