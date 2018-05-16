package prCompumatica;

import java.util.*;

public class Dieta {
	// EnumMap <Clave, Valor>
	// Clave es un objeto Enum de Comidas.java (desayuno, almuerzo, merienda, cena)
	// Valor es un Plato
	public EnumMap<Comidas, Platos> dieta;
	
	public Dieta() {
		dieta =  new EnumMap<Comidas, Platos>(Comidas.class);
	}
	
	public void agregaPlato(Platos p, Comidas c) {
		
		switch(c) {
			case DESAYUNO:
				dieta.put(Comidas.DESAYUNO, p);
				break;
			
			case ALMUERZO:
				dieta.put(Comidas.ALMUERZO, p);			
				break;
				
			case MERIENDA:
				dieta.put(Comidas.MERIENDA, p);
				break;
				
			case CENA:
				dieta.put(Comidas.CENA, p);
				break;
				
			default:
				break;
		}
	}
	
}
