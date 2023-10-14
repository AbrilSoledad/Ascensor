package ar.edu.unlam.dominio;

public class Ascensor1 {

	private final int PISO_MAXIMO;
	private final int PISO_MINIMO;
	private final double PESO_MAXIMO;
	private final int CAPACIDAD_MAXIMA;
	private boolean puertaAbierta;
	private double pesoActual;
	private int pisoActual;
	private int personasIngresadas;
	private boolean sobrecarga;
	private Persona[] ocupantes;

	public Ascensor1(int pisoMinimo, int pisoMaximo, double pesoMaximo, int capacidadMaxima) {
		this.PISO_MINIMO = pisoMinimo;
		this.PISO_MAXIMO = pisoMaximo;
		this.pisoActual = PISO_MINIMO;
		this.puertaAbierta = true;
		this.PESO_MAXIMO = pesoMaximo;
		this.pesoActual = 0;
		this.CAPACIDAD_MAXIMA = capacidadMaxima;
		this.personasIngresadas = 0;
		this.sobrecarga = false;
	}

	public boolean sobrecarga() {
		boolean pesoDeMas = sobrecarga;

		if (pesoActual > this.PESO_MAXIMO || personasIngresadas > this.CAPACIDAD_MAXIMA) {
			return pesoDeMas = true;
		}

		return pesoDeMas;
	}

	public boolean abrirPuerta() {

		return this.puertaAbierta = true;
	}

	public void cerrarPuerta() {

		if (!sobrecarga()) {
			this.puertaAbierta = false;
		}
	}

	public void subir() {
		if (!puertaAbierta && pisoActual < PISO_MAXIMO && this.pesoActual < this.PESO_MAXIMO && !sobrecarga) {
		}
		this.pisoActual++;
	}

	public void bajar() {
		if (!puertaAbierta && pisoActual > PISO_MINIMO && this.pesoActual < this.PESO_MAXIMO && !sobrecarga) {
		}
		this.pisoActual--;
	}

	public void irAlPiso(int pisoDeseado) {

		while (!puertaAbierta && pisoActual < pisoDeseado && pisoActual <= PISO_MAXIMO && !sobrecarga) {

			this.subir();
		}

		while (!puertaAbierta && pisoActual > pisoDeseado && pisoActual >= PISO_MINIMO && !sobrecarga) {
			this.bajar();
		}

	}

	public void ingresarCantidadDeOcupantes(int cantidadDePersonas) {
		setOcupantes(new Persona[cantidadDePersonas]);
	}

	public void ingresar(double peso) {

		if (puertaAbierta && peso < this.PESO_MAXIMO) {
			this.pesoActual += peso;
			this.personasIngresadas++;
		}
	}

	public void ingresar(Persona elQueEntra) {

		if ((elQueEntra.getPeso() < this.PESO_MAXIMO) && (this.personasIngresadas < this.CAPACIDAD_MAXIMA)
				&& (this.puertaAbierta == true)) {

			for (int i = 0; i < ocupantes.length; i++) {
				if (this.ocupantes[i] == null) {
					this.ocupantes[i] = elQueEntra;
				}
			}
			this.pesoActual += elQueEntra.getPeso();
			this.personasIngresadas++;
		}
	}

	public void salir(double peso) {

		if (puertaAbierta) {
			this.pesoActual -= peso;
			this.personasIngresadas--;
		}
	}

	public void salir(Persona elQueBaja) {

		if (this.puertaAbierta == true) {

			for (int i = 0; i < ocupantes.length; i++) {

				if (ocupantes != null && ocupantes[i] == elQueBaja) {

					this.pesoActual -= elQueBaja.getPeso();
					ocupantes[i] = null;
					this.personasIngresadas--;
				}
			}
		}
	}

	public boolean isPuertaAbierta() {
		return puertaAbierta;
	}

	public void setPuertaAbierta(boolean puertaAbierta) {
		this.puertaAbierta = puertaAbierta;
	}

	public double getPesoActual() {
		return pesoActual;
	}

	public void setPesoActual(double pesoActual) {
		this.pesoActual = pesoActual;
	}

	public int getPersonasIngresadas() {
		return personasIngresadas;
	}

	public void setPersonasIngresadas(int personasIngresadas) {
		this.personasIngresadas = personasIngresadas;
	}

	public int getPISO_MAXIMO() {
		return PISO_MAXIMO;
	}

	public int getPISO_MINIMO() {
		return PISO_MINIMO;
	}

	public double getPESO_MAXIMO() {
		return PESO_MAXIMO;
	}

	public int getCAPACIDAD_MAXIMA() {
		return CAPACIDAD_MAXIMA;
	}

	public void setPisoActual(int pisoActual) {
		this.pisoActual = pisoActual;
	}

	public int getPisoActual() {
		return pisoActual;
	}

	public Persona[] getOcupantes() {
		return ocupantes;
	}

	public void setOcupantes(Persona[] ocupantes) {
		this.ocupantes = ocupantes;
	}
}
