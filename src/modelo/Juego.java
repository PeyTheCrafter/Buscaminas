package modelo;

public class Juego {
	private int lado;
	private int minas;

	public Juego(int lado, int minas) {
		super();
		this.lado = lado;
		this.minas = minas;
	}

	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}

	public int getMinas() {
		return minas;
	}

	public void setMinas(int minas) {
		this.minas = minas;
	}
}
