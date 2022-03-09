package refactor;
import java.io.IOException;
import java.util.Scanner;

public class Planner {
	
	static Scanner in = new Scanner(System.in);
	protected int processNum;		// ok
	protected int[] arrivals; 		// ok 
	protected int[] times;			// ok
	protected int[] starts;			// 
	protected int[] ends;			//
	protected int[] totalTimes; 	// ok
	protected int[] waits; 			// ok
	protected double[] penalties;	// ok
	
	Planner() {
		processNum = askUser("Introduzca el número de procesos: ");
		arrivals = new int[processNum];
		times = new int[processNum];
		starts = new int[processNum];
		ends = new int[processNum];
		totalTimes = new int[processNum];
		waits = new int[processNum];
		penalties = new double[processNum];
		// do this automatically
		arrivals = getProcessData("Introduzca los tiempos de llegada para cada proceso: ", processNum);
		times = getProcessData("Introduzca los tiempos de ejecución para cada proceso: ", processNum);
	}
	
	Planner(int processNum) {
		this.processNum = processNum;
		arrivals = new int[processNum];
		times = new int[processNum];
		starts = new int[processNum];
		ends = new int[processNum];
		totalTimes = new int[processNum];
		waits = new int[processNum];
		penalties = new double[processNum];
		// do this automatically
		arrivals = getProcessData("Introduzca los tiempos de llegada para cada proceso: ", processNum);
		times = getProcessData("Introduzca los tiempos de ejecución para cada proceso: ", processNum);
	}
	
	int[] getArrivals() {
		return arrivals;
	}
	
	int[] getTimes() {
		return times;
	}
	
	int[] getStarts() {
		return starts;
	}
	
	int[] getEnds() {
		return ends;
	}
	
	void setTotalTimes() {
		for (int i = 0; i < processNum; i++)
			totalTimes[i] = ends[i] - arrivals[i]; // also works times + waits
	}
	
	int[] getTotalTimes() {
		return totalTimes;
	}

	void setWaits() {
		for (int i = 0; i < times.length; i++)
			waits[i] = totalTimes[i] - times[i];
	}
	
	int[] getWaits() {
		return waits;
	}
	
	void setPenalties() {
		for (int i = 0; i < processNum; i++)
			penalties[i] = totalTimes[i] / times[i];
	}
	
	double[] getPenalties() {
		return penalties;
	}
	
	/**
	 * Prints the string, reads int from console and returns it
	 * @param message - the message to print to console
	 * @return an int (as user input)
	 */
	public static int askUser(String message) {
		System.out.print(message);
		return in.nextInt();
	}
	
	/**
	 * prints the string, reads int from console as many times as the number of 
	 * processes
	 * displays a prompt with the number of the process it is requesting data from
	 * @param message - message to print through console
	 * @param size - how many times to read from console
	 * @return user input array of length 'size'
	 * @throws IOException 
	 */
	public static int[] getProcessData (String message, int size) {
		int[] arr = new int[size];
		System.out.println(message);
		for (int i = 0; i < size; i++) {
			System.out.print("P" + (i+1) +": ");
			arr[i] = in.nextInt();
		} return arr;
	}
	
	/**
	 * @param thing  - any int array
	 * @param processNum - the number of processes
	 * @return average - the average of the contents of array
	 */
	public static float average (int[] things, int processNum) {
		float avg = 0;
		for (int thing : things) avg += thing;
		return (avg / processNum);
	}

}
