package com.zhongzhou.permission.annotation;

import com.zhongzhou.entity.system.TSysMenu;
import com.zhongzhou.entity.system.TSysPermission;
import com.zhongzhou.permission.PermissionHolder;
import com.zhongzhou.utils.HttpKit;
import com.zhongzhou.entity.system.TSysMenu;
import com.zhongzhou.entity.system.TSysPermission;
import com.zhongzhou.permission.PermissionHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import com.zhongzhou.entity.system.TSysMenu;
import com.zhongzhou.entity.system.TSysPermission;
import com.zhongzhou.utils.HttpKit;

import java.lang.reflect.Method;
import java.util.List;

import static com.zhongzhou.utils.HttpKit.getRequest;
import static com.zhongzhou.utils.HttpKit.getResponse;

@Aspect
@Component
public class PermissionAop {

    //为RequiresPermission添加切面
    @Pointcut("@annotation(com.zhongzhou.permission.annotation.RequiresPermission)")
    public void aspectjMethod() {
    };


    //执行方法前 确定当前角色是否有权限访问
    @Around("aspectjMethod()")
    public Object before(ProceedingJoinPoint point) throws Throwable {
        System.out.println("为RequiresPermission添加切面");
        //获取拦截的方法名
        MethodSignature msig = (MethodSignature) point.getSignature();
        if (!(point.getSignature() instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        Object target = point.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        String managerUrl = currentMethod.getAnnotation(RequiresPermission.class).ManagerUrl();
        String permission = currentMethod.getAnnotation(RequiresPermission.class).Permission();
        if(validation(permission,managerUrl)){
            //执行业务
            Object result = point.proceed();
            return result;
        }else{
            String path = HttpKit.getRequest().getContextPath();
            HttpKit.getResponse().sendRedirect(path+"/noAuth");
            return null;
        }

    }


    public boolean validation(String rqpermission,String managerUrl){
        //通过url查找menu对象
        //TSysMenu menu = (TSysMenu)PermissionHolder.me().get(".."+getRequest().getServletPath());
        TSysMenu menu = (TSysMenu) PermissionHolder.me().get(managerUrl);
        if(menu!=null&&menu.getPermissionList()!=null&&menu.getPermissionList().size()>0){
            List<TSysPermission> permissions = menu.getPermissionList();
            for (TSysPermission permission:permissions) {
                //遍历权限 如果与 注解的相同则验证通过否则 无权限
                if(rqpermission.equals(permission.getId().toString())){
                    return true;
                }
            }
        }else if(menu!=null&&"".equals(rqpermission)){
            //如果 权限没有填 且menu不为空则 有权限
            return true;
        }
        return false;
    }

}
