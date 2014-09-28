package testing;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

import org.junit.*;

import build.IO;

/**
 * 
 * Tests the Input/Output class which is necessary for altering files.
 * 
 * @author Michael Weinberger 4AHITT
 * @version 2014-09-27
 *
 */
public class TestIO {
	
	IO ioread;
	IO iowrite;
	boolean out;
	
	@Before
	public void setup() {
		ioread = new IO(IO.getWorkingDir() +"/src/testing/IOplayground/read.csv");
		iowrite = new IO(IO.getWorkingDir() +"/src/testing/IOplayground/write.csv");
	}
	
	/**
	 * Checks if the actual working directory could be found.
	 */
	@Test
	public void testgetWorkingDirectory() {
		String s = IO.getWorkingDir();
		assertTrue(s.contains("/tgm/sew/hit/roboterfabrik/Simulation/"));
	}
	
	/**
	 * Reads a file from the HDD.
	 */
	@Test
	public void testRead() {
		ArrayList<String> al = ioread.read();
		Iterator<String> it = al.iterator();
		
		String asrt = "";
		
		while (it.hasNext()) {
			asrt = asrt + it.next();
		}
		
		assertEquals("Readingthefilewassuccessfulhooray", asrt);
	}
	
	/**
	 * Checks how a FileNotFoundException is handled by the read-method.
	 */
	@Test
	public void testReadFileNotFoundException() {
		ioread = new IO("");
		ioread.read();
	}
	
	/**
	 * Checks if a file could be written on the HDD.
	 */
	@Test
	public void testWrite() {
		out = iowrite.write("Test writing\n");
		
		assertEquals(true, out);
	}
	
	/**
	 * Checks how a IOException is handled by the write-method.
	 */
	@Test
	public void testWriteIOException() {
		iowrite = new IO("");
		out = iowrite.write("Test writing\n");
		
		assertEquals(false, out);
	}
	
	/**
	 * Checks how a IOException is handled by the write-method.
	 */
	@Test
	public void testWriteNullPointerException() {
		iowrite = new IO(null);
		out = iowrite.write("Test writing\n");
		
		assertEquals(false, out);
	}
	
	/**
	 * Checks if the files are present on the hard drive.
	 */
	@Test
	public void testCheckfiles() {
		IO.CheckFiles(IO.getWorkingDir() + "/src/testing/IOplayground/csv");
		
		File f = new File(IO.getWorkingDir() + "/src/testing/IOplayground/csv/eye.csv");
		boolean file = f.isFile();
		
		assertEquals(true, file);
	}
	
	/**
	 * Checks how a IOException is handled by the checkfile-method.
	 */
	@Test
	public void testCheckfilesIOException() {
		IO.CheckFiles("");
		
		File f = new File("");
		boolean file = f.isFile();
		
		assertEquals(false, file);
	}
	
	/**
	 * Checks if the directory is present on the hard drive.
	 */
	@Test
	public void testCheckdir() {
		IO.checkDir(IO.getWorkingDir() + "/src/testing/IOplayground/csv");
		
		File f = new File(IO.getWorkingDir() + "/src/testing/IOplayground/csv");
		boolean file = f.isDirectory();
		
		assertEquals(true, file);
	}
	
	/**
	 * Checks the output if the directory could not be found.
	 */
	@Test
	public void testCheckdirother() {
		out = IO.checkDir(IO.getWorkingDir() + "/src/testing/IOplayground/theresnothinginhere");
		
		File f = new File(IO.getWorkingDir() + "/src/testing/IOplayground/theresnothinginhere");
		f.delete();
		
		assertEquals(false, out);
	}
	
	
}
