package com.iteasyup.myprj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.iteasyup.myprj.controller.bean.BookForm;
import com.iteasyup.myprj.dao.BookDao;
import com.iteasyup.myprj.dao.entity.BookEntity;
import com.iteasyup.myprj.service.model.Book;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    
	private BookDao bookDao ;
	
	public List<Book> showBook(){
		
		List<BookEntity> bookEntities = bookDao.searchBook();
		
		List<Book> books = new ArrayList<Book>();
		
		for(int i = 0;i<bookEntities.size();i++) {
			Book book = new Book(bookEntities.get(i).getId(),
					             bookEntities.get(i).getBookName(),
					             bookEntities.get(i).getPublishTime());
			books.add(book);
		}
		return books;
	}
	
	
    public int addBook(BookForm bookForm) {
    	
    	BookEntity bookEntity = new BookEntity(bookForm.getId(),
    			              bookForm.getBookName(),
    			              bookForm.getPublishTime());
    	
    	int result = bookDao.addBook(bookEntity);
    	
    	return result;
    }
    
    
    public int modifyBook(BookForm bookForm) {
    	
    	BookEntity bookEntity  = new BookEntity(bookForm.getId(),bookForm.getBookName(),bookForm.getPublishTime());
    	
    	int result = bookDao.modifyBookById(bookEntity);
    	
    	if(result != 0) {
    		
    		return result;
    	}
    	return 0;
    }
    
    public int deleteBook(BookForm bookForm) {
    	
    	int bookId = bookForm.getId();
    	
    	int result = bookDao.deleteBookById(bookId);
    	
    	if(result != 0) {
    		
    		return result;
    	}
    	return 0;
    }
    
    public List<Book> select(BookForm bookForm){
    	
    	String name ="%"+bookForm.getBookName()+"%";
    	
    	List<BookEntity> bookEntities = bookDao.selectByName(name);
    	
    	List<Book> books = new ArrayList<Book>();
    	
    	for(int i = 0;i<bookEntities.size();i++) {
    		Book book = new Book(bookEntities.get(i).getId(),
    				bookEntities.get(i).getBookName(),
    				bookEntities.get(i).getPublishTime());
    		books.add(book);
    	}    	  
    		
    		return books;  	
   	    	
    }
}
