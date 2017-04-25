package me.mancos.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by mancos on 2017/3/18.
 * 上午10:04
 * TODO:
 * qualifier : Sometimes the type alone is insufficient to identify a dependency
 */

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ContextLife {
    String value() default "Application";
}
