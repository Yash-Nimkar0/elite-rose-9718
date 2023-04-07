package Problem1;

public class Even implements Runnable{
	public void run() {
		for(int i=0;i<=20;i++) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
	}
}
