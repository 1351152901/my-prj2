package com.iteasyup.myprj.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.iteasyup.myprj.controller.bean.SigninForm;
import com.iteasyup.myprj.service.UserService;
import com.iteasyup.myprj.service.model.User;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SigninController {
    
	private UserService userService;
	@GetMapping("signin")
	public String init(@ModelAttribute SigninForm signinForm) {
		
		return "signin";
	}
	
	
	@PostMapping("signin")
	public String signin(@ModelAttribute @Valid SigninForm signinForm,BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			
			return "signin";
		}
		
		User user = userService.signinByUsernameAndPassword(signinForm);
		
		if(user == null) {
			
			model.addAttribute("errors3", "用户名或密码错误！");
			return "signin";
		}
		return "redirect:/index";
	}
}
