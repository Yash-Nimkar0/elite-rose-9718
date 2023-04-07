package Problem2;

public class Salman extends Thread{
	Common c;
	
	public Salman(Common c) {
		this.c=c;
	}
	
	
	
	public void run() {
		int i=0;
		while(true) {
			c.produce(i);
			i++;
		}
}
}