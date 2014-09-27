package build;
import java.io.File;
import java.util.ArrayList;

import threading.Watchable;

public class Assembler {

	private Watchable watchable;

	private Secretary secretary;

	private IO iO;

	private Assembler a;
	
	public Assembler(int id) {
		File f1 = new File(""); 
		String path1 = f1.getAbsolutePath() +"/src/arm.csv";
		File f2 = new File(""); 
		String path2 = f2.getAbsolutePath() +"/src/chaindrive.csv";
		File f3 = new File(""); 
		String path3 = f3.getAbsolutePath() +"/src/eye.csv";
		File f4 = new File(""); 
		String path4 = f4.getAbsolutePath() +"/src/torso.csv";
		IO ioArm = new IO(path1);
		IO ioChaindrive = new IO(path2);
		IO ioEye = new IO(path3);
		IO ioTorso = new IO(path4);
	}
/*
	public void run() {
		Secretary s = new Secretary();
		a = new Assembler(s.getAssemblerID());
		a.build();
	}

	public void build(ArrayList<String> parts) {
		String arm1 = a.deliver(1);
		String arm2 = a.deliver(1);
		String torso1 = a.deliver(2);
		String chaindrive1 = a.deliver(3);
		String eye1 = a.deliver(4);
		String eye2 = a.deliver(4);
		
	
	}*/

}
