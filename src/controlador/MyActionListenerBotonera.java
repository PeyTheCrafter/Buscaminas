package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyActionListenerBotonera implements ActionListener {
	ParaUI paraUI;
	Buscaminas game;

	public MyActionListenerBotonera(ParaUI paraUI, Buscaminas game) {
		super();
		this.paraUI = paraUI;
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton) e.getSource();
		String name = boton.getName();
		int[] coordenadas = interpretarCoordenadas(name);
		if (comprobarMina(coordenadas[0], coordenadas[1])) {
			paraUI.finalizarJuego();
			System.out.println("Has perdido");
		} else {
			this.game.recorrer(coordenadas[0], coordenadas[1]);
		}
		this.paraUI.actualizarVentana();
	}

	/**
	 * Comprueba si una casilla es una mina
	 * 
	 * @param x
	 *            coordenada x
	 * @param y
	 *            coordenada y
	 * @return true si la casilla es una mina, false si no
	 */
	private boolean comprobarMina(int x, int y) {
		return this.game.tablero[x][y].isMina();
	}

	/**
	 * Interpreta las coordenadas recibidas en un String
	 * 
	 * @param cadena
	 *            String con las coordenadas.
	 * @return array con las coordenadas separadas
	 */
	private int[] interpretarCoordenadas(String cadena) {
		String coord[] = cadena.split("-");
		int coordenadas[] = new int[2];
		for (int i = 0; i < coordenadas.length; i++) {
			coordenadas[i] = Integer.valueOf(coord[i]);
		}
		return coordenadas;
	}

}
