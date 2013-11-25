package AhorcadoTDD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Usuario {
	
	String UsuarioNombre;
	String UsuarioLogin;
	String UsuarioPassword;
	
	private static final String _REGISTRO_EXITOSO = "El Usuario se registro correctamente";
	private static final String _ERROR_LOGIN_REPETIDO = "El Id de Usuario (Login) ya se encuentra registrado";
	private static final String _INICIO_DE_SESION_EXITOSO = "Bienvenido Acaba De Iniciar Session";
	private static final String _ERROR_LOGIN_INCORRECTO = "Error: Login Incorrecto";
	private static final String _ERROR_PASSWORD_INCORRECTO = "Error: Password Incorrecto";
	
	public String RegistrarUsuario(String nombre, String login, String password) {
		
		UsuarioNombre = nombre;
		UsuarioLogin = login;
		UsuarioPassword = password;
		
		FileWriter fichero = null;
        PrintWriter pw = null;
	    String nuevoUsuario = UsuarioNombre + "|" + UsuarioLogin + "|" + UsuarioPassword;
        String mensaje = "";
        try
        {
        	if(ExisteLogin(UsuarioLogin))
        	{
	            mensaje = _ERROR_LOGIN_REPETIDO;
        	}
        	else
        	{
        		fichero = new FileWriter("usuarios.txt", true);
	            pw = new PrintWriter(fichero);
	            pw.println(nuevoUsuario);
	            mensaje = _REGISTRO_EXITOSO;
        	}
            
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

	private boolean ExisteLogin(String usuarioLogin) {
		  File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null; 
	      boolean ExisteLogin = false;
	 
	      try 
	      {
	         archivo = new File ("usuarios.txt");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         String linea = "";
	         
	         while((linea = br.readLine())!=null)
	        	 if(usuarioLogin.equals(getUserLogin(linea)))
	        	 {
	        		 ExisteLogin = true;
	        	 }
	      }catch (Exception e) {
	          e.printStackTrace();
	      } finally {
	         try {
	         if (null != fr)
	        	 fr.close();
	         } catch (Exception e2) {
	            e2.printStackTrace();
	         }
	      }
		  return ExisteLogin;
	}

	private String getUserLogin(String linea) {
		//ArrayList<String> datosUsuario = new ArrayList<String>();
		String[] datosUsuario = linea.split("\\|");
		return datosUsuario[1];
	}

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

	public String IniciarSesion(String login, String pass) {
		String mensaje = "";
		if(ExisteLogin(login))
		{
			if(ExistePassword(pass))
				mensaje = _INICIO_DE_SESION_EXITOSO;
			else
				mensaje = _ERROR_PASSWORD_INCORRECTO;
		}
		else
		{
			mensaje = _ERROR_LOGIN_INCORRECTO;
		}
		return mensaje;
	}

	private boolean ExistePassword(String pass) {
		File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null; 
	      boolean ExistePass = false;
	 
	      try 
	      {
	         archivo = new File ("usuarios.txt");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         String linea = "";
	         
	         while((linea = br.readLine())!=null)
	        	 if(pass.equals(getUserPassword(linea)))
	        	 {
	        		 ExistePass = true;
	        	 }
	      }catch (Exception e) {
	          e.printStackTrace();
	      } finally {
	         try {
	         if (null != fr)
	        	 fr.close();
	         } catch (Exception e2) {
	            e2.printStackTrace();
	         }
	      }
		  return ExistePass;
	}

	private String getUserPassword(String linea) {
		//ArrayList<String> datosUsuario = new ArrayList<String>();
		String[] datosUsuario = linea.split("\\|");
		return datosUsuario[2];
	}
	
	

}
