package juego03.modelo;

import java.util.Random;

public class Coordinate {
	private int positionX, positionY;

	public Coordinate(int positionX, int positionY) {
		this();
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public Coordinate() {
		super();
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + positionX;
		result = prime * result + positionY;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (positionX != other.positionX)
			return false;
		if (positionY != other.positionY)
			return false;
		return true;
	}
	
	public void randomCoordinate(int size) {
			int random = this.getRandom(size);
			this.setPositionX(random);
			this.setPositionY(random);
	}
	private  int getRandom(int size) {
		return new Random().nextInt(size);
	}
	
}
