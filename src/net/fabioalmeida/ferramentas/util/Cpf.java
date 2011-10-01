package net.fabioalmeida.ferramentas.util;

import java.util.Random;


public class Cpf {

	private String numero;
	
	public Cpf() {
		completarComNumeroAleatorio();
	}
	
	public Cpf(String numero) {
		this.numero = StringHelper.pegarApenasNumeros(numero);
	}
	
	public boolean valido() {
        return digitoVerificador() == calcularDigitoVerficador();
    }

	public long digitoVerificador() {
		return Long.parseLong(this.numero) % 100;
	}

	public long calcularDigitoVerficador() {
        long deslocamentoDoDigito = 10L;
		long[] digitos = ArrayHelper.stringParaArrayLong(numero.substring(0,9));
		long primeiroDigito = ArrayHelper.modulo11(digitos, 2, 11);
        digitos = ArrayHelper.adicionarDigitoParaArray(digitos, ArrayHelper.modulo11(digitos, 2, 11));
        long segundoDigito = ArrayHelper.modulo11(digitos, 2, 11);
		return (primeiroDigito*deslocamentoDoDigito)+segundoDigito;
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
