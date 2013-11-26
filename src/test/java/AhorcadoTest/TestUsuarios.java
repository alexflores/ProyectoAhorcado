package AhorcadoTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
		user = new Usuario("Pablo Alboran", "pablo", "pablo123");
		String mensajeDeExito = "El Usuario se registro correctamente";
		assertTrue(mensajeDeExito.equals(user.RegistrarUsuario(user)));
	}
	
	@Test
	public void DevuelveUnMensajeDeErrorSiElLoginYaSeEncuentraRegistrado()
	{
		user = new Usuario("Pablo Alboran", "pablo", "pablo123");
		user.RegistrarUsuario(user);
		Usuario user2 = new Usuario("Pablo Alboran", "pablo", "pablo123");
		String mensajeDeError = "El Id de Usuario (Login) ya se encuentra registrado";
		assertTrue(mensajeDeError.equals(user.RegistrarUsuario(user2)));
	}
	
	@Test
	public void SiElUsuarioEstaRegistradoAlIngresarLoginDevuelveUnMensajeDeInicioDeSession()
	{
		user = new Usuario("Pablo Alboran", "pablo", "pablo123");
		user.RegistrarUsuario(user);
		String mensajeDeExito = "Bienvenido Acaba De Iniciar Session";
		assertTrue(mensajeDeExito.equals(user.IniciarSesion(user)));
	}
	
	@Test
	public void SiElUsuarioEstaRegistradoAlIngresarLoginIncorrectoDevuelveUnMensajeDeError()
	{
		user = new Usuario("Pablo Alboran", "pabloa", "pablo123");
		String mensajeDeExito = "Error: Login Incorrecto";
		assertTrue(mensajeDeExito.equals(user.IniciarSesion(user)));
	}
	
	@Test
	public void SiElUsuarioEstaRegistradoAlIngresarPasswordIncorrectoDevuelveUnMensajeDeError()
	{
		user = new Usuario("Pablo Alboran", "pabloa", "pablo123");
		user.RegistrarUsuario(user);
		Usuario user2 = new Usuario("Pablo Alboran", "pabloa", "pablo1234");
		String mensajeDeExito = "Error: Password Incorrecto";
		assertTrue(mensajeDeExito.equals(user.IniciarSesion(user2)));
	}
	
	@Test
	public void SiElUsuarioEstaRegistradoModificaSusDatosCorrectamenteRecibeUnMensajeExitoso()
	{
		user = new Usuario("Pablo Alboran", "pablo", "pablo123");
		user.RegistrarUsuario(user);
		Usuario nuevoUsuario = new Usuario("Pablo Pedro Paredes Alboran", "pablo", "pablo123");
		String msg = user.ModificarUsuario(user, nuevoUsuario);
		String mensajeDeExito = "Los cambios fueron guardados Exitosamente";
		assertTrue(mensajeDeExito.equals(msg));
	}
}
