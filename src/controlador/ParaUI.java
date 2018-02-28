package controlador;

import vista.UI;

public class ParaUI extends UI{
	protected int lado = 10;
	protected int minas = 10;
	protected MyActionListenerBotonera listener = new MyActionListenerBotonera(this, this.game);
	Buscaminas game = new Buscaminas(this.lado, this.minas);

	public ParaUI() {
		super();
		this.game = new Buscaminas(this.lado, this.minas);
		añadirListener();
	}
	
	public void añadirListener() {
		
	}
	
	protected void actualizarVentana() {
		for (int i = 0; i < this.game.tablero.length; i++) {
			for (int j = 0; j < this.game.tablero.length; j++) {
				if(!this.game.tablero[i][j].isVelada()) {
					this.botonera.botones[i][j].setEnabled(false);
				}
			}
		}
	}

}
