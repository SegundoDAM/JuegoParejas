package juego03.control;

import juego03.modelo.Coordinate;
import juego03.modelo.Tablero;
import juego03.vista.BoardPresenter;
import juego03.vista.BoardViewer;
import juego03.vista.BoardViewerConsole;

public class Game {
	public final int size=4;
	private Tablero tablero = new Tablero(size);
	private BoardViewer boardview = new BoardViewerConsole(new BoardPresenter(tablero));
	private boolean ganador = false;

	public void play() {
		do {
			boardview.showBoard();
			if (realizarJugada())
				ganador = tablero.comprobarGanador();
		} while (!ganador);
	}

	/**
	 * controla la jugada actual
	 * 
	 * @param tablero
	 * @param ocultas
	 * @return
	 */
	public boolean realizarJugada() {
		Coordinate origen,destino;
		origen=revelaCoordinate();
		boardview.showBoard();		
		destino=revelaCoordinate();
		boardview.showBoard();
		boolean comprobacion = tablero.comprobarParejas(origen, destino);
		this.pausar(1);
		if (!comprobacion) {
			tablero.ocultarPosiciones(origen);
			tablero.ocultarPosiciones(destino);
		}
		boardview.showBoard();
		return comprobacion;
	}
	private void pausar(int i) {
		try {
			new Thread().sleep(i * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private Coordinate revelaCoordinate() {
		Coordinate coordinate;
		do {
			coordinate = boardview.getCoordinate(size);
		} while (!tablero.revealPosition(coordinate));
		return coordinate;
	}

//	boolean comprobacion = comprobarParejas(origen, destino);

//	pausar(1);
//		if (!comprobacion) {
//			ocultarPosiciones(ocultas, origen);
//			ocultarPosiciones(ocultas, destino);
//		}
//		CoupleParts.mostrarTablero(ocultas);
//		return comprobacion;
//	}

}
