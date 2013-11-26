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
		String mensajeDeExito = "El Usuario se registro correctamente";
		assertTrue(mensajeDeExito.equals(user.RegistrarUsuario("Pablo Alboran", "pablo", "pablo123")));
	}
	
	@Test
	public void DevuelveUnMensajeDeErrorSiElLoginYaSeEncuentraRegistrado()
	{
		user.RegistrarUsuario("Pablo Alboran", "pablo", "pablo123");
		String mensajeDeError = "El Id de Usuario (Login) ya se encuentra registrado";
		assertTrue(mensajeDeError.equals(user.RegistrarUsuario("Pablo Alboran", "pablo", "pablo123")));
	}
	
	@Test
	public void SiElUsuarioEstaRegistradoAlIngresarLoginDevuelveUnMensajeDeInicioDeSession()
	{
		user.RegistrarUsuario("Pablo Alboran", "pablo", "pablo123");
		String mensajeDeExito = "Bienvenido Acaba De Iniciar Session";
		assertTrue(mensajeDeExito.equals(user.IniciarSesion("pablo", "pablo123")));
	}
	
	@Test
	public void SiElUsuarioEstaRegistradoAlIngresarLoginIncorrectoDevuelveUnMensajeDeError()
	{
		user.RegistrarUsuario("Pablo Alboran", "pablo", "pablo123");
		String mensajeDeExito = "Error: Login Incorrecto";
		assertTrue(mensajeDeExito.equals(user.IniciarSesion("pabloa", "pablo123")));
	}
	
	@Test
	public void SiElUsuarioEstaRegistradoAlIngresarPasswordIncorrectoDevuelveUnMensajeDeError()
	{
		user.RegistrarUsuario("Pablo Alboran", "pablo", "pablo123");
		String mensajeDeExito = "Error: Password Incorrecto";
		assertTrue(mensajeDeExito.equals(user.IniciarSesion("pablo", "pablo1234")));
	}
	
	

}
