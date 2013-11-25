package AhorcadoTDD;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Usuario {
	
	String UsuarioNombre;
	String UsuarioLogin;
	String UsuarioPassword;
	
	private static final String _REGISTRO_EXITOSO = "El Usuario se registro correctamente";
	
	public void NuevoUsuario(String nombre, String login, String password)
	{
		UsuarioNombre = nombre;
		UsuarioLogin = login;
		UsuarioPassword = password;
	}
	
	public String RegistrarUsuario(Usuario user) {
		
		FileWriter fichero = null;
        PrintWriter pw = null;
	    String nuevoUsuario = user.UsuarioNombre + "|" + user.UsuarioLogin + "|" + user.UsuarioPassword;
        String mensaje = "";
        try
        {
        	fichero = new FileWriter("Usuarios.txt", true);
            pw = new PrintWriter(fichero);
            pw.println(nuevoUsuario.toLowerCase());
            mensaje = _REGISTRO_EXITOSO;
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        return mensaje;
	}
	
	

}
