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
