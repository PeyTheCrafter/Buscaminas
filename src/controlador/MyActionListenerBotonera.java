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

	/**
	 * Obtiene el botón pulsado. Extrae su name y lo interpreta a coordenadas. Según
	 * estas coordenadas: <br>
	 * -Si es mina, se procede a la finalización del juego.<br>
	 * -Si tiene 0 minas a su alrededor, se recorre el tablero.<br>
	 * -Si tiene más de 0 minas a su alrededor, se desvela la casilla en las
	 * coordenadas del botón.<br>
	 * Al finalizar, actualiza la ventana.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton) e.getSource();
		String name = boton.getName();
		int[] coordenadas = interpretarCoordenadas(name);
		if (comprobarMina(coordenadas[0], coordenadas[1])) {
			paraUI.finalizarJuego();
			System.out.println("Has perdido");
		} else if (this.game.tablero[coordenadas[0]][coordenadas[1]].getNumeroMinas() == 0) {
			this.game.recorrer(coordenadas[0], coordenadas[1]);
		} else {
			this.game.tablero[coordenadas[0]][coordenadas[1]].setVelada(false);
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
	 * @return true si la casilla es una mina, false si no lo es.
	 */
	private boolean comprobarMina(int x, int y) {
		return this.game.tablero[x][y].isMina();
	}

	/**
	 * Interpreta las coordenadas recibidas del name del botón.
	 * 
	 * @param cadena
	 *            String con las coordenadas.
	 * @return array (int[]) con las coordenadas separadas.
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
