package Problem2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FirstThread {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<Student> stds=new ArrayList<>();
		stds.add(new Student("Anuj",56.25,77.58));
		stds.add(new Student("Bharat",66.25,57.58));
		stds.add(new Student("Chaman",70.25,66.74));
		stds.add(new Student("Dhanush",58.25,95.74));
		stds.add(new Student("Garv",58.62,95.74));
		
		PrintWriter pr  =new PrintWriter("student.txt");
		for(Student std:stds )pr.println(std);
		pr.flush();
		pr.close();
		System.out.println("Done");
		
	}
}
