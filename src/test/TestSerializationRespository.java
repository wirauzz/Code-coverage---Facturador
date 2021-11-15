package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entidades.CDR;
import entidades.FabricaDePlanesYTarifas;
import entidades.Usuario;
import repository.IRepository;
import repository.SerializationRepository;

class TestSerializationRespository {

	@Test
	@DisplayName("Cargar 5 CDRs desde archivo .csv")
	public void VerificarLaCargaDeCdrsDesdeArchivoCsv(){
		IRepository serializationRepository =new SerializationRepository("cdrs.csv","usuarios.csv");
		ArrayList<CDR> CDRs = serializationRepository.obtenerCDRs();
		assertEquals(5,CDRs.size(),"No se cargaron los 5 cdrs desde el archivo .csv");
	}
	
	@Test
	@DisplayName("No se encontro el archivo .csv de carga de CDRS")
	public void VerificarQueNoSeCarganCdrsSiNoSeEncontroElArchivo(){
		IRepository serializationRepository =new SerializationRepository("jtestdata\\cdrs.csv","usuarios.csv");
		ArrayList<CDR> CDRs = serializationRepository.obtenerCDRs();
		assertEquals(0,CDRs.size() );
	}
	@Test
	@DisplayName("Guardar CDRs procesados")
	public void DeberiaGuardarLosCDRsProcesados(){
		IRepository serializationRepository =new SerializationRepository("cdrs.csv","usuarios.csv");
		ArrayList<CDR> CDRs = serializationRepository.obtenerCDRs();
		serializationRepository.guardarCDRsProcesados(CDRs);
	}
	
	@Test
	@DisplayName("Cargar usuarios desde archivo .csv")
	public void VerificarCargadoDeUsuariosDesdeArchivoCsv(){
		IRepository serializationRepository =new SerializationRepository("cdrs.csv","usuarios.csv");
		FabricaDePlanesYTarifas fabrica = new FabricaDePlanesYTarifas();
		ArrayList<Usuario> Usuarios= serializationRepository.obtenerUsuarios(fabrica);
		assertEquals(5,Usuarios.size() );
	}

}
