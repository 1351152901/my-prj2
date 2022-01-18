package com.iteasyup.myprj.controller.bean;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain  = true)
public class SignupForm {
    
	@NotEmpty(message = "{MES_001}")
	@Size(max = 12,min = 6,message = "{MES_002}")
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]{5,11}",message = "{MES_003}")
	private String username;
	
	@NotEmpty(message = "{MES_004")
	@Size(max = 12,min = 6,message = "{MES_005}")
	private String email;
	
	@NotEmpty(message = "{MES_006}")
	@Size(max = 10,min = 6,message = "{MES_007}")	
	private String password;
	
	@NotEmpty(message = "{MES_008}")
	@Size(max = 10,min = 6,message = "{MES_009}")
	private String repassword;
}
