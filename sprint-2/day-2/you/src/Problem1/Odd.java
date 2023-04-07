package Problem1;

public class Odd implements Runnable{
	Thread tr;
	public Odd(Thread tr){
		this.tr=tr;
	}
	public void run() {
		try {
			tr.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<=20;i++) {
			if(i%2==1) {
				System.out.println(i);
			}
		}
	}
}
