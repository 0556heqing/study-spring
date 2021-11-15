package com.heqing.springboot.controller.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author heqing
 * @date 2021/7/16 18:41
 */
@Documented
//指定注解的处理类
@Constraint(validatedBy = {ConstantValidatorHandler.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface Constant {

    String message() default "{constraint.default.const.message}";

    String value();

    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}