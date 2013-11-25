package AhorcadoTDD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Usuario {
	
	String UsuarioNombre;
	String UsuarioLogin;
	String UsuarioPassword;
	
	private static final String _REGISTRO_EXITOSO = "El Usuario se registro correctamente";
	private static final String _ERROR_LOGIN_REPETIDO = "El Id de Usuario (Login) ya se encuentra registrado";
	
	public void NuevoUsuario(String nombre, String login, String password)
	{
		UsuarioNombre = nombre;
		UsuarioLogin = login;
		UsuarioPassword = password;
	}
	
	public String RegistrarUsuario() {
		
		FileWriter fichero = null;
        PrintWriter pw = null;
	    String nuevoUsuario = UsuarioNombre + "|" + UsuarioLogin + "|" + UsuarioPassword;
        String mensaje = "";
        try
        {
        	if(LoginRepetido(UsuarioLogin))
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

	private boolean LoginRepetido(String usuarioLogin) {
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
	
	

}
