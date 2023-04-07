package problem1;

public class Virat extends Thread {
	Rohit r;
	public Virat(Rohit r) {
		// TODO Auto-generated constructor stub
		this.r=r;
	}
	public void run() {
		try {
			r.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int sum=0;
		for(int i=0;i<=20;i++)sum+=i; 
		System.out.println(Thread.currentThread().getName()+" calculated "+sum);
			
		
	}
}
