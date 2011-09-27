package net.fabioalmeida.ferramentas.util;

import java.util.Random;


public class Cpf {

	private String numero;
	
	public Cpf(String numero) {
		this.numero = pegarApenasNumeros(numero);
	}
	
	public boolean isCpf() {
        return digitoVerificador() == calcularDigitoVerficador();
    }

	public long digitoVerificador() {
		return Long.parseLong(this.numero) % 100;
	}

	public long calcularDigitoVerficador() {
		String cpf = this.numero;
        long deslocamentoDoDigito = 10L;
		String cpfSemDigito =cpf.substring(0,9); 
		long[] digito = stringToLongArray(cpfSemDigito);
		long primeiroDigito = modulo11_base2_n(digito);
        digito = addDigitoToArray(digito, primeiroDigito);

        long digitoVerificadorCalculado = (primeiroDigito*deslocamentoDoDigito)+modulo11_base2_n(digito);
		return digitoVerificadorCalculado;
	}





	private static long[] addDigitoToArray(long[] digito, long novodigito) {
		long[] result = new long[digito.length+1];
		for (int i = 0; i < digito.length; i++) {
			result[i] = digito[i];
		}
		result[result.length-1] = novodigito;
		return result;
	}
	
	
	


	public static String pegarApenasNumeros(String string) {
		StringBuilder build = new StringBuilder(11);
		char[] c = string.toCharArray();
		for (int i = 0; i < c.length; i++ ) {
			if (c[i] >= 48 && c[i] <= 57) build.append(c[i]);
		}
		return build.toString();
	}


	public static long modulo11_base2_n(long[] digito) {
        long soma = 0;
		for (int i = digito.length-1, n = 2;  i >=0 ; i--, n++) {
        	soma += digito[i]*n;
        }
        
        long mod11 = soma % 11;
        long result = mod11 < 2 ? 0 : 11-mod11;
		return result;
	}

	
	private static long[] stringToLongArray(String cpf) {
		char[] digito = cpf.toCharArray();
		long[] result = new long[digito.length];
		
		for(int i = 0; i < result.length; i++) {
			result[i] = (digito[i] - 48) ;
		}
		
		return result;
	}
	
	
}
