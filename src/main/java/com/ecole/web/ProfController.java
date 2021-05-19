package com.ecole.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecole.service.IProfesseurService;

@Controller
@RequestMapping("/prof")
public class ProfController {
	@Autowired
	private IProfesseurService professeurService;
	
	@GetMapping({"","/"})
	public String defaultPage(Model model) {
		return "prof";
	}
	
	@GetMapping("/students")
	public String getMyStudents(Model model) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Long prof_id = professeurService.professeur(email).getId();
		model.addAttribute("students",professeurService.myStudents(prof_id));
		return "prof";
	}
	
	@GetMapping("/cours")
	public String getMyCours(Model model) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Long prof_id = professeurService.professeur(email).getId();
		model.addAttribute("cours",professeurService.myCourses(prof_id));
		return "prof";
	}
	

}
