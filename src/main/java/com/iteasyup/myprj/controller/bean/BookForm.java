package com.iteasyup.myprj.controller.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BookForm {
   
	private int id;
	
	private String bookName;
	
	private String publishTime;
}
