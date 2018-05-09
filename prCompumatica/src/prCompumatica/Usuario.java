package prCompumatica;

public class Usuario {
	private String usuario;
	private String contrase�a;
	private String email;
	
	public Usuario(String usuario, String contrase�a, String email){
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		this.email = email;
		Datos.RegistraUsuario(usuario, contrase�a, email);
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
