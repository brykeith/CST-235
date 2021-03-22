package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import beans.Word;
import business.WordFetchService;

@ManagedBean
@SessionScoped
public class FormController {
	@EJB WordFetchService service;
	
	public void findWord(Word word) {
		service.findOccurences(word);
	}
}
