package com.iteasyup.myprj.controller.bean;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SigninForm {
    
	@NotEmpty(message = "{MES_010}")
	private String username;
	
	@NotEmpty(message = "{MES_011}")
	private String password;
}
