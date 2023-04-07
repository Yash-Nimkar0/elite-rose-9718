package Problem3;

public class T1 extends Thread{
	public void run(){
		for(int i=0;i<10;i++) {
			System.out.println(i+"T1");
		}
	}
}
