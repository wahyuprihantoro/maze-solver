import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

public class PathLengthCount {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
		TreeMap<String, Integer> map = new TreeMap<>();
		String input = null;
		while ((input = br.readLine()) != null) {
			if (map.get(input) == null) {
				map.put(input, 1);
			} else {
				map.put(input, map.get(input) + 1);
			}
		}
		for (String string : map.keySet()) {
			System.out.println(string + " -> " + map.get(string));
		}
	}
}
