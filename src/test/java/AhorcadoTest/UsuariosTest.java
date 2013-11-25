package AhorcadoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import AhorcadoTDD.Usuario;

public class UsuariosTest {

	@Test
	public void DevuelveUnMensajeDeExitoSiElUsuarioAhSidoRegistradoSatisfactoriamente() {
		Usuario user = new Usuario();
		user.NuevoUsuario("Pablo Alboran", "pablo", "pablo123");
		String mensajeDeExito = "El Usuario se registro correctamente";
		assertTrue(mensajeDeExito.equals(user.RegistrarUsuario(user)));
	}

}
