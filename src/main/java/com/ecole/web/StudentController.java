package com.ecole.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecole.service.IEtudiantService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private IEtudiantService etudiantService;
	
	@GetMapping({"","/"})
	public String defaultPage() {
		return "etudiant";
	}
	
	@GetMapping("/profs")
	public String getMyProfs(Model model) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Long student_id = etudiantService.etudiant(email).getId();
		model.addAttribute("profs",etudiantService.myProfs(student_id));
		return "etudiant";
	}
	
	@GetMapping("/cours")
	public String getMyCours(Model model) {
		model.addAttribute("cours",etudiantService.myCourses());
		return "etudiant";
	}

}
