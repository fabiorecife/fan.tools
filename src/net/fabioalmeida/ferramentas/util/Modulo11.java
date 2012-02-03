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


public class Modulo11 {
	int base;
	int maximo;
	final int modulo = 11;
	public Modulo11(int base, int maximo) {
		this.base = base;
		this.maximo = maximo;
	}
	
	public long calcular(long[] digitos) {
		long soma = somaDigitosMultiplicados(digitos, base, maximo);
		long resto = (soma % 11);
		long digitoVerificador = resto < 2 ? 0 : 11 - resto;
		return digitoVerificador;
	}
	
	public long somaDigitosMultiplicados(long[] digitos, long base , long maximo ) {
		long mult = base;
		long soma = 0;
		for (int i = digitos.length-1; i >= 0; i--) {
			soma += (mult*digitos[i]);
			if (mult == maximo) mult = base; else mult++;
		}
		return soma;
	}
	
	
}
