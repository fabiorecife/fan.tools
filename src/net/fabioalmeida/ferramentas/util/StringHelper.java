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


public class StringHelper {

	public static String pegarApenasNumeros(String string) {
		StringBuilder build = new StringBuilder(11);
		char[] c = string.toCharArray();
		for (int i = 0; i < c.length; i++ ) {
			if (Character.isDigit(c[i])) build.append(c[i]);
		}
		return build.toString();
	}

	public static String formatarNumeroComZerosAEsquerda(long numero, int size) {
		String result = String.valueOf(numero);
		while (result.length() < size) {
			result = "0" + result;
		}
		return result;
	}

	public static String reverse(String string) {
		StringBuilder build = new StringBuilder(string.length()) ;
		char[] cs = string.toCharArray();
		
		for (int i = cs.length-1 ; i>=0; i--) {
			build.append(cs[i]);
		}
		
		return build.toString();
	}

	
	
}
