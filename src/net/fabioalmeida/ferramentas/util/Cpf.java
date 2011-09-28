package net.fabioalmeida.ferramentas.util;

import java.util.Random;


public class Cpf {

	private String numero;
	
	public Cpf() {
		completarComNumeroAleatorio();
	}
	
	
	public Cpf(String numero) {
		this.numero = pegarApenasNumeros(numero);
	}
	
	public boolean valido() {
		if (numero == null || numero.length() != 11) return false;
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

	public void completarComNumeroAleatorio() {
		StringBuffer numeroAleatorios = gerarNumerosAleatorios();
        adicionarDigitosVerificadores(numeroAleatorios);
		this.numero = numeroAleatorios.toString();
		
	}


	private StringBuffer gerarNumerosAleatorios() {
		StringBuffer numeroCpf = new StringBuffer (11);
        int digito = 0;
        int numeroLength = this.numero == null ? 0 : this.numero.length();
        for (int i = numeroLength ; i < 9; i ++) {
            digito = (int) ( Math.random() * 10);
            numeroCpf.append(Integer.toString(digito));
        }
		return numeroCpf;
	}


	private void adicionarDigitosVerificadores(StringBuffer numeroCpf) {
        this.numero = numeroCpf.toString();
		long digitoVerificador = calcularDigitoVerficador();
        if (digitoVerificador < 10) {
        	numeroCpf.append("0" + Long.toString(digitoVerificador));
        } else {
        	numeroCpf.append(Long.toString(digitoVerificador));
        }
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
		Cpf other = (Cpf) obj;
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
	
	
}
