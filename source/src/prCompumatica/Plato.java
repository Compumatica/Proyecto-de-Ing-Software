package prCompumatica;

import java.util.*;

public class Plato {
	private String nombre;
	private Map<Alimento, Float> alimentos;
	
	private float calorias;
	private float proteinas;
	private float grasas;
	private float carbohidratos;
	
	private boolean almuerzoCena;
	
	public Plato(String nombre, Alimento[] alimentos, float[] cantidades){
		if(nombre.length() == 0)
			throw new RuntimeException("Nombre no valido para un plato");
		
		if(cantidades == null){
			cantidades = new float[alimentos.length];
			Arrays.fill(cantidades, 100f);
		}
		
		if(alimentos.length != cantidades.length)
			throw new RuntimeException("El numero de ingredientes del plato debe coincidir con el de cantidades.");
		
		this.nombre = nombre;
		this.alimentos = new HashMap<>();
	
		for(int i = 0; i < alimentos.length; i++) {
			this.alimentos.put(alimentos[i], cantidades[i]);
		}
		
		int i = 0;
		for(Alimento a : alimentos) {
			calorias += a.getCalorias();
			proteinas += a.getProteinas();
			grasas += a.getGrasas();
			carbohidratos += a.getCarbohidratos();
			i++;
		}
	}
	
	public Plato(String nombre, Alimento ... alimentos){
		this(nombre, alimentos, null);
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
		sb.append("Calorias: \t"+calorias+"\n");
		sb.append("Proteinas: \t"+proteinas+"\n");
		sb.append("Grasas: \t"+grasas+"\n");
		sb.append("Carbohidratos: \t"+carbohidratos+"\n");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj){
		Plato p = (Plato) obj;
		return p != null && nombre.equalsIgnoreCase(p.nombre);
	}
	
	@Override
	public int hashCode(){
		return nombre.hashCode();
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
