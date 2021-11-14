package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entidades.FabricaDePlanesYTarifas;
import planes.IPlan;
import tarifaciones.ITarifacion;

class TestFabricaDePlanesYTarifas {

	@Test
	@DisplayName("La fabrica retorna una instancia del Plan Prepago")
	public void VerificarElRetornoDeUnaInstanciaDePlanPrepago(){
		FabricaDePlanesYTarifas fabrica= new FabricaDePlanesYTarifas();
		IPlan plan = fabrica.getPlan("PREPAGO");
		assertNotNull(plan,"No se obtuvo la instancia de Plan Prepago");
		assertEquals("PREPAGO", plan.getTipoDePlan(),"Se obtuvo una instancia de Plan pero no del Plan Prepago");
	}
	
	@Test
	@DisplayName("La fabrica retorna una instancia del Plan Postpago")
	public void VerificarElRetornoDeUnaInstanciaDePlanPostpago(){
		FabricaDePlanesYTarifas fabrica= new FabricaDePlanesYTarifas();
		IPlan plan = fabrica.getPlan("POSTPAGO");
		assertNotNull(plan,"No se obtuvo la instancia de Plan Postpago");
		assertEquals("POSTPAGO", plan.getTipoDePlan(),"Se obtuvo una instancia de Plan pero no del Plan Postpago");
	}
	
	@Test
	@DisplayName("La fabrica retorna una instancia del Plan Wow")
	public void VerificarElRetornoDeUnaInstanciaDePlanWow(){
		FabricaDePlanesYTarifas fabrica= new FabricaDePlanesYTarifas();
		IPlan plan = fabrica.getPlan("WOW");
		assertNotNull(plan,"No se obtuvo la instancia de Plan Wow");
		assertEquals("WOW", plan.getTipoDePlan(),"Se obtuvo una instancia de Plan pero no del Plan Wow");
	}
	
	@Test
	@DisplayName("La fabrica retorna NULL al tratar de obtener un plan inexistente")
	public void VerificarElRetornoDeNullAlTratarDeObtenerUnPlanInexistente(){
		FabricaDePlanesYTarifas fabrica= new FabricaDePlanesYTarifas();
		assertNull(fabrica.getPlan("asd"));
	}

	@Test
	@DisplayName("La fabrica retorna una instancia de Tarificacion diferenciada por horario")
	public void VerificarElRetornoDeUnaInstanciaDeTarificacionDiferenciadaPorHorario(){
		FabricaDePlanesYTarifas fabrica= new FabricaDePlanesYTarifas();
		ITarifacion tarificacion = fabrica.getTarifacion("DIFERENCIADA POR HORARIO");
		assertNotNull(tarificacion,"No se obtuvo la instancia de Tarificacion diferenciada por horario");
		assertEquals("DIFERENCIADA POR HORARIO", tarificacion.getTipoDeTarifacion(),"Se obtuvo una instancia de Tarificacion erronea");
	}
	
	@Test
	@DisplayName("La fabrica retorna una instancia de Tarificacion fija por minuto")
	public void VerificarElRetornoDeUnaInstanciaDeTarificacionFijaPorMinuto(){
		FabricaDePlanesYTarifas fabrica= new FabricaDePlanesYTarifas();
		ITarifacion tarificacion = fabrica.getTarifacion("FIJA POR MINUTO");
		assertNotNull(tarificacion,"No se obtuvo la instancia de Tarificacion fija por minuto");
		assertEquals("FIJA POR MINUTO",tarificacion.getTipoDeTarifacion(),"Se obtuvo una instancia de Tarificacion erronea");
	}
	
	@Test
	@DisplayName("La fabrica retorna NULL al tratar de obtener un Tipo de tarificacion inexistente")
	public void VerificarElRetornoDeNullAlTratarDeObtenerUnTipoDeTarificacionInexistenet(){
		FabricaDePlanesYTarifas fabrica= new FabricaDePlanesYTarifas();
		assertNull(fabrica.getTarifacion("asd"));
	}
	

}
