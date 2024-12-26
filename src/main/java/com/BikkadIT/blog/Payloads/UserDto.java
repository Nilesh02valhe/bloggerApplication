package com.BikkadIT.blog.Payloads;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotNull
	private String name;
	@Email
	private String email;
	@NotBlank
	private String password;
	@NotNull
	private String about;

}
