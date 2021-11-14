package test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import cargarCdrsDeRepositorio.CargarCdrsDesdeRepositorio;
import cargarCdrsDeRepositorio.ICargarCdrsDesdeRepositorio;
import repository.IRepository;
import repository.JDBRepository;


class TestCargarCDRRepositorio {

	@Test
	public void TestCargarCdrsDesdeRepositorio(){
		IRepository repositorio = new JDBRepository("TelcoDB.db");
		ICargarCdrsDesdeRepositorio casoDeUso = new CargarCdrsDesdeRepositorio(repositorio);
		assertEquals("class cargarCdrsDeRepositorio.CargarCdrsDesdeRepositorio", casoDeUso.getClass().toString());
	}
	

	@Test
	public void TestObtenerCDRS(){
		IRepository repositorio = new JDBRepository("TelcoDB.db");
		ICargarCdrsDesdeRepositorio casoDeUso = new CargarCdrsDesdeRepositorio(repositorio);
		assertAll("Lista de los CDRs",
				() -> assertEquals(79372469, casoDeUso.obtenerCDRS().get(0).getTelefonoOrigen()),
				() -> assertEquals(68749514, casoDeUso.obtenerCDRS().get(0).getTelefonoDestino()),
				() -> assertEquals("10/10/19", casoDeUso.obtenerCDRS().get(0).getFecha()),
				() -> assertEquals("06:15:15", casoDeUso.obtenerCDRS().get(0).getHora()),
				() -> assertEquals("01:00:00", casoDeUso.obtenerCDRS().get(0).getTiempoDuracion()),
				() -> assertEquals(0, casoDeUso.obtenerCDRS().get(0).getCosto())
		);
		

	}
}
