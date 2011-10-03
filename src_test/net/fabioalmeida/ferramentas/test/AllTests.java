package net.fabioalmeida.ferramentas.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
		ArrayHelperTest.class,
		CnpjTest.class, 
		CpfTest.class,
		DigitoVerificadorTest.class,
		GeradorNumerosTest.class,
		Modulo11Test.class, 
		StringHelperTest.class
})
public class AllTests {

}
