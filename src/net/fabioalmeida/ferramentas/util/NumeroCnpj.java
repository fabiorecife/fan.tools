package net.fabioalmeida.ferramentas.util;


public class NumeroCnpj  {

	private static final int TAMANHO_CNPJ = 14;
	private String numero;
	private Modulo11 modulo11;
	private DigitoVerificador digitoVerificador;

	public NumeroCnpj(String numero) {
		initInternal();
		this.numero = StringHelper.pegarApenasNumeros(numero);
	}

	public NumeroCnpj () {
		initInternal();
		completarComNumeroAleatorio();
	}

	private void initInternal() {
		modulo11 = new Modulo11(2,9);
		digitoVerificador = new DigitoVerificador(2,modulo11);
	}

	private void completarComNumeroAleatorio() {
		GeradorNumeros gerador = new GeradorNumeros();
		this.numero = gerador.criarNumero(12);
		this.numero += StringHelper.formatarNumeroComZerosAEsquerda(digitoVerificador.calcular(getNumeroSemDigito()),2);
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
	
	@Override
	public String toString() {
		return this.numero;
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
		NumeroCnpj other = (NumeroCnpj) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	
	
}
