package vista;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;

public class Botonera extends JPanel {
	protected int lado;
	public JButton botones[][];

	/**
	 * Create the panel.
	 */
	public Botonera(int lado) {
		this.lado = lado;
		setLayout(new GridLayout(this.lado, this.lado, 0, 0));
		crearBotones();
	}

	private void crearBotones() {
		this.botones = new JButton[this.lado][this.lado];
		for (int i = 0; i < this.lado; i++) {
			for (int j = 0; j < this.lado; j++) {
				this.botones[i][j] = new JButton();
				this.botones[i][j].setName(i + "-" + j);
				this.botones[i][j].setOpaque(true);
				this.botones[i][j].setFont(new Font("Tahoma", 0, 9));
				this.add(this.botones[i][j]);
			}
		}
	}

}
