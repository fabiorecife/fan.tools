package net.fabioalmeida.ferramentas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.fabioalmeida.ferramentas.util.NumeroCnpj;

import org.junit.Test;

public class CnpjTest {

	@Test
	public void test_cnpj_invalido_menos_14_caracteres() {
		NumeroCnpj cnpj = new NumeroCnpj("0");
		assertFalse(cnpj.valido());
	}

	@Test
	public void test_cnpj_invalido_maisque_14_caracteres() {
		NumeroCnpj cnpj = new NumeroCnpj("0000000000000000000");
		assertFalse(cnpj.valido());
	}
		
	
	@Test
	public void test_cnpj_valido() {
		NumeroCnpj cnpj = new NumeroCnpj("97602468000198");
		assertTrue(cnpj.valido());
	}

	@Test
	public void test_cnpj_naoValido() {
		NumeroCnpj cnpj = new NumeroCnpj("97602468000191");
		assertFalse(cnpj.valido());
	}
	
	@Test
	public void test_cnpj_getNumeroSemDigito() {
		NumeroCnpj cnpj = new NumeroCnpj("12345678901234");
		long [] digitos = cnpj.getNumeroSemDigito();
		assertEquals(12, digitos.length);
		for (int i = 1; i < 10; i++) {
			assertEquals(i,digitos[i-1]);	
		}
	}
	
	@Test
	public void test_cnpj_getDigitoVerificador() {
		NumeroCnpj cnpj = new NumeroCnpj("12345678901234");
		assertEquals(34, cnpj.getDigitoVerificador());
	}
	
	@Test
	public void test_cnpj_construtor_default() {
		NumeroCnpj cnpj = new NumeroCnpj();
		assertEquals(14, cnpj.toString().length());
		assertTrue(cnpj.valido());
	}
	
	
}
