package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.UI;

public class ParaUI extends UI {
	protected int lado = 14;
	protected int minas = 25;
	Buscaminas game = new Buscaminas(this.lado, this.minas);
	MyActionListenerBotonera listenerBotonera = new MyActionListenerBotonera(this, game);
	MyActionListenerNuevoJuego listenerNuevoJuego = new MyActionListenerNuevoJuego(this, game);
	public ParaUI() {
		super();
		this.lado = 10;
		actualizarVentana();
		añadirListenerBotonera();
		mntmNuevoJuego.addActionListener(listenerNuevoJuego);
	}

	/**
	 * Añade el listener a la botonera
	 */
	protected void añadirListenerBotonera() {
		for (int i = 0; i < this.botonera.botones.length; i++) {
			for (int j = 0; j < this.botonera.botones.length; j++) {
				this.botonera.botones[i][j].addActionListener(listenerBotonera);
			}
		}
	}

	/**
	 * Actualiza la información de la ventana en función del tipo de casilla que es
	 * y del número de minas que hay a su alrededor:<br>
	 * -Para casillas con 0 minas a su alrededor desactiva el botón.<br>
	 * -Para casillas con más de 0 minas a su alrededor, muestra el número de minas
	 * que tiene.
	 */
	protected void actualizarVentana() {
		for (int i = 0; i < this.game.tablero.length; i++) {
			for (int j = 0; j < this.game.tablero.length; j++) {
				// Para las casillas desveladas.
				if (!this.game.tablero[i][j].isVelada() && !this.game.tablero[i][j].isMina()) {
					// Desactivar los botones que no sean minas y tengan alguna mina alrededor.
					if (this.game.tablero[i][j].getNumeroMinas() == 0) {
						cambiarVisibilidadBotones(i, j, false);
					}
					// Si no es una mina y tiene como mínimo una mina a su alrededor.
					if (this.game.tablero[i][j].getNumeroMinas() > 0) {
						this.botonera.botones[i][j].setText(String.valueOf(this.game.tablero[i][j].getNumeroMinas()));
					}
				}
			}
		}
	}

	/**
	 * Cambia la visibilidad del botón seleccionado a la deseada.
	 * 
	 * @param i
	 *            coordenadas del botón.
	 * @param j
	 *            coordenadas del botón.
	 * @param estado
	 *            nuevo estado del botón.
	 */
	protected void cambiarVisibilidadBotones(int i, int j, boolean estado) {
		this.botonera.botones[i][j].setEnabled(estado);
	}

	/**
	 * Muestra las minas y desactiva todos los botones.
	 */
	protected void finalizarJuego() {
		for (int i = 0; i < this.game.tablero.length; i++) {
			for (int j = 0; j < this.game.tablero.length; j++) {
				cambiarVisibilidadBotones(i, j, false);
				if (this.game.tablero[i][j].isMina()) {
					this.botonera.botones[i][j].setBackground(Color.RED);
				}
			}
		}
	}

	/**
	 * Elimina el texto de los botones y elimina el color de fondo.
	 */
	protected void limpiarBotones() {
		for (int i = 0; i < this.lado; i++) {
			for (int j = 0; j < this.lado; j++) {
				this.botonera.botones[i][j].setText("");
				this.botonera.botones[i][j].setBackground(null);
			}
		}
	}
}
