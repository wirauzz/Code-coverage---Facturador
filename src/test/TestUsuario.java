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
		assertAll("Pruebas a pasar",
		() -> assertNotNull(usuario),
		() -> assertEquals( "Juan Judas",usuario.getNombre()),
		() -> assertEquals(83925956, usuario.getNumeroTelefonoMovil()),
		() ->assertEquals(1324561203, usuario.getCi())	
		);
		
	}
	
	
	@Test
	@DisplayName("Seteo de plan de pago")
	public void VerificarSeteoDePlanDePago() {
		Usuario usuario= new Usuario("Juan Judas",1324561203,83925956);
		IPlan plan = new PlanPostpago();
		usuario.setPlan(plan);
		assertAll("Pruebas a pasar",
		() -> assertNotNull(usuario.getPlan()),
		() -> assertEquals("POSTPAGO", usuario.getPlan().getTipoDePlan())
		);
		
	}
	
	@Test
	@DisplayName("Seteo de tipo de tarifacion")
	public void VerificarSeteoDeTipoDeTarifacion() {
		Usuario usuario= new Usuario("Juan Judas",1324561203,83925956);
		ITarifacion tarifacion = new TarifacionFijaPorMinuto();
		usuario.setTarifacion(tarifacion);
		assertEquals("FIJA POR MINUTO", usuario.getTarifacion().getTipoDeTarifacion());
		assertNotNull(usuario.getTarifacion());
	}

	@Test
	@DisplayName("Seteo de Nombre")
	public void VerificarSeteoDeNombreDeUsuario() {
		Usuario usuario= new Usuario("Juan Judas",1324561203,83925956);
		usuario.setNombre("Marcelo Pedraza");
		assertEquals("Marcelo Pedraza", usuario.getNombre());
		
	}
	@Test
	@DisplayName("Seteo de CI de usuario")
	public void VerificarSeteoDeCiDeUsuario() {
		Usuario usuario= new Usuario("Juan Judas",1324561203,83925956);
		usuario.setCi(243567231);
		assertEquals(243567231, usuario.getCi());
		
	}
	@Test
	@DisplayName("Seteo de Numero de telefono de usuario")
	public void VerificarSeteoDeNumeroDeTelefonoDeUsuario() {
		Usuario usuario= new Usuario("Juan Judas",1324561203,83925956);
		usuario.setNumeroTelefonoMovil(243567231);
		assertEquals(243567231, usuario.getNumeroTelefonoMovil());
		
	}
}
