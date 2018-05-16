package prCompumatica;

public class AsistenteDieta {

	private static List<Plato> platosAlmCena, platosDesMer;
	
	public static String hacerSugerencia(String usuario) {
		filtrar(usuario.getAlergenos(), usuario.getAlimentosVetados());
		return "";
	}
	
	private static void filtrar(List<Alergeno> alergenos, List<Alimento> vetados){
		platosAlmCena.removeIf(p -> vetados.contains(p) || p.contieneAlergenos(alergenos));
		platosDesMer.removeIf(p -> vetados.contains(p) || p.contieneAlergenos(alergenos));
	}

}
