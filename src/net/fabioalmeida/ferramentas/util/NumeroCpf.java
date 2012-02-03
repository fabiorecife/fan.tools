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



public class NumeroCpf  {

	private String numero;
	private Modulo11 modulo11;
	private DigitoVerificador digitoVerificador;
	private String numeroFormatado;
	
	public NumeroCpf(String numero) {
		modulo11 = new Modulo11(2,11);
		digitoVerificador = new DigitoVerificador(2,modulo11);
		this.numero = StringHelper.pegarApenasNumeros(numero);
		formateNumero();
	}
	
	public NumeroCpf() {
		modulo11 = new Modulo11(2,11);
		digitoVerificador = new DigitoVerificador(2,modulo11);
		completarComNumeroAleatorio();
		formateNumero();
	}
	
	public void completarComNumeroAleatorio() {
		GeradorNumeros gerador = new GeradorNumeros();
		this.numero = gerador.criarNumero(9);
		this.numero	+= StringHelper.formatarNumeroComZerosAEsquerda(digitoVerificador.calcular(getNumeroSemDigito()), 2);
	}

	
	public boolean valido() {
		if (this.numero == null || this.numero.length() != 11) return false;
        return getDigitoVerificador() == digitoVerificador.calcular(getNumeroSemDigito());
    }

	private long[] getNumeroSemDigito() {
		return ArrayHelper.stringParaLongArray(numero.substring(0, 9));
	}

	
	public long getDigitoVerificador() {
		return Long.parseLong(this.numero) % 100;
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
		NumeroCpf other = (NumeroCpf) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return numero;
	}
	
	
	private void formateNumero() {
		StringBuilder build = new StringBuilder();
		build.append(numero.substring(0, 3));
		build.append('.');
		build.append(numero.substring(3, 6));
		build.append('.');
		build.append(numero.substring(6, 9));
		build.append('-');
		build.append(numero.substring(9, 11));
		
		this.numeroFormatado = build.toString();
	}

	public String formatado() {
		return this.numeroFormatado;
	}

	
}
