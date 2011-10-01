package net.fabioalmeida.ferramentas.util;

public class StringHelper {

	public static String pegarApenasNumeros(String string) {
		StringBuilder build = new StringBuilder(11);
		char[] c = string.toCharArray();
		for (int i = 0; i < c.length; i++ ) {
			if (c[i] >= 48 && c[i] <= 57) build.append(c[i]);
		}
		return build.toString();
	}

}
