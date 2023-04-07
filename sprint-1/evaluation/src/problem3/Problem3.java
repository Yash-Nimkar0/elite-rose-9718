package problem3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem3 {
	public static void main(String[] args) {
		List<String>names=Arrays.asList("Yash","Janhavi","Shivani","Gajanan","Chitra","Sarthak","Aditya","Netra","Aarya","Vedant");
		names.forEach(r->System.out.println(r));
		System.out.println("-------------------");
		List<String>newnames=names.stream().filter(s->s.length()%2==0).map(s->s.toUpperCase())
		.sorted((a,b) -> a.compareTo(b)> 0 ? -1 : +1 ).collect(Collectors.toList());
		newnames.forEach(r->System.out.println(r));
	}
}
