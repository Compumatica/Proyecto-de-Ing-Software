/*
  Historial:
   - 11-04-2018: Creado por Manuel López Reviriego
   - 24-04-2018: Editado por Meead y Alejandro
*/
public interface IBaseDeDatos {
	
	
	void registrarCuenta(String usuario, String clave, String email);
	
	
	void eliminarCuenta(String campo, String clave, boolean campoEsEmail);
	

	boolean verificarCredenciales(String campo, String clave, boolean campoEsEmail);
	
	
	boolean existeEmail(String email);

    
	void cambiarEmail(String usuario, String clave, String nuevoEmail);

	
	void cambiarClave(String usuario, String clave, String nuevaClave);
	
}
