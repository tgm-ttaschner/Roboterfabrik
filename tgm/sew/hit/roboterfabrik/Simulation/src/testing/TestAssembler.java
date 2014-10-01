package testing;
import static org.junit.Assert.*;
import threading.*;
import build.*;

import org.junit.Before;
import org.junit.Test;


public class TestAssembler {
	
	@Test
	public void testSort(){
		int[] a1 = new int[3];
		a1[0] = 3;
		a1[1] = 1;
		a1[2] = 2;
		Assembler.sort(a1);
		assertEquals(1, a1[0]);
	}
	@Test
	public void testtoInt(){
		int[] a1 = new int[2];
		String s[]  = {"Hallo","1","2"};
		Assembler.toInt(a1, s);
		assertEquals(1,a1[0]);
	}
	@Test
	public void testBuild(){
		String a1[] = {"teil","2","1"};
		String a2[] = {"teil","2","1"};
		String a3[] = {"teil","2","1"};
		String a4[] = {"teil","2","1"};
		String a5[] = {"teil","2","1"};
		String a6[] = {"teil","2","1"};
		Secretary s = new Secretary(1);
		Storage st = new Storage();
		Assembler a = new Assembler(s,st);
		Threadee t = a.build(a1,a2,a3,a4,a5,a6);
		
		
		
	}
	
}
