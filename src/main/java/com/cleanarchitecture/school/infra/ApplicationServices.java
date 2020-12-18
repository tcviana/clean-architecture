package com.cleanarchitecture.school.infra;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A anotacao <code>ApplicationServices</code> indica que uma classe faz parte
 * da camada de aplicacao.
 *
 * @author Roberto Perillo
 * @version 1.0 07/03/2017
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface ApplicationServices {


}
