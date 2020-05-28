package com.zhongzhou.log;

import com.zhongzhou.utils.SpringContextHolder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import com.zhongzhou.utils.SpringContextHolder;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 被修改的bean临时存放的地方
 * 存放key ,value 形式
 * @author yumeng
 * @date 2018-07-03 10:19
 */
@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION)
public class LogObjectHolder implements Serializable{

    private HashMap<String, Object> objectMap = new HashMap<>();

    public void set(String key,Object obj) {
        this.objectMap.put(key,obj);
    }

    public Object get(String key) {
        return objectMap.get(key);
    }

    public static LogObjectHolder me(){
        LogObjectHolder bean = SpringContextHolder.getBean(LogObjectHolder.class);
        return bean;
    }
}
