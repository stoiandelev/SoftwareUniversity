package Anotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ Interface, we create annotation;
 * We have -> retention policy, target and attributes;
 * Name -> for name of table
 *
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {

    String name();


}
