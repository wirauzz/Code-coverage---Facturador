package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import entidades.CDR;
import planes.IPlan;
import planes.PlanPrepago;
import tarifaciones.ITarifacion;
import tarifaciones.TarifacionFijaPorMinuto;

class TestPlanPrepago {

	@Test
	public void TestgetTipoPlan(){
		IPlan planPrepago = new PlanPrepago();
		assertEquals("PREPAGO", planPrepago.getTipoDePlan());
	}
	
	@Test
	public void TestCalcularCostoDeLlamada(){
		CDR cdr = new CDR(70743567,70765342,"10/10/19","07:14","00:02:00",2.2);
		ITarifacion tarifacionFijaPorMinuto = new TarifacionFijaPorMinuto();
		IPlan planPrepago = new PlanPrepago();
		assertEquals(2.90, planPrepago.calcularCostoDeLlamada(tarifacionFijaPorMinuto, cdr));
	}

}
