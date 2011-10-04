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


public class NumeroCnpj  {

	private static final int TAMANHO_CNPJ = 14;
	private String numero;
	private Modulo11 modulo11;
	private DigitoVerificador digitoVerificador;

	public NumeroCnpj(String numero) {
		initInternal();
		this.numero = StringHelper.pegarApenasNumeros(numero);
	}

	public NumeroCnpj () {
		initInternal();
		completarComNumeroAleatorio();
	}

	private void initInternal() {
		modulo11 = new Modulo11(2,9);
		digitoVerificador = new DigitoVerificador(2,modulo11);
	}

	private void completarComNumeroAleatorio() {
		GeradorNumeros gerador = new GeradorNumeros();
		this.numero = gerador.criarNumero(12);
		this.numero += StringHelper.formatarNumeroComZerosAEsquerda(digitoVerificador.calcular(getNumeroSemDigito()),2);
	}
	
	public boolean valido() {
		if (numero == null || numero.length() != TAMANHO_CNPJ) return false;
		return getDigitoVerificador() == digitoVerificador.calcular(getNumeroSemDigito());
	}
	
	public long[] getNumeroSemDigito() {
		return ArrayHelper.stringParaLongArray(numero.substring(0, 12));
	}
	
	public long getDigitoVerificador() {
		return Long.parseLong(this.numero) % 100;
	}
	
	@Override
	public String toString() {
		return this.numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumeroCnpj other = (NumeroCnpj) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	
	
}
