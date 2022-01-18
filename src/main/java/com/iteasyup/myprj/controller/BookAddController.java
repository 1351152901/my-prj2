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
public class BookAddController {
    
	private BookService bookService;
	@GetMapping("add")
	public String init() {
		
		return "addbook";
	}
	
	@PostMapping("add")
	public String add(BookForm bookForm,Model model) {
		
		int res = bookService.addBook(bookForm);
		
		if(res == 0) {
			
			model.addAttribute("error4","添加书籍失败");
			return "addbook";
		}
		
		return "redirect:/index";
	}
}
