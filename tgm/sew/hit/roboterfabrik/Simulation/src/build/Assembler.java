package build;
import java.io.File;
import java.util.ArrayList;

import threading.Watchable;

public class Assembler {

	private Watchable watchable;
	/**
	 * Secretary, which gives the IDs to the Threadees and Assemblers
	 */
	private Secretary secretary;

	private IO iO;
	/**
	 * id -> ID of the Assembler
	 */
	private Long id;
	/**
	 * idTh -> ID of the Threadee
	 */
	private Long idTh;
	/**
	 * Storage, where the parts come from
	 */
	private Storage s;
	/**
	 * 
	 * @param id: ID of the Assembler
	 * @param idThreadee: ID of the Threadee 
	 */
	public Assembler(Long id,Long idThreadee) {
		File f1 = new File(""); 
		String path1 = f1.getAbsolutePath() +CLI.lagerVerzeichnis +"/arm.csv";
		File f2 = new File(""); 
		String path2 = f2.getAbsolutePath() +CLI.lagerVerzeichnis +"/chaindrive.csv";
		File f3 = new File(""); 
		String path3 = f3.getAbsolutePath() +CLI.lagerVerzeichnis +"/eye.csv";
		File f4 = new File(""); 
		String path4 = f4.getAbsolutePath() +CLI.lagerVerzeichnis +"/torso.csv";
		IO ioArm = new IO(path1);
		IO ioChaindrive = new IO(path2);
		IO ioEye = new IO(path3);
		IO ioTorso = new IO(path4);
		this.id = id;
		this.idTh = idThreadee;
		
	}
	/**
	 * This Method sorts values of an int-array in ascending order 
	 * @param array: Array with int-values, that should be ordered
	 */
	public static void sort(int[] array){
		int length = array.length;
		int value;
		for(int c = 0; c < length-1; c++) {	
			for(int i = 0; i < length-1; i++) {
				if(array[i] > array[i+1]) {	
					value = array[i];	
					array[i] = array[i+1];
					array[i+1] = value;
				}
			}
		}	
	}
	/**
	 * This method parses string-values of a string-array into int-values which are saved in an int-array
	 * @param array1: int-array in which the String-values of array2 are saved as int-values
	 * @param array2: string-array, which string-values will be parsed into int-values
	 */
	public static void toInt(int[] array1,String[] array2){
		for (int i = 0; i < array2.length; i++) {
		    if(i == 0){
		    	
		    }else{
		    	array1[(i-1)] = Integer.parseInt(array2[i]); 
		    }
		}
	}

	public void run() {
		this.build();
	}
	
	public void build() {
		String[] a1 = s.deliver(1);
		String[] a2 = s.deliver(1);
		String[] t1 = s.deliver(2);
		String[] c1 = s.deliver(3);
		String[] e1 = s.deliver(4);
		String[] e2 = s.deliver(4);
		
		if(a1 != null && a2 != null && t1 != null && c1 != null && e1 != null && e2 != null){
			int[] sorta1 = new int[(a1.length - 1)];
			int[] sorta2 = new int[(a2.length - 1)];
			int[] sortt1 = new int[(t1.length - 1)];
			int[] sortc1 = new int[(c1.length - 1)];
			int[] sorte1 = new int[(e1.length - 1)];
			int[] sorte2 = new int[(e1.length - 1)];
		
			toInt(sorta1,a1);
			toInt(sorta2,a2);
			toInt(sortt1,t1);
			toInt(sortc1,c1);
			toInt(sorte1,e1);
			toInt(sorte2,e2);
		
			sort(sorta1);
			sort(sorta2);
			sort(sortt1);
			sort(sortc1);
			sort(sorte1);
			sort(sorte2);
			
			
			String[] arm1 = new String[(sorta1.length + 1)];
			String[] arm2 = new String[(sorta2.length + 1)];
			String[] chaindrive = new String[(sortc1.length + 1)];
			String[] eye1 = new String[(sorte1.length + 1)];
			String[] eye2 = new String[(sorte2.length + 1)];
			String[] torso = new String[(sortt1.length + 1)];
			
			for(int i = 0; i < arm1.length; i++){
				if(i == 0){
					arm1[i] = "Threadee-ID"+idTh;
				}else{
					if(i == 1){
						arm1[i] = "Mitarbeiter-ID"+id;
					}else{
						if(i == 2){
							arm1[i] = "Arm1";
						}else{
							arm1[i] = ""+sorta1[(i-3)];
						}
					}
				}
			}
			for(int i = 0; i < arm2.length; i++){
				if(i == 0){
					arm2[i] = "Threadee-ID"+idTh;
				}else{
					if(i == 1){
						arm2[i] = "Mitarbeiter-ID"+id;
					}else{
						if(i == 2){
							arm2[i] = "Arm2";
						}else{
							arm2[i] = ""+sorta2[(i-3)];
						}
					}
				}
			}
			for(int i = 0; i < chaindrive.length; i++){
				if(i == 0){
					chaindrive[i] = "Threadee-ID"+idTh;
				}else{
					if(i == 1){
						chaindrive[i] = "Mitarbeiter-ID"+id;
					}else{
						if(i == 2){
							chaindrive[i] = "Kettenantrieb";
						}else{
							chaindrive[i] = ""+sortc1[(i-3)];
						}
					}
				}
			}
			for(int i = 0; i < eye1.length; i++){
				if(i == 0){
					eye1[i] = "Threadee-ID"+idTh;
				}else{
					if(i == 1){
						eye1[i] = "Mitarbeiter-ID"+id;
					}else{
						if(i == 2){
							eye1[i] = "Auge1";
						}else{
							eye1[i] = ""+sorte1[(i-3)];
						}
					}
				}
			}
			for(int i = 0; i < eye2.length; i++){
				if(i == 0){
					eye2[i] = "Threadee-ID"+idTh;
				}else{
					if(i == 1){
						eye2[i] = "Mitarbeiter-ID"+id;
					}else{
						if(i == 2){
							eye2[i] = "Auge2";
						}else{
							eye2[i] = ""+sorte2[(i-3)];
						}
					}
				}
			}
			for(int i = 0; i < torso.length; i++){
				if(i == 0){
					torso[i] = "Threadee-ID"+idTh;
				}else{
					if(i == 1){
						torso[i] = "Mitarbeiter-ID"+id;
					}else{
						if(i == 2){
							torso[i] = "Auge2";
						}else{
							torso[i] = ""+sortt1[(i-3)];
						}
					}
				}
			}
			
			
		}else{
			System.out.print("Nicht alle benoetigten Teile vorhanden");
		}
		
	}
}
