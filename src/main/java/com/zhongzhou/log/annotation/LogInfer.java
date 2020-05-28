package com.zhongzhou.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogInfer {
    String logModel();
    String logType();
    String ID() default "id";
    String remake() default "无";
    String objectKey() default "无";
}
