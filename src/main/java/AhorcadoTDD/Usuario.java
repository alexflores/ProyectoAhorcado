package AhorcadoTDD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Usuario {
	
	public int UsuarioId;
	String UsuarioNombre;
	String UsuarioLogin;
	String UsuarioPassword;
	ArrayList<String> ListaDeUsuarios = ObtenerListaDeUsuarios();
	
	private static final String _REGISTRO_EXITOSO = "El Usuario se registro correctamente";
	private static final String _INICIO_DE_SESION_EXITOSO = "Bienvenido Acaba De Iniciar Session";
	private static final String _MODIFICAR_USUARIO_EXITOSO = "Los cambios fueron guardados Exitosamente";
	private static final String _ERROR_LOGIN_REPETIDO = "El Id de Usuario (Login) ya se encuentra registrado";
	private static final String _ERROR_LOGIN_INCORRECTO = "Error: Login Incorrecto";
	private static final String _ERROR_PASSWORD_INCORRECTO = "Error: Password Incorrecto";
	private static final String _ERROR_MODIFICAR_USUARIO = "Error: No se pudo guardar los cambios realizados";
	
	public Usuario()
	{
		this.UsuarioId = -1;
		this.UsuarioNombre = "";
		this.UsuarioLogin = "";
		this.UsuarioPassword = "";
	}
	
	public Usuario (String usuarioNombre, String usuarioLogin, String usuarioPassword)
	{
		this.UsuarioId = -1;
		this.UsuarioNombre = usuarioNombre;
		this.UsuarioLogin = usuarioLogin;
		this.UsuarioPassword = usuarioPassword;
	}
	
	// Metodos privadossss ..........................
	
	public ArrayList<String> ObtenerListaDeUsuarios() {
	      BufferedReader br = null; 
	      ArrayList<String> UserList = new ArrayList<String>();
	      String linea = "";
	      try {
	         br = new BufferedReader(new FileReader (new File ("usuarios.txt")));
	         while((linea = br.readLine())!=null)
	        	 UserList.add(linea);
	      }
	      catch (Exception e) {
	          e.printStackTrace();
	      } 
	      finally {
	         try {
		         if (null != br)
		        	 br.close();
	         } 
	         catch (Exception e2) {
	            e2.printStackTrace();
	         }
	      }
		  return UserList;
	}
	
	private void GuardarListaDeUsuarios(ArrayList<String> Usuarios) {
		LimpiarArchivoUsuarios();
		PrintWriter pw = null;
        try{
        	pw = new PrintWriter(new FileWriter("usuarios.txt", true));
    		for(int i=0; i<Usuarios.size(); i++)
    		{
    			pw.println(Usuarios.get(i));
    		}
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
           try {
	           if (null != pw)
	        	   pw.close();
           } 
           catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	
	private String GenerarIdUsuario() {
		return Integer.toString(ListaDeUsuarios.size()+1);
	}

	private boolean ExisteLogin(String usuarioLogin) {
	      boolean ExisteLogin = false;
	      for(int i=0; i<ListaDeUsuarios.size(); i++)
	      {
	    	  if(usuarioLogin.equals(getUserLogin(ListaDeUsuarios.get(i))))
	    		  ExisteLogin = true;
	      }
		  return ExisteLogin;
	}

	private boolean ExistePassword(String pass) {
	      boolean ExistePass = false;
	      for(int i=0; i<ListaDeUsuarios.size(); i++)
	      {
	    	  if(pass.equals(getUserPassword(ListaDeUsuarios.get(i))))
	    		  ExistePass = true;
	      }
		  return ExistePass;
	}
	
	private int getUserId(String linea) {
		String[] datosUsuario = linea.split("\\|");
		return Integer.parseInt(datosUsuario[0]);
	}

	private String getUserNombre(String linea) {
		String[] datosUsuario = linea.split("\\|");
		return datosUsuario[1];
	}
	
	private String getUserLogin(String linea) {
		String[] datosUsuario = linea.split("\\|");
		return datosUsuario[2];
	}
	
	private String getUserPassword(String linea) {
		String[] datosUsuario = linea.split("\\|");
		return datosUsuario[3];
	}
	
	// Metodos Publicoss........
	
	public boolean LimpiarArchivoUsuarios() {
		
		boolean resp = false;
		File fichero = new File("usuarios.txt");
		if (fichero.delete())
		{
			try {
				  if (fichero.createNewFile())
				    resp = true;
				} catch (IOException ioe) {
				  ioe.printStackTrace();
				}
		}	 
		return resp;
	}

	public String RegistrarUsuario(Usuario user) {
		String mensaje = "";
    	if(ExisteLogin(user.UsuarioLogin)){
            mensaje = _ERROR_LOGIN_REPETIDO;
    	}
    	else{
    		String idUsuario = GenerarIdUsuario();
    	    String nuevoUsuario = idUsuario + "|" + user.UsuarioNombre + "|" + user.UsuarioLogin + "|" + user.UsuarioPassword;
    	    ListaDeUsuarios.add(nuevoUsuario);
    		GuardarListaDeUsuarios(ListaDeUsuarios);
            mensaje = _REGISTRO_EXITOSO;
    	}
        return mensaje;
	}
	
	public String IniciarSesion(Usuario user) {
		String mensaje = "";
		if(ExisteLogin(user.UsuarioLogin)){
			if(ExistePassword(user.UsuarioPassword))
				mensaje = _INICIO_DE_SESION_EXITOSO;
			else
				mensaje = _ERROR_PASSWORD_INCORRECTO;
		}
		else{
			mensaje = _ERROR_LOGIN_INCORRECTO;
		}
		return mensaje;
	}
	
	public Usuario ObtenerUsuarioPorLoginYPassword(Usuario user)
	{
	      Usuario usuario = new Usuario();
	      String linea = "";
	      for(int i=0; i<ListaDeUsuarios.size(); i++)
	      {
	    	  linea = ListaDeUsuarios.get(i);
	    	  if(user.UsuarioPassword.equals(getUserPassword(linea))&&user.UsuarioLogin.equals(getUserLogin(linea))){
	    		  usuario.UsuarioId = getUserId(linea);
	    		  usuario.UsuarioNombre = getUserNombre(linea);
	    		  usuario.UsuarioLogin = getUserLogin(linea);
	    		  usuario.UsuarioPassword = getUserPassword(linea);
	    	  }
	      }
		  return usuario;
	}

	public String ModificarUsuario(Usuario nuevoUsuario) {
		String mensaje = _ERROR_MODIFICAR_USUARIO;
		if(nuevoUsuario.UsuarioId>0&&nuevoUsuario.UsuarioId<=ListaDeUsuarios.size()){
			String newUser = nuevoUsuario.UsuarioId +"|"+ nuevoUsuario.UsuarioNombre +"|"+ nuevoUsuario.UsuarioLogin +"|"+ nuevoUsuario.UsuarioPassword;
			ListaDeUsuarios.set(nuevoUsuario.UsuarioId-1, newUser);
			mensaje = _MODIFICAR_USUARIO_EXITOSO;
		}
        return mensaje;
	}
	
	
}
