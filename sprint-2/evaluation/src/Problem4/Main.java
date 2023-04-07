package Problem4;

public class Main {
	public static void main(String[] args) {
		Common c=new Common();
		Producer pt=new Producer(c);
		Consumer ct=new Consumer(c);
		
		pt.start();
		ct.start();
	}
}
