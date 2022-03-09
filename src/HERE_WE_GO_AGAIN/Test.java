package HERE_WE_GO_AGAIN;

import java.util.Scanner;

public class Test {
	
	private static Scanner in = new Scanner(System.in);
	
	// ask user for what algorithm, return the algorithm
	private static int getAlgorithm() {
		int algorithm;
		do {
			System.out.println("Indique el algoritmo:\n \t1) FIFO\n \t2) Shortest Job First\n \t3) Round Robin");
			System.out.print("> ");
			algorithm = in.nextInt();
		} while (algorithm > 3 || algorithm <= 0);
		return algorithm;
	}
	
	public static void main(String[] args) {

		Scheduler scheduler;

		switch (getAlgorithm()) {
			case 1:
				scheduler = new FIFO();
				break;
			case 2:
				scheduler = new SJF();
				break;
			case 3:
				scheduler = new RR();
				break;
		} 
	}

}
