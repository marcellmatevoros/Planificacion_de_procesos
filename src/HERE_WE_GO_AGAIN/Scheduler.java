package HERE_WE_GO_AGAIN;

import java.io.IOException;
import java.text.Collator;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

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
	
	static void setTotalTimes() {
		for (Process p : processes)
			p.setTotalTime( p.getEnd() - p.getArrival() );
	}

	static void setWaits() {
		for (Process p : processes)
			p.setWait( p.getTotalTime() - p.getTime() );
	}
	
	protected static void setPenalties() {
		for (Process p : processes)
			p.setPenalty( p.getTotalTime() / p.getTime() );
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
	 * prints the string, reads from the console n times (n being a parameter)
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
	 * @param thing  - any int array
	 * @param processNum - the number of processes
	 * @return average - the average of the contents of array
	 */
	protected static float average (int[] things, int processNum) {
		float avg = 0;
		for (int thing : things) avg += thing;
		return (avg / processNum);
	}

	protected static void draw (LinkedList<Process> processes) {
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
	 * Sort a LinkedList<Process> into TreeMap<attribute,index>. Only 'time' and
	 * 'arrival' attributes of Process Class are implemented
	 * @param Processes - LinkedList<Process>
	 * @param attribute - String
	 * @return map - TreeMap<atribute,index>
	 */
	static void sortProcs(LinkedList<Process> processes, String attribute) throws Exception {
		TreeMap<Integer,Integer> attributeIndexMap = new TreeMap<>();
		LinkedList<Process> list = new LinkedList<>();
		for (int i = 0; i < processes.size(); i++) {
			if (attribute.equals("arrival"))
				attributeIndexMap.put(processes.get(i).getArrival(), i);
			else if (attribute.equals("time"))
				attributeIndexMap.put(processes.get(i).getTime(), i);
			else throw new Exception("Only accepts 'arrival' or 'time' as String arguments");
		} 
		for (Integer index : attributeIndexMap.values())
			list.add(processes.get(index));
		processes.clear(); 
		for (Process p : list)
			processes.add(p);
	}
	
	static  TreeMap<Integer,Integer> getTreeMap( LinkedList<Process> processes, String attribute) {
		TreeMap<Integer,Integer> map = new TreeMap<>();
		for (int i = 0; i < processes.size(); i++) {
			if (attribute.equals("arrival"))
				map.put(processes.get(i).getArrival(), i);
			else if (attribute.equals("time"))
				map.put(processes.get(i).getTime(), i);
		} return map;
	}

}
