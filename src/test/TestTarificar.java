package test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import entidades.CDR;
import entidades.Usuario;
import planes.PlanPostpago;
import tarifaciones.TarifacionFijaPorMinuto;
import tarificar.ITarificar;
import tarificar.Tarificar;

class TestTarificar {

	@Test
	public void TestTarificar0CDRs() throws ParseException{
		ArrayList<CDR> registrosTelefonicos = new ArrayList<CDR>();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario("gio",877878,70743567);
		usuario.setPlan(new PlanPostpago());
		usuario.setTarifacion(new TarifacionFijaPorMinuto());
		usuarios.add(usuario);
		ITarificar tarificar = new Tarificar(usuarios, registrosTelefonicos);
		assertTrue(tarificar.tarificarCDRs().isEmpty());
	}
	@Test
	public void TestTarificar1CDRs() throws ParseException{
		ArrayList<CDR> registrosTelefonicos = new ArrayList<CDR>();
		registrosTelefonicos.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",0));
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario("gio",877878,70743567);
		usuario.setPlan(new PlanPostpago());
		usuario.setTarifacion(new TarifacionFijaPorMinuto());
		usuarios.add(usuario);
		ITarificar tarificar = new Tarificar(usuarios, registrosTelefonicos);
		assertEquals(1,tarificar.tarificarCDRs().size());
	}
	
	@Test
	public void TestTarificar2CDRs() throws ParseException{
		ArrayList<CDR> registrosTelefonicos = new ArrayList<CDR>();
		registrosTelefonicos.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",0));
		registrosTelefonicos.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:00",0));
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario("gio",877878,70743567);
		usuario.setPlan(new PlanPostpago());
		usuario.setTarifacion(new TarifacionFijaPorMinuto());
		usuarios.add(usuario);
		ITarificar tarificar = new Tarificar(usuarios, registrosTelefonicos);
		assertEquals(2,tarificar.tarificarCDRs().size());
	}
	
	@Test
	public void TestTarificarNCDRs() throws ParseException{
		ArrayList<CDR> registrosTelefonicos = new ArrayList<CDR>();
		registrosTelefonicos.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",0));
		registrosTelefonicos.add(new CDR(70743567,70765346,"10/10/21","19:14","00:02:00",0));
		registrosTelefonicos.add(new CDR(70743567,70765345,"10/10/21","19:14","00:02:30",0));
		registrosTelefonicos.add(new CDR(70743567,70765344,"10/10/21","19:14","00:02:00",0));
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario("gio",877878,70743567);
		usuario.setPlan(new PlanPostpago());
		usuario.setTarifacion(new TarifacionFijaPorMinuto());
		usuarios.add(usuario);
		ITarificar tarificar = new Tarificar(usuarios, registrosTelefonicos);
		assertEquals(4,tarificar.tarificarCDRs().size());
	}
	
	@Test
	public void TestBuscarUsuarioListaVacia() throws ParseException{
		ArrayList<CDR> registrosTelefonicos = new ArrayList<CDR>();
		registrosTelefonicos.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",0));
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Tarificar tarificar = new Tarificar(usuarios,registrosTelefonicos);
		assertNull(tarificar.buscarUsuario(70743567));
	}
	
	@Test
	public void TestBuscarUsuarioListaCon1Usuario() throws ParseException{
		ArrayList<CDR> registrosTelefonicos = new ArrayList<CDR>();
		registrosTelefonicos.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",0));
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario("gio",877878,70743567);
		usuario.setPlan(new PlanPostpago());
		usuario.setTarifacion(new TarifacionFijaPorMinuto());
		usuarios.add(usuario);
		Tarificar tarificar = new Tarificar(usuarios,registrosTelefonicos);
		assertEquals(70743567,tarificar.buscarUsuario(70743567).getNumeroTelefonoMovil());
	}
	
	@Test
	public void TestBuscarUsuarioListaCon2Usuarios() throws ParseException{
		ArrayList<CDR> registrosTelefonicos = new ArrayList<CDR>();
		registrosTelefonicos.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",0));
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario("gio",877878,70743567);
		usuario.setPlan(new PlanPostpago());
		usuario.setTarifacion(new TarifacionFijaPorMinuto());
		usuarios.add(usuario);
		
		Usuario usuario2 = new Usuario("walson",87854,70743568);
		usuario2.setPlan(new PlanPostpago());
		usuario2.setTarifacion(new TarifacionFijaPorMinuto());
		usuarios.add(usuario2);
		
		Tarificar tarificar = new Tarificar(usuarios,registrosTelefonicos);
		assertEquals(70743568,tarificar.buscarUsuario(70743568).getNumeroTelefonoMovil());
	}
	
	@Test
	public void TestBuscarUsuarioListaCon3Usuarios() throws ParseException{
		ArrayList<CDR> registrosTelefonicos = new ArrayList<CDR>();
		registrosTelefonicos.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",0));
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario("gio",877878,70743567);
		usuario.setPlan(new PlanPostpago());
		usuario.setTarifacion(new TarifacionFijaPorMinuto());
		usuarios.add(usuario);
		
		Usuario usuario2 = new Usuario("walson",87854,70743568);
		usuario2.setPlan(new PlanPostpago());
		usuario2.setTarifacion(new TarifacionFijaPorMinuto());
		usuarios.add(usuario2);
		
		Usuario usuario3 = new Usuario("John",4563,70743560);
		usuario3.setPlan(new PlanPostpago());
		usuario3.setTarifacion(new TarifacionFijaPorMinuto());
		usuarios.add(usuario3);
		
		Tarificar tarificar = new Tarificar(usuarios,registrosTelefonicos);
		assertEquals(70743567,tarificar.buscarUsuario(70743567).getNumeroTelefonoMovil());
	}
	
	@Test
	public void TestBuscarUsuarioInexistente() throws ParseException{
		ArrayList<CDR> registrosTelefonicos = new ArrayList<CDR>();
		registrosTelefonicos.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",0));
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario("gio",877878,70743567);
		usuario.setPlan(new PlanPostpago());
		usuario.setTarifacion(new TarifacionFijaPorMinuto());
		usuarios.add(usuario);
		Tarificar tarificar = new Tarificar(usuarios,registrosTelefonicos);
		assertNull(tarificar.buscarUsuario(98753));
	}

}
