package threading;

public class Threadee {
	
	private Long id;
	
	private Long idTh;
	
	String[] arm1;
	
	String[] arm2;
	
	String[] chaindrive;
	
	String[] eye1;
	
	String[] eye2;
	
	String[] torso;
	
	public Threadee(long threadeeID,long workerID,String[] partsArm1, String[] partsArm2, String[] partsChaindrive,String[] partsEye1, String[] partsEye2, String[] partsTorso) {
		this.id = workerID;	
		this.idTh = threadeeID;	
		this.arm1 = partsArm1;
		this.arm2 = partsArm2;
		this.chaindrive = partsChaindrive;
		this.eye1 = partsEye1;
		this.eye2 = partsEye2;
		this.torso = partsTorso;
	}
	
	
}
