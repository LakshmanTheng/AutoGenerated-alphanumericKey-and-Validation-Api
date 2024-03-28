package in.login.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name = "login")
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	@Size(min=3, max=50, message="Name should be minimum 3 charector and maxx 50 charecter")
	private String name;
	
	@Email
	@NotEmpty(message="Your Email id is not correct !!!")
	private String email;
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	@Size(min = 4, max = 10, message = "password must be min of 3 char and max of 10 char")
	private String password;
	
	private String loginid=UUID.randomUUID().toString().replace("-", "").substring(0,10);

	public Login() {
		super();
		
	}

	public Login(Long id,
			@NotEmpty @Size(min = 3, max = 50, message = "Name should be minimum 3 charector and maxx 50 charecter") String name,
			@Email @NotEmpty(message = "Your Email id is not correct !!!") String email, @NotEmpty String username,
			@NotEmpty @Size(min = 4, max = 10, message = "password must be min of 3 char and max of 10 char") String password,
			String loginid) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.loginid = loginid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	
//	@PrePersist
//	private void loginId() {
//		if(loginid == null) {
//			String uuid= UUID.randomUUID().toString().replace("-", "").substring(0, 8);
//			this.loginid=uuid;
//		}
//	}
	
	
}
