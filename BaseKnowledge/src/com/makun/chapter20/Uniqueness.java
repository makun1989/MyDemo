package com.makun.chapter20;

public @interface Uniqueness {
	Constraints constraints() default @Constraints;
}
