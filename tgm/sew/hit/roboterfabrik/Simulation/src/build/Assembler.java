package build;
import java.io.File;

import threading.Threadee;

import java.util.ArrayList;

import threading.Watchable;
/**
 * 
 * Assembler-Class, which simulates the process of building a roboter.
 * 
 * @author Alexander Koelbl 4AHITT
 * @version 2014-09-30
 *
 */
public class Assembler implements Runnable{
	private Secretary secretary;
	private Furnisher furnisher;
	private Storage storage;
	Long idTh;
	Long id;
	private boolean stop = false;
	private IO io;
	/**
	 * Constructor
	 * @param s: Secretary, where the Threadees and Workers become their IDs
	 * @param st: Sotrage, where the parts come from
	 */
	public Assembler(Secretary s,Storage st) {
		this.secretary = s;
		this.storage = st;
	}
	/*
	 * Stops the run method
	 */
	public void stop() {
		this.stop = true;
		}
	/**
	 * This method simulates the process of building a roboter.
	 * @param a1: String array in which the arm1 parts are in
	 * @param a2: String array in which the arm2 parts are in
	 * @param a3: String array in which the torso parts are in
	 * @param a4: String array in which the chaindrive parts are in
	 * @param a5: String array in which the eye1 parts are in
	 * @param a6: String array in which the eye2 parts are in
	 * @return Threadee: Threadee with the finished robot
	 */
	public Threadee build(String[] a1, String[] a2, String[] a3, String[] a4, String[] a5, String[] a6){
		if(a1 != null && a2 != null && a3 != null && a4 != null && a5 != null && a6 != null){
			idTh = secretary.getID();
			id = secretary.getID();
			int[] sorta1 = new int[(a1.length - 1)];
			int[] sorta2 = new int[(a2.length - 1)];
			int[] sortt1 = new int[(a3.length - 1)];
			int[] sortc1 = new int[(a4.length - 1)];
			int[] sorte1 = new int[(a5.length - 1)];
			int[] sorte2 = new int[(a6.length - 1)];
		
			Assembler.toInt(sorta1,a1);
			Assembler.toInt(sorta2,a2);
			Assembler.toInt(sortt1,a3);
			Assembler.toInt(sortc1,a4);
			Assembler.toInt(sorte1,a5);
			Assembler.toInt(sorte2,a6);
		
			Assembler.sort(sorta1);
			Assembler.sort(sorta2);
			Assembler.sort(sortt1);
			Assembler.sort(sortc1);
			Assembler.sort(sorte1);
			Assembler.sort(sorte2);
			
			
			String[] arm1 = new String[(sorta1.length + 3)];
			String[] arm2 = new String[(sorta2.length + 3)];
			String[] chaindrive = new String[(sortc1.length + 3)];
			String[] eye1 = new String[(sorte1.length + 3)];
			String[] eye2 = new String[(sorte2.length + 3)];
			String[] torso = new String[(sortt1.length + 3)];
			
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
			Threadee t = new Threadee(idTh,id, arm1, arm2, chaindrive, eye1, eye2,torso);
			return t;
		}else{
			System.out.print("Nicht alle Teile sind vorhanden");
			return null;
		}
	}
	/**
	 * 
	 */
	@Override
	public void run() {
		long speed=300l;
		while(stop == false){
			
		
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			String[] a1 = storage.deliver(1);
			String[] a2 = storage.deliver(1);
			String[] t1 = storage.deliver(2);
			String[] c1 = storage.deliver(3);
			String[] e1 = storage.deliver(4);
			String[] e2 = storage.deliver(4);
			
			Threadee roboter = build(a1,a2,t1,c1,e1,e2);
		}
		
	}	
	/**
	 * This method sorts the values of an int-array in ascending order
	 * @param array: Array, which should be sorted
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
	 * This method takes a int and a string array and parses the string-values into int-values
	 * @param array1: Int array, in which the string-values of array2 are saved as int-values
	 * @param array2: String array, with the string-values in it
	 */
	public static void toInt(int[] array1,String[] array2){
		for (int i = 0; i < array2.length; i++) {
		    if(i == 0){
		    	
		    }else{
		    	array1[(i-1)] = Integer.parseInt(array2[i]); 
		    }
		}
	}
}
