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

import org.junit.Test;

import net.fabioalmeida.ferramentas.util.ArrayHelper;

public class ArrayHelperTest {

	@Test
	public void test_stringParaLongArray() {
		long[] digitos = ArrayHelper.stringParaLongArray("0123456789");
		compararArray0_9(digitos);
	}

	@Test
	public void test_adicionarDigitoParaArray() {
		long[] digitos = new long[] {0,1,2,3,4,5,6,7,8};
		digitos = ArrayHelper.adicionarDigitoParaArray(digitos,9);
		compararArray0_9(digitos);
	}

	private void compararArray0_9(long[] digitos) {
		for (int i = 0 ; i < digitos.length; i++) {
			assertEquals(i, digitos[i]);
		}
	}

}
