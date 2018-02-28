package controlador;

import modelo.Casilla;

public class Buscaminas {
	protected Casilla[][] tablero;
	protected int lado;
	protected int minas;

	public Buscaminas(int lado, int minas) {
		super();
		this.lado = lado;
		this.tablero = new Casilla[this.lado][this.lado];
		this.minas = minas;
		crearTablero();
		iniciarJuego();
	}

	/**
	 * Coloca las minas y calcula cuántas minas tiene cada casilla a su alrededor.
	 */
	public void iniciarJuego() {
		colocarMinas();
		establecerNumeroMinas();
	}

	/**
	 * Vela las casillas y elimina todas las minas.
	 */
	public void limpiarTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				this.tablero[i][j].setMina(false);
				this.tablero[i][j].setVelada(true);
			}
		}
	}

	/**
	 * Coloca las minas en posiciones aleatorias del tablero..
	 */
	private void colocarMinas() {
		for (int i = 0; i < minas; i++) {
			int x = (int) (Math.random() * this.tablero.length);
			int y = (int) (Math.random() * this.tablero.length);
			this.tablero[x][y].setMina(true);
		}
	}

	/**
	 * Crea y rellena el tablero de juego con Casillas.
	 */
	private void crearTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				this.tablero[i][j] = new Casilla(i, j);
			}
		}
	}

	/**
	 * Recorre de forma recursiva el tablero, comprobando los alrededores de
	 * aquellas casillas vacías.
	 * 
	 * @param x
	 *            coordenada x de origen.
	 * @param y
	 *            coordenada y de origen.
	 */
	public void recorrer(int x, int y) {
		this.tablero[x][y].setVelada(false);
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (comprobarRango(i, j)) {
					if (this.tablero[i][j].getNumeroMinas() == 0 && this.tablero[i][j].isVelada()) {
						recorrer(i, j);
					} else {
						this.tablero[i][j].setVelada(false);
					}
				}
			}
		}
	}

	/**
	 * Comprueba que una casilla esté dentro del rango del tablero.
	 * 
	 * @param x
	 *            coordenada x.
	 * @param y
	 *            coordenada y.
	 * @return true si está dentro del rango, false si no.
	 */
	private boolean comprobarRango(int x, int y) {
		return x >= 0 && x < this.tablero.length && y >= 0 && y < this.tablero.length;
	}

	/**
	 * Recorre el tablero y establece el número de minas que tiene cada casilla.
	 * 
	 * @param tablero
	 *            tablero de juego.
	 */
	private void establecerNumeroMinas() {
		for (int i = 0; i < this.tablero.length; i++) {
			for (int j = 0; j < this.tablero.length; j++) {
				this.tablero[i][j].setNumeroMinas(contarMinas(i, j));
			}
		}
	}

	/**
	 * Cuenta las minas existentes alrededor de una casilla. Resta una al resultado
	 * en caso de que la casilla a comprobar sea una mina.
	 * 
	 * @param tablero
	 *            tablero de juego.
	 * @param x
	 *            coordenada x de la casilla a comprobar.
	 * @param y
	 *            coordenada y de la casilla a comprobar.
	 * @return el número de minas encontradas alrededor de la casilla.
	 */
	private int contarMinas(int x, int y) {
		int minas = 0;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (comprobarRango(i, j)) {
					if (this.tablero[i][j].isMina()) {
						minas++;
					}
				}
			}
		}
		if (this.tablero[x][y].isMina()) {
			minas -= 1;
		}
		return minas;
	}
}
