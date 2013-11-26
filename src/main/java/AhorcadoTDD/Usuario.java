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
	private static final String _INICIO_DE_SESION_EXITOSO = "Bienvenido Acaba De Iniciar Session";
	private static final String _MODIFICAR_USUARIO_EXITOSO = "Los cambios fueron guardados Exitosamente";
	private static final String _ERROR_LOGIN_REPETIDO = "El Id de Usuario (Login) ya se encuentra registrado";
	private static final String _ERROR_LOGIN_INCORRECTO = "Error: Login Incorrecto";
	private static final String _ERROR_PASSWORD_INCORRECTO = "Error: Password Incorrecto";
	private static final String _ERROR_MODIFICAR_USUARIO = "Error: No se pudo guardar los cambios realizados";
	
	
	public Usuario()
	{
		this.UsuarioNombre = "";
		this.UsuarioLogin = "";
		this.UsuarioPassword = "";
	}
	
	public Usuario (String usuarioNombre, String usuarioLogin, String usuarioPassword)
	{
		this.UsuarioNombre = usuarioNombre;
		this.UsuarioLogin = usuarioLogin;
		this.UsuarioPassword = usuarioPassword;
	}
	
	public String RegistrarUsuario(Usuario user) {
		
		FileWriter fichero = null;
        PrintWriter pw = null;
	    String nuevoUsuario = user.UsuarioNombre + "|" + user.UsuarioLogin + "|" + user.UsuarioPassword;
        String mensaje = "";
        try
        {
        	if(ExisteLogin(user.UsuarioLogin))
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

	public String IniciarSesion(Usuario user) {
		String mensaje = "";
		if(ExisteLogin(user.UsuarioLogin))
		{
			if(ExistePassword(user.UsuarioPassword))
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
	
		String[] datosUsuario = linea.split("\\|");
		return datosUsuario[2];
	}

	public String ModificarUsuario(Usuario antiguoUsuario, Usuario nuevoUsuario) {
		PrintWriter pw = null;
		ArrayList<String> ListaUsuarios = new ArrayList<String>();
		String mensaje = _ERROR_MODIFICAR_USUARIO;
		ListaUsuarios = OtenerListaDeUsuarios();
		System.out.println(ListaUsuarios.size());
        try
        {
            pw = new PrintWriter(new FileWriter("usuarios.txt"));
            for(int i=0; i<=ListaUsuarios.size()-1; i++)
            {
            	if(antiguoUsuario.UsuarioLogin.equals(getUserLogin(ListaUsuarios.get(i)))&&	 
    	 	       antiguoUsuario.UsuarioPassword.equals(getUserPassword(ListaUsuarios.get(i))))
    	        {
            		pw.println(nuevoUsuario.UsuarioNombre+"|"+nuevoUsuario.UsuarioLogin+"|"+nuevoUsuario.UsuarioPassword);
            		mensaje = _MODIFICAR_USUARIO_EXITOSO;
    	        }
            	else
            	{
            		pw.println(ListaUsuarios.get(i));
            	}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
           try {
           if (null!=pw)
        	   pw.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        return mensaje;
	}
	
	public ArrayList<String> OtenerListaDeUsuarios()
	{
		BufferedReader br = null; 
		ArrayList<String> ListaDeUsuarios = new ArrayList<String>();
        String linea = "";
         
        try
        {
	        br = new BufferedReader(new FileReader ("usuarios.txt"));
            while((linea = br.readLine())!=null)
            {
            	ListaDeUsuarios.add(linea);
            }
        } 
        catch (Exception e) {
        	System.out.println();
        	System.out.println("Entraste al catch");
            e.printStackTrace();
        }finally {
            try {
                if (null!=br)
                	br.close();
                	  // ficheroWriter.close();
                } catch (Exception e2) {
                   e2.printStackTrace();
                }
             }
        return ListaDeUsuarios;
	}
}
