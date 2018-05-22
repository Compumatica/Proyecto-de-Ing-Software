package prCompumatica;

public class Dieta {
	
	private Plato[] platos;
	
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
	
}
