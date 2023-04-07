package assignments1;

public class rev extends Thread {
	public void run() {
		int sum1=0;
		int sum2=1;
		for(int i=1;i<=10;i++) {
			int sum=sum1+sum2;
			sum1=sum2;
			sum2=sum;
			System.out.println(sum);
		}
	}
}
