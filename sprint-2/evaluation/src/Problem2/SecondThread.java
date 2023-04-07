package Problem2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SecondThread {
	public static void main(String[] args) throws IOException {
		BufferedReader   br=new BufferedReader(new FileReader("student.txt"));
		List<Student>allLines=br.readLine();
		br.close();
		
		
		
		int max=0;
		for(String line:allLines) {
			
		}
	}
	
}
