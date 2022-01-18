package com.iteasyup.myprj.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Book {
   
	private int id;
	
	private String bookName;
	
	private String publishTime;
}
