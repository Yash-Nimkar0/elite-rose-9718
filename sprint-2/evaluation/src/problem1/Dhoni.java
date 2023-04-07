package problem1;

public class Dhoni extends Thread{
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println(currentThread().getName()+" is printing "+i); 
		}
	}
}
