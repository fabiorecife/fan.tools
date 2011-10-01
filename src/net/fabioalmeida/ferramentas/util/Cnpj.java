package net.fabioalmeida.ferramentas.util;

import java.io.Serializable;

public class Cnpj  {

	private static final int TAMANHO_CNPJ = 14;
	private String numero;
	private Modulo11 modulo11;

	public Cnpj(String numero) {
		modulo11 = new Modulo11(2,9);
		this.numero = StringHelper.pegarApenasNumeros(numero);
	}

	public boolean valido() {
		if (numero == null || numero.length() != TAMANHO_CNPJ) return false;
		return digitoVerificador() == calcularDigitoVerficador();
	}
	
	public long digitoVerificador() {
		return Long.parseLong(this.numero) % 100;
	}
	
	public void completarComNumeroAleatorio() {
		GeradorNumeros gerador = new GeradorNumeros();
		this.numero = gerador.criarNumero(12);
		this.numero += String.valueOf(calcularDigitoVerficador());
	}

	public long calcularDigitoVerficador() {
		long [] digitos = ArrayHelper.stringParaLongArray(this.numero.substring(0,12));
		long digitoVerificador1 = modulo11.calcular(digitos);
		digitos = ArrayHelper.adicionarDigitoParaArray(digitos, digitoVerificador1);
		long digitoVerificador2 = modulo11.calcular(digitos);
		return (digitoVerificador1*10)+digitoVerificador2; 
	}

	
	
	
}
