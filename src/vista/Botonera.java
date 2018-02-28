package vista;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;

public class Botonera extends JPanel {
	protected int lado;

	/**
	 * Create the panel.
	 */
	public Botonera(int lado) {
		this.lado = lado;
		setLayout(new GridLayout(this.lado, this.lado, 0, 0));
		crearBotones();
	}

	private void crearBotones() {
		for (int i = 0; i < this.lado; i++) {
			for (int j = 0; j < this.lado; j++) {
				JButton boton = new JButton();
				boton.setName(i + "-" + j);
				boton.setOpaque(true);
//				boton.setBackground(new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
//						(int) (Math.random() * 255)));
				this.add(boton);
			}
		}
	}

}
