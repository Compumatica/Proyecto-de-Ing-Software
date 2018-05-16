package prCompumatica;

import java.util.*;

public class Alimento {
	private String nombre;
	private Set<Alergeno> alergenos;
	
	private float calorias;
	private float proteinas;
	private float grasas;
	private float carbohidratos;
	
	public Alimento(String nombre, float calorias, float grasas, float carbohidratos,
			           float proteinas, Alergeno ... alergenos){
		this.nombre = nombre;
		
		this.alergenos = new HashSet<>(Arrays.asList(alergenos));
		
		this.calorias = calorias;
		this.proteinas = proteinas;
		this.grasas = grasas;
		this.carbohidratos = carbohidratos;
	}
	
	public String getNombre(){
		return nombre;
	}

	public boolean contieneAlergenos(List<Alergeno> alergenos){
		for(Alergeno a : alergenos){
			if(this.alergenos.contains(a))
				return true;
		}
		return false;
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
}
