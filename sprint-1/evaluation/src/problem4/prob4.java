package problem4;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
public class prob4 {
		public static void main(String[] args) {
			List<Integer>ages=Arrays.asList(10,19,26,54,75,27,9,13,6,38);
		
			long count=ages.stream().filter(s->s>=18)
					.count();
			if(count>0) {
				System.out.println("Some or none will cast vote");
			}
			else {
				System.out.println("You all can cast your vote");
			}
			System.out.println("_______________");
			ages.stream().forEach(s->System.out.println(s));
			System.out.println("_______________");
			List newlist=ages.stream().collect(Collectors.toList()); 
			Collections.sort(newlist);
			System.out.println("_______________");
			for(int i=5;i<=7;i++) {
				System.out.println(newlist.get(i));
			}
			System.out.println("_______________");
		long sum=	ages.stream().mapToInt((x)->x).summaryStatistics().getSum();
		System.out.println(sum);
		
		
	}
		
}

//True
//False



