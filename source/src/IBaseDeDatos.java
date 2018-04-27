/*
  Historial:
   - 11-04-2018: Creado por Manuel López Reviriego
*/
public interface IBaseDeDatos {
	
	/** Crea una cuenta en la base de datos, siempre y cuando el usuario no exista, y
	*  {@code usuario}, {@code password} y {@code email} sean válidos.
	*  @exception UsuarioExisteException (nombre no definitivo)
	*  @exception FormatoNoValidoException (nombre no definitivo)
	*  @author Manuel López Reviriego
	*  @date 11-04-2018
	*  @since 0.1
	*/
	void registrarCuenta(String usuario, String clave, String email);
	
	/** Elimina una cuenta en la base de datos, siempre y cuando el usuario exista y la clave
	*  sea correcta.
	*  @param campoEsEmail Será {@code true} si el {@code campo} representa un email. Si es {@code false}, entonces
	*  representará un nombre de usuario.
	*  @exception CredencialesIncorrectasException (nombre no definitivo)
	*  @author Manuel López Reviriego
	*  @date 11-04-2018
	*  @since 0.1
	*/
	void eliminarCuenta(String campo, String clave, boolean campoEsEmail);
	
	/** Comprueba si el usuario está registrado con dicha clave.
	*  @param campoEsEmail Será {@code true} si el {@code campo} representa un email. Si es {@code false}, entonces
	*  representará un nombre de usuario.
	*  @exception UsuarioNoExisteException (nombre no definitivo)
	*  @exception EmailNoAsignadoException (nombre no definitivo)
	*  @author Manuel López Reviriego
	*  @date 11-04-2018
	*  @since 0.1
	*/
	boolean verificarCredenciales(String campo, String clave, boolean campoEsEmail);
	
	/** Comprueba si existe un usuario que se ha registrado con el correo {@code email}.
	*  @author Manuel López Reviriego
	*  @date 11-04-2018
	*  @since 0.1
	*/
	boolean existeEmail(String email);

        /** Si las credenciales son correctas, se asignará un nuevo correo al usuario (reemplazando el anterior).
     	*  @exception CredencialesIncorrectasException (nombre no definitivo)
     	*  @exception FormatoNoValidoException (nombre no definitivo)
   	*  @author Manuel López Reviriego
   	*  @date 11-04-2018
   	*  @since 0.1
        */
	void cambiarEmail(String usuario, String clave, String nuevoEmail);

	/** Si las credenciales son correctas, se asignará un nueva contraseña al usuario (reemplazando la anterior).
	*  @exception CredencialesIncorrectasException (nombre no definitivo)
     	*  @exception FormatoNoValidoException (nombre no definitivo)
	*  @author Manuel López Reviriego
	*  @date 11-04-2018
	*  @since 0.1
	*/
	void cambiarClave(String usuario, String clave, String nuevaClave);
	
}