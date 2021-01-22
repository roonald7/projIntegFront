package main.java.util;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import main.java.entity.MedidorJson;

public class HttpConnectionMethodsTest {
	private List<?> listaMedidor = null;
	
	private HttpConnectionMethods hcm;
	
	@Before
	public void initTest() {
		hcm = spy(HttpConnectionMethods.class);
	}
	
	@Test
	@Ignore
	public void testRestGET1() {
		listaMedidor = hcm.restGET();
		assertEquals("Checking if an object inside the list belongs to the correct class",MedidorJson.class,listaMedidor.get(0).getClass());
	}
	
}
