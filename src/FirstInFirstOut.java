
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/***
 * 
 * @author Marcell Voros
 * 
 *         FIFO (First In First Out) El primero en llegar es el primero en ser
 *         atendido Mientras el primero no se termina, no empieza el proximo
 *         proceso.
 *
 */

public class FirstInFirstOut {

	public static void main(String[] args) {
		Scanner numero = new Scanner(System.in);
		ArrayList<Integer> lasLLegadas = new ArrayList<Integer>();
		ArrayList<Integer> tiempoDeEjecucion = new ArrayList<Integer>();
		char abc = 65;
		int valor = 0;
		int tiempo = 0;
		String delay = "";

		System.out.println("Cuantos procesos hay?");
		int procesos = numero.nextInt();
		for (int i = 0; i < procesos; i++) {
			System.out.println("\nInstante de la llegada: " + abc);
			valor = numero.nextInt();
			System.out.println("Tiempo de ejecucion del proceso: " + abc);
			tiempo = numero.nextInt();
			abc++;
			lasLLegadas.add(valor);
			tiempoDeEjecucion.add(tiempo);
		}
		System.out.println("\n   0 |1 |2 |3 |4 |5 |6 |7 |8 |9 |10|11|12|13|14|15|16|17|18|19|20");
		abc = 65;
		System.out.print(abc + ": ");
		for (int i = 0; i < procesos; i++) {
			for (int j = 0; j < tiempoDeEjecucion.get(i); j++) {
				System.out.print("X |");
				delay += ". |";
			}
			if (i < procesos - 1) {
				System.out.print("\n" + ++abc + ": ");
				System.out.print(delay);
			}

		}
	}
}
