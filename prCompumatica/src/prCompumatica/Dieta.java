package prCompumatica;

import java.util.*;

public class Dieta {
	
	private List<Plato>[] platos;
	
	public Dieta() {
		platos = new List<>[4];
	}
	
	// Setters
	
	public void setDesayuno(Plato ... platos){
		set(0, platos);
	}
	
	public void setAlmuerzo(Plato ... platos){
		set(1, platos);
	}
			  
	public void setMerienda(Plato ... platos){
		set(2, platos);
	}
	
	public void setCena(Plato ... platos){
		set(3, platos);
	}
	
	private void set(int index, Plato ... plato){
		if(platos[index] == null)
			platos[index] = new ArrayList<>();
		platos[index].addAll((Collection<? extends Plato>) Arrays.asList(platos));
	}
	
	// Getters
	
	public List<Plato> getDesayuno(){
		return platos[0];
	}
	
	public List<Plato> getAlmuerzo(){
		return platos[1];
	}
	
	public List<Plato> getMerienda(){
		return platos[2];
	}
	
	public List<Plato> getCena(){
		return platos[3];
	}
	
}
