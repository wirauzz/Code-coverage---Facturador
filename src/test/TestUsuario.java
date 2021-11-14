package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entidades.Usuario;
import planes.IPlan;
import planes.PlanPostpago;
import tarifaciones.ITarifacion;
import tarifaciones.TarifacionFijaPorMinuto;

class TestUsuario {
	@Test
	@DisplayName("Constructor")
	public void VerificarFuncionamientoDelConstructor() {
		Usuario usuario= new Usuario("Juan Judas",1324561203,83925956);
		assertNotNull(usuario,"No se instancio el objeto Usuario");
		assertEquals( "Juan Judas",usuario.getNombre(),"Error setear el Nombre de usuario en el contructor");
		assertEquals(83925956, usuario.getNumeroTelefonoMovil(),"Error setear el numero de telefono de Usuario en el contructor");
		assertEquals(1324561203, usuario.getCi(),"Error setear el Ci de Usuario en el contructor");
	}
	
	/*@Test
	@DisplayName("Obtener nombre")
	public void ObtnerNombre() {
		Usuario usuario= new Usuario("Juan Judas",1324561203,83925956);
		assertEquals( "Juan Judas",usuario.getNombre(),"Error al obtener el Nombre de Usuario");
	}
	
	@Test
	@DisplayName("Obtener Ci")
	public void ObtnerCi() {
		Usuario usuario= new Usuario("Juan Judas",1324561203,83925956);
		assertEquals(1324561203, usuario.getCi(),"Error al obtener el Ci de Usuario");
	}
	
	@Test
	@DisplayName("Obtener Numero de telefono")
	public void ObtnerNumeroDeTelefono() {
		Usuario usuario= new Usuario("Juan Judas",1324561203,83925956);
		assertEquals(83925956, usuario.getNumeroTelefonoMovil(),"Error al obtener el Numero de Telefono de Usuario");
	}*/
	
	@Test
	@DisplayName("Seteo de plan de pago")
	public void VerificarSeteoDePlanDePago() {
		Usuario usuario= new Usuario("Juan Judas",1324561203,83925956);
		IPlan plan = new PlanPostpago();
		usuario.setPlan(plan);
		assertNotNull(usuario.getPlan(),"No se seteo el plan de pago");
		assertEquals("POSTPAGO", usuario.getPlan().getTipoDePlan(),"Se obtuvo un plan de pago erroneo");
	}
	
	@Test
	@DisplayName("Seteo de tipo de tarifacion")
	public void VerificarSeteoDeTipoDeTarifacion() {
		Usuario usuario= new Usuario("Juan Judas",1324561203,83925956);
		ITarifacion tarifacion = new TarifacionFijaPorMinuto();
		usuario.setTarifacion(tarifacion);
		assertEquals("FIJA POR MINUTO", usuario.getTarifacion().getTipoDeTarifacion(),"No se seteo la tarifacion fija por minuto");
		assertNotNull(usuario.getTarifacion(),"No se seteo la tarifacion");
	}

	@Test
	@DisplayName("Seteo de Nombre")
	public void VerificarSeteoDeNombreDeUsuario() {
		Usuario usuario= new Usuario("Juan Judas",1324561203,83925956);
		usuario.setNombre("Marcelo Pedraza");
		assertEquals("Marcelo Pedraza", usuario.getNombre(),"No se seteo el nuevo nombre de usuario");
		
	}
	@Test
	@DisplayName("Seteo de CI de usuario")
	public void VerificarSeteoDeCiDeUsuario() {
		Usuario usuario= new Usuario("Juan Judas",1324561203,83925956);
		usuario.setCi(243567231);
		assertEquals(243567231, usuario.getCi(),"No se seteo el nuevo ci de usuario");
		
	}
	@Test
	@DisplayName("Seteo de Numero de telefono de usuario")
	public void VerificarSeteoDeNumeroDeTelefonoDeUsuario() {
		Usuario usuario= new Usuario("Juan Judas",1324561203,83925956);
		usuario.setNumeroTelefonoMovil(243567231);
		assertEquals(243567231, usuario.getNumeroTelefonoMovil(),"No se seteo el nuevo numero de telefono de usuario");
		
	}
}
