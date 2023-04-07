package Problem1;

public class Salman implements Runnable {
	public void run() {
		int sum=0;
		for(int i=0;i<10;i++) {
			sum=sum+i;
			
		}
		for(int i=0;i<10;i++) {
			
			System.out.println(sum);
		}
	}
}
