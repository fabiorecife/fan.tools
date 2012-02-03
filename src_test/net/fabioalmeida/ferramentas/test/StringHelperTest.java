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
		assertEquals("7", StringHelper.formatarNumeroComZerosAEsquerda(7,1));
		assertEquals("07", StringHelper.formatarNumeroComZerosAEsquerda(7,2));
		assertEquals("007", StringHelper.formatarNumeroComZerosAEsquerda(7,3));
		assertEquals("17", StringHelper.formatarNumeroComZerosAEsquerda(17,2));
	}

	@Test
	public void test_reverse() {
		assertEquals("54321", StringHelper.reverse("12345"));
		assertEquals("12345", StringHelper.reverse(StringHelper.reverse("12345")));
	}
	
}
