package main;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.RUNTIME)
@Repeatable(NullFields.class)
@Target(FIELD)
public @interface Nullable {
	boolean value() default false;
}
