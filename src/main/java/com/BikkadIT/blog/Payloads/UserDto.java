package com.BikkadIT.blog.Payloads;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotEmpty()
	@Size(min=4, message="Username must be minimum 4 characters !!")
	private String name;
	
	@Email(message="Email address is not valid !!")
	private String email;
	
	@NotEmpty()
	@Size(min = 6, max= 12, message="Password must be minimum of 6 char")
//	@Pattern (message="Maximum 4 Alphanumariacal")
	private String password;
	
	@NotEmpty()
	private String about;

}
