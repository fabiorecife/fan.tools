package net.fabioalmeida.ferramentas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.fabioalmeida.ferramentas.util.ArrayHelper;
import net.fabioalmeida.ferramentas.util.Cpf;
import net.fabioalmeida.ferramentas.util.Modulo11;
import net.fabioalmeida.ferramentas.util.StringHelper;

import org.junit.Test;

public class CpfTest {

	
	@Test
	public void test_isCpf() {
		Cpf cpf = new Cpf("98453147671");
		assertTrue(cpf.valido());
	}
	
	@Test
	public void test_isCpf_com_zero() {
		Cpf cpf = new Cpf("88557474520");
		assertTrue(cpf.valido());
	}

	@Test
	public void test_isCpf_cpf_falso() {
		Cpf cpf = new Cpf("88557474521");
		assertFalse(cpf.valido());
	}

	@Test
	public void test_calculoDigitoVerificador() {
		Cpf cpf = new Cpf("88557474520");
		assertEquals("digito verificador calculado errado", 20L, cpf.calcularDigitoVerficador());
	}
	
	
	
	
	@Test
	public void test_modulo11_base_2_11() {
		Modulo11 modulo11 = new Modulo11(2,11);
		assertEquals("modulo11 calculado errado", 2, modulo11.calcular(new long[] {8,8,5,5,7,4,7,4,5}));
		assertEquals("modulo11 calculado errado", 0, modulo11.calcular(new long[] {8,8,5,5,7,4,7,4,5,2}));
	}
	
	@Test 
	public void test_digitoVerificador() {
		Cpf cpf = new Cpf("00000000000");
		assertEquals("pegou os numeros errados", 0,cpf.getDigitoVerificador());
		cpf = new Cpf("00000000099");
		assertEquals("pegou os numeros errados", 99,cpf.getDigitoVerificador());
	}
	
	@Test 
	public void test_equals() {
		Cpf cpf = new Cpf("10000000000");
		Cpf cpf2 = new Cpf("10000000000");
		assertEquals(cpf, cpf2);
		assertEquals(cpf.hashCode(), cpf2.hashCode());
		assertEquals(cpf.toString() , cpf2.toString());
	}
	
	@Test
	public void test_geracaoAutomatica() {
		Cpf cpf = new Cpf();
		assertTrue(cpf.valido());
	}
	
}
