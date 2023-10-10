
public class Tablero {
	int[][] casillas;

	public Tablero(int size) {
		super();
		casillas = new int[size][size];
	}

	public int getValueAt(Coordenada posicion) {
		return casillas[posicion.getPosicionX()][posicion.getPosicionY()];
	}

	public void setValueAt(Coordenada posicion, int valor) {
		casillas[posicion.getPosicionX()][posicion.getPosicionY()] = valor;
	}

	public boolean comprobarParejas(Coordenada origen, Coordenada destino) {
		return getValueAt(origen) == getValueAt(destino);
	}

	public void mostrarTablero() {
		System.out.print("   ");
		for (int i = 0; i < casillas.length; i++) {
			System.out.print("   " + i + " ");
		}
		System.out.println();
		System.out.print("   ");
		System.out.print("╔");
		for (int i = 0; i < casillas.length; i++) {
			System.out.print("════");
			if (i != casillas.length - 1)
				System.out.print("╦");
		}
		System.out.println("╗");
		for (int i = 0; i < casillas.length; i++) {
			System.out.print("  " + i);
			System.out.print("║ ");
			for (int j = 0; j < casillas[i].length; j++) {
				if (casillas[i][j] < 10 && casillas[i][j] > -1)
					System.out.print(" ");
				if (casillas[i][j] == -1)
					System.out.print("X ");
				else
					System.out.print(casillas[i][j]);
				System.out.print(" ║ ");
			}
			System.out.println();
			if (i != casillas.length - 1) {
				System.out.print("   ");
				System.out.print("╠");
				for (int j = 0; j < casillas.length; j++) {
					System.out.print("════");
					if (j != casillas.length - 1)
						System.out.print("╬");
				}
				System.out.println("╣");
			} else {
				System.out.print("   ");
				System.out.print("╚");
				for (int h = 0; h < casillas.length; h++) {
					System.out.print("════");
					if (h != casillas.length - 1)
						System.out.print("╩");
				}
				System.out.println("╝");
			}
		}
	}

}
