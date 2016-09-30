/**
 *
 */
package com.gzj.tulip.jade.plugin.sql.annotations;

import java.lang.annotation.*;

/**
 * @author Alan
 */
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreNull {

    boolean value() default true;//默认忽略空
}
