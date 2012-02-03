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
		NumeroCpf cpf = new NumeroCpf();
		assertTrue(cpf.formatado().charAt(3) == '.');
		assertTrue(cpf.formatado().charAt(7) == '.');
		assertTrue(cpf.formatado().charAt(11) == '-');
	}
	
}
