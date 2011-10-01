package net.fabioalmeida.ferramentas.test;

import static org.junit.Assert.*;

import net.fabioalmeida.ferramentas.util.DigitoVerificador;
import net.fabioalmeida.ferramentas.util.Modulo11;

import org.junit.Test;

public class DigitoVerificadorTest {

	@Test
	public void test() {
		DigitoVerificador dv = new DigitoVerificador(2, new Modulo11(2,11));
		assertEquals(29, dv.calcular(new long[] {1,5,2,2,6,7,0,9,1}));
		
	}

}
