package prCompumatica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseDeDatos implements IBaseDeDatos{
	
	public static URL URL_LOGIN;
	public static URL URL_EMAIL_EXISTS;
	private final static String OK = "0";
	
	private Usuario usuario;
	
	public BaseDeDatos() {
		try {
			URL_LOGIN = new URL("http://compumatica.dx.am/login.php");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void registrarCuenta(String usuario, String clave, String email) {
		this.usuario = new Usuario(usuario, clave, email);
	}

	@Override
	public void eliminarCuenta(String campo, String clave, boolean campoEsEmail) {
		
	}

	@Override
	public boolean verificarCredenciales(String campo, String clave, boolean campoEsEmail) {
		return receiveEcho(URL_LOGIN, new Tupla("Nombre", campo), new Tupla("Clave", clave)).equals(OK);	
	}

	@Override
	public boolean existeEmail(String email) {
		return receiveEcho(URL_EMAIL_EXISTS).equals(OK);
	}

	@Override
	public void cambiarEmail(String usuario, String clave, String nuevoEmail) {
		
	}

	@Override
	public void cambiarClave(String usuario, String clave, String nuevaClave) {
		
	}
		
	private String receiveEcho(URL phpURL, Tupla ... pares) {
		String res = "";

		StringBuilder postData = new StringBuilder();

		for(Tupla p : pares) {
			postData.append("&" + p.s1() + "=" + p.s2());
		}
		//System.out.println(postData.toString()); // DEBUGGING
		HttpURLConnection conn;
			try {
			// Convert string to byte array, as it should be sent
			byte[] postDataBytes = postData.toString().getBytes("UTF-8");
				conn = (HttpURLConnection)phpURL.openConnection();
				System.out.println("conex");
			// Tell server that this is POST and in which format is the data
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
			conn.setDoOutput(true);
			conn.getOutputStream().write(postDataBytes);

			//System.out.println("Mandado"); // DEBUGGING
			// This gets the output from your server
			Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

			for (int c; (c = in.read()) >= 0;)
			    res += (char) c;

			//System.out.println(res); // DEBUGGING
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return res.trim();
	}
	
	class Tupla {
		String t1, t2;
		public Tupla(String t1, String t2) {
			this.t1 = t1;
			this.t2 = t2;
		}
		
		public String s1() {
			return t1;
		}
		
		public String s2() {
			return t2;
		}
		
		public void setS1(String s) {
			t1 = s;
		}
		
		public void setS2(String s) {
			t2 = s;
		}
	}
	
}
