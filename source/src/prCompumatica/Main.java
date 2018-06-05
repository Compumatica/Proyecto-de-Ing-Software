package prCompumatica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		String username, password, email;
		String check;
		AsistenteDieta IA;
		boolean fin = false;
		Usuario user;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca nombre de usuario: ");
		username = br.readLine();
		System.out.println("Introduzca password: ");
		password = br.readLine();
		System.out.println("Introduzca email: ");
		email = br.readLine();
		user = new Usuario(username, password, email);
		// almacenar usuario en BD?
		while(!fin) {
			check = br.readLine();
			if(check.trim().equalsIgnoreCase("Fin")) {
				fin = true;
			}else if(check.trim().equalsIgnoreCase("dame dieta")){
				System.out.println("elaborando dieta...");
				//IA.hacerSugerencia(user);
			}
			
		}
	}

}
