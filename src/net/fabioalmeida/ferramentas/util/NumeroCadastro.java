package net.fabioalmeida.ferramentas.util;

public class NumeroCadastro {
	private String numero;
	private String digitoVerificador;
	private Modulo11 modulo11;
	
	
	public NumeroCadastro(String numero, String digitoVerificador) {
		modulo11 = new Modulo11(2,11);
		this.numero = StringHelper.pegarApenasNumeros(numero);
		this.digitoVerificador = digitoVerificador;
		
	}

	@Override
	public String toString() {
		return numero;
	}


	public boolean valido() {
		return extrairDigitoVerificador() == calcularDigitoVerficador();
	}


	private long calcularDigitoVerficador() {
		long deslocamentoDoDigito = 10L;
		long[] digitos = ArrayHelper.stringParaLongArray(numero.substring(0,9));
		long primeiroDigito = modulo11.calcular(digitos);
        digitos = ArrayHelper.adicionarDigitoParaArray(digitos, primeiroDigito);
        long segundoDigito = modulo11.calcular(digitos);
		return (primeiroDigito*deslocamentoDoDigito)+segundoDigito;
	}


	private long extrairDigitoVerificador() {
		
		return Long.parseLong(numero) % 100;
	}
	
}
