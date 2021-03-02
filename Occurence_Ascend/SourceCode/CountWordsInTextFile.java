// Michael Skipper, N01162792 
import java.io.*;
import java.util.*;
public class CountWordsInTextFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path as a Program Argument from the Run Configurations menu. ");
        File file = new File(scanner.next());
        if (!file.isFile()) {
            System.out.println(file + " is not a file. ");
        }
        String[] words;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            StringBuilder buffer = new StringBuilder(10000);
            String s;
            while ((s = in.readLine()) != null)
                buffer.append(s).append("\n");
            words = buffer.toString().split("[ \n\t\r.,;:!?(){}]");
        } catch (IOException ex) {
            words = new String[1];
            System.out.println("Error opening file. ");
            System.exit(0);
        }
        scanner.close();
        Map<String, Integer> map = new TreeMap<>();
        for (String word1 : words) {
            String key = word1.toLowerCase();
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
        map.forEach((k, v) -> System.out.println(k + "\t" + v));
    }
}