package net.fabioalmeida.ferramentas.test;

import static org.junit.Assert.*;

import net.fabioalmeida.ferramentas.util.StringHelper;

import org.junit.Test;

public class StringHelperTest {

	@Test 
	public void test_pegarApenasNumeros() {
		String numero = "123.456 aaa 789";
		assertEquals("pegar Apenas numeros errado", "123456789",StringHelper.pegarApenasNumeros(numero) );
		numero = "88557474520";
		assertEquals("pegar Apenas numeros errado", numero,StringHelper.pegarApenasNumeros(numero) );
	}
	
	@Test
	public void test_formatarNumeroComZerosAEsquerda() {
		assertEquals("07", StringHelper.formatarNumeroComZerosAEsquerda(7,2));
		assertEquals("007", StringHelper.formatarNumeroComZerosAEsquerda(7,3));
	}

}
