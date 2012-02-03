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

import net.fabioalmeida.ferramentas.util.DigitoVerificador;
import net.fabioalmeida.ferramentas.util.Modulo11;

import org.junit.Test;

public class DigitoVerificadorTest {

	@Test
	public void test() {
		DigitoVerificador dv = new DigitoVerificador(2, new Modulo11(2,11));
		assertEquals(29, dv.calcular(new long[] {1,5,2,2,6,7,0,9,1}));
		
	}

}
