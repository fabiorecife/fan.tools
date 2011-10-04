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
