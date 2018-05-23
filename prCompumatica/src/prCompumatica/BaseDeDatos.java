package prCompumatica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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
	
	private String sendEcho(URL phpURL, Tupla ... pares) {
		 try {
	            // open a connection to the site
	            URLConnection con = phpURL.openConnection();
	            // activate the output
	            con.setDoOutput(true);
	            PrintStream ps = new PrintStream(con.getOutputStream());
	            // send your parameters to your site
	            for(Tupla p : pares) {
	            	ps.print("&" + p.s1() + "=" + p.s2());
	            }

	            // we have to get the input stream in order to actually send the request
	            con.getInputStream();

	            // close the print stream
	            ps.close();
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
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
			return t1;
		}
		
		public void setS1(String s) {
			t1 = s;
		}
		
		public void setS2(String s) {
			t2 = s;
		}
	}
	
}
