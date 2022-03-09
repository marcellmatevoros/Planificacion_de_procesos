package refactor;

import java.io.IOException;
import java.util.Scanner;

public class PlannerTest {
	
	static Scanner in = new Scanner(System.in);
	
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
		
		int algorithm = getAlgorithm();
		Planner planner;

		switch (algorithm) {
		case 1:
			// Your code here
			planner = new FIFO();
			break;
		case 2:
			// Your code here
			planner = new SJF();
			break;
		case 3:
			// Your code here
			planner = new RR();
			break;
		} 

		in.close();
		System.out.println("FIN!");
	}

}
