
public class Game {
	private TableroJuego tablero = new TableroJuego(Constantes.size);
	private TableroOcultas ocultas = new TableroOcultas(Constantes.size);

	public void play() {
		boolean ganador = false;
		do {
			ocultas.mostrarTablero();
			if (this.realizarJugada())
				ganador = ocultas.comprobarParejas();
		} while (!ganador);
	}

	public Coordenada pedirCoordenada() {
		return new Coordenada(CoupleParts.pedirValor(), CoupleParts.pedirValor());
	}

	/**
	 * controla la jugada actual
	 * 
	 * @param tablero
	 * @param ocultas
	 * @return
	 */
	public boolean realizarJugada() {
		Coordenada origen;
		do {
			origen = pedirCoordenada();
		} while (!revelarPosicion(origen));
		ocultas.mostrarTablero();
		Coordenada destino;
		do {
			destino = pedirCoordenada();
		} while (!revelarPosicion(destino));
		ocultas.mostrarTablero();
		boolean comprobacion = tablero.comprobarParejas(origen, destino);
		CoupleParts.pausar(1);
		if (!comprobacion) {
			// TODO juntar las dos llamadas en un solo metodo
			ocultas.ocultarPosiciones(origen);
			ocultas.ocultarPosiciones(destino);
		}
		ocultas.mostrarTablero();
		return comprobacion;
	}

	public boolean revelarPosicion(Coordenada origen) {
		boolean retorno = false;
		if (ocultas.getValueAt(origen) == -1) {
			ocultas.setValueAt(origen, tablero.getValueAt(origen));
			retorno = true;
			//HOla
		}
		return retorno;
	}

	public static void main(String[] args) {
		new Game().play();
	}
}
