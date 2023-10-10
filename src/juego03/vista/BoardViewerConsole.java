package juego03.vista;

import java.util.Scanner;

import juego03.modelo.Coordinate;

public class BoardViewerConsole extends BoardViewer {

	public BoardViewerConsole(BoardPresenter boardPresenter) {
		super(boardPresenter);
	}
	
	@Override
	
	public Coordinate getCoordinate(int size) {
		Coordinate coordenada = new Coordinate();
		coordenada.setPositionX(pedirValor(size));
		coordenada.setPositionY(pedirValor(size));
		return coordenada;
	}

	private int pedirValor(int size) {
		Scanner leer = new Scanner(System.in);
		int valor = 0;
		do {
			System.out.println("introduce un valor entre 0 y " + (size - 1));
			valor = leer.nextInt();
		} while (!comprobarValor(valor,size));
		return valor;
	}

	private boolean comprobarValor(int valor,int size) {
		return valor >= 0 && valor < size;
	}

	@Override
	public void showBoard() {System.out.print("   ");
	for (int i = 0; i < boardPresenter.length(); i++) {
		System.out.print("   " + i + " ");
	}
	System.out.println();
	System.out.print("   ");
	System.out.print("â•”");
	for (int i = 0; i < boardPresenter.length(); i++) {
		System.out.print("â•?â•?â•?â•?");
		if (i != boardPresenter.length() - 1)
			System.out.print("â•¦");
	}
	System.out.println("â•—");
	for (int i = 0; i < boardPresenter.length(); i++) {
		System.out.print("  " + i);
		System.out.print("â•‘ ");
		Coordinate coordinate = null;
		for (int j = 0; j < boardPresenter.length(); j++) {
			coordinate = new Coordinate(i, j);
			if (boardPresenter.getValueAt(coordinate) < 10 && boardPresenter.getValueAt(coordinate) > -1)
				System.out.print(" ");
		}
		if (boardPresenter.getValueAt(coordinate) == -1)
			System.out.print("X ");
		else
			System.out.print(boardPresenter.getValueAt(coordinate));
		System.out.print(" â•‘ ");
		System.out.println();
		if (i != boardPresenter.length() - 1) {
			System.out.print("   ");
			System.out.print("â• ");
			for (int j = 0; j < boardPresenter.length(); j++) {
				System.out.print("â•?â•?â•?â•?");
				if (j != boardPresenter.length() - 1)
					System.out.print("â•¬");
			}
			System.out.println("â•£");
		} else {
			System.out.print("   ");
			System.out.print("â•š");
			for (int h = 0; h < boardPresenter.length(); h++) {
				System.out.print("â•?â•?â•?â•?");
				if (h != boardPresenter.length() - 1)
					System.out.print("â•©");
			}
			System.out.println("â•?");
		}
		}

	}

	

}
