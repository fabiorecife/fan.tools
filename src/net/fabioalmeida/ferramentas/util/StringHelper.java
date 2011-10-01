package net.fabioalmeida.ferramentas.util;

public class StringHelper {

	public static String pegarApenasNumeros(String string) {
		StringBuilder build = new StringBuilder(11);
		char[] c = string.toCharArray();
		for (int i = 0; i < c.length; i++ ) {
			if (Character.isDigit(c[i])) build.append(c[i]);
		}
		return build.toString();
	}

	public static String formatarNumeroComZerosAEsquerda(long numero, int size) {
		return String.format("%0"+size+"d", numero);
	}

}
