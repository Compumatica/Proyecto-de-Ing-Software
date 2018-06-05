package prCompumatica;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Dieta implements Comparable<Dieta> {
	
	private List<Plato> platos;
	private float grasas, carbohidratos, proteinas, calorias;
	
	public Dieta() {
		platos = new LinkedList<>();
	}
	
	// Setters
	
	public void add(Plato p){
		platos.add(p);
	}
	
	public void remove(Plato p){
		platos.remove(p);
	}
	
	// Getters
	
	public List<Plato> getPlatos(){
		return platos;
	}
	
	public boolean contains(Plato p){
		return platos.contains(p);
	}
	
	public int size(){
		return platos.size();
	}
	
	public boolean completa(){
		return platos.size() == 4;
	}
		
	public float getGrasas() {
		for(int i = 0; i < 4; i++) {
			grasas += platos.get(i).getGrasas();
		}
		return grasas;
	}
	
	public float getCalorias() {
		for(int i = 0; i < 4; i++) {
			calorias += platos.get(i).getCalorias();
		}
		return calorias;
	}
	
	public float getCarbohidratos() {
		for(int i = 0; i < 4; i++) {
			carbohidratos += platos.get(i).getCarbohidratos();
		}
		return carbohidratos;
	}
	
	public float getProteinas() {
		for(int i = 0; i < 4; i++) {
			proteinas += platos.get(i).getProteinas();
		}
		return proteinas;
	}
	
	public String showDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append("Dieta: \n");
		sb.append("Calorias totales: \t"+calorias+"\n");
		sb.append("Proteinas totales: \t"+proteinas+"\n");
		sb.append("Grasas totales: \t"+grasas+"\n");
		sb.append("Carbohidratos totales: \t"+carbohidratos+"\n");
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return platos.toString();
	}
	
	public Dieta clone(){
		Dieta d = new Dieta();
		for(Plato p : platos)
			d.add(p);
		return d;
	}

	@Override
	public int compareTo(Dieta d) {
		return (int) (AsistenteDieta.h(this) - AsistenteDieta.h(d));
	}
	
}
