package Pt;

import Pt.Terreny;

public class Municipi {

	private String nom; // el nom del municipi (un cop assignat un valor a aquest atribut ja no es podrà
						// tornar a canviar
	private String comarca; // el nom de la comarca a la quepertany el municipi (un cop assignat un valor a
							// aquest atribut ja no es podrà tornar a canviar)
	private int habitants; // nombre d’habitants que hi ha al municip

	public static Terreny[] terrenys = new Terreny[50]; // els terrenys que té el municipi​ considerarem un màxim de 50 terrenys

	private double superficie; // la superficie en Ha que té el municipi
	
	//---------------------------------CONSTRUCTORS-----------------------------------
	
	public Municipi(String nom,String comarca, int habitants) {
		this.setNom(nom);
		this.setComarca(comarca);
		this.setHabitants​(habitants);
	}
	public Municipi(String nom,String comarca, int habitants, Terreny[] terrenys) {
		this.setNom(nom);
		this.setComarca(comarca);
		this.setHabitants​(habitants);
		this.setTerrenys(terrenys);
	}

	//-----------------------------------SETTERS-----------------------------------

	public void setNom(String nouNom) {
		nom = nouNom;
	}

	public void setComarca(String novaComarca) {
		comarca = novaComarca;
	}

	public void setHabitants​(int nouHabitants​) {
		habitants​ = nouHabitants​;
	}

	public void setTerrenys(Terreny[] nouTerrenys) {
		terrenys = nouTerrenys;
	}

	public void setSuperficie(double novaSuperficie) {
		superficie = novaSuperficie;
	}

	//-----------------------------------GETTERS-----------------------------------

	public String getNom() {
		return nom;
	}

	public String getComarca() {
		return comarca;
	}

	public int getHabitants​() {
		return habitants​;
	}

	public Terreny[] getTerrenys() {
		return terrenys;
	}

	public double getSuperficie() {
		return superficie;
	}
	
	//-----------------------------------METODES-----------------------------------
	
	public void afegirTerreny(Terreny t) {
		for (int i = 0; i < terrenys.length; i++) {
			if (terrenys[i] == null) {
				terrenys[i] = t;
				break;
			}
		}
	}
	
	public Terreny obteTerreny(String ref) {			
		for (int i = 0; i < terrenys.length; i++) {
			if (terrenys[i] != null && terrenys[i].getRefercncia() == ref) {				
				return terrenys[i];
			}
		}
		return null;			
	}
	
	public void afegeixProp(String ref,String propietari){		
		for (int i = 0; i < terrenys.length; i++) {
			if (terrenys[i] != null && terrenys[i].getRefercncia() == ref) {
				for (int j = 0; j < Terreny.propietaris.length; j++) {
					if(Terreny.propietaris[j] == null) {
					//if (terrenys[i].getPropietaris() == null) {
						Terreny.propietaris[j] = propietari;
						terrenys[i].setPropietaris(Terreny.propietaris);
						break;
					//}	
					}					
				}				
			}
		}
	}
	
	public void eliminaProp(String ref,String propietari){		
		for (int i = 0; i < terrenys.length; i++) {
			if (terrenys[i] != null && terrenys[i].getRefercncia() == ref) {
				for (int j = 0; j < Terreny.propietaris.length; j++) {
					if(Terreny.propietaris[j] == propietari) {
					//if (terrenys[i].getPropietaris() == null) {
						Terreny.propietaris[j] = null;
						terrenys[i].setPropietaris(Terreny.propietaris);
						break;
					//}	
					}					
				}				
			}
		}
	}
	
	public void requalifica (Terreny t) {	
		if (t.getCategoria() == "Rustic") {
			t.setCategoria("Urba");
		} else {
			t.setCategoria("Rustic");
		}
	}	
}