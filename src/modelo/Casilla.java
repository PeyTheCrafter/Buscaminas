package modelo;

public class Casilla {
	private boolean velada = true;
	private boolean marcada = false;
	private boolean mina;
	private int numeroMinas = 0;
	private int posX;
	private int posY;

	public Casilla(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}

	public boolean isMarcada() {
		return marcada;
	}

	public void setMarcada(boolean marcada) {
		this.marcada = marcada;
	}

	public boolean isVelada() {
		return velada;
	}

	public void setVelada(boolean velada) {
		this.velada = velada;
	}

	public boolean isMina() {
		return mina;
	}

	public void setMina(boolean mina) {
		this.mina = mina;
	}

	public int getNumeroMinas() {
		return numeroMinas;
	}

	public void setNumeroMinas(int numeroMinas) {
		this.numeroMinas = numeroMinas;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}
