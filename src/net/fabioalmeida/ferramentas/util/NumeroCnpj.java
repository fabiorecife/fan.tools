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


public class NumeroCnpj  {

	private static final int TAMANHO_CNPJ = 14;
	private String numero;
	private String numeroFormatado;
	private Modulo11 modulo11;
	private DigitoVerificador digitoVerificador;

	public NumeroCnpj(String numero) {
		initInternal();
		this.numero = StringHelper.pegarApenasNumeros(numero);
		if (tamanhoValido()) formateNumero();
	}

	private void formateNumero() {
		StringBuilder build = new StringBuilder();
		build.append(numero.substring(0, 2));
		build.append('.');
		build.append(numero.substring(2, 5));
		build.append('.');
		build.append(numero.substring(5, 8));
		build.append('/');
		build.append(numero.substring(8, 12));
		build.append('-');
		build.append(numero.substring(12, 14));
		
		this.numeroFormatado = build.toString();
	}

	public NumeroCnpj () {
		initInternal();
		completarComNumeroAleatorio();
		formateNumero();
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
		if (!tamanhoValido()) return false;
		return getDigitoVerificador() == digitoVerificador.calcular(getNumeroSemDigito());
	}

	private boolean tamanhoValido() {
		return numero != null && numero.length() == TAMANHO_CNPJ;
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

	public String formatado() {
		return this.numeroFormatado;
	}

	
	
}
