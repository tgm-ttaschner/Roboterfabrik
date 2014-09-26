package build;
import java.util.ArrayList;

public class Assembler {

	private Stoppable stoppable;

	private Secretary secretary;

	private IO iO;

	public Assembler Assembler(int id) {
		return null;
	}

	public void run() {
		Secretary s = new Secretary();
		Assembler a = new Assembler(s.getAssemblerID());
		a.build();
	}

	public void build(ArrayList<String> parts) {
		
	}

}
