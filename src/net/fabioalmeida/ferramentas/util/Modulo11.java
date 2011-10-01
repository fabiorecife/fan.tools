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
