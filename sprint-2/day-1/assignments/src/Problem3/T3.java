package Problem3;

public class T3 extends Thread{
	Thread tr3;
	public T3(Thread tr3) {
		 this.tr3=tr3;
	}
	public void run(){
		try {
			tr3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<10;i++) {
			System.out.println(i +"T3");
		}
	}
}
