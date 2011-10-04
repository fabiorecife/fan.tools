/*
 *	fan.tools - small tools in java/gwt 
 *	Copyright (C) 2011  Fábio Almeida (http://fabioalmeida.net)
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
	
	
}
