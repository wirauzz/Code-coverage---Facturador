package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entidades.CDR;
import planes.IPlan;
import planes.PlanPostpago;
import tarifaciones.ITarifacion;
import tarifaciones.TarifacionFijaPorMinuto;

class TestTarifacionFijaPorMinuto {

	@Test
	@DisplayName("Calcular costo con tarifacion fija por minuto")
	public void VerificarCalculoDeCosteDeCdr() {
		CDR cdr = new CDR(70743567,70765342,"10/10/19","07:14","00:1:00",2.2);
		IPlan planPostpago = new PlanPostpago();
		assertEquals(1.45, planPostpago.calcularCostoDeLlamada(new TarifacionFijaPorMinuto(), cdr),()->"El calculo de coste de llamada por tarifacion fija por minuto no es correcto");
	}
	
	@Test
	@DisplayName("Seteo de nueva tarifa por minuto")
	public void VerificarSeteoDeNuevaTarifaPorMinuto() {
		CDR cdr = new CDR(70743567,70765342,"10/10/19","07:14","00:1:00",2.2);
		IPlan planPostpago = new PlanPostpago();
		ITarifacion tarifacion = new TarifacionFijaPorMinuto();
		((TarifacionFijaPorMinuto) tarifacion).establecerMontoDeTarifaFijaPorMinuto(4.0);
		assertEquals(4.00, planPostpago.calcularCostoDeLlamada(tarifacion, cdr),()->"El calculo de coste de llamada por tarifacion fija por minuto no es correcto");
	}
	
	@Test
	@DisplayName("Obtener el Nombre del tipo de tarifacion")
	public void VerificarQueSeRetornaElNombeDelTipoDeTarifacion(){
		ITarifacion tarifacion= new TarifacionFijaPorMinuto();
		assertEquals("FIJA POR MINUTO", tarifacion.getTipoDeTarifacion(),()->"No se retorno el nombre del tipo de tarifacion fija por minuto");
	}
	
	@Test
	@DisplayName("Contructor de tarifacion fija por minuto")
	public void VerificarFuncionamientoDelContructorDeTarifacionFijaPorMinuto(){
		ITarifacion tarifacion= new TarifacionFijaPorMinuto();
		assertNotNull(tarifacion,()->"No se creo una instancia de tarifacion fija por minuto");
	}


}
