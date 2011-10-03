package net.fabioalmeida.ferramentas.util;



public class Cpf  {

	private String numero;
	private Modulo11 modulo11;
	private DigitoVerificador digitoVerificador;
	
	public Cpf(String numero) {
		modulo11 = new Modulo11(2,11);
		digitoVerificador = new DigitoVerificador(2,modulo11);
		this.numero = StringHelper.pegarApenasNumeros(numero);
	}
	
	public Cpf() {
		modulo11 = new Modulo11(2,11);
		digitoVerificador = new DigitoVerificador(2,modulo11);
		completarComNumeroAleatorio();
	}
	
	public void completarComNumeroAleatorio() {
		GeradorNumeros gerador = new GeradorNumeros();
		this.numero = gerador.criarNumero(9);
		this.numero	+= StringHelper.formatarNumeroComZerosAEsquerda(digitoVerificador.calcular(getNumeroSemDigito()), 2);
	}

	
	public boolean valido() {
		if (this.numero == null || this.numero.length() != 11) return false;
        return getDigitoVerificador() == digitoVerificador.calcular(getNumeroSemDigito());
    }

	private long[] getNumeroSemDigito() {
		return ArrayHelper.stringParaLongArray(numero.substring(0, 9));
	}

	
	public long getDigitoVerificador() {
		return Long.parseLong(this.numero) % 100;
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
