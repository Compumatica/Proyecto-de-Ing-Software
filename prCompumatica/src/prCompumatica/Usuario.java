package prCompumatica;

import java.util.Arrays;
import java.util.List;

public class Usuario {
	private String usuario;
	private String contraseña;
	private String email;
	
	private Sexo sexo;
	
	private List<Alergeno> alergenos;
	private List<Alimento> alimentosVetados;
	
	/**
	 * 
	 * @param usuario
	 * @param contraseña
	 * @param email
	 */
	public Usuario(String usuario, String contraseña, String email){
		this(usuario, contraseña, email, Sexo.INDETERMINADO);
	}
	
	public Usuario(String usuario, String contraseña, String email, Sexo sexo){
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.email = email;
		this.sexo = sexo;
		Datos.RegistraUsuario(this);
	}
	
	public void setAlergenos(Alergeno...alergenos) {
		this.alergenos = Arrays.asList(alergenos);
	}
	
	public void vetarAlimentos(Alimento...alimentos) {
		this.alimentosVetados = Arrays.asList(alimentos);
	}
	
	public List<Alergeno> getAlergenos(){
		return alergenos;
	}
	
	public List<Alimento> getAlimentosVetados(){
		return alimentosVetados;
	}
	
	public String consultarDatosPersonales() {
		return Datos.datosPersonales(this);
	}
	
	public String consultarDatosSobreDietas() {
		return Datos.datosDietas(this);
	}
	
	public String modificarDatos() {
		return Datos.modificaDatosPersonales(this);
	}
	
	public void darOpinion(String texto) {
		//Opinion op = new Opinion(texto);
		//Opinion.mandarOpinion(op);
	}
	
	public String pedirDieta() {
		//return AsistenteDieta.hacerSugerencia(usuario);
		return "";
	}
}
