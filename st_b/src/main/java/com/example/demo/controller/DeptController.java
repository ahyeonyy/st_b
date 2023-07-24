package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.DeptDAO_JPA;
import com.example.demo.dao.DeptDAO_mb;

import lombok.Setter;

@Setter
@Controller
public class DeptController {
	@Autowired
	private DeptDAO_JPA dao_JPA;

	@Autowired
	private DeptDAO_mb dao_mb;

	@GetMapping("/dept/list")
	public void list(Model model) {
		model.addAttribute("list", dao_JPA.findAll());
	}
	
	@GetMapping("/dept/detail/{dno}")
	public String detail(@PathVariable("dno") int dno,Model model) {
		model.addAttribute("d",dao_mb.findByDno(dno));
		return "/dept/detail";
	}
}