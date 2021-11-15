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
	public void TestTarificarCDRs() throws ParseException{
		ArrayList<CDR> registrosTelefonicos = new ArrayList<CDR>();
		registrosTelefonicos.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",0));
		registrosTelefonicos.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:00",0));
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario("gio",877878,70743567);
		usuario.setPlan(new PlanPostpago());
		usuario.setTarifacion(new TarifacionFijaPorMinuto());
		usuarios.add(usuario);
		ITarificar tarificar = new Tarificar(usuarios, registrosTelefonicos);
		assertEquals(2.9,tarificar.tarificarCDRs().get(1).getCosto());
	}
	
	@Test
	public void TestBuscarUsuario() throws ParseException{
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
