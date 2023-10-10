package juego03.modelo;

public class Tablero {
	Cell[][] board;
	private int size;

	public Tablero(int size) {
		super();
		crearTablero();
		this.size=size;
	}

	/**
	 * Coloca aleatoriamente las parejas sobre el tablero
	 * 
	 * @return
	 */

	public void crearTablero() {
		// Los archivos no se reconocen bien siestan en el
		// default package por eso creamos el package Juego
		board = new Cell[size][size];
		this.rellenarOrdenado();
		this.intercambiarPosiciones();
	}

	/**
	 * coloca las parejas seguidas en la matriz
	 * 
	 * @param board
	 *            con las partejas ordenadas
	 */
	public void rellenarOrdenado() {
		for (int i = 0, value = 0; i < board.length; i++) {
			for (int j = 0; j < board.length - 1; j += 2, value++) {
				board[i][j] = new Cell(value);
				board[i][j + 1] = new Cell(value);
			}
		}
	}

	/**
	 * Intercambiar las posiciones del tablero para ocultar las parejas
	 * 
	 * @param board
	 */
	public void intercambiarPosiciones() {
		// creamos las coordenadas de origen y destino
		Coordinate origin = new Coordinate(), target = new Coordinate();
		int intercambios = (int) Math.pow(size, 3);
		for (int i = 0; i < intercambios; i++) {
			origin.randomCoordinate(size);
			target.randomCoordinate(size);
			intercambiarPosicion(origin, target);
		}
	}

	/**
	 * Inmtercambia los valores de entre dos posiciones en una matriz
	 * 
	 * @param board
	 * @param origin
	 * @param target
	 */
	public void intercambiarPosicion(Coordinate origin, Coordinate target) {
		int intercambio = getValueAt(origin);
		setValueAt(origin, getValueAt(target));
		setValueAt(target, intercambio);
	}

	public boolean comprobarParejas(Coordinate origen, Coordinate destino) {
		return getValueAt(origen) == getValueAt(destino);
	}

	public void ocultarPosiciones(Coordinate coordinate) {
		getCellAt(coordinate).setVisible(false);
	}

	public boolean comprobarGanador() {
		boolean resultado = true;
		for (int i = 0; i < size && resultado; i++) {
			for (int j = 0; j < size && resultado; j++) {
				if(!getCellAt(new Coordinate(i, j)).isVisible()) {
					return false;
				}
			}
		}
		return resultado;
	}

	public boolean revealPosition(Coordinate origen) {
		boolean retorno = false;
		if (!getCellAt(origen).isVisible()) {
			getCellAt(origen).setVisible(true);
			retorno = true;
		}
		return retorno;
	}

	private Cell getCellAt(Coordinate coordinate) {
		return board[coordinate.getPositionX()][coordinate.getPositionY()];
	}

	private void setValueAt(Coordinate coordinate, int value) {
		board[coordinate.getPositionX()][coordinate.getPositionY()].setValue(value);
	}

	public int getValueAt(Coordinate coordinate) {
		return board[coordinate.getPositionX()][coordinate.getPositionY()].getValue();
	}

	public int length() {
		return board.length;
	}

	public boolean getVisibleAt(Coordinate coordinate) {
		return getCellAt(coordinate).isVisible();
	}

}
