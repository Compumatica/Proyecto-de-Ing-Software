package prCompumatica;

import java.util.Arrays;

public class Dieta {
	
	private Plato[] platos;
	private float grasas, carbohidratos, proteinas, calorias;
	
	public Dieta() {
		platos = new Plato[4];
	}
	
	// Setters
	
	public void setDesayuno(Plato plato){
		platos[0] = plato;
	}
	
	public void setAlmuerzo(Plato plato){
		platos[1] = plato;
	}
			  
	public void setMerienda(Plato plato){
		platos[2] = plato;
	}
	
	public void setCena(Plato plato){
		platos[3] = plato;
	}
	
	// Getters
	
	public Plato getDesayuno(){
		return platos[0];
	}
	
	public Plato getAlmuerzo(){
		return platos[1];
	}
	
	public Plato getMerienda(){
		return platos[2];
	}
	
	public Plato getCena(){
		return platos[3];
	}
	
	public int getGrasas() {
		for(int i = 0; i < 4; i++) {
			grasas += platos[i].getGrasas();
		}
		return grasas;
	}
	
	public int getCalorias() {
		for(int i = 0; i < 4; i++) {
			calorias += platos[i].getCalorias();
		}
		return calorias;
	}
	
	public int getCarbohidratos() {
		for(int i = 0; i < 4; i++) {
			carbohidratos += platos[i].getCarbohidratos();
		}
		return carbohidratos;
	}
	
	public int getProteinas() {
		for(int i = 0; i < 4; i++) {
			proteinas += platos[i].getProteinas();
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
		return Arrays.toString(platos);
	}
	
}
