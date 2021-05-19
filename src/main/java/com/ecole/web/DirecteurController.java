package com.ecole.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecole.beans.Etudiant;
import com.ecole.beans.Professeur;
import com.ecole.service.IDirecteurService;

@Controller
@RequestMapping("/directeur")
public class DirecteurController {
	@Autowired
	private IDirecteurService directeurService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping({"","/"})
	public String defaultPage(Model model) {
		return "directeur";
	}
	
	@GetMapping("/profs")
	public String getAllProfs(Model model) {
		model.addAttribute("profs",directeurService.allProfs());
		return "directeur";
	}
	
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students",directeurService.allStudents());
		return "directeur";
	}
	
	@GetMapping("/student/form")
	public String getStudentForm(Model model){
		model.addAttribute("etudiant", new Etudiant());
		return "directeur";
	}
	
	@PostMapping("/addStudent")
	public String saveStudent(@Valid Etudiant student,BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "directeur";
		student.setPassword(passwordEncoder.encode(student.getPassword()));
		directeurService.addEtudiant(student);
		return "redirect:";       
	}
	
	@GetMapping("/prof/form")
	public String getProfForm(Model model) {
		model.addAttribute("professeur",new Professeur());
		return "directeur";
	}
	
	@PostMapping("/addProf")
	public String saveProf(@Valid Professeur prof,BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "directeur";
		prof.setPassword(passwordEncoder.encode(prof.getPassword()));
		directeurService.addProf(prof);
		return "redirect:";
	}
	
}



