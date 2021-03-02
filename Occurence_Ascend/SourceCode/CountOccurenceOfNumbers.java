// Michael Skipper, N01162792
import java.util.*;
public class CountOccurenceOfNumbers {	
	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);
		Map<Integer, Integer> map = new HashMap<>(); 
		System.out.println("Enter a sequence of integers ending with 0: ");
		int key;
		while ((key = input.nextInt()) != 0) {
			if (!map.containsKey(key)) {
				map.put(key, 1);
			}
			else {
				int counter = map.get(key);
				counter++;
				map.put(key, counter);
			}
		}
		int max = Collections.max(map.values());

		System.out.println("The most commonly occuring integer(s) in your input: ");
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max) {
				System.out.print(entry.getKey() + " ");
			}
		}
	}
}