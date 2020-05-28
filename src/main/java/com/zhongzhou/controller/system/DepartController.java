package com.zhongzhou.controller.system;

import com.github.pagehelper.PageInfo;
import com.zhongzhou.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;
import com.zhongzhou.controller.base.BaseController;
import com.zhongzhou.entity.system.TSysDepart;
import com.zhongzhou.entity.system.TSysDepartCriteria;
import com.zhongzhou.service.system.TSysDepartService;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Api(tags={"部门模块"})
@Controller
@RequestMapping(value="/depart")
public class DepartController extends BaseController {


    @Autowired
    private TSysDepartService departService;


    //菜单管理
    @ApiIgnore
    @RequestMapping(value="/list",method = RequestMethod.GET)
    public String list(){
        return "depart/list";
    }

    //用户input页
    @ApiIgnore
    @RequestMapping(value="/input",method = RequestMethod.GET)
    public String Input(ModelMap mm,HttpServletRequest request){
        if(!StringUtils.isEmpty(request.getParameter("id"))){
            Integer id = Integer.parseInt(request.getParameter("id"));
            mm.addAttribute("object",departService.selectByPrimaryKey(id));
        }
        mm.addAttribute("departList",departService.selectByExample(new TSysDepartCriteria()));
        return "depart/input";
    }
    @ApiOperation("部门列表")
    @RequestMapping(value="/departList",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult departList(@ApiParam(required=true,value="一页多少条数据")Integer pageSize, @ApiParam(required=true,value="第几页")Integer pageNum, @ApiParam(required=true,value="搜索的字段")String search){
        HttpResult result = new HttpResult();
        try{
            TSysDepartCriteria criteria = new TSysDepartCriteria();
            if(search!=null&&!search.equals("")){
                criteria.createCriteria().andDepartnameLike(search);
            }
            PageInfo info = departService.selectByExample(criteria,pageSize,pageNum);
            result.setCount(info.getTotal());
            result.setData(info.getList());
            result.setCode(Consts.SUCCESS);
            result.setMsg("获取成功");
        }catch (Exception e){
            result.setCode(Consts.ERROR);
            result.setMsg("获取失败!"+e.getMessage());
        }
        return result;
    }
    @ApiOperation("保存部门")
    @RequestMapping(value="/saveDepart",method = {RequestMethod.POST,RequestMethod.GET})
    @ApiImplicitParam(name = "depart", value = "单个部门信息", dataType = "TSysDepart")
    @ResponseBody
    public HttpResult saveDepart(TSysDepart depart){
        HttpResult result = new HttpResult();
        try{
            if (depart==null) throw new Exception("参数错误!");
            //id为空则新增
            if(depart.getId()==null||depart.getId()==0){
                depart.setCreatetime(new Date());
                depart = departService.insertSelective(depart);
            }else{
                //更新
                departService.updateByPrimaryKeySelective(depart);
            }
            //返回id
            result.setData(depart.getId());
            result.setCode(Consts.SUCCESS);
            result.setMsg("操作成功");
        }catch (Exception e){
            result.setCode(Consts.ERROR);
            result.setMsg("操作失败!"+e.getMessage());
        }
        return result;
    }
    @ApiOperation("删除部门")
    @RequestMapping(value="/delDepart",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult delDepart(@ApiParam(required=true,value="部门id数组")@RequestParam(value = "departIds[]")Integer[] departIds){
        HttpResult result = new HttpResult();
        try{
            List<Integer> ids = Arrays.asList(departIds);
            TSysDepartCriteria criteria = new TSysDepartCriteria();
            criteria.createCriteria().andIdIn(ids);
            departService.deleteByExample(criteria);
            //返回id
            result.setCode(Consts.SUCCESS);
            result.setMsg("操作成功");
        }catch (Exception e){
            result.setCode(Consts.ERROR);
            result.setMsg("操作失败!"+e.getMessage());
        }
        return result;
    }

}
