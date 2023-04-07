package Problem1;

public class Hritik implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int pro=1;
		for(int i=1;i<10;i++) {
			pro=pro*i;
		}
		for(int i=1;i<10;i++) {
			
			System.out.println(pro);
		}
	}
	
	
}
