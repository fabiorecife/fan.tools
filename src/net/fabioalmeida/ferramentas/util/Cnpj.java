package net.fabioalmeida.ferramentas.util;

import java.io.Serializable;

public class Cnpj implements Serializable {

	private static final int TAMANHO_CNPJ = 14;
	private String numero;

	public Cnpj(String numero) {
		this.numero = StringHelper.pegarApenasNumeros(numero);
	}

	public boolean valido() {
		if (numero == null || numero.length() != TAMANHO_CNPJ) return false;
		return digitoVerificador() == calcularDigitoVerificador();
	}
	
	private long digitoVerificador() {
		return Long.parseLong(this.numero) % 100;
	}
	
	private long calcularDigitoVerificador() {
		long [] digitos = ArrayHelper.stringParaArrayLong(this.numero.substring(0,12));
		long digitoVerificador1 = ArrayHelper.modulo11(digitos,2,9);
		digitos = ArrayHelper.adicionarDigitoParaArray(digitos, digitoVerificador1);
		long digitoVerificador2 = ArrayHelper.modulo11(digitos,2,9);
		return (digitoVerificador1*10)+digitoVerificador2; 
	}
	
	
}
