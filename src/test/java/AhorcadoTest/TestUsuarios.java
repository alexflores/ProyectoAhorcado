package AhorcadoTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import AhorcadoTDD.Diccionario;
import AhorcadoTDD.Usuario;

public class TestUsuarios {

Usuario user;
	
	@Before
	public void initObjects()
	{
		user = new Usuario();
		user.LimpiarArchivoUsuarios();
	}
	
	@Test
	public void DevuelveUnMensajeDeExitoSiElUsuarioAhSidoRegistradoSatisfactoriamente() {
		//user.LimpiarArchivoUsuarios();
		user.NuevoUsuario("Pablo Alboran", "pablo", "pablo123");
		String mensajeDeExito = "El Usuario se registro correctamente";
		assertTrue(mensajeDeExito.equals(user.RegistrarUsuario()));
	}
	
	@Test
	public void DevuelveUnMensajeDeErrorSiElLoginYaSeEncuentraRegistrado()
	{
		user.NuevoUsuario("Pablo Alboran", "pablo", "pablo123");
		user.RegistrarUsuario();
		user.NuevoUsuario("Alejando Pablo Estrada", "pablo", "alejandro213");
		String mensajeDeError = "El Id de Usuario (Login) ya se encuentra registrado";
		assertTrue(mensajeDeError.equals(user.RegistrarUsuario()));
	}
	
	@Test
	public void SiElUsuarioEstaRegistradoAlIngresarLoginDevuelveUnMensajeDeInicioDeSession()
	{
		user.NuevoUsuario("Pablo Alboran", "pablo", "pablo123");
		user.RegistrarUsuario();
		String mensajeDeExito = "Bienvenido Acaba De Iniciar Session";
		assertTrue(mensajeDeExito.equals(user.IniciarSesion("pablo", "pablo123")));
	}
	

}
