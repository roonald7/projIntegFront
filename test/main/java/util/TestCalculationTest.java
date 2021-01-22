package main.java.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.spy;

public class TestCalculationTest {
	
	private TestCalculation ts;
	
	@Before
	public void initTeste() {
		ts = spy(TestCalculation.class);
	}
	
	@After
	public void finishTest() {
		ts = null;
	}
	
	@Test
	public void testSoma1() {
		int a = 10;
		int b = 7;
		
		assertEquals(17, ts.soma(a, b));
	}
	
	@Test
	public void testSoma2() {
		int a = Integer.MAX_VALUE;
		int b = 1;
		
		assertEquals(-2147483648, ts.soma(a, b));
	}
	
	@Test
	public void testSoma3(){
		int a = Integer.MIN_VALUE;
		int b = Integer.MAX_VALUE;
		
		assertEquals(-1, ts.soma(a, b));
	}

	@Test
	public void testeMultiplicao1() {
		int a = 15;
		int b = -18;
		
		System.out.println(ts.multiplicacao(a, b));
		assertEquals(-270, ts.multiplicacao(a, b));
	}
	
	@Test
	public void testeMultiplicao2() {
		int a = -1;
		int b = Integer.MAX_VALUE;
		
		assertEquals(-2147483647, ts.multiplicacao(a, b));
	}
	
	@Test
	public void testeMultiplicao3() {
		int a = -1;
		int b = Integer.MIN_VALUE + 1;

		assertEquals(2147483647, ts.multiplicacao(a, b));
	}
	
	@Test
	public void testeMultiplicao4() {
		int a = 0;
		int b = Integer.MIN_VALUE;

		assertEquals(0, ts.multiplicacao(a, b));
	}
}
