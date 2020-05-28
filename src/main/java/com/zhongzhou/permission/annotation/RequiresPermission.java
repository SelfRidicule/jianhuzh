package com.zhongzhou.permission.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequiresPermission {
    //属于哪一个url
    String ManagerUrl();
    //属于哪一个操作权限
    String Permission() default "";
}
