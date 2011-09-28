package net.fabioalmeida.ferramentas.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.fabioalmeida.ferramentas.util.Cpf;

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
		assertEquals("pegar Apenas numeros errado", "123456789",Cpf.pegarApenasNumeros(numero) );
		numero = "88557474520";
		assertEquals("pegar Apenas numeros errado", numero,Cpf.pegarApenasNumeros(numero) );
	}
	
	@Test
	public void test_modulo11_base_2_n() {
		assertEquals("modulo11 calculado errado", 2, Cpf.modulo11_base2_n(new long[] {8,8,5,5,7,4,7,4,5}));
		assertEquals("modulo11 calculado errado", 0, Cpf.modulo11_base2_n(new long[] {8,8,5,5,7,4,7,4,5,2}));
	}
	
	@Test 
	public void test_digitoVerificador() {
		Cpf cpf = new Cpf("00000000000");
		assertEquals("pegou os numeros errados", 0L,cpf.digitoVerificador());
	}
	
	@Test
	public void test_gerarCPF() {
		Cpf cpf = new Cpf();
		assertTrue(cpf.valido());
	}
	
	@Test
	public void test_cpfNumeroVazio() {
		Cpf cpf = new Cpf("");
		assertFalse(cpf.valido());
	}
	
	
}
