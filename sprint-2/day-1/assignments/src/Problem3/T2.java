package Problem3;

public class T2 extends Thread{
	Thread tr2;
	public T2(Thread tr2) {
		this.tr2=tr2;
	}
	public void run(){
		try {
			tr2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<10;i++) {
			System.out.println(i+"T2");
		}
	}
}
