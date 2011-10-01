package net.fabioalmeida.ferramentas.test;

import static org.junit.Assert.*;
import net.fabioalmeida.ferramentas.util.GeradorNumeros;

import org.junit.Test;

public class GeradorNumerosTest {

	@Test
	public void test() {
		GeradorNumeros gerador = new GeradorNumeros();
		String numero = gerador.criarNumero(9);
		assertEquals(9, numero.length());
	}

}
