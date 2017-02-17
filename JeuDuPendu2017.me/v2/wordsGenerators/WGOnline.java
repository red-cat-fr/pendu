package v2.wordsGenerators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import v2.WordsGenerator;

/**
 * Created by ianisbedard on 15/02/2017.
 */
public class WGOnline implements WordsGenerator {

	private String searchWord() throws IOException {

		StringBuilder result = new StringBuilder();
		URL url = new URL("http://www.palabrasaleatorias.com/mots-aleatoires.php");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		int count = 0;
		while ((line = rd.readLine()) != null) {
			if (count == 113) {
				result.append(line.substring(0, line.indexOf("<")));
			}
			count++;
		}
		rd.close();
		String stringResult = result.toString();
		System.out.println(stringResult);
		if (stringResult.contains(" ")) {
			stringResult = stringResult.substring(0, stringResult.indexOf(" "));
			System.out.println(stringResult);
		}

		return stringResult.toLowerCase();

	}

	@Override
	public String getWord() {
		String string = null;
		try {
			string = searchWord();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return string;
		}
	}
}
