package net.fabioalmeida.ferramentas.util;

public class ArrayHelper {

	public static long[] adicionarDigitoParaArray(long[] digitos, long digitoNovo) {
		long[] digitosNovos = new long[digitos.length+1];
		
		for (int i = 0 ; i < digitos.length; i++) {
			digitosNovos[i] = digitos[i];
		}
		digitosNovos[digitosNovos.length-1] = digitoNovo;
		
		return digitosNovos;
	}


	public static long[] stringParaLongArray(String numero) {
		char [] c = numero.toCharArray();
		long [] digitos = new long[c.length];
		for (int i=0; i < digitos.length; i++) {
			digitos[i] = Character.digit(c[i], 10);
		}
		return digitos;
	}
	
}
