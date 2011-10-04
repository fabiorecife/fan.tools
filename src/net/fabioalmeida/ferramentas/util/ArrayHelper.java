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

package net.fabioalmeida.ferramentas.util;

public class ArrayHelper {

	public static long[] adicionarDigitoParaArray(long[] digitos, long digitoNovo) {
		long[] digitosNovos = new long[digitos.length+1];
		
		for (int i = 0 ; i < digitos.length; i++) {
			digitosNovos[i] = digitos[i];
		}
		digitosNovos[digitosNovos.length-1] = digitoNovo;
		
		return digitosNovos;
	}


	public static long[] stringParaLongArray(String numero) {
		char [] c = numero.toCharArray();
		long [] digitos = new long[c.length];
		for (int i=0; i < digitos.length; i++) {
			digitos[i] = Character.digit(c[i], 10);
		}
		return digitos;
	}
	
}
