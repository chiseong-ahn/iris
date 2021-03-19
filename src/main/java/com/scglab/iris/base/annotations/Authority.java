package com.scglab.iris.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authority {

	Role role() default Role.GUEST;
	
	public enum Role {
		ADMIN,
		MEMBER,
		GUEST;
	}
}

