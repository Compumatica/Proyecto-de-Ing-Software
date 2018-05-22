package prCompumatica;

public class Usuario {
	private String usuario;
	private String password;
	private String email;
	
	public Usuario(String usuario, String password, String email){
		this.usuario = usuario;
		this.password = password;
		this.email = email;
		Datos.registraUsuario(usuario, password, email);
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
		//falta implementar un constructor para la clase Datos
		Datos datos = null;
		op.mandarOpinion(datos);
	}
	
	public String pedirDieta() {
		return AsistenteDieta.hacerSugerencia(usuario);
	}
}
