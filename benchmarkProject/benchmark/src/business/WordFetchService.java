package business;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Word;


@Stateless
@LocalBean
public class WordFetchService {
	
	private String BibleApiUrl = "https://api.scripture.api.bible/v1/bibles/de4e12af7f28f599-01";
	private String ApiKey = "360ac1bec3974694ac360b536d9f5070";
	                         

    public WordFetchService() {}

    public void findOccurences(Word word) {
    	try {
    		
    		String urlStr = BibleApiUrl + "/search?query=" + word.getWord() + "&limit=1";
    		URL url = new URL(urlStr);
    		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    		conn.setRequestMethod("GET");
    		conn.setRequestProperty("api-key", ApiKey);
    		
    		if(conn.getResponseCode() == 200) {
    			
    			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String contents = bufferReader.readLine();
				bufferReader.close();
				conn.disconnect();
				
				
				String totalPattern = "\"total\":";
				int start = contents.indexOf(totalPattern);
				if(start > 0) {
					start += totalPattern.length();
					String total = contents.substring(start, contents.indexOf(",", start));
					try {
						int totalInt = Integer.parseInt(total);
						word.setOccurences(totalInt);
					} catch(Exception e) {
						word.setOccurences(-1);
						e.printStackTrace();
					}
				}
    		}
    	}catch(Exception e) {
    		word.setOccurences(-1);
    		e.printStackTrace();
    	}
    }
}
