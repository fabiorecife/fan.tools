package net.fabioalmeida.ferramentas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.fabioalmeida.ferramentas.util.ArrayHelper;
import net.fabioalmeida.ferramentas.util.Cnpj;
import net.fabioalmeida.ferramentas.util.Modulo11;

import org.junit.Test;

public class CnpjTest {

	@Test
	public void test_cnpj_invalido_menos_14_caracteres() {
		Cnpj cnpj = new Cnpj("0");
		assertFalse(cnpj.valido());
	}

	@Test
	public void test_cnpj_invalido_maisque_14_caracteres() {
		Cnpj cnpj = new Cnpj("0000000000000000000");
		assertFalse(cnpj.valido());
	}
		
	
	@Test
	public void test_cnpj_valido() {
		Cnpj cnpj = new Cnpj("97602468000198");
		assertTrue(cnpj.valido());
	}

	@Test
	public void test_cnpj_naoValido() {
		Cnpj cnpj = new Cnpj("97602468000191");
		assertFalse(cnpj.valido());
	}
	
	
	
	@Test
	public void test_modulo11_vetor_1_base_2_9() {
		Modulo11 modulo11= new Modulo11(2,9);
		assertEquals(9, modulo11.calcular(new long[]{1}) );
	}

	@Test
	public void test_modulo11_vetor_11_base_2_9() {
		Modulo11 modulo11= new Modulo11(2,9);
		assertEquals(6, modulo11.calcular(new long[]{1,1}) );
	}
	

	@Test
	public void test_modulo11_vetor_111_base_2_9() {
		Modulo11 modulo11= new Modulo11(2,9);
		assertEquals(2, modulo11.calcular(new long[]{1,1,1}) );
	}
	
	@Test
	public void test_modulo11_vetor_1110_base_2_9() {
		Modulo11 modulo11= new Modulo11(2,9);
		assertEquals(0, modulo11.calcular(new long[]{1,1,1,0}) );
	}
	
	
}
