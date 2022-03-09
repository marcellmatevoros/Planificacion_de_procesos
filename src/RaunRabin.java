import java.util.Scanner;

public class RaunRabin {
		
	static Scanner in = new Scanner(System.in);

	public static void main(String args[]) {

		int processNum, i, quantum, count = 0, temp, sq = 0; 
		float avgWaitTime = 0, avgTurnAroundTime = 0;
		int[] times = new int[10];
		int[] waitTimes = new int[10];
		int[] turnAroundTimes = new int[10];
		int[] rem_bt = new int[10];

		processNum = askUser("Enter the number of processes: ");
		times = askUser("Enter the burst time of each Process: ", processNum);
		quantum = askUser("Enter the quantum time: ");

		while (true) {
			for (i = 0, count = 0; i < processNum; i++) {
				temp = quantum;
				if (rem_bt[i] == 0) {
					count++;
					continue;
				}
				if (rem_bt[i] > quantum)
					rem_bt[i] = rem_bt[i] - quantum;
				else if (rem_bt[i] >= 0) {
					temp = rem_bt[i];
					rem_bt[i] = 0;
				}
				sq = sq + temp;
				turnAroundTimes[i] = sq;
			}
			if (processNum == count)
				break;
		}
		
		waitTimes = getWaits(turnAroundTimes, times);
		
		System.out.print("--------------------------------------------------------------------------------");
		System.out.print("\nProcess\t  Burst Time\t  Turnaround Time\t  Waiting Time\n");
		System.out.print("--------------------------------------------------------------------------------");

		for (i = 0; i < processNum; i++)
			System.out.print("\n " + (i + 1) + "\t " + 
							 times[i] + "\t\t " + 
							 turnAroundTimes[i] + "\t\t " + 
							 waitTimes[i] + "\n");
		

		// print averages
		System.out.println("Average waiting Time = " + average(waitTimes, processNum));
		System.out.println("Average turnaround time = " + average(turnAroundTimes, processNum));
		System.out.println("Average time: " + average(times, processNum));
	}
	
	/**
	 * Prints the string, reads int from console and returns it
	 * @param message - the message to print to console
	 * @return an int (as user input)
	 */
	static int askUser(String message) {
		System.out.print(message);
		return in.nextInt();
	}
	
	/**
	 * prints the string, reads int from console as many times as specified
	 * @param message - message to print through console
	 * @param size - how many times to read from console
	 * @return user input array of length 'size'
	 */
	static int[] askUser (String message, int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			System.out.print("P" + i +": ");
			arr[i] = in.nextInt();
		} return arr;
		
	}
	
	/**
	 * @param thing  - any int array
	 * @param processNum - the number of processes
	 * @return average - the average of the contents of array
	 */
	static float average (int[] things, int processNum) {
		float avg = 0;
		for (int thing : things) avg += thing;
		return (avg / processNum);
	}
	
	/**
	 *	Calculates the waiting times given the times and turn around times 
	 * @param turnAroundTimes
	 * @param times
	 * @return waits - the waiting times
	 */
	static int[] getWaits(int[] turnAroundTimes, int[] times) {
		int[] waits = new int[times.length];
		for (int i = 0; i < times.length; i++)
			waits[i] = turnAroundTimes[i] - times[i];
		return waits;
	}
	
}
