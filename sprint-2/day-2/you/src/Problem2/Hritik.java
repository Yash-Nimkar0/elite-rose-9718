package Problem2;

public class Hritik extends Thread {
	
	Common c;
	public Hritik(Common c) {
		this.c=c;
	}
	
	
	
	public void run() {
		while(true) {
			int i=c.consume();
			System.out.println(i);
		}

}
}