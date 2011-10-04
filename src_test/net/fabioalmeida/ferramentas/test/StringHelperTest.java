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
