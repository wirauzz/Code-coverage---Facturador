package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entidades.CDR;
import planes.IPlan;
import planes.PlanPostpago;
import tarifaciones.TarifacionFijaPorMinuto;

class TestPlanPostpago {
	

	@Test
	@DisplayName("Calcular costo de llamada")
	public void VerificarCalculoDeCosteDeCdr() {
		CDR cdr = new CDR(70743567,70765342,"10/10/19","07:14","00:51:00",2.2);
		IPlan planPostpago = new PlanPostpago();
		assertEquals(73.95, planPostpago.calcularCostoDeLlamada(new TarifacionFijaPorMinuto(), cdr),()->"El calculo de coste de llamada del plan postpago es erroneo");
	}
	
	@Test
	@DisplayName("Obtener el Nombre del plan")
	public void VerificarQueSeRetornaElNombeDelTipoDePlan(){
		IPlan planPostpago = new PlanPostpago();
		assertEquals("POSTPAGO", planPostpago.getTipoDePlan(),()->"El nombre del plan Postpago es diferente a POSTPAGO");
	}

}
