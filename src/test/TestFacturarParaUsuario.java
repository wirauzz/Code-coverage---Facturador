package test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import entidades.CDR;
import entidades.Usuario;
import facturarParaUsuario.FacturarParaUsuario;
import facturarParaUsuario.IFacturarParaUsuario;
import planes.PlanWow;


class TestFacturarParaUsuario {
	IFacturarParaUsuario facturar= new FacturarParaUsuario();
	
	@Test
	public void TestFacturarParaUnUsuario0veces() {
		ArrayList<CDR> registrosTelefonicosTarificados = new ArrayList<CDR>();
		Usuario usuario = new Usuario("gio",877878,70743567);
		usuario.setPlan(new PlanWow());
		assertEquals("gio",facturar.facturarParaUnUsuario(registrosTelefonicosTarificados,usuario, "10-10-21").getNombre());
	}
	
	@Test
	public void TestFacturarParaUnUsuario1vez() {
		ArrayList<CDR> registrosTelefonicosTarificados = new ArrayList<CDR>();
		registrosTelefonicosTarificados.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",2.2));
		Usuario usuario = new Usuario("gio",877878,70743567);
		usuario.setPlan(new PlanWow());
		assertEquals("gio",facturar.facturarParaUnUsuario(registrosTelefonicosTarificados,usuario, "10-10-21").getNombre());
	}
	
	@Test
	public void TestFacturarParaUnUsuario2veces() {
		ArrayList<CDR> registrosTelefonicosTarificados = new ArrayList<CDR>();
		registrosTelefonicosTarificados.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",2.2));
		registrosTelefonicosTarificados.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",4.8));
		Usuario usuario = new Usuario("gio",877878,70743567);
		usuario.setPlan(new PlanWow());
		assertEquals("gio",facturar.facturarParaUnUsuario(registrosTelefonicosTarificados,usuario, "10-10-21").getNombre());
	}
	
	@Test
	public void TestFacturarParaUnUsuarioNveces() {
		ArrayList<CDR> registrosTelefonicosTarificados = new ArrayList<CDR>();
		registrosTelefonicosTarificados.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",2.2));
		registrosTelefonicosTarificados.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",4.8));
		registrosTelefonicosTarificados.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",2.2));
		registrosTelefonicosTarificados.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",4.8));		registrosTelefonicosTarificados.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",2.2));
		registrosTelefonicosTarificados.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",4.8));
		Usuario usuario = new Usuario("gio",877878,70743567);
		usuario.setPlan(new PlanWow());
		assertEquals("gio",facturar.facturarParaUnUsuario(registrosTelefonicosTarificados,usuario, "10-10-21").getNombre());
	}
	
	@Test
	public void TestcumpleConFechaYnumero() {
		ArrayList<CDR> registrosTelefonicosTarificados = new ArrayList<CDR>();
		registrosTelefonicosTarificados.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",2.2));
		Usuario usuario = new Usuario("gio",877878,70743567);
		usuario.setPlan(new PlanWow());
		assertEquals("gio",facturar.facturarParaUnUsuario(registrosTelefonicosTarificados,usuario, "10-10-21").getNombre());
	}
	
	@Test
	public void TestNocumpleConFechaYnumero() {
		ArrayList<CDR> registrosTelefonicosTarificados = new ArrayList<CDR>();
		registrosTelefonicosTarificados.add(new CDR(70743567,70765342,"10/10/21","19:14","00:02:30",2.2));
		Usuario usuario = new Usuario("gio",877878,70743567);
		usuario.setPlan(new PlanWow());
		assertEquals("gio",facturar.facturarParaUnUsuario(registrosTelefonicosTarificados,usuario, "5-5-21").getNombre());
	}
	

}
