package ao.accountservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties("accountservice")
@Getter
@Setter
public class Configuration {

	private String name;
	private String lastName;

}
