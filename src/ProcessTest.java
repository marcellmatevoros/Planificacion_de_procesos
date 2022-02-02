import java.util.ArrayList;
import java.util.Scanner;

public class ProcessTest {
		
	static Scanner in = new Scanner(System.in);

	// ask user for how many processes, return the number of processes
	static int getProcessNum() {
		System.out.print("Introduzca el número de procesor que quiere introducir: ");
		int processNum = in.nextInt();
		return processNum;
	}
	
	// ask user for what algorithm, return the algorithm
	static int getAlgorithm() {
		System.out.print("Indique el algoritmo: 1) FIFO, 2) Shortest Job First, 3) Round Robin.");
		int algorithm = in.nextInt();
		return algorithm;
	}
	
	public static void main(String[] args) {
		int processNum = getAlgorithm();
		switch( processNum ) {
		case 1:
			ArrayList<FIFO> processes = new ArrayList<>(); // our processes array
			break;
		case 2: 
			ArrayList<ShortestJobFirst> processes = new ArrayList<>(); // our processes array
			break;
		case 3:
			ArrayList<RoundRobin> processes = new ArrayList<>(); // our processes array
			break;
		default:
			System.out.println();
			break;
		}

		while (processNum > 0) {

			
			processNum--;
		}
	}

}
