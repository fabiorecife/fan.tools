package net.fabioalmeida.ferramentas.test;

import static org.junit.Assert.*;

import org.junit.Test;

import net.fabioalmeida.ferramentas.util.ArrayHelper;

public class ArrayHelperTest {

	@Test
	public void test_stringParaLongArray() {
		long[] digitos = ArrayHelper.stringParaLongArray("0123456789");
		compararArray0_9(digitos);
	}

	@Test
	public void test_adicionarDigitoParaArray() {
		long[] digitos = new long[] {0,1,2,3,4,5,6,7,8};
		digitos = ArrayHelper.adicionarDigitoParaArray(digitos,9);
		compararArray0_9(digitos);
	}

	private void compararArray0_9(long[] digitos) {
		for (int i = 0 ; i < digitos.length; i++) {
			assertEquals(i, digitos[i]);
		}
	}

}
