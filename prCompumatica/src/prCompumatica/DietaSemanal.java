package prCompumatica;

public class DietaSemanal {
	
	Dieta[] semanal = new Dieta[7];
	int pos = 0; // primera posicion libre
	
	public DietaSemanal() {
		
	}
	
	public Dieta[] getDieta() {
		return semanal;
	}
	
	public void put (Dieta diet) {
		if (pos == 7) {
			System.out.println("error: array de dietas llena");
		}else {
			semanal[pos] = diet;
			pos++;
		}
	}
	

}

