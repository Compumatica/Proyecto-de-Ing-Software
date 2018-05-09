package prCompumatica;

import java.util.ArrayList;

public class Platos {
	String nombre;
	private ArrayList<Alimentos> componentes;
	
	
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
	// setters
	public void nombre(String n) {
		nombre=n;
	}
	public void componentes(ArrayList<Alimentos> comp) {
		componentes=comp;
	}
	
}
