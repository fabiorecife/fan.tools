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


public class DigitoVerificador {
	int size;
	Modulo11 modulo11;
	long digitoVerificador;
	
	
	public DigitoVerificador(int size, Modulo11 modulo11) {
		this.modulo11 = modulo11;
		this.size = size;
	}

	public long calcular(long[] digitos) {
		long [] dv = new long[size];
		for (int i = 0 ; i < dv.length; i++) {
			dv[i] = modulo11.calcular(digitos);
			digitos = ArrayHelper.adicionarDigitoParaArray(digitos, dv[i]);
		}
		return concatenarDigitos(dv);
	}

	private long concatenarDigitos(long[] digitos) {
		StringBuilder build = new StringBuilder();
		for (int i = 0 ; i < digitos.length; i++) {
			build.append(digitos[i]);
		}
		return Long.parseLong(build.toString());
	}	

	
	
}
