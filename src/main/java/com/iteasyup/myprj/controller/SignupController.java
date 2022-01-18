package com.iteasyup.myprj.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iteasyup.myprj.controller.bean.SignupForm;
import com.iteasyup.myprj.service.UserService;
import com.iteasyup.myprj.service.model.User;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SignupController {
    
	private UserService userService;
	@GetMapping("signup")
	public String init(@ModelAttribute SignupForm signupForm) {
		
		return "signup";
	}
	
	@ResponseBody
	@PostMapping("ajax")
	public String ajax(String username) {
		
		User user = userService.getUserByUsername(username);
		
		if(user !=null) {
			
			return "此用户已存在";
		}
		return "";
	}
	
	@PostMapping("signup")
	public String addUser(@ModelAttribute @Valid SignupForm signupForm,
			BindingResult result,Model model) {
		
		//输入的格式校验
		if(result.hasErrors()) {
			return "signup";
		}
//		//判断此用户是否已经存在
//		User user  = userService.getUserByUsername(signupForm.getUsername());
//		
//		if(user !=null) {
//		    model.addAttribute("userError", "此用户名已存在，请重新输入");
//		    return "signup";
//		}
		
		//密码与确认密码一致性校验
		if(signupForm.getPassword()!=null && signupForm.getRepassword()!=null) {
			if(!signupForm.getPassword().equals(signupForm.getRepassword())) {
				
				model.addAttribute("errors1","密码输入不一致，请重新输入！");
				return "signup";
			}
		}
		
		int res = userService.addUser(signupForm);
		
		if(res == 0) {
			
			model.addAttribute("errors2", "用户注册失败");
			return "signup";
		}
		
		return "redirect:/signin";
	}
}
