package Problem2;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Common c= new Common();
		Salman sl=new Salman(c);
		Hritik hr=new Hritik(c);
		
		sl.start();
		hr.start();
	}

}
