package Problem4;

public class Consumer extends Thread {
	Common c;
	public Consumer(Common c) {
		// TODO Auto-generated constructor stub
		this.c=c;
		
	}
	
	public void run() {
		while (true) {
			int i=c.consume();
			System.out.println("Consumer calculated"+i);
			
		}
	}
}
