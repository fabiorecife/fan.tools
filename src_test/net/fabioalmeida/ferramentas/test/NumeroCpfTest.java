package net.fabioalmeida.ferramentas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.fabioalmeida.ferramentas.util.NumeroCnpj;
import net.fabioalmeida.ferramentas.util.NumeroCpf;

import org.junit.Test;

public class NumeroCpfTest {
	
	@Test
	public void test_valido() {
		NumeroCpf cpf = new NumeroCpf("98453147671");
		assertTrue(cpf.valido());
	}
	
	@Test
	public void test_valido_com_zero() {
		NumeroCpf cpf = new NumeroCpf("88557474520");
		assertTrue(cpf.valido());
	}

	@Test 
	public void test_digitoVerificador() {
		NumeroCpf cpf = new NumeroCpf("00000000000");
		assertEquals("pegou os numeros errados", 0,cpf.getDigitoVerificador());
		cpf = new NumeroCpf("00000000099");
		assertEquals("pegou os numeros errados", 99,cpf.getDigitoVerificador());
	}
	
	@Test 
	public void test_equals() {
		NumeroCpf cpf = new NumeroCpf("10000000000");
		NumeroCpf cpf2 = new NumeroCpf("10000000000");
		assertEquals(cpf, cpf2);
		assertEquals(cpf.hashCode(), cpf2.hashCode());
		assertEquals(cpf.toString() , cpf2.toString());
	}
	
	@Test
	public void test_geracaoAutomatica() {
		NumeroCpf cpf = new NumeroCpf();
		assertTrue(cpf.valido());
	}
	
	@Test
	public void test_formatado() {
		NumeroCnpj cnpj = new NumeroCnpj();
		assertTrue(cnpj.formatado().charAt(3) == '.');
		assertTrue(cnpj.formatado().charAt(7) == '.');
		assertTrue(cnpj.formatado().charAt(11) == '-');
	}
	
}
