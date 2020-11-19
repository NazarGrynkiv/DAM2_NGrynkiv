package Pt;

public class Terreny {
	
	refUnica ref = new refUnica();

	private String referencia;
	public double llargada;
	private double altura;
	private String categoria;

	private final double taxaR = 5.25;
	private final double taxaU = 7.50;

	public static String[] propietaris = new String[4];
	public String poblacio;

//---------------------------------CONSTRUCTORS-----------------------------------

	public Terreny(double llargada, double altura, String poblacio) {

		this.referencia = this.ref.getRef(poblacio);
		this.llargada = llargada;
		this.altura = altura;
		this.categoria = "Rustic";
		this.propietaris[0] = "Consistori";
		this.poblacio = poblacio;

	}

	public Terreny(double llargada, double altura, String poblacio, String categoria) {

		this.referencia = this.ref.getRef(poblacio);
		this.llargada = llargada;
		this.altura = altura;
		this.categoria = categoria;
		this.propietaris[0] = "Consistori";
		this.poblacio = poblacio;

	}

	public Terreny(double llargada, double altura, String poblacio, String categoria, String[] propietaris) {

		this.referencia = this.ref.getRef(poblacio);
		this.llargada = llargada;
		this.altura = altura;
		this.categoria = categoria;
		this.poblacio = poblacio;

		boolean prop = false;

		for (int i = 0; i < propietaris.length; i++) {
			if (propietaris[i] != null) {
				prop = true;
			}
		}
		if (prop) {
			this.propietaris = propietaris;
		} else {
			this.propietaris[0] = "Consistori";
		}
	}

//-----------------------------------SETTERS-----------------------------------

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public void setLlargada(double llargada) {
		this.llargada = llargada;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setPropietaris(String[] propietaris) {
			this.propietaris = propietaris;	
	}

	public void setPoblacio(String poblacio) {
		this.poblacio = poblacio;
	}
	
//-----------------------------------GETTERS-----------------------------------

	public String getRefercncia() {
		return this.referencia;
	}

	public double getAltura() {
		return this.altura;
	}

	public double getLlargada() {
		return this.llargada;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public String[] getPropietaris() {
		return this.propietaris;
	}

	public String getPoblacio() {
		return this.poblacio;
	}

//------------------------------------------------------------------------------

	public void mostrarTerreny() {
		System.out.println("Referencia: " + this.getRefercncia());
		System.out.println("Ciutat/poble: " + this.poblacio);
		System.out.println("Superficie: " + String.format("%.5f", this.obtenirSup()) + "Ha");
		System.out.print("Propietari/s: ");
		for (int i = 0; i < propietaris.length; i++) {
			if (this.propietaris[i] != null) {
				System.out.print(this.propietaris[i] + " ");
			}
		}
		System.out.println("\nCategoria: " + this.categoria);
	}
	
	public double obtenirSup() {

		return ((this.llargada * this.altura) / 10000);

	}

	public double impostBase() {

		double imp = 0;

		if (categoria == "Rustic") {
			imp = taxaR * obtenirSup() * 10000;

			if (obtenirSup() > 25) {
				imp = imp * 1.05;
				System.out.println("Impost per Terreny Rustic: " + imp);
			}
		} else {

			imp = taxaU * obtenirSup() * 10000;

			if (obtenirSup() > 5) {
				imp = imp * 1.15;
				System.out.println("Impost per Terreny Urba: " + imp);
			}
		}

		return imp;
	}

	public String mostraPropietaris() {
		String prop = "";
		System.out.print("Propietaris: ");
		for (int i = 0; i < propietaris.length; i++) {
			if (this.propietaris[i] != null) {
				prop = this.propietaris[i];
				System.out.print(this.propietaris[i] + " ");
			}
		}
		return prop;
	}

	public String compara(Terreny t) {
		String res = new String();

		if (this.categoria != t.categoria) {
			System.out.println("Els terrenys no és poden comparar perque son de diferanta categoria!");
		} else {
			String ref = this.getRefercncia();
			String reft = t.getRefercncia();
			if (this.obtenirSup() > t.obtenirSup()) {
				System.out.println("El terreny " + ref + " és més gran");
			} else if (this.obtenirSup() < t.obtenirSup()) {
				System.out.println("El terreny " + reft + " és més gran");
			} else {
				System.out.println("Son iguals.");
			}

			if (this.impostBase() > t.impostBase()) {
				System.out.println("El terreny " + ref + " paga l'impost més gran");

			} else if (this.impostBase() > t.impostBase()) {
				System.out.println("El terreny " + reft + " paga l'impost més gran");
			} else {
				System.out.println("Els dos terrenys paguen el mateix impost.");
			}

		}
		return res;
	}
}