package com.iteasyup.myprj.controller.bean;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.iteasyup.myprj.service.BookService;
import com.iteasyup.myprj.service.model.Book;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SelectController {
    
	private BookService bookService;
	
	@PostMapping("select")
	public String select(BookForm bookForm,Model model) {
		
		List<Book> books = bookService.select(bookForm);
		
		model.addAttribute("books", books);
		
		return "redirect:/select";
	}
}
