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

public class GeradorNumeros {

	public String criarNumero(int size) {
		StringBuilder numero = new StringBuilder(size);
		 int digito = 0;
	        int numeroLength = numero == null ? 0 : numero.length();
	        for (int i = numeroLength ; i < size; i ++) {
	            digito = (int) ( Math.random() * 10);
	            numero.append(Integer.toString(digito));
	        }
			return numero.toString();
	}

}
