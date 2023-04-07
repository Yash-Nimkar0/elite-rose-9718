package problem1;

public class Rohit extends Thread{
	Dhoni d;
	public Rohit(Dhoni d) {
		// TODO Auto-generated constructor stub
		this.d=d;
	}
	public void run() {
		try {
			d.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int product=1;
		for(int i=1;i<=10;i++)product*=i;
			System.out.println(Thread.currentThread().getName()+" calculated "+product);
		
		
		
	}
}
