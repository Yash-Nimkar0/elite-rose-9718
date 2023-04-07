package Problem1;

public class Demo {
	public static void main(String[] args) {
		Even e=new Even();
		Thread e1=new Thread(e);
		Odd o=new Odd(e1);
		
		Thread o1=new Thread(o);
		e1.start();
		o1.start();
	}
}
