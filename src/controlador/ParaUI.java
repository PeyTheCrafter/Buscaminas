package controlador;

import java.awt.Color;

import vista.UI;

public class ParaUI extends UI {
	protected int lado = 10;
	protected int minas = 10;
	Buscaminas game = new Buscaminas(this.lado, this.minas);
	MyActionListenerBotonera listenerBotonera = new MyActionListenerBotonera(this, game);

	public ParaUI() {
		super();
		actualizarVentana();
		añadirListener();
	}

	public void añadirListener() {
		for (int i = 0; i < this.botonera.botones.length; i++) {
			for (int j = 0; j < this.botonera.botones.length; j++) {
				this.botonera.botones[i][j].addActionListener(listenerBotonera);
			}
		}
	}

	/**
	 * Actualiza la información de la ventana en función del tipo de casilla que es
	 * y del número de minas que hay a su alrededor.
	 */
	protected void actualizarVentana() {
		for (int i = 0; i < this.game.tablero.length; i++) {
			for (int j = 0; j < this.game.tablero.length; j++) {
				// Para las casillas desveladas.
				if (!this.game.tablero[i][j].isVelada()) {
					// Desactivar los botones con 0 minas a su alrededor.
					if (this.game.tablero[i][j].getNumeroMinas() == 0) {
						this.botonera.botones[i][j].setEnabled(false);
					}
					// Si no es una mina y tiene como mínimo una mina a su alrededor.
					if (!this.game.tablero[i][j].isMina() && this.game.tablero[i][j].getNumeroMinas() > 0) {
						this.botonera.botones[i][j].setText(String.valueOf(this.game.tablero[i][j].getNumeroMinas()));
					}
				}
				if (this.game.tablero[i][j].isMina()) {
					this.botonera.botones[i][j].setBackground(Color.RED);
				}
			}
		}
		this.game.mostrarTablero();
	}

}
