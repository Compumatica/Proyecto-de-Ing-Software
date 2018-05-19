package prCompumatica;

import java.util.ArrayList;

public class Platos {
	String nombre;
	private ArrayList<Alimento> componentes;
	float grasas = 0, carbohidratos = 0, proteinas = 0;
	
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
	
	public float getGrasas() {
		for(Alimento a : componentes) {
			grasas += a.getGrasas();
		}
		return grasas;
	}
	
	public float getCarbohidratos() {
		for(Alimento a : componentes) {
			carbohidratos += a.getCarbohidratos();
		}
		return carbohidratos;
	}
	
	public float getProteinas() {
		for(Alimento a : componentes) {
			proteinas += a.getProteinas();
		}
		return proteinas;
	}
	
	// setters
	public void nombre(String n) {
		nombre=n;
	}
	public void componentes(ArrayList<Alimento> comp) {
		componentes=comp;
	}
	
}
