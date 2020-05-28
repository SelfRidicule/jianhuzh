package com.zhongzhou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    //后台首页
    @RequestMapping(value = "/admin/v1/backstageLists")
    public String backstageLists(HttpSession session , HttpServletRequest request ,ModelMap mm , String policestationId) {
        mm.addAttribute("policestationId", policestationId);
        System.out.println("=============>> policestationId : " + policestationId);

        return "jianhuduty/backstageList";
    }

    //视频监控页面
    @RequestMapping(value = "/admin/v1/spjk")
    public String spjk(ModelMap mm , String id) {
        mm.addAttribute("id" , id);
        return "jianhu/spjk";
    }
    //视频监控新增页面
    @RequestMapping(value = "/admin/v1/spjkadd")
    public String spjkadd() {

        return "jianhu/spjkadd";
    }
    //视频监控修改页面
    @RequestMapping(value = "/admin/v1/spjkupdate")
    public String spjkupdate(ModelMap mm , String id) {
        mm.addAttribute("id",id);
        return "jianhu/spjkupdate";
    }
    //人员导入页面
    @RequestMapping(value = "/admin/v1/imports")
    public String importer() {

        return "jianhuduty/import";
    }
    //人员新增页面
    @RequestMapping(value = "/admin/v1/newAdds")
    public String newAdds() {

        return "jianhuduty/newAdd";
    }
    //人员修改页面
    @RequestMapping(value = "/admin/v1/updates")
    public String updates(Integer id,ModelMap mm) {
        mm.addAttribute("id" , id);
        return "jianhuduty/update";
    }
    //舆情
    @RequestMapping(value = "/admin/v1/publicSentiment")
    public  String publicSentiment(){
        return "jianhu/publicSentiment";
    }

    //稳情
    @RequestMapping(value = "/admin/v1/stability")
    public  String stability(){
        return "jianhu/stability";
    }

    //重点人员
    @RequestMapping(value = "/admin/v1/keyPersonnel")
    public  String keyPersonnel(){
        return "jianhu/keyPersonnel";
    }

    //--------------------------------------------------
    //后台首页
    @RequestMapping(value = "/admin/v1/backstageList")
    public String backstageList(HttpSession session , HttpServletRequest request ,ModelMap mm , String id ) {

        return "jianhu/backstageList";
    }
    //导入页面
    @RequestMapping(value = "/admin/v1/import")
    public String imports() {

        return "jianhu/import";
    }
    //账号管理页面
    @RequestMapping(value = "/admin/v1/administration")
    public String administration() {
        System.out.println();
        return "jianhu/administration";
    }
    //新增页面
    @RequestMapping(value = "/admin/v1/newAdd")
    public String newAdd() {

        return "jianhu/newAdd";
    }
    //修改页面
    @RequestMapping(value = "/admin/v1/update")
    public String update(Integer id,ModelMap mm) {
        mm.addAttribute("id" , id);
        return "jianhu/update";
    }
    //登录页面
    @RequestMapping(value = "/admin/v1/policeStation")
    public String policeStation() {

        return "jianhu/policeStation";
    }

    //管理员登录页面
    @RequestMapping(value = "/admin/v1/policeAdmin")
    public String policeAdmin() {
        return "jianhu/policeAdmin";
    }

    //后台首页
    @RequestMapping(value = "/index")
    public  String index(){
        return "home/index";
    }

    //执法办案
    @RequestMapping(value = "/plan")
    public  String plan(){
        return "home/plan";
    }

    //demo
    @RequestMapping(value = "/jumpDemo")
    public  String demo(){
        return "/jk/demo";
    }



}
