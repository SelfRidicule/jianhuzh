package com.zhongzhou.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhongzhou.entity.Policestation;
import com.zhongzhou.entity.system.TSysUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhongzhou.entity.system.TSysUser;
import com.zhongzhou.entity.system.TSysMenu;
import com.zhongzhou.permission.PermissionHolder;
import com.zhongzhou.entity.system.TSysMenu;

/**
 * 系统拦截器
 * 验证登录情况
 */

public class SystemInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object obj, Exception err)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object obj, ModelAndView mav) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {

        return isLogin( request,  response,  obj);

//        return true;
    }

    public boolean isLogin(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception{
        String path = request.getContextPath();
        //String BASE_URL = request.getScheme()+"://"+request.getHeader("Host")+path+"/";
        String BASE_URL = path+"/";
        request.getSession().setAttribute("BASE_URL",BASE_URL);
        //判断是否登录
        TSysUser user = (TSysUser) request.getSession().getAttribute("user");

        Policestation policestation = (Policestation) request.getSession().getAttribute("policestation");

        if(user!=null) {
            //已经登录的话,获取在当前路径下操作权限
            TSysMenu menu = (TSysMenu) PermissionHolder.me().get(request.getServletPath().substring(1, request.getServletPath().length()));
            if (menu != null) {
                request.getSession().setAttribute("menuPermission", menu.getPermissionList());
            }
            return true;

        }else if(policestation != null){

            return true ;

        }else {
            String basePath = request.getContextPath();
            response.sendRedirect(basePath+"/login");
        }

        return false;
    }



}
