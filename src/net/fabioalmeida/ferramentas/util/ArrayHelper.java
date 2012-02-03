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
