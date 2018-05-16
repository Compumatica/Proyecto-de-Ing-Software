package prCompumatica;

import java.util.ArrayList;

public class Platos {
	String nombre;
	private ArrayList<Alimento> componentes;
	int Grasas, Carbohidratos, Proteinas;
	
	// True -> El plato es de almuerzo o cena 
	// False -> El plato es de cena o merienda
	boolean franjaAlmuerzo;
	
	public Platos(String n, ArrayList<Alimento> comp){
		nombre=n;
		componentes=comp;
		
	}
	
	public Platos(String n) {
		nombre=n;
		componentes = new ArrayList<Alimento>();
	}
	public Platos() {
		this("plato_sin_nombre");
	}
	// modifiers
	public void addAlimento(Alimento a) {
		componentes.add(a);
	}
	// getters
	public ArrayList<Alimento> componentes() {
		ArrayList<Alimento> clone = new ArrayList<Alimento>(componentes);
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
	public void componentes(ArrayList<Alimento> comp) {
		componentes=comp;
	}
	
}
