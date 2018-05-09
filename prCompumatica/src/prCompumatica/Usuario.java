package prCompumatica;

public class Usuario {
	private String usuario;
	private String contraseña;
	private String email;
	
	public Usuario(String usuario, String contraseña, String email){
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.email = email;
		Datos.RegistraUsuario(usuario, contraseña, email);
	}
	
	public String consultarDatosPersonales() {
		return Datos.datosPersonales(usuario);
	}
	
	public String consultarDatosSobreDietas() {
		return Datos.datosDietas(usuario);
	}
	
	public String modificarDatos() {
		return Datos.modificaDatosPersonales(usuario);
	}
	
	public void darOpinion(String texto) {
		Opinion op = new Opinion(texto);
		Opinion.mandarOpinion(op);
	}
	
	public String pedirDieta() {
		return AsistenteDieta.hacerSugerencia(usuario);
	}
}
