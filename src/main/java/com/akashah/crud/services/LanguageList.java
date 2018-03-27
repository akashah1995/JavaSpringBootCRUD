package com.akashah.crud.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.akashah.crud.models.Language;
import com.akashah.crud.repositories.LanguageRepository;




@Service
public class LanguageList {
	private LanguageRepository languageRepository;
	
	public LanguageList(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	ArrayList<Language> listLanguages = new ArrayList <Language> ();
	
	public ArrayList<Language> allLanguages(){
		return (ArrayList<Language>) languageRepository.findAll();
	}
	
	public Language findLanguageById(Long id) {
		return languageRepository.findOne(id);
		
	}
	
	public void addLanguage(Language language) {
		languageRepository.save(language);
	}
	
	public void updateLanguage(long id,Language language) {
		languageRepository.delete(id);
		languageRepository.save(language);
		
	}
	
	public void deleteLanguage(Long Id) {
			languageRepository.delete(Id);

	}
	

}
