import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsPractice {

	public static void main(String[] args) {
		List<Integer> li = new ArrayList<Integer>();
		for(int i=0;i<10;i++)
		{
			li.add(i);
		}
		Stream<Integer> stream = li.stream();
		stream.forEach(p -> System.out.println(p));

	}

}
