package com.akashah.crud.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.akashah.crud.models.Language;
import com.akashah.crud.services.LanguageList;

@Controller
public class LanguagesController {
	
	LanguageList languageList;
	
	public LanguagesController(LanguageList languageList) {
		this.languageList = languageList;
	}
	
//	@Transactional
	@RequestMapping("/languages")
	public String Display(Model model, @ModelAttribute("language") Language language, BindingResult result) {
		ArrayList <Language> listLanguages = languageList.allLanguages();
		model.addAttribute("listLanguages", listLanguages);
		System.out.println(listLanguages);
		System.out.println("none here");
		return "Languages.jsp";
	}
	@PostMapping("/languages")
	public String addLanguage(@Valid @ModelAttribute("language")Language language, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "Languages.jsp";
		}
		
		else {
			
			languageList.addLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{id}")
	public String aboutLanguage(@PathVariable("id") Long id, Model model) {
		Language language =languageList.findLanguageById(id);
		model.addAttribute("language",language);
		return "aboutLanguage.jsp";
	}
	
	@RequestMapping("/languages/edit/{id}")
	public String editLanguage(@PathVariable("id") Long id, Model model, @ModelAttribute("language") Language language) {
		 model.addAttribute("index",id);
		 return "editLanguage.jsp";
	}
	
	@PostMapping("/languages/modify/{id}")
	public String modifyLanguage(@Valid @ModelAttribute("language")Language language, BindingResult result, HttpSession session,@PathVariable("id")Long id ) {
		if(result.hasErrors()) {
			return "editLanguage.jsp";
		}
		
		else {
			languageList.updateLanguage(id,language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/delete/{id}")
	public String deleteLanguage(@PathVariable("id") Long id, Model model) {
		 languageList.deleteLanguage(id);
		 return "redirect:/languages";
	}
	
	
	
}
