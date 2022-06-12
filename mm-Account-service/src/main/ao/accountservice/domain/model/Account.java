package ao.accountservice.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;//retornar sugestao quando falhar
	private String firstName;
	private String lastName;
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="account_id")
	private List<Saving> savings;
	
	public Account(String Fname,String Lname,String username, String password) {
		this.firstName=Fname;
		this.password=password;
		this.lastName=Lname;
		this.username=username;
	}
}
