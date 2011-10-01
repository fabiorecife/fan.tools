package net.fabioalmeida.ferramentas.test;

import static org.junit.Assert.*;

import net.fabioalmeida.ferramentas.util.NumeroCadastro;

import org.junit.Test;

public class NumeroCadastroTest {

	@Test
	public void test_validade() {
		NumeroCadastro numero = new NumeroCadastro("000000000","00");
		assertTrue(numero.valido());
	}

}
