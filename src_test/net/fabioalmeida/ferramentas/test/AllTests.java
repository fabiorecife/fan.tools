package net.fabioalmeida.ferramentas.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
		CnpjTest.class, 
		CpfTest.class, 
		GeradorNumerosTest.class,
		Modulo11Test.class, 
		NumeroCadastroTest.class,
		DigitoVerificadorTest.class,
		StringHelperTest.class
})
public class AllTests {

}
