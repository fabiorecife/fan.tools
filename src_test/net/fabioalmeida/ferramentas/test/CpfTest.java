package net.fabioalmeida.ferramentas.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.fabioalmeida.ferramentas.util.ArrayHelper;
import net.fabioalmeida.ferramentas.util.Cpf;
import net.fabioalmeida.ferramentas.util.StringHelper;

import org.junit.Before;
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
	public void test_getOnlyNumbers() {
		String numero = "123.456 aaa 789";
		assertEquals("pegar Apenas numeros errado", "123456789",StringHelper.pegarApenasNumeros(numero) );
		numero = "88557474520";
		assertEquals("pegar Apenas numeros errado", numero,StringHelper.pegarApenasNumeros(numero) );
	}
	
	@Test
	public void test_modulo11_base_2_11() {
		assertEquals("modulo11 calculado errado", 2, ArrayHelper.modulo11(new long[] {8,8,5,5,7,4,7,4,5},2,11));
		assertEquals("modulo11 calculado errado", 0, ArrayHelper.modulo11(new long[] {8,8,5,5,7,4,7,4,5,2},2,11));
	}
	
	@Test 
	public void test_digitoVerificador() {
		Cpf cpf = new Cpf("00000000000");
		assertEquals("pegou os numeros errados", 0L,cpf.digitoVerificador());
	}
	
	
}
