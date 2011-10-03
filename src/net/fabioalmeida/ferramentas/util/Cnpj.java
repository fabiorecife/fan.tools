package net.fabioalmeida.ferramentas.util;

import java.io.Serializable;

public class Cnpj  {

	private static final int TAMANHO_CNPJ = 14;
	private String numero;
	private Modulo11 modulo11;
	private DigitoVerificador digitoVerificador;

	public Cnpj () {
		modulo11 = new Modulo11(2,9);
		digitoVerificador = new DigitoVerificador(2,modulo11);
		completarComNumeroAleatorio();
	}
	
	public Cnpj(String numero) {
		modulo11 = new Modulo11(2,9);
		digitoVerificador = new DigitoVerificador(2,modulo11);
		this.numero = StringHelper.pegarApenasNumeros(numero);
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
	
	private void completarComNumeroAleatorio() {
		GeradorNumeros gerador = new GeradorNumeros();
		this.numero = gerador.criarNumero(12);
		this.numero += StringHelper.formatarNumeroComZerosAEsquerda(digitoVerificador.calcular(getNumeroSemDigito()),2);
	}

	public String getNumero() {
		return this.numero;
	}

	
}
