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

import net.fabioalmeida.ferramentas.util.Modulo11;

import org.junit.Test;

public class Modulo11Test {

	@Test
	public void test_calcular_tudo0() {
		Modulo11 modulo11 = new Modulo11(2,11);
		assertEquals(0,modulo11.calcular(new long [] {0,0,0,0,0,0,0,0,0,0,0}));
	}
	
	@Test
	public void test_calcular() {
		Modulo11 modulo11 = new Modulo11(2,11);
		assertEquals(9,modulo11.calcular(new long [] {9,1,8,7,6,4,4,4,7}));
		assertEquals(0,modulo11.calcular(new long [] {6,5,1,5,9,4,4,4,7}));
	}
	
	@Test
	public void test_modulo11_base_2_11() {
		Modulo11 modulo11 = new Modulo11(2,11);
		assertEquals("modulo11 calculado errado", 2, modulo11.calcular(new long[] {8,8,5,5,7,4,7,4,5}));
		assertEquals("modulo11 calculado errado", 0, modulo11.calcular(new long[] {8,8,5,5,7,4,7,4,5,2}));
	}
	
	@Test
	public void test_modulo11_vetor_1_base_2_9() {
		Modulo11 modulo11= new Modulo11(2,9);
		assertEquals(9, modulo11.calcular(new long[]{1}) );
	}

	@Test
	public void test_modulo11_vetor_11_base_2_9() {
		Modulo11 modulo11= new Modulo11(2,9);
		assertEquals(6, modulo11.calcular(new long[]{1,1}) );
	}
	

	@Test
	public void test_modulo11_vetor_111_base_2_9() {
		Modulo11 modulo11= new Modulo11(2,9);
		assertEquals(2, modulo11.calcular(new long[]{1,1,1}) );
	}
	
	@Test
	public void test_modulo11_vetor_1110_base_2_9() {
		Modulo11 modulo11= new Modulo11(2,9);
		assertEquals(0, modulo11.calcular(new long[]{1,1,1,0}) );
	}	
	
	
}
