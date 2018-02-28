package controlador;

import vista.UI;

public class ParaUI extends UI {
	protected int lado = 10;
	protected int minas = 10;
	Buscaminas game = new Buscaminas(this.lado, this.minas);
	MyActionListenerBotonera listenerBotonera = new MyActionListenerBotonera(this, game);

	public ParaUI() {
		super();
		añadirListener();
	}

	public void añadirListener() {
		for (int i = 0; i < this.botonera.botones.length; i++) {
			for (int j = 0; j < this.botonera.botones.length; j++) {
				this.botonera.botones[i][j].addActionListener(listenerBotonera);
			}
		}
	}

	protected void actualizarVentana() {
		for (int i = 0; i < this.game.tablero.length; i++) {
			for (int j = 0; j < this.game.tablero.length; j++) {
				if (!this.game.tablero[i][j].isVelada()) {
					this.botonera.botones[i][j].setEnabled(false);
				}
			}
		}
	}

}
