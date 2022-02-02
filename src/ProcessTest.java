import java.util.ArrayList;
import java.util.Scanner;

public class ProcessTest {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// ask for how many processes
		System.out.print("Introduzca el número de procesor que quiere introducir: ");
		int processNum = in.nextInt();
		System.out.print("\nIndique el algoritmo a utilizar: 1) FIFO, 2) Shortest Job First, 3) Round Robin.");
		int algorithm = in.nextInt();
		ArrayList<Process> processes = new ArrayList<>(); // our processes array
		switch(algorithm) {
		case 1:
			
		}

		while (processNum > 0) {

			
			processNum--;
		}

	}

}
