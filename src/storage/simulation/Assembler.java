package storage.simulation;

import java.util.ArrayList;

public class Assembler {
	
	private ArrayList<String> parts;
	private int assemblerID;
	
	public ArrayList<String> getParts() {
		return parts;
	}
	
	public void setParts(ArrayList<String> parts) {
		this.parts = parts;
	}
	
	public int getAssemblerID() {
		return assemblerID;
	}
	
	public void setAssemblerID(int assemblerID) {
		this.assemblerID = assemblerID;
	}
	
	public void build(String parts)	{
		
	}
}