package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import entidades.CDR;

class TestCDR {
	
	
	CDR cdr; 

	@Test
	@DisplayName("Constructor de CDR")
	public void VerificarFuncionamientoDelConstructorDeCdr(){
		cdr =new CDR(70743567,70765342,"10/10/20","19:14","00:02:30",2.2);
		assertEquals(70743567, cdr.getTelefonoOrigen());
		assertEquals(70765342, cdr.getTelefonoDestino());
		assertEquals("10/10/20", cdr.getFecha());
		assertEquals("19:14", cdr.getHora());
		assertEquals("00:02:30", cdr.getTiempoDuracion());
		assertEquals(2.2, cdr.getCosto());
	}
	@Test
	@DisplayName("Obtencion del mes de la fecha del CDR")
	public void VerificarLaObtencionDelMesDeLaFechaDeCdr(){
		cdr =new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",2.2);
		assertEquals("10", cdr.getMes());
		
	}
	
	@DisplayName("Seteo de nuevo costo en CDR")
	@Test
	public void VerificarSeterDelCostoDeCdr(){
		cdr =new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",0.0);
		cdr.setCosto(4.8);
		assertEquals(4.8, cdr.getCosto());
		
	}
	
	@DisplayName("Obtencion de la duracion de llamada en minutos con segundo (hh/mm/ss)")
	@Test
	public void VerificarLaObtencionDelaDuracionDeLaLlamadaEnMinutosConSegundos(){
		CDR cdr = new CDR(70743567,70765342,"10/10/19","19:14","02:01:18",2.2);
		assertEquals(121.18, cdr.getDuracionDeLlamadaEnMinutos());
		
	}
	@DisplayName("Obtencion de la duracion de llamada en minutos sin segundos (hh/mm)")
	@Test
	public void VerificarLaObtencionDelaDuracionDeLaLlamadaEnMinutosSinSegundos(){
		CDR cdr = new CDR(70743567,70765342,"10/10/19","19:14","01:02",2.2);
		assertEquals(62.00, cdr.getDuracionDeLlamadaEnMinutos());
		
	}

}
