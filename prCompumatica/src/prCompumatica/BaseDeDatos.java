package prCompumatica;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class BaseDeDatos implements IBaseDeDatos{
	
	public final static URL URL_LOGIN = new URL("");
	public final static URL URL_EMAIL_EXISTS = new URL("");
	private final static String OK = "0";
	
	private Usuario usuario;
	private boolean existe = false;
	
	@Override
	public void registrarCuenta(String usuario, String clave, String email) {
		usuario = new Usuario(usuario, clave, email);
	}

	@Override
	public void eliminarCuenta(String campo, String clave, boolean campoEsEmail) {
		
	}

	@Override
	public boolean verificarCredenciales(String campo, String clave, boolean campoEsEmail) {
		return getEcho(URL_LOGIN).equals(OK);	
	}

	@Override
	public boolean existeEmail(String email) {
		return getEcho(URL_EMAIL_EXISTS).equals(OK);
	}

	@Override
	public void cambiarEmail(String usuario, String clave, String nuevoEmail) {
		
	}

	@Override
	public void cambiarClave(String usuario, String clave, String nuevaClave) {
		
	}
	
	private String getEcho(URL phpURL) {
		String res = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(phpURL.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            res = inputLine;
        in.close();
        return res.trim();
	}

}
