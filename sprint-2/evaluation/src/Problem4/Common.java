package Problem4;

public class Common {
	int num;
	boolean flag=true;
	public synchronized void produce(int i) {
		if(flag==true) {
			num=i;
			this.notify();
			System.out.println("Producer produced "+num);
			flag=false;
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized int consume() {
		int sum=0;
		if(flag==true) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		flag=true;
		this.notify();
		for(int k=0;k<=num;k++) {
			sum+=k;
			
		}
		return sum; 
	}
}
