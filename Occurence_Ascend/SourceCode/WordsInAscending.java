// Michael Skipper, N01162792
import java.util.*;
public class WordsInAscending {
	 public static void main(String[] args) {	
	String text = "z Good morning. Have a good class. Have a good visit. Have fun!";
    Map<String, Integer> map = new TreeMap<>();
    String[] words = text.split("[\\s+]");
    for (String anotherword : words) {
        String key = anotherword.toLowerCase();
        if (key.length() > 0) {
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                int value = map.get(key);
                value++;
                map.put(key, value);
            }
        }
    }
    ArrayList<WordOccurrence> list = new ArrayList<>();
    map.forEach((k, v) -> list.add(new WordOccurrence(k, v)));
    Collections.sort(list);
    list.forEach((word) -> System.out.println(word.word + "\t" + word.count));
    
    // if we stored the instances of WordOccurrence in a tree set, 
    // the implementation would involve the semantics of a binary search tree, 
    // as opposed to the more logical capability of storing the instances in 
    // an array list, to store elements initially in the order of their input order 


}
	
	private static class WordOccurrence implements Comparable<WordOccurrence> {
	
	    int count;
	    String word;
	
	    public WordOccurrence(String word, int count) {
	        this.word = word;
	        this.count = count;
	    }
	
	    @Override
	    public int compareTo(WordOccurrence o) {
	        if (o.count > count)
	            return -1;
	        else if (o.count < count)
	            return 1;
	        else
	            return 0;
	    }

	} 
}
