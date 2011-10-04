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
