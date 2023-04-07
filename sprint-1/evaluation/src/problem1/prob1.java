package problem1;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier; 
public class prob1 {
	public static void main(String[] args){
		//Predicate
		Predicate<Product>p1=p->p.getQuantity()<5;
		System.out.println(p1.test(new Product(10,"Car",15,10)));
		System.out.println("---------------------");
		//Consumer
		Consumer<Product>c1=s->System.out.println(s);
		c1.accept(new Product(20,"pen",20,20));
		System.out.println("---------------------");
		//Supplier
		Supplier<Product>s1=()->new Product(30,"house",899,2);
		System.out.println(s1.get());
		System.out.println("---------------------");
		//Function
		 
	}
}
