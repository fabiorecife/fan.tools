package net.fabioalmeida.ferramentas.util;

public class GeradorNumeros {

	public String criarNumero(int size) {
		StringBuilder numero = new StringBuilder(size);
		 int digito = 0;
	        int numeroLength = numero == null ? 0 : numero.length();
	        for (int i = numeroLength ; i < size; i ++) {
	            digito = (int) ( Math.random() * 10);
	            numero.append(Integer.toString(digito));
	        }
			return numero.toString();
	}

}
