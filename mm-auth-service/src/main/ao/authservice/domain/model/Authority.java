package ao.authservice.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "Authority")
public class Authority  implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	
	public Authority(String name) {
		this.name=name;
	}
	
	@Override
	public String getAuthority() {
		return this.name.toUpperCase();
	}
}
