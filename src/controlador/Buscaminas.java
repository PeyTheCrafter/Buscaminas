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
		iniciarJuego();
	}

	private void iniciarJuego() {
		crearTablero();
		colocarMinas();
		establecerNumeroMinas();
	}

	private void colocarMinas() {
		for (int i = 0; i < minas; i++) {
			int x = (int) (Math.random() * this.tablero.length);
			int y = (int) (Math.random() * this.tablero.length);
			this.tablero[x][y].setMina(true);
		}
	}

	private void crearTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				this.tablero[i][j] = new Casilla(i, j);
			}
		}
	}

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

	private boolean comprobarRango(int i, int j) {
		return i >= 0 && i < this.tablero.length && j >= 0 && j < this.tablero.length;
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

	/**
	 * Muestra el tablero por consola.
	 * 
	 * @param tablero
	 *            tablero de juego.
	 */
	public void mostrarTablero() {
		for (int i = 0; i < this.tablero.length; i++) {
			for (int j = 0; j < this.tablero.length; j++) {
				if (this.tablero[i][j].isMina()) {
					System.out.print("# ");
				} else {
					System.out.print(this.tablero[i][j].getNumeroMinas() + " ");
				}
			}
			System.out.println();
		}
	}

}
