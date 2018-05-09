package prCompumatica;
import java.util.ArrayList;
import java.util.List;

public class Alimentos {
  	public static String nombre= "pasta";
	public static int gramos = 100;
	public static int caloria100Gramos = 200;
	public static int caloriasTotales = gramos * (caloria100Gramos/100);
	List<String> nutrientes = Array.asList ("Proteinas", "Carbohidratos");
	
	// public Alimentos (String nombre, int gramos, int caloria100Gramos, int caloriasTotales, List<String> nutrientes){
	//	this.nombre = nombre;
	//	this.gramos = gramos;
	//	this.caloria100Gramos = caloria100Gramos;
	//	this.CaloriasTotales = caloriasTotales;
	//	this.nutrientes= nutrientes;
	//}
	

	assertThat(nombre, is("pasta"));
	assertThat(gramos, is("100"));
	assertThat(caloriasTotales, is("200"))
	assertThat(nutrientes, contains("Proteinas", "Carbohidratos"));
}
