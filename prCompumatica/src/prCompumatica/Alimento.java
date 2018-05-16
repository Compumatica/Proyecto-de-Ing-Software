package prCompumatica;

import java.util.*;

public class Alimento {
	private String nombre;
	private Set<Alergeno> alergenos;
	
	private float calorias;
	private float proteinas;
	private float grasas;
	private float carbohidratos;
	private float proteinasPor100Gramos;
	private float carbohidratosPor100Gramos;
	private float grasasPor100Gramos;
	
	public Alimento(String nombre, float calorias,float grasasPor100Gramos,float carbohidratosPor100Gramos
			           ,float proteinasPor100Gramos, Alergeno ... alergenos){
		this.nombre = nombre;
		
		this.alergenos = new HashSet<>(Arrays.asList(alergenos));
		
		this.calorias = calorias;
		proteinas = proteinasPor100Gramos/100;
		grasas = grasasPor100Gramos/100,
		carbohidratos = cabohidratosPor100Gramos;
		
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
