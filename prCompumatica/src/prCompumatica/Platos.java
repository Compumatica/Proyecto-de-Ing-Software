package prCompumatica;

import java.util.ArrayList;

public class Platos {
	String nombre;
	private ArrayList<Alimentos> componentes;
	int Grasas, Carbohidratos, Proteinas;
	
	// True -> El plato es de almuerzo o cena 
	// False -> El plato es de cena o merienda
	boolean franjaAlmuerzo;
	
	public Platos(String n, ArrayList<Alimentos> comp){
		nombre=n;
		componentes=comp;
		
	}
	
	public Platos(String n) {
		nombre=n;
		componentes = new ArrayList<Alimentos>();
	}
	public Platos() {
		this("plato_sin_nombre");
	}
	// modifiers
	public void addAlimento(Alimentos a) {
		componentes.add(a);
	}
	// getters
	public ArrayList<Alimentos> componentes() {
		ArrayList<Alimentos> clone = new ArrayList<Alimentos>(componentes);
		return clone;
	}
	public String nombre() {
		String ret = new String(nombre);
		return ret;
	}
	
	// Respecto a franjaAlmuerzo (convenio)
	// True -> El plato es de almuerzo o cena 
	// False -> El plato es de cena o merienda
	public boolean getHora() {
		return franjaAlmuerzo;
	}
	
	public int getGrasas() {
		return Grasas;
	}
	
	public int getCarbohidratos() {
		return Carbohidratos;
	}
	
	public int getProteinas() {
		return Proteinas;
	}
	
	// setters
	public void nombre(String n) {
		nombre=n;
	}
	public void componentes(ArrayList<Alimentos> comp) {
		componentes=comp;
	}
	
}
