package com.zhongzhou.controller.system;

import com.zhongzhou.controller.base.BaseController;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;
import com.zhongzhou.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@ApiIgnore
@Controller
public class IndexController extends BaseController {

    @ApiIgnore
    @RequestMapping(value="/html/{path}",method = RequestMethod.GET)
    public String freeMarker(ModelMap mm,@PathVariable String path){
        return "html/"+path;
    }

    @ApiIgnore
    @RequestMapping(value="/html/{path}/{path2}",method = RequestMethod.GET)
    public String freeMarker2(ModelMap mm,@PathVariable String path,@PathVariable String path2){
        return path+"/"+path2;
    }

    @ApiIgnore
    @RequestMapping(value="/doc/{path}",method = RequestMethod.GET)
    public String freeMarker1(ModelMap mm,@PathVariable String path){
        return "doc/"+path;
    }
    /*@RequestMapping(value="/temple/{path}")
    public String freeMarker3(ModelMap mm,@PathVariable String path){
        return "temple/"+path;
    }*/

    //后台主页
    @ApiIgnore
    @RequestMapping(value="/Index.html",method = RequestMethod.GET)
    public String lying(ModelMap mm){
        return "index1";
    }

    //后台主页
    @ApiIgnore
    @RequestMapping(value="/index.html",method = RequestMethod.GET)
    public String index(ModelMap mm){
        return "sys_index";
    }
}
