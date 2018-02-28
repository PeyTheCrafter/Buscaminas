package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyActionListenerNuevoJuego implements ActionListener {
	ParaUI paraUI;
	Buscaminas game;

	public MyActionListenerNuevoJuego(ParaUI paraUI, Buscaminas game) {
		super();
		this.paraUI = paraUI;
		this.game = game;
	}

	/**
	 * Crea un nuevo juego. Para ello:<br>
	 * 1. Reactiva todos los botones.<br>
	 * 2. Limpia los botones: elimina el texto de los botones, así como el color de
	 * fondo.<br>
	 * 3. Limpia el tablero: Elimina todas las minas y vela todas las casillas.<br>
	 * 4. Inicia el juego: Recoloca las minas y calcula cuántas minas tiene cada
	 * casilla a su alrededor.<br>
	 * 5. Actualiza la ventana.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < paraUI.lado; i++) {
			for (int j = 0; j < paraUI.lado; j++) {
				paraUI.cambiarVisibilidadBotones(i, j, true);
			}
		}
		paraUI.limpiarBotones();
		game.limpiarTablero();
		game.iniciarJuego();
		paraUI.actualizarVentana();
	}

}
