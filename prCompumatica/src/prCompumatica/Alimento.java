package prCompumatica;

import java.util.*;

public class Alimento {
	private String nombre;
	private Set<Alergeno> alergenos;
	
	private float calorias;        // Por cada 100g
	private float proteinas;       // Por cada 100g
	private float grasas; 	       // Por cada 100g
	private float carbohidratos;   // Por cada 100g
	
	private float cantidad;        // En gramos
	
	public Alimento(String nombre, float cantidad, float calorias, float grasas, float carbohidratos,
	           float proteinas, Alergeno ... alergenos){
		this.nombre = nombre;
		
		this.alergenos = new HashSet<>(Arrays.asList(alergenos));
		
		this.cantidad = cantidad;
		
		this.calorias = calorias;
		this.proteinas = proteinas;
		this.grasas = grasas;
		this.carbohidratos = carbohidratos;
	}

	public boolean contieneAlergenos(List<Alergeno> alergenos){
		for(Alergeno a : alergenos){
			if(this.alergenos.contains(a))
				return true;
		}
		return false;
	}
	
	// Getters
	
	public String getNombre(){
		return nombre;
	}
	
	public String getCantidad(){
		return cantidad;
	}
	
	public float getCalorias(){
		return calorias/100 * cantidad;
	}
	
	public float getProteinas(){
		return proteinas/100 * cantidad;
	}
	
	public float getGrasas(){
		return grasas/100 * cantidad;
	}
	
	public float getCarbohidratos(){
		return carbohidratos/100 * cantidad;
	}
}
