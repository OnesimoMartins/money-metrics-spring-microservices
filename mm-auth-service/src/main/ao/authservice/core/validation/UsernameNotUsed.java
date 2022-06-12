package ao.authservice.core.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=UsernameNotUsedValidation.class)
public @interface UsernameNotUsed {
	
	String message() default "username already used by another account";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
