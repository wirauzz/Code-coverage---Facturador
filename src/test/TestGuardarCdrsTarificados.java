package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import entidades.CDR;
import repository.IRepository;
import repository.JDBRepository;
import repository.SerializationRepository;
import guardarCdrsTarificados.GuardarCdrsTarificados;
import guardarCdrsTarificados.IGuardarCdrsTarificados;


class TestGuardarCdrsTarificados {

	IRepository repositorio = new JDBRepository("TelcoDB.db");
	IGuardarCdrsTarificados casoDeUso = new GuardarCdrsTarificados(repositorio);
	
	@Test
	public void TestGuardarRegistrosEnRepositorio(){
		IRepository serializationRepository = new SerializationRepository("cdrs.csv","usuarios.csv");
		ArrayList<CDR> CDRs = serializationRepository.obtenerCDRs();
		casoDeUso.guardarRegistrosEnRepositorio(CDRs);
		assertEquals(5,repositorio.obtenerCDRs().size());
	}

}
