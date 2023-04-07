package Problem4;
import java.util.Random;
import java.util.random.*;
public class Producer extends Thread {
	Common c;
	
	public Producer(Common c) {
		// TODO Auto-generated constructor stub
		this.c=c;
	}
	public void run() {
		Random rand=new Random();
		int top=6;
		
		int i=rand.nextInt(top);
		while(true) {
			c.produce(i);
			i=rand.nextInt(top);
		}
		
		
	}
}
