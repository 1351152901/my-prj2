package com.iteasyup.myprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.iteasyup.myprj.controller.bean.BookForm;
import com.iteasyup.myprj.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ModifyController {
    
	private BookService bookService;
	
	@GetMapping("modify")
	public String modify() {
		
		return "modify";
	}
	
	@PostMapping("modify")
	public String change(BookForm bookForm,Model model) {
		
		int res = bookService.modifyBook(bookForm);
		
		if(res == 0) {
			
			model.addAttribute("error5", "修改失败！");
			return "modify";
		}
		return "redirect:/index";
	}
}
