package HERE_WE_GO_AGAIN;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Scheduler {
	
	private static Scanner in = new Scanner(System.in);
	protected static LinkedList<Process> processes; 
	protected int processNum;
	protected static int[] times;
	protected static int[] arrivals;
	
	Scheduler () {
		processes = new LinkedList<>();
		processNum = askUser("Introduzca el número de procesos: ");
		times = getProcessData("Introduzca los tiempos de llegada para cada proceso: ", processNum);
		arrivals = getProcessData("Introduzca los tiempos de ejecución para cada proceso: ", processNum);
		for (int i = 0; i < processNum; i++)
			processes.add(new Process(times[i], arrivals[i]));
	}
	
	void setTotalTimes() {
		for (Process p : processes)
			p.setTotalTime( p.getEnd() - p.getArrival() );
	}

	void setWaits() {
		for (Process p : processes)
			p.setWait( p.getTotalTime() - p.getTime() );
	}
	
	void setPenalties() {
		for (Process p : processes)
			p.setPenalty( p.getTotalTime() / p.getTime() );
	}
	
	protected void draw (LinkedList<Process> processes) {
		String drawing = "";
		for (Process p : processes) {
			String nothing = "", wait = "", execution = "";
			for (int i = 0; i < p.getArrival(); i++) 
				nothing += " ";
			for (int i = p.getArrival(); i <= p.getWait(); i++) 
				wait += "-";
			for (int i = p.getStart(); i <= p.getEnd(); i++) 
				execution += "*";
			drawing += nothing + wait + execution + "\n";
		} System.out.println(drawing);
	}
	
	/**
	 * Prints the string, reads int from console and returns it
	 * @param message - the message to print to console
	 * @return an int (as user input)
	 */
	protected static int askUser(String message) {
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
	protected static int[] getProcessData (String message, int size) {
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
	protected static float average (int[] things, int processNum) {
		float avg = 0;
		for (int thing : things) avg += thing;
		return (avg / processNum);
	}

}
