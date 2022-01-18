package com.iteasyup.myprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.iteasyup.myprj.controller.bean.BookForm;
import com.iteasyup.myprj.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DeleteController {
    
	private BookService bookService;
	
	@GetMapping("delete")
	public String delete(BookForm bookForm,Model model) {
		
		int res = bookService.deleteBook(bookForm);
		
		if(res ==0) {
			
			model.addAttribute("error6", "删除失败");
			return "index";
		}
		return "index";
	}
}
