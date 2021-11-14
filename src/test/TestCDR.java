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
		assertEquals(70743567, cdr.getTelefonoOrigen(),"Error al obtener el telefono de origen");
		assertEquals(70765342, cdr.getTelefonoDestino(),"Error al obtener el telefono de destino");
		assertEquals("10/10/20", cdr.getFecha(),"Error al obtener la fecha");
		assertEquals("19:14", cdr.getHora(),"Error al obtener la hora");
		assertEquals("00:02:30", cdr.getTiempoDuracion(),"Error al obtener el tiempo de duracion de la llamada");
		assertEquals(2.2, cdr.getCosto(),"Error al obtener el costo");
	}
	@Test
	@DisplayName("Obtencion del mes de la fecha del CDR")
	public void VerificarLaObtencionDelMesDeLaFechaDeCdr(){
		cdr =new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",2.2);
		assertEquals("10", cdr.getMes(),"Error al obtener el mes de la fecha del CDR");
		
	}
	
	@DisplayName("Seteo de nuevo costo en CDR")
	@Test
	public void VerificarSeterDelCostoDeCdr(){
		cdr =new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",0.0);
		cdr.setCosto(4.8);
		assertEquals(4.8, cdr.getCosto(),"Error al setear nuevo costo en CDR");
		
	}
	
	@DisplayName("Obtencion de la duracion de llamada en minutos con segundo (hh/mm/ss)")
	@Test
	public void VerificarLaObtencionDelaDuracionDeLaLlamadaEnMinutosConSegundos(){
		CDR cdr = new CDR(70743567,70765342,"10/10/19","19:14","02:01:18",2.2);
		assertEquals(121.18, cdr.getDuracionDeLlamadaEnMinutos(),"Error al calcular la duracion en minutos(hh/mm)");
		
	}
	@DisplayName("Obtencion de la duracion de llamada en minutos sin segundos (hh/mm)")
	@Test
	public void VerificarLaObtencionDelaDuracionDeLaLlamadaEnMinutosSinSegundos(){
		CDR cdr = new CDR(70743567,70765342,"10/10/19","19:14","01:02",2.2);
		assertEquals(62.00, cdr.getDuracionDeLlamadaEnMinutos(),"Error al calcular la duracion en minutos(mm/ss)");
		
	}

}
