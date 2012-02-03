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
