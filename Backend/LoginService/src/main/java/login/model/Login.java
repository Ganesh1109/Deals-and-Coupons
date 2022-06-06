package login.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "cred")
public class Login {
	@Id
	private String userId;
	private String useremail;
	private int password;
	
}