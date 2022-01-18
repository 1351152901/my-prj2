package com.iteasyup.myprj.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.iteasyup.myprj.service.BookService;
import com.iteasyup.myprj.service.model.Book;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {
    
	private  BookService bookService;
	
	@GetMapping("index")
	public String init(Model model) {
		
		List<Book> books = bookService.showBook();
		
		model.addAttribute("books", books);
		
		return "index";
	}
}
