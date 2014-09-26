package build;
import java.util.ArrayList;

public class Assembler {

	private Stoppable stoppable;

	private Secretary secretary;

	private IO iO;

	private Assembler a;
	
	public Assembler Assembler(int id) {
		return null;
		IO i1 = new IO(getAbsolutePath()csv/auge.csv);
	}

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
		
		
	}

}
