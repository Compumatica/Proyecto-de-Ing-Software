package prCompumatica;

import java.util.*;

public class Plato {
	private String nombre;
	private Map<Alimento, Integer> alimentos;
	
	private float calorias;
	private float proteinas;
	private float grasas;
	private float carbohidratos;
	
	private boolean almuerzoCena;
	
	public Plato(String nombre, Alimento[] alimentos, int[] cantidades){
		if(nombre.length() == 0)
			throw new RuntimeException("Nombre no valido para un plato");
		
		if(alimentos.length != cantidades.length)
			throw new RuntimeException("El numero de ingredientes del plato debe coincidir con el de cantidades.");
		
		this.nombre = nombre;
		this.alimentos = new HashMap<>();
		
		for(int i = 0; i < alimentos.length; i++) {
			this.alimentos.put(alimentos[i], cantidades[i]);
		}
		
		for(Alimento i : alimentos) {
			calorias += i.getCalorias();
			proteinas += i.getProteinas();
			grasas += i.getGrasas();
			carbohidratos += i.getCarbohidratos();
		}
	}
	
	public boolean contieneAlergenos(List<Alergeno> alergenos){
		for(Alimento al : alimentos.keySet()) {
			if(al.contieneAlergenos(alergenos))
				return true;
		}
		return false;
	}
	
	public boolean validoParaAlmorzarCenar() {
		return almuerzoCena;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public float getCalorias(){
		return calorias;
	}
	
	public float getProteinas(){
		return proteinas;
	}
	
	public float getGrasas(){
		return grasas;
	}
	
	public float getCarbohidratos(){
		return carbohidratos;
	}
	
	public String showDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre: "+nombre+"\n");
		sb.append("Calorias: "+calorias+"\n");
		sb.append("Proteinas: "+proteinas+"\n");
		sb.append("Grasas: "+grasas+"\n");
		sb.append("Carbohidratos: "+carbohidratos+"\n");
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return nombre;
	}	
}
