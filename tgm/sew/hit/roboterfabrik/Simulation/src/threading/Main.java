package threading;

public class Main {
	public static void main(String[] args) {
		
		WatchDog wd = new WatchDog(10);
		
		for (int i = 0; i < 5; i++) {
			
			NumberThread t = new NumberThread(i+1);
			new Thread(t).start();
			wd.add(t);
			
		}
		
		new Thread(wd).start();
		
	}
}