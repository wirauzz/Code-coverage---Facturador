package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entidades.CDR;
import tarifaciones.ITarifacion;
import tarifaciones.TarifacionDiferenciadaPorHorario;

class TestTarificacionDiferenciadaPorHorario {

	@Test
	public void TesGetTipoDeTarifacion(){
		ITarifacion tarifacionDiferenciadaPorHorario = new TarifacionDiferenciadaPorHorario();
		assertEquals("DIFERENCIADA POR HORARIO", tarifacionDiferenciadaPorHorario.getTipoDeTarifacion());
	}
	
	@Test
	public void TestCalculoCosteHorarioNormal(){
		CDR cdr = new CDR(70743567,70765342,"10/10/21","07:14","00:02:00",0.0);
		ITarifacion tarifacionDiferenciadaPorHorario = new TarifacionDiferenciadaPorHorario();
		assertEquals(2.9, tarifacionDiferenciadaPorHorario.calcularCoste(cdr));
	}
	
	@Test
	public void TestCalculoCosteHorarioReducido(){
		
		CDR cdr = new CDR(70743567,70765342,"10/10/21","21:14","00:02:00",0.0);
		ITarifacion tarifacionDiferenciadaPorHorario = new TarifacionDiferenciadaPorHorario();
		assertEquals(1.9, tarifacionDiferenciadaPorHorario.calcularCoste(cdr));
	}
	
	@Test
	public void TestCalculoCosteHorarioReducido01(){
		
		CDR cdr = new CDR(70743567,70765342,"10/10/21","0:14","00:02:00",0.0);
		ITarifacion tarifacionDiferenciadaPorHorario = new TarifacionDiferenciadaPorHorario();
		assertEquals(1.9, tarifacionDiferenciadaPorHorario.calcularCoste(cdr));
	}

	@Test
	public void TestCalculoCosteSuperReducido(){
		
		CDR cdr = new CDR(70743567,70765342,"10/10/21","5:14","00:02:00",0.0);
		ITarifacion tarifacionDiferenciadaPorHorario = new TarifacionDiferenciadaPorHorario();
		assertEquals(1.4, tarifacionDiferenciadaPorHorario.calcularCoste(cdr));
	}
	
	@Test
	public void DeberiaRetornar0ComoCosteALasmenos21HrsPor1Minutos(){
		
		CDR cdr = new CDR(70743567,70765342,"10/10/19","-21:14","00:01:00",0.0);
		ITarifacion tarifacionDiferenciadaPorHorario = new TarifacionDiferenciadaPorHorario();
		assertEquals(0, tarifacionDiferenciadaPorHorario.calcularCoste(cdr));
	}
}
