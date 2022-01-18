package com.iteasyup.myprj.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {
   
	private int id;
	
	private String username;
	
	private String email;
	
	private String password;
}
