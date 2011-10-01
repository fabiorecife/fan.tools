package net.fabioalmeida.ferramentas.util;

public class ArrayHelper {

	public static long somaDigitosMultiplicados(long[] digitos, long base , long maximo ) {
		long mult = base;
		long soma = 0;
		for (int i = digitos.length-1; i >= 0; i--) {
			soma += (mult*digitos[i]);
			if (mult == maximo) mult = base; else mult++;
		}
		return soma;
	}
	
	
	public static long modulo11(long[] digitos, long base , long maximo) {
		long soma = ArrayHelper.somaDigitosMultiplicados(digitos, base, maximo);
		long resto = (soma % 11);
		long digitoVerificador = resto < 2 ? 0 : 11 - resto;
		return digitoVerificador;
	}


	public static long[] adicionarDigitoParaArray(long[] digitos, long digitoNovo) {
		long[] digitosNovos = new long[digitos.length+1];
		
		for (int i = 0 ; i < digitos.length; i++) {
			digitosNovos[i] = digitos[i];
		}
		digitosNovos[digitosNovos.length-1] = digitoNovo;
		
		return digitosNovos;
	}


	public static long[] stringParaArrayLong(String numero) {
		char [] chars = numero.toCharArray();
		long [] digitos = new long[chars.length];
		for (int i=0; i < digitos.length; i++) {
			digitos[i] = chars[i] - 48;
		}
		return digitos;
	}
	
}
