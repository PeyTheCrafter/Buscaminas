package test;

import modelo.Casilla;

public class Recursividad {
	public static void main(String[] args) {
		Casilla[][] tablero = new Casilla[10][10];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = new Casilla(i, j);
				tablero[i][j].setMina(false);
			}
		}
		tablero[5][5].setMina(true);
		tablero[5][6].setMina(true);
		Recursividad instancia = new Recursividad();
		instancia.establecerNumeroMinas(tablero);
		instancia.mostrarTablero(tablero);
	}

	// private void recorrer(Casilla[][] tablero) {
	// for (int i = 0; i < tablero.length; i++) {
	// for (int j = 0; j < tablero.length; j++) {
	// if (i >= 0 && i < tablero.length && j >= 0 && j < tablero.length) {
	// if (tablero[i][j].getNumeroMinas())
	// }
	// }
	// }
	// }

	/**
	 * Recorre el tablero y establece el número de minas que tiene cada casilla.
	 * 
	 * @param tablero
	 *            tablero de juego.
	 */
	private void establecerNumeroMinas(Casilla[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j].setNumeroMinas(contarMinas(tablero, i, j));
			}
		}
	}

	/**
	 * Cuenta las minas existentes alrededor de una casilla.
	 * 
	 * @param tablero
	 *            tablero de juego.
	 * @param x
	 *            coordenada x de la casilla.
	 * @param y
	 *            coordenada y de la casilla.
	 * @return el número de minas encontradas alrededor de la casilla.
	 */
	private int contarMinas(Casilla[][] tablero, int x, int y) {
		int minas = 0;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i >= 0 && i < tablero.length && j >= 0 && j < tablero.length) {
					if (tablero[i][j].isMina()) {
						minas++;
					}
				}
			}
		}
		if (tablero[x][y].isMina()) {
			minas -= 1;
		}
		return minas;
	}

	/**
	 * Muestra el tablero por consola.
	 * 
	 * @param tablero
	 *            tablero de juego.
	 */
	private void mostrarTablero(Casilla[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (tablero[i][j].isMina()) {
					System.out.print("# ");
				} else {
					System.out.print(tablero[i][j].getNumeroMinas() + " ");
				}
			}
			System.out.println();
		}
	}
}
