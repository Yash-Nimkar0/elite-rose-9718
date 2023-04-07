package problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class prob2 {
	public static void main(String[] args) {
		List<Student>students=new ArrayList<>();
		students.add(new Student(10,"ST1",500,"Mumbai"));
		students.add(new Student(20,"ST2",800,"BLR"));
		students.add(new Student(30,"ST3",300,"Delhi"));
		students.add(new Student(40,"ST4",750,"Chennai"));
		students.add(new Student(50,"ST5",250,"Kolkata"));
		
		
		students.forEach(r->System.out.println(r));
		System.out.println("-------------------");
		
		
		List<Employee>emps=students.stream().filter(s->s.getMarks()>500)
				.map(s->new Employee(s.getRoll(),s.getName(),s.getMarks()*10000,s.getAddress()))
				.collect(Collectors.toList());
		Collections.sort(emps,(a,b)->a.getSalary()<b.getSalary()?+1:-1);
		emps.forEach(r->System.out.println(r));
		
	}
}
