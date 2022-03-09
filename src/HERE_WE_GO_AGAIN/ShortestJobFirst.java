package HERE_WE_GO_AGAIN;

/***
 * 
 * @author Mehdi Jahanmard
 * 
 *         SJF (Shortest Job First) El proceso que menos dure es el entrara y se acabara por completo. 
 *         Hay que tener en cuenta que el proceso debe haber llegado.
 *         El tiempo de espera se represnta con [.] y los procesos en ejecucion con un X.
 *
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ShortestJobFirst {

	public static void main(String[] args) {
		Scanner numero = new Scanner(System.in);

		char abc = 65;
		int arrival = 0;
		int tiempo = 0;
		String delay = "";

		System.out.println("Cuantos procesos hay?");
		int procesos = numero.nextInt();
		ArrayList<Tasks> allTasks = new ArrayList<Tasks>();
		ArrayList<Tasks> finalSortedTasks = new ArrayList<Tasks>();
		for (int i = 0; i < procesos; i++) {
			System.out.println("\nInstante de la llegada: " + abc);
			arrival = numero.nextInt();
			System.out.println("Tiempo de ejecucion del proceso: " + abc);
			tiempo = numero.nextInt();

			Tasks instance = new Tasks(abc, arrival, tiempo);
			allTasks.add(instance);
			abc++;
		}

		Tasks a = allTasks.get(0);
		a.setStart(0);

		while (allTasks.size() > 0) {

			System.out.println("a is " + a.getLetterOfProcess());

			for (int i = 0; i < allTasks.size(); i++) {

				Tasks taskCase = allTasks.get(i);
				System.out.println("this is all task: " + taskCase.getLetterOfProcess());

			}

			finalSortedTasks.add(a);
			allTasks.remove(a);
			if (allTasks.size() > 0) {

				ArrayList<Tasks> tempoList = new ArrayList<Tasks>();
				for (int i = 0; i < allTasks.size(); i++) {

					Tasks taskCase = allTasks.get(i);
					if (taskCase.getArrival() <= a.getDuration()) {
						tempoList.add(taskCase);
					}

				}

				int min = Integer.MAX_VALUE;
				int minTaskIndex = 0;
				for (int i = 0; i < tempoList.size(); i++) {
					if (tempoList.get(i).getDuration() < min) {
						min = tempoList.get(i).getDuration();
						minTaskIndex = i;
					}
				}

				if (tempoList.size() != 0) {
					Tasks candidate = tempoList.get(minTaskIndex);
					candidate.setStart(a.getStart() + a.getDuration());
					a = candidate;
				} else {
					Tasks candidate = allTasks.get(0);
					candidate.setStart(a.getStart() + a.getDuration());
					a = candidate;
				}

			}

		}

		ArrayList<Tasks> finalList = new ArrayList<Tasks>();
		
		for (Tasks t : allTasks)
			finalList.add(t);
		
		Tasks taskCase = finalSortedTasks.get(0);
		finalList.add(taskCase);
		for (int j = 1; j < finalSortedTasks.size(); j++) {

			for (int i = 0; i < finalSortedTasks.size(); i++) {

				System.out.println(taskCase.getLetterOfProcess() + ".." + "\n");
				if (finalSortedTasks.get(i).ConvertMyLetterToAsci() == taskCase.ConvertMyLetterToAsci() + 1) {
					taskCase = finalSortedTasks.get(i);
					finalList.add(taskCase);
				}
			}
		}
		System.out.println("\n");
		for (int i = 0; i < finalList.size(); i++) {
			System.out.println(finalList.get(i).getLetterOfProcess() + " an");
		}

		for (int i = 0; i < finalList.size(); i++) {
			Tasks printingElement = finalList.get(i);
			printingElement.setEnd();
			printingElement.setE();

			for (int j = 0; j < printingElement.getStart() - printingElement.getE(); j++) {
				System.out.print("   ");
			}
			for (int j = 0; j < printingElement.getE(); j++) {
				System.out.print("[.]");
			}
			for (int j = printingElement.getArrival(); j < printingElement.getArrival()
					+ printingElement.getDuration(); j++) {
				System.out.print("X |");
			}
			System.out.print("\n");

		}

		System.out.println("0 |1 |2 |3 |4 |5 |6 |7 |8 |9 |10|11|12|13|14|15|16|17|18|19|20");
	}
}
