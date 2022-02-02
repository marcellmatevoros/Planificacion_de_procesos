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
		int algorithm;
		do {
			System.out.print("Indique el algoritmo: 1) FIFO, 2) Shortest Job First, 3) Round Robin.");
			algorithm = in.nextInt();
		} while (algorithm > 3 || algorithm < 0);
		return algorithm;
	}

	// ask user for arrival time and return it
	static int getArrival() {
		System.out.print("Introduzca llegada del proceso: ");
		int arrival = in.nextInt();
		return arrival;
	}

	// ask user for time of process and return it
	static int getTime() {
		System.out.print("Introduzca tiempo del proceso: ");
		int t = in.nextInt();
		return t;
	}

	public static void main(String[] args) {

		while (in.hasNext()) {

			int algorithm = getAlgorithm();
			int processNum = getProcessNum();
			ArrayList<Process> procs = new ArrayList<>(); // processes array

			while (processNum > 0) {

				switch (algorithm) {
				case 1:
					procs.add(new FIFO(getArrival(), getTime()));
					break;
				case 2:
					procs.add(new ShortestJobFirst(getArrival(), getTime()));
					break;
				case 3:
					procs.add(new RoundRobin(getArrival(), getTime()));
					break;
				}

				/* PLEASE READ THIS
				 * 
				 * now we would have to do:
				 * procs.get(procs.size()-1).setWait, setTotalTime() ... etc
				 * 
				 * basically, every iteration of this while loop, we calculate the newest process' attributes 
				 * based on the attributes from the other processes
				 * 
				 * We can do this by creating arrays like: times[], totalTimes[] ... etc and passing them to
				 * the setters (setter methods) ... that is why we are doing all the calculations through the setters, 
				 * and each one of you is coding the setters of your algorithm
				 * 
				 */

				processNum--;
			}

		} in.close();

	}

}
