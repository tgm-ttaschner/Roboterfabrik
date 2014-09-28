package testing;

import static org.junit.Assert.*;

import org.junit.*;

import build.Storage;
import build.CLI;
import build.IO;

/**
 * 
 * 
 * 
 * @author Michael Weinberger 4AHITT
 * @version 2014-09-28
 *
 */
public class TestStorage {
	
	String[] out;
	IO arm;
	IO chaindrive;
	IO torso;
	IO eye;
	
	@Before
	public void setup() {
		CLI.lagerVerzeichnis = "/src/testing/IOplayground/csv/";
		
		arm = new IO(IO.getWorkingDir() +"/src/testing/IOplayground/csv/arm.csv");
		chaindrive = new IO(IO.getWorkingDir() +"/src/testing/IOplayground/csv/chaindrive.csv");
		torso = new IO(IO.getWorkingDir() +"/src/testing/IOplayground/csv/torso.csv");
		eye = new IO(IO.getWorkingDir() +"/src/testing/IOplayground/csv/eye.csv");
		
		arm.overWrite("");
		arm.write("Arm,11,24,3,4,25,6,8,8,9,10,11,12,13,14,15,16,17,18,195,5");
		arm.write("Arm,91,62,3,4,54,6,7,8,9,10,11,12,13,14,15,16,17,18,119,32");
		arm.write("Arm,91,62,3,4,54,6,7,8,9,10,11,12,13,14,15,16,17,18,119,520");
		
		chaindrive.overWrite("");
		chaindrive.write("Chaindrive,11,24,3,4,25,6,8,8,9,10,11,12,13,14,15,16,17,18,195,5");
		chaindrive.write("Chaindrive,91,62,3,4,54,6,7,8,9,10,11,12,13,14,15,16,17,18,119,32");
		chaindrive.write("Chaindrive,91,62,3,4,54,6,7,8,9,10,11,12,13,14,15,16,17,18,119,520");
		
		torso.overWrite("");
		torso.write("Torso,11,24,3,4,25,6,8,8,9,10,11,12,13,14,15,16,17,18,195,5");
		torso.write("Torso,91,62,3,4,54,6,7,8,9,10,11,12,13,14,15,16,17,18,119,32");
		torso.write("Torso,91,62,3,4,54,6,7,8,9,10,11,12,13,14,15,16,17,18,119,520");
		
		eye.overWrite("");
		eye.write("Eye,11,24,3,4,25,6,8,8,9,10,11,12,13,14,15,16,17,18,195,5");
		eye.write("Eye,91,62,3,4,54,6,7,8,9,10,11,12,13,14,15,16,17,18,119,32");
		eye.write("Eye,91,62,3,4,54,6,7,8,9,10,11,12,13,14,15,16,17,18,119,520");
		
		
	}
	
	/**
	 * Demands an arm from the storage.
	 */
	@Test
	public void testDeliverArm() {
		Storage test = new Storage();
		
		out = test.deliver(Storage.ARM);
		
		assertEquals("Arm", out[0]);
	}
	
	/**
	 * Demands an eye from the storage.
	 */
	@Test
	public void testDeliverEye() {
		Storage test = new Storage();
		
		out = test.deliver(Storage.EYE);
		
		assertEquals("Eye", out[0]);
	}
	
	/**
	 * Demands a chaindrive from the storage.
	 */
	@Test
	public void testDeliverChaindrive() {
		Storage test = new Storage();
		
		out = test.deliver(Storage.CHAINDRIVE);
		
		assertEquals("Chaindrive", out[0]);
	}
	
	/**
	 * Demands a torso from the storage.
	 */
	@Test
	public void testDeliverTorso() {
		Storage test = new Storage();
		
		out = test.deliver(Storage.TORSO);
		
		assertEquals("Torso", out[0]);
	}
	
	/**
	 * Triggers the return null, with no 
	 */
	@Test
	public void testDeliverFalse() {
		Storage test = new Storage();
		
		out = test.deliver(42);
		
		assertEquals(null, out);
	}
	
}
