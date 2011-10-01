package net.fabioalmeida.ferramentas.test;

import static org.junit.Assert.*;

import net.fabioalmeida.ferramentas.util.Modulo11;

import org.junit.Test;

public class Modulo11Test {

	@Test
	public void test_calcular_tudo0() {
		Modulo11 modulo11 = new Modulo11(2,11);
		assertEquals(0,modulo11.calcular(new long [] {0,0,0,0,0,0,0,0,0,0,0}));
	}
	
	@Test
	public void test_calcular() {
		Modulo11 modulo11 = new Modulo11(2,11);
		assertEquals(9,modulo11.calcular(new long [] {9,1,8,7,6,4,4,4,7}));
		assertEquals(0,modulo11.calcular(new long [] {6,5,1,5,9,4,4,4,7}));
	}
	
}
