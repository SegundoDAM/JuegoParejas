
public class TableroJuego extends Tablero{

	public TableroJuego(int size) {
		super(size);
		crearTablero();
	}
	/**
	 * Coloca aleatoriamente las parejas sobre el tablero
	 * 
	 * @return
	 */
	public void crearTablero() {
		this.rellenarOrdenado();
		this.intercambiarPosiciones();
	}
	/**
	 * coloca las parejas seguidas en la matriz
	 * 
	 * @param tablero
	 *            con las partejas ordenadas
	 */
	public void rellenarOrdenado() {
		for (int i = 0, valor = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length - 1; j += 2, valor++) {
				casillas[i][j] = valor;
				casillas[i][j + 1] = valor;
			}
		}
	}
	/**
	 * Intercambiar las posiciones del tablero para ocultar las parejas
	 * 
	 * @param tablero
	 */
	public  void intercambiarPosiciones() {
		// creamos las coordenadas de origen y destino
		int[] origen = new int[2], destino = new int[2];
		int intercambios = (int) Math.pow(Constantes.size, 3);
		for (int i = 0; i < intercambios; i++) {
			CoupleParts.realizarSorteo(origen);
			CoupleParts.realizarSorteo(destino);
			this.intercambiarPosicion(origen, destino);
		}
	}
	/**
	 * Intercambia los valores de entre dos posiciones en una matriz
	 * 
	 * @param tablero
	 * @param origen
	 * @param destino
	 */
	public void intercambiarPosicion(int[] origen, int[] destino) {
		int intercambio = casillas[origen[0]][origen[1]];
		casillas[origen[0]][origen[1]] = casillas[destino[0]][destino[1]];
		casillas[destino[0]][destino[1]] = intercambio;
	}
}
