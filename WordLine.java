import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.ArrayList;

public class WordLine {

	static TreeMap<String, ArrayList<Integer>> Map = new TreeMap<>();

	public static void Maps(char lower, char upper, String fileName) {

		TextFileInput inFile = new TextFileInput(fileName);
		String line = inFile.readLine();
		int counter = 1;
		Map.clear();

		while (line != null) {
			StringTokenizer tokens = new StringTokenizer(line, ",. ():\'’”‘“\"");
			while (tokens.hasMoreTokens()) {
				String s = tokens.nextToken();
				if (Map.containsKey(s)) {
					ArrayList<Integer> x = (ArrayList<Integer>) Map.get(s);
					x.add(counter);
					Map.put(s, x);
				} else if (!Map.containsKey(s)) {
					if (s.charAt(0) == lower || s.charAt(0) == upper) {
						ArrayList<Integer> arrlist = new ArrayList<Integer>();
						arrlist.add(counter);
						Map.put(s, arrlist);
					}
				}

			}
			counter++;
			line = inFile.readLine();
		}
	}

	public static TreeMap getTreemap() {
		return Map;
	}
}