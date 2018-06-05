package prCompumatica;

import java.util.*;

import jdk.nashorn.internal.runtime.regexp.joni.MatcherFactory;

public class AsistenteDieta {

	private static LinkedList<Plato> platosAlmCena, platosDesMer;
	
	static {
		// Cargar platos de la bd
		Alimento lecheLactosa = new Alimento("Leche con lactosa", 122f, 4.88f, 11.49f, 8.03f, Alergeno.LACTOSA); // 1 taza
		Alimento cereales = new Alimento("Cereales", 376f, 3.38f, 83.02f, 7.24f); // 100g
		Alimento arrozBlanco = new Alimento("Arroz blanco", 129, 0.28f, 27.9f, 2.66f); // 100g
		Alimento salsaTomate = new Alimento("Salsa de tomate", 90f, 0.49f, 18.08f, 3.17f); // 1 taza
		Alimento panBlanco = new Alimento("Pan blanco", 266f, 3.29f, 50.61f, 7.64f, Alergeno.GLUTEN, Alergeno.HUEVO);
		Alimento lonchaQueso = new Alimento("Loncha de queso", 84f, 6.46f, 1.13f, 5.33f, Alergeno.LACTOSA);
		Alimento lonchaJamon = new Alimento("Loncha de jamón", 91f, 4.82f, 2.14f, 9.3f);
		Alimento galleta = new Alimento("Galleta", 24f, 1.07f, 3.45f, 0.27f);
		Alimento pechugaPollo = new Alimento("Pechuga de pollo", 302f, 11.97f, 0f, 45.8f); // 1 cuarto de pechuga
		
													// calorias grasas carbohidratos proteinas
		
		Alimento pasta = new Alimento("Pasta", 157f, 0.92f, 30.68f, 5.76f); // 100g racion normal
		
		Alimento terneraPicada = new Alimento("Ternera picada", 182, 12, 0.9f, 17); // 100g racion normal
	
		Alimento huevo = new Alimento("Huevo", 65, 4.377f, 0.34f, 5.54f); // mediano
		Alimento zanahoria = new Alimento("Zanahoria", 52, 0.31f, 12.26f, 1.19f); // 1 taza
		Alimento guisantes = new Alimento("Guisantes", 117, 0.58f, 20.97f, 7.86f); // 1 taza
		
		platosAlmCena = new LinkedList<>();
		platosDesMer = new LinkedList<>();
		
		platosDesMer.add(new Plato("Tazón de cereales con leche", lecheLactosa, cereales));
		platosDesMer.add(new Plato("Bocadillo de jamón y queso", panBlanco, lonchaJamon, lonchaQueso));
		platosDesMer.add(new Plato("Galletas", galleta, galleta, galleta, galleta, galleta));
		
		//platosAlmCena.add(new Plato("Arroz con tomate", arrozBlanco, salsaTomate));
		//platosAlmCena.add(new Plato("Pollo con tomate", pechugaPollo, salsaTomate));
		platosAlmCena.add(new Plato("Macarrones", pasta, salsaTomate, terneraPicada));
		platosAlmCena.add(new Plato("Espaguetis", pasta, salsaTomate, terneraPicada));
		platosAlmCena.add(new Plato("Arroz tres delicias", arrozBlanco, arrozBlanco, zanahoria, guisantes));
		
		Collections.shuffle(platosAlmCena);
		Collections.shuffle(platosDesMer);
	}
	
	public static Dieta hacerSugerencia(Usuario usuario) {
		filtrar(usuario.getAlergenos(), usuario.getAlimentosVetados());
		return generarDieta();
	}
	
	private static void filtrar(List<Alergeno> alergenos, List<Alimento> vetados){
		if(alergenos != null){
			platosAlmCena.removeIf(p -> p.contieneAlergenos(alergenos));
			platosDesMer.removeIf(p -> p.contieneAlergenos(alergenos));
		}
		
		if(vetados != null){
			platosAlmCena.removeIf(p -> vetados.contains(p));
			platosDesMer.removeIf(p -> vetados.contains(p));
		
		}
	}
	
	
	private static Dieta generarDieta(){
		Queue<Dieta> cola = new PriorityQueue<>();
		cola.add(new Dieta());
		float c = Float.POSITIVE_INFINITY;
		Dieta sol = null;
		
		while(!cola.isEmpty()){
			Dieta d = cola.poll();
			if(d.completa()){
				if(h(d) < c){
					c = h(d);
					sol = d;
					cola.removeIf(x -> h(x) >= h(d));
				}
			} else{
				List<Plato> sucesores = sucesores(d);
				for(Plato suc : sucesores) {
					d.add(suc);
					
					if(h(d) < c)
						cola.add(d.clone());
					
					d.remove(suc);
				}
			}
		}
		return sol;
	}
	
	@SuppressWarnings("unchecked")
	private static List<Plato> sucesores(Dieta dieta){
		List<Plato> suc = new LinkedList<>();
		if(dieta.size() <= 1) { // Hay que elegir un almuerzo o una cena
			suc = (List<Plato>)platosAlmCena.clone();
		} else { // Hay que elegir un desayuno o un almuerzo
			suc = (List<Plato>)platosDesMer.clone();
		}
		suc.removeIf(plato -> dieta.contains(plato));
		return suc;
	}
	
	public static float h(Dieta menu){
		float x = -2500f, y = -275f, z = -55f, t = -56f;
		for(Plato p : menu.getPlatos()){
			if(p != null){
				x += p.getCalorias();
				y += p.getCarbohidratos();
				z += p.getGrasas();  
	    		t += p.getProteinas();
			}
		}
	    return x*x + y*y + z*z + t*t;
	}
	
	// Utils
	private <T> T[] toArray(T ... a){
		return a;
	}
}
