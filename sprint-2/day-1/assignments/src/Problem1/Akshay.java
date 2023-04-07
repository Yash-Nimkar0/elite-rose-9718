package Problem1;

public class Akshay {
	public static void main(String[] args) {
		Hritik hr = new Hritik();
		Salman sl=new Salman();
		Thread tr1=new Thread(hr);
		Thread tr2=new Thread(sl);
		tr1.start();
		tr2.start();
		try {
			tr1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tr2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName());
		}
		
	}
}
