package shadow.test.output;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import shadow.CompileException;
import shadow.Main;

public class NegativeTests {

	private ArrayList<String> args = new ArrayList<String>();

	@Before
	public void setup() throws Exception {		
		String os = System.getProperty("os.name").toLowerCase();
		
		if( os.contains("windows") ) {
			args.add("-c");
			args.add("windows.xml");
		}
		else if( os.contains("mac") ) {
			args.add("-c");
			args.add("mac.xml");
		}
	}
	
	private void enforce() throws Exception
	{
		try
		{
			Main.run(args.toArray(new String[] { }));
			throw new Exception("Test failed");
		}
		catch( CompileException e )
		{			
		}		
	}
	
	
	@Test public void testConstantInitializationFailure() throws Exception
	{
		args.add("tests-negative/compile/constant-initialization-failure/Test.shadow");
		enforce();		
	}
}
