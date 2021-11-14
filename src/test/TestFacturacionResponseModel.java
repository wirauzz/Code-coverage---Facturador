package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import entidades.Usuario;
import planes.PlanWow;
import responseModels.FacturacionResponseModel;

class TestFacturacionResponseModel {

	@Test
	@DisplayName("Constructor de FacturacionResponseModel")
	public void VerificarFuncionamientoDelConstructorDeFacturacionResponseModel(){
		Usuario usuario=new Usuario("Wilson Judas",1324561203,83925956);
		usuario.setPlan(new PlanWow());
		FacturacionResponseModel factura = new FacturacionResponseModel(usuario,7,"10/10/19"); 
		assertEquals("Wilson Judas", factura.getNombre(),()->"Error al obtener el nombre del dueño de la factura");
		assertNotNull(factura,()->"No se inicializo la clase FacturacionResponseModel");
	}
}
