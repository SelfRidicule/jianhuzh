package com.zhongzhou.controller;

import com.zhongzhou.entity.Policeduty;
import com.zhongzhou.entity.system.TSysUser;
import com.zhongzhou.service.PolicedutyService;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/duty")
public class PolicedutyController {


    @Autowired
    PolicedutyService policedutyService;


    /**
     * 后台 数据列表
     */
    @RequestMapping(value="/dataList",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult dataList(HttpServletRequest request, HttpSession session , Integer pageNum , Integer pageSize , String keyword , String status,  Integer policestationid){


        TSysUser user = (TSysUser) request.getSession().getAttribute("user");

        return policedutyService.dataPageList(keyword , status, pageNum,  pageSize , policestationid);
    }

    /**
     * 后台 添加
     */
    @RequestMapping(value="/add",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult add(HttpServletRequest request, HttpSession session , Policeduty policeduty){



        policedutyService.insertSelective(policeduty);


        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");
        result.setData(policeduty);

        return result;
    }

    /**
     * 后台 查询id
     */
    @RequestMapping(value="/queryId",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult queryId(HttpServletRequest request, HttpSession session , Integer id){


        Policeduty policeduty =  policedutyService.selectByPrimaryKey(id);


        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");
        result.setData(policeduty);

        return result;
    }

    /**
     * 后台 修改
     */
    @RequestMapping(value="/update",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult update(HttpServletRequest request, HttpSession session , Policeduty policeduty){


        policedutyService.updateByPrimaryKeySelective(policeduty);


        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");
        result.setData(policeduty);

        return result;
    }


    /**
     * 后台 删除
     */
    @RequestMapping(value="/delete",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult delete(HttpServletRequest request, HttpSession session , Integer id){


        policedutyService.deleteByPrimaryKey(id);


        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");

        return result;
    }


    /**
     * upload excel
     */
    @RequestMapping(value="/uploadExcel",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult uploadExcel(HttpServletRequest request, HttpSession session , MultipartFile file , Integer policestationId) throws Exception{

        if(policestationId == null){
            return null;
        }

        Workbook wb = null; // 工作区域

        //获取文件名
        String filename=file.getOriginalFilename();

        // 获取文件后缀
        String prefix=filename.substring(filename.lastIndexOf(".")+1);

        if (prefix.equals("xlsx")) {
            try {
                wb = new XSSFWorkbook(file.getInputStream());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        else if (prefix.equals("xls")) {
            try {
                wb = new HSSFWorkbook(file.getInputStream());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            return null;
        }



        // 这个必须用接口
        Sheet sheet  = wb.getSheetAt(0);

        //判断是否存在sheet
        if(sheet == null){
            return null;
        }

        List<List<String>> list = new ArrayList<>();

        //遍历当前sheet中的所有行
        for (int j = 2; j <= sheet.getLastRowNum(); j++) {
            Row row = sheet.getRow(j);
            if(row==null){
                continue;
            }

            Policeduty policeduty = new Policeduty();

            String name  = getCellValue(row.getCell(0));
            String sex = getCellValue(row.getCell(1));
            String identity = getCellValue(row.getCell(2));
            String company = getCellValue(row.getCell(3));
            String phone = getCellValue(row.getCell(4));
            String duties = getCellValue(row.getCell(5));

            policeduty.setName(name);
            policeduty.setSex(sex);
            policeduty.setIdentity(identity);
            policeduty.setCompany(company);
            policeduty.setPhone(phone);
            policeduty.setDuties(duties);
            policeduty.setPolicestationid(policestationId);
            //默认不值班
            policeduty.setStatus(0);

            policedutyService.insertSelective(policeduty);
        }



        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");
        result.setData(list);

        return result;
    }

    /**
     * 描述：对表格中数值进行格式化
     * @param cell
     * @return
     */
    public  String getCellValue(Cell cell){
        String value = null;
        DecimalFormat df = new DecimalFormat("0");  //格式化number String字符
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //日期格式化
        DecimalFormat df2 = new DecimalFormat("0.00");  //格式化数字

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if("General".equals(cell.getCellStyle().getDataFormatString())){
                    value = df.format(cell.getNumericCellValue());
                }else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){
                    value = sdf.format(cell.getDateCellValue());
                }else{
                    value = df2.format(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            default:
                break;
        }
        return value;
    }

}
