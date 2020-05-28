package com.zhongzhou.permission;

import com.zhongzhou.entity.system.TSysMenu;
import com.zhongzhou.utils.SpringContextHolder;
import com.zhongzhou.entity.system.TSysMenu;
import com.zhongzhou.utils.SpringContextHolder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import com.zhongzhou.entity.system.TSysMenu;
import com.zhongzhou.utils.SpringContextHolder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 菜单 与操作权限临时存放的地方
 * 两个数组
 * 一个存放单纯的menu 另一个存放menu加上操作权限
 * @author yumeng
 * @date 2018-07-03 10:19
 */
@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION)
public class PermissionHolder implements Serializable{


    private List<TSysMenu> menuList = new ArrayList<>();

    private HashMap<String, Object> menuMap = new HashMap<>();

    public void setMenuList(List<TSysMenu> menuList) {
        this.menuList = menuList;
    }

    public List<TSysMenu> getMenuList() {
        return menuList;
    }

    public void set(String key,Object obj) {

        this.menuMap.put(key,obj);
    }

    public Object get(String key) {
        return menuMap.get(key);
    }

    public static PermissionHolder me(){
        PermissionHolder bean = SpringContextHolder.getBean(PermissionHolder.class);
        return bean;
    }
}
