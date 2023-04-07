package problem1;

public class Main {
	public static void main(String[] args) {
		Dhoni d=new Dhoni();
		Rohit r=new Rohit(d);
		Virat v=new Virat(r);
		d.setName("Dhoni");
		r.setName("Rohit");
		v.setName("Virat");
		d.setPriority(10);
		d.start();
		r.start();
		v.start();
	}

}
