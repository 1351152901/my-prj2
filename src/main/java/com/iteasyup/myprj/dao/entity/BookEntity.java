package com.iteasyup.myprj.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BookEntity {
    
	private int id;
	
	private String bookName;
	
	private String publishTime;
}
