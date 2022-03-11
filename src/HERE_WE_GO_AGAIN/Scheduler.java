package HERE_WE_GO_AGAIN;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class Scheduler {
	
	private static Scanner in = new Scanner(System.in);
	protected static LinkedList<Process> processes; 
	protected int processNum;
	
	Scheduler () {
		processes = new LinkedList<>();
		processNum = askUser("Introduzca el número de procesos: ");
		int[] times = getProcessData("Introduzca los tiempos de llegada para cada proceso: ", processNum);
		int[] arrivals = getProcessData("Introduzca los tiempos de ejecución para cada proceso: ", processNum);
		for (int i = 0; i < processNum; i++)
			processes.add(new Process((1+i), times[i], arrivals[i]));
	}
	
	public static void main(String[] args) throws Exception {
		Scheduler scheduler;
		switch (getAlgorithm()) {
			case 1:
				scheduler = new FCFS();
				break;
			case 2:
				scheduler = new SJF(); // (esto es hacer el objeto)
				break;
			case 3:
				scheduler = new RR();
				break;
		} 
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
	 * Prints the string, reads from the console n times (n being a parameter)
	 * @param message - String to print through console
	 * @param n - int, how many times to read from console
	 * @return  array - int[n]
	 */
	protected static int[] getProcessData (String message, int n) {
		int[] arr = new int[n];
		System.out.println(message);
		for (int i = 0; i < n; i++) {
			System.out.print("P" + (i+1) +": ");
			arr[i] = in.nextInt();
		} return arr;
	}

	/**
	 * Asks user to choose an algorithm from the console, and returns the user
	 * input if it is in the range [1,3]
	 * @return algorithm  
	 */
	private static int getAlgorithm() {
		int algorithm;
		do {
			System.out.println("Indique el algoritmo:\n \t1) FCFS\n \t2) Shortest Job First\n \t3) Round Robin");
			System.out.print("> ");
			algorithm = in.nextInt();
		} while (algorithm > 3 || algorithm <= 0);
		return algorithm;
	}
	
	/**
	 * Draws each process in the list 
	 * @param processes  
	 */
	protected static void draw(LinkedList<Process> processes) {
		String drawing = "\n";
		for (Process p : processes) {
			String nothing = "", wait = "", execution = "";
			for (int i = 0; i  < p.getArrival(); i++) 
				nothing += "-";
			for (int i = 0; i < p.getWait(); i++) 
				wait += ".";
			for (int i = 0; i < p.getTime(); i++) 
				execution += "x";
			drawing += ("\t" + p.getID() + ":" + nothing + wait + execution + "\n");
		} System.out.println(drawing);
	}

	/**
	 * Sort a LinkedList<Process> into TreeMap<attribute,index>. Only 'time',
	 * 'arrival' and 'ID' attributes of Process Class are implemented
	 * @param Processes - LinkedList<Process>
	 * @param attribute - String
	 * @return map - TreeMap<atribute,index>
	 */
	protected static void sortProcs (LinkedList<Process> processes, String attribute) throws Exception {
		TreeMap<Integer,Integer> attributeIndexMap = new TreeMap<>();
		LinkedList<Process> list = new LinkedList<>();
		for (int i = 0; i < processes.size(); i++) {
			if (attribute.equals("arrival"))
				attributeIndexMap.put(processes.get(i).getArrival(), i);
			else if (attribute.equals("time"))
				attributeIndexMap.put(processes.get(i).getTime(), i);
			else if (attribute.equals("ID"))
				attributeIndexMap.put(processes.get(i).getID(), i );
			else throw new Exception("Only accepts 'arrival', 'ID' or 'time' as String arguments");
		} for (Integer index : attributeIndexMap.values())
			list.add(processes.get(index));
		processes.clear(); 
		for (Process p : list)
			processes.add(p);
	}
	
	/**
	 * returns the sorted list of processes
	 * @param processes - Process List to sort
	 * @param attribute - attribute to sort by
	 * @return list - sorted list
	 * @throws Exception - if the attribute name is not recognized
	 */
	protected static LinkedList<Process> getSortedList(LinkedList<Process> processes, String attribute) throws Exception {
		TreeMap<Integer,Integer> attributeIndexMap = new TreeMap<>();
		LinkedList<Process> list = new LinkedList<>();
		for (int i = 0; i < processes.size(); i++) {
			if (attribute.equals("arrival"))
				attributeIndexMap.put(processes.get(i).getArrival(), i);
			else if (attribute.equals("time"))
				attributeIndexMap.put(processes.get(i).getTime(), i);
			else throw new Exception("Only accepts 'arrival' or 'time' as String arguments");
		} for (Integer index : attributeIndexMap.values())
			list.add(processes.get(index));
		return list;
	}

	/**
	 * Prints the message and the average of the attribute in the list of Processes  
	 * @param procs 
	 * @param attribute - the name of the attribute as String 
	 * @param msg - Message to print to console
	 */
	protected static void printAverage (LinkedList<Process> procs, String attribute, String msg) {
		float avg = 0;
		for (Process p : procs) {
			if (attribute.equals("totalTime"))
				avg += p.getTotalTime();
			else if (attribute.equals("wait"))
				avg += p.getTotalTime();
			else if (attribute.equals("penalty"))
				avg += p.getPenalty();
		} avg /= procs.size();
		System.out.println("\t" + msg + String.format("%.2f", avg));
	}

	//// NEVER USED METHODS: ////
	
	/**
	 * @param list - the list of processes to use
	 * @param value - the value of the ID
	 * @return index - index of the Process in the list containing that ID value
	 */
	protected static int getIndexFromID(LinkedList<Process> list, int value) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getID() == value)
				return i;
		} return 0;
	}

}
