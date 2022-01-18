package com.iteasyup.myprj.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserEntity {
   
	private int id;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private String creatTime;
}
