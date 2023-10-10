
public class TableroOcultas extends Tablero {

	public TableroOcultas(int size) {
		super(size);
		rellenarOcultas();
	}
	public void ocultarPosiciones(Coordenada coordenada) {
		setValueAt(coordenada, -1); 
	}

	/**
	 * Comprueba si todas las casillas estan ocultas
	 * 
	 * @param ocultas
	 * @return
	 */
	public boolean comprobarParejas() {
		boolean resultado = true;
		for (int i = 0; i < casillas.length && resultado; i++) {
			for (int j = 0; j < casillas.length && resultado; j++) {
				int[] coordenada= {i,j};
				//otra forma de escribirlo
				if (getValueAt(new Coordenada(i,j))==-1 )  
					resultado = false;
			}
		}
		return resultado;
	}

	/**
	 * Rellenar de -1 todas las fichas de ocultas
	 * 
	 * @param ocultas
	 */
	public void rellenarOcultas() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				setValueAt(new Coordenada(i,j),-1); 
			}
		}
	}
}
