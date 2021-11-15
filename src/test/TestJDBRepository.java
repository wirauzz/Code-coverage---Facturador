package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entidades.CDR;
import entidades.FabricaDePlanesYTarifas;
import repository.IRepository;
import repository.JDBRepository;


class TestJDBRepository {

	@Test
	@DisplayName("Se inicializa JDBRepository con el path dado")
	public void VerificarQueElContructorFunciona(){
		IRepository JDBRepositorio =new JDBRepository("TelcoDB.db");
		assertNotNull(JDBRepositorio);
	}
	
	@Test
	@DisplayName("Se cargan 5 CDRs desde JDB")
	public void VerificarElCargadoDeCDRsDesdeLaDb(){
		IRepository JDBRepositorio =new JDBRepository("TelcoDB.db");
		assertEquals(5,JDBRepositorio.obtenerCDRs().size());
	}
	
	@Test
	@DisplayName("Se guardan CDRs procesados a la DB")
	public void VerificarElGuardadoDeCDRsProcesadosALaDb(){
		IRepository JDBRepositorio =new JDBRepository("TelcoDB.db");
		JDBRepositorio.guardarCDRsProcesados(JDBRepositorio.obtenerCDRs());
	}

	@Test
	public void VerificarElCargadoDeUsuariosDesdeLaDb(){
		IRepository JDBRepositorio =new JDBRepository("TelcoDB.db");
		FabricaDePlanesYTarifas fabrica = new FabricaDePlanesYTarifas();
		assertEquals(4,JDBRepositorio.obtenerUsuarios(fabrica).size());
	}
	
	@Test
	@DisplayName("Error al cargar usuarios de la base de datos con path erroneo")
	public void VerificarQueNoSePuedeCargarDatosSiElPathNoContieneUnaBaseDeDatos(){
		IRepository JDBRepositorio =new JDBRepository("TelcdoDB.db");
		FabricaDePlanesYTarifas fabrica = new FabricaDePlanesYTarifas();
		assertEquals(0,JDBRepositorio.obtenerUsuarios(fabrica).size());
	}
	
	@Test
	@DisplayName("Error al  intentar cargar usuarios de la DB con path erroneo")
	public void DeberiaSalirUnMensajeDeErrorAlCargarCDRSDesdeLaBaseDeDatosErronea(){
		IRepository JDBRepositorio =new JDBRepository("TelcdoDB.db");
		assertEquals(0,JDBRepositorio.obtenerCDRs().size());
	}
	
	@Test
	@DisplayName("Guardar cdrs tarificados en una base de datos cuando el path erroneo")
	public void DeberiaSalirUnMensajeDeErrorAlGuardarCDRSEnLaBaseDeDatosErronea(){
		IRepository JDBRepositorio =new JDBRepository("TelcdoDB.db");
		ArrayList<CDR> registrosTelefonicosTarificados = new ArrayList<CDR>();
		registrosTelefonicosTarificados.add(new CDR(70743567,70765342,"10/10/19","19:14","00:02:30",2.2));
		registrosTelefonicosTarificados.add(new CDR(70743567,70765342,"10/10/19","19:14","00:02:30",4.8));
		registrosTelefonicosTarificados.add(new CDR(70742567,70765342,"10/10/19","19:14","00:02:30",2.2));
		JDBRepositorio.guardarCDRsProcesados(registrosTelefonicosTarificados);
	}

}
