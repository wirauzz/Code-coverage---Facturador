package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.api.Test;
import cargarUsuariosDeRepositorio.CargarUsuariosDesdeRepositorio;
import cargarUsuariosDeRepositorio.ICargarUsuariosDesdeRepositorio;
import repository.IRepository;
import repository.JDBRepository;

class TestCargarUsuariosRepositorio {

		@Test
		public void TestCargarUsuariosDesdeRepositorio(){
			IRepository repositorio = new JDBRepository("TelcoDB.db");
			ICargarUsuariosDesdeRepositorio casoDeUso = new CargarUsuariosDesdeRepositorio(repositorio);
			assertEquals("class cargarUsuariosDeRepositorio.CargarUsuariosDesdeRepositorio", casoDeUso.getClass().toString());
		}
		
		@Test
		public void TestObtenerUsuarios(){
			IRepository repositorio = new JDBRepository("TelcoDB.db");
			ICargarUsuariosDesdeRepositorio casoDeUso = new CargarUsuariosDesdeRepositorio(repositorio);
			assertAll("Criterios de funcionamiento correcto para carga de usuarios",
					() -> assertEquals("Jose Augusto", casoDeUso.obtenerUsuarios().get(0).getNombre()),
					() -> assertEquals(13892648, casoDeUso.obtenerUsuarios().get(0).getCi()),
					() -> assertEquals(79372469, casoDeUso.obtenerUsuarios().get(0).getNumeroTelefonoMovil()),
					() -> assertEquals("PREPAGO", casoDeUso.obtenerUsuarios().get(0).getPlan().getTipoDePlan()),
					() -> assertEquals("DIFERENCIADA POR HORARIO", casoDeUso.obtenerUsuarios().get(0).getTarifacion().getTipoDeTarifacion())				
			);
		}

}
