package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import entidades.CDR;
import planes.IPlan;
import planes.PlanWow;
import tarifaciones.ITarifacion;
import tarifaciones.TarifacionFijaPorMinuto;

class TestPlanWow {

	@Test
	public void TestGetTipoPlan(){
		IPlan planWow = new PlanWow();
		assertEquals("WOW", planWow.getTipoDePlan());
	}
	
	@Test
	public void TestGetNumeroAmigos(){
		IPlan planWow = new PlanWow();
		ArrayList<Integer> numerosAmigos = new ArrayList<Integer>();
		numerosAmigos.add(70768374);
		((PlanWow) planWow).setNumerosAmigos(numerosAmigos);
		assertEquals("70768374", ((PlanWow) planWow).getNumeroAmigosParaString());
	}
	
	@Test
	public void TestGetNumeroAmigosVacio(){
		IPlan planWow = new PlanWow();
		ArrayList<Integer> numerosAmigos = new ArrayList<Integer>();
		((PlanWow) planWow).setNumerosAmigos(numerosAmigos);
		assertEquals("Sin numeros amigos", ((PlanWow) planWow).getNumeroAmigosParaString());
	}
	
	@Test
	public void TestCalcularCostoDeLlamada(){
		CDR cdr = new CDR(70743567,70765342,"10/10/19","07:14","00:02:00",0.0);
		ITarifacion tarifacionFijaPorMinuto = new TarifacionFijaPorMinuto();
		IPlan planWow = new PlanWow();
		ArrayList<Integer> numerosAmigos = new ArrayList<Integer>();
		numerosAmigos.add(70765342);
		((PlanWow) planWow).setNumerosAmigos(numerosAmigos);
		assertEquals(0, planWow.calcularCostoDeLlamada(tarifacionFijaPorMinuto, cdr));
	}
	
	@Test
	public void TestCalcularCostoDeLlamadaAmigoVacio(){
		CDR cdr = new CDR(70743567,70765342,"10/10/19","07:14","00:02:00",0.0);
		ITarifacion tarifacionFijaPorMinuto = new TarifacionFijaPorMinuto();
		IPlan planWow = new PlanWow();
		ArrayList<Integer> numerosAmigos = new ArrayList<Integer>();
		((PlanWow) planWow).setNumerosAmigos(numerosAmigos);
		assertEquals(2.9, planWow.calcularCostoDeLlamada(tarifacionFijaPorMinuto, cdr));
	}

}
