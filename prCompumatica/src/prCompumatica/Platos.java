package prCompumatica;

import java.util.ArrayList;

public class Platos {
	String nombre;
	private ArrayList<Alimento> componentes;
	int Grasas = 0, Carbohidratos = 0, Proteinas = 0;
	
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
		for(Alimento a : componentes) {
			Grasas += a.getGrasas();
		}
		return Grasas;
	}
	
	public int getCarbohidratos() {
		for(Alimento a : componentes) {
			Carbohidratos += a.getCarbohidratos();
		}
		return Carbohidratos;
	}
	
	public int getProteinas() {
		for(Alimento a : componentes) {
			Proteinas += a.getProteinas();
		}
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
