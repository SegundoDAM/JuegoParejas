

import java.util.Random;
import java.util.Scanner;

public class CoupleParts {
	
	
	
	public static void pausar(int i) {
		try {
			new Thread().sleep(i * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	
	

	
	public static int pedirValor() {
		Scanner leer = new Scanner(System.in);
		int valor = 0;
		do {
			System.out.println("introduce un valor entre 0 y " + (Constantes.size - 1));
			valor = leer.nextInt();
		} while (!comprobarValor(valor));
		return valor;
	}

	public static boolean comprobarValor(int valor) {
		return valor >= 0 && valor < Constantes.size;
	}

	

	

	/**
	 * genera una coordenda valida (dentro de los limites del tablero
	 * 
	 * @param coordenada
	 */
	public static void realizarSorteo(int[] coordenada) {
		for (int i = 0; i < coordenada.length; i++) {
			coordenada[i] = new Random().nextInt(Constantes.size);
		}
	}



	

	

	

}
