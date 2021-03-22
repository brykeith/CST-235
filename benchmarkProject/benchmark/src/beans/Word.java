/*
 * Creator: Donald Trowbridge
 * Date: 12/13/2020
 */

package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="word")
@SessionScoped
public class Word {
	private String Word;
	private int occurences;
	
	public Word() {
		occurences = -1;
	}

	public String getWord() {
		return Word;
	}

	public void setWord(String word) {
		Word = word;
	}

	public int getOccurences() {
		return occurences;
	}

	public void setOccurences(int occurences) {
		this.occurences = occurences;
	}
	
	
}
