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
