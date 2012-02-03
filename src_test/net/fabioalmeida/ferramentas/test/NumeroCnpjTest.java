/*
 *	fan.tools - small tools in java/gwt 
 *	Copyright (C) 2011  Fabio Almeida (http://fabioalmeida.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabioalmeida.ferramentas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.fabioalmeida.ferramentas.util.NumeroCnpj;

import org.junit.Test;

public class NumeroCnpjTest {

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
	
	@Test
	public void test_formatado() {
		NumeroCnpj cnpj = new NumeroCnpj();
		assertTrue(cnpj.formatado().charAt(2) == '.');
		assertEquals('.',cnpj.formatado().charAt(6));
		assertTrue(cnpj.formatado().charAt(10) == '/');
		assertTrue(cnpj.formatado().charAt(15) == '-');
	}
}
