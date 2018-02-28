package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class UI extends JFrame {

	private JPanel contentPane;
	protected Botonera botonera;

	protected int lado = 10;

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnJuego = new JMenu("Juego");
		menuBar.add(mnJuego);
		
		JMenuItem mntmNuevoJuego = new JMenuItem("Nuevo juego.");
		mnJuego.add(mntmNuevoJuego);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		botonera = new Botonera(this.lado);
		contentPane.add(botonera, BorderLayout.CENTER);
	}
}
