package net.fabioalmeida.ferramentas.util;


public class DigitoVerificador {
	int size;
	Modulo11 modulo11;
	long digitoVerificador;
	
	
	public DigitoVerificador(int size, Modulo11 modulo11) {
		this.modulo11 = modulo11;
		this.size = size;
	}

	public long calcular(long[] digitos) {
		long [] dv = new long[size];
		for (int i = 0 ; i < dv.length; i++) {
			dv[i] = modulo11.calcular(digitos);
			digitos = ArrayHelper.adicionarDigitoParaArray(digitos, dv[i]);
		}
		return concatenarDigitos(dv);
	}

	private long concatenarDigitos(long[] digitos) {
		StringBuilder build = new StringBuilder();
		for (int i = 0 ; i < digitos.length; i++) {
			build.append(digitos[i]);
		}
		return Long.parseLong(build.toString());
	}	

	
	
}
