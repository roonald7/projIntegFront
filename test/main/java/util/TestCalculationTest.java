package main.java.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCalculationTest {

	@Test
	public void testSoma1() {
		TestCaculation ts = new TestCaculation();
		
		int a = 10;
		int b = 7;
		
		assertEquals(17, ts.soma(a, b));
	}
	
	@Test
	public void testSoma2() {
		TestCaculation ts = new TestCaculation();
		
		int a = Integer.MAX_VALUE;
		int b = 1;
		
		assertEquals(-2147483648, ts.soma(a, b));
	}
	
	@Test
	public void testSoma3(){
		TestCaculation ts = new TestCaculation();
		
		int a = Integer.MIN_VALUE;
		int b = Integer.MAX_VALUE;
		
		System.out.println(a);
		System.out.println(b);
		assertEquals(-1, ts.soma(a, b));
	}

}
