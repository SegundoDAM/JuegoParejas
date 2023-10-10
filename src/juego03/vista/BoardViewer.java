package juego03.vista;

import juego03.modelo.Coordinate;

public abstract class BoardViewer {
	protected BoardPresenter boardPresenter;
	
	public BoardViewer(BoardPresenter boardPresenter) {
		super();
		this.boardPresenter = boardPresenter;
	}
	public abstract void showBoard();
	public abstract Coordinate getCoordinate(int size);
}
