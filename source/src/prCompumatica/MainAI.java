package prCompumatica;

public class MainAI {

	public static void main(String[] args) {
		Usuario u = new Usuario(null, null, null);
		u.setAlergenos();
		System.out.println(AsistenteDieta.hacerSugerencia(u));
	}

}
