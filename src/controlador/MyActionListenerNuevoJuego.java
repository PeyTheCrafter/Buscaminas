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
