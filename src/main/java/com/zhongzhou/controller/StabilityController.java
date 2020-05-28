package com.zhongzhou.controller;

import com.zhongzhou.entity.Publicsentiment;
import com.zhongzhou.entity.Stability;
import com.zhongzhou.entity.Videosurveillance;
import com.zhongzhou.entity.system.TSysUser;
import com.zhongzhou.service.StabilityService;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value = "/stability")
public class StabilityController {
    /**
     * 稳情（网格信息）
     */
    @Autowired
    private StabilityService service;


    /**
     * 稳情后台数据列表
     */
    @RequestMapping(value = "/dataList", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public HttpResult dataList(HttpServletRequest request, HttpSession session, Integer pageNum, Integer pageSize, String keyword, Integer policestationid) {


        TSysUser user = (TSysUser) request.getSession().getAttribute("user");

        return service.dataPageList(keyword, pageNum, pageSize, policestationid);
    }


    /**
     * 稳情后台添加
     */
    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public HttpResult add(HttpServletRequest request, HttpSession session, Stability stability) {


        service.insertSelective(stability);


        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");
        result.setData(stability);

        return result;
    }


    /**
     * 稳情后台查询id
     */
    @RequestMapping(value = "/queryId", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public HttpResult queryId(HttpServletRequest request, HttpSession session, Integer id) {


        Stability stability = service.selectByPrimaryKey(id);


        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");
        result.setData(stability);

        return result;
    }


    /**
     * 后台 修改
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public HttpResult update(HttpServletRequest request, HttpSession session, Stability stability) {


        service.updateByPrimaryKeySelective(stability);


        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");
        result.setData(stability);

        return result;
    }


    /**
     * 后台 删除
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public HttpResult delete(HttpServletRequest request, HttpSession session, Integer id) {


        service.deleteByPrimaryKey(id);


        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");

        return result;
    }


    /**
     * upload excel
     */
    @RequestMapping(value = "/uploadExcel", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public HttpResult uploadExcel(HttpServletRequest request, HttpSession session, MultipartFile file, Integer policestationId) throws Exception {

        if (policestationId == null) {
            return null;
        }

        Workbook wb = null; // 工作区域

        //获取文件名
        String filename = file.getOriginalFilename();

        // 获取文件后缀
        String prefix = filename.substring(filename.lastIndexOf(".") + 1);

        if (prefix.equals("xlsx")) {
            try {
                wb = new XSSFWorkbook(file.getInputStream());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else if (prefix.equals("xls")) {
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
        Sheet sheet = wb.getSheetAt(0);

        //判断是否存在sheet
        if (sheet == null) {
            return null;
        }

        List<List<String>> list = new ArrayList<>();

        //遍历当前sheet中的所有行
        for (int j = 2; j <= sheet.getLastRowNum(); j++) {
            Row row = sheet.getRow(j);
            if (row == null) {
                continue;
            }

            //创建对象
            String rusticate = getCellValue(row.getCell(0));
            String gridsequence = getCellValue(row.getCell(1));
            String gridpersontype = getCellValue(row.getCell(2));
            String gridpersonname = getCellValue(row.getCell(3));
            String idcard = getCellValue(row.getCell(4));
            String sex = getCellValue(row.getCell(5));
            String age = getCellValue(row.getCell(6));
            String gridpersonphone = getCellValue(row.getCell(7));
            String politicallook = getCellValue(row.getCell(8));
            String education = getCellValue(row.getCell(9));
            String marital = getCellValue(row.getCell(10));
            String currentaddress = getCellValue(row.getCell(11));
            String otheridentity = getCellValue(row.getCell(12));
            String managerhouse = getCellValue(row.getCell(13));
            String gridcode = getCellValue(row.getCell(14));
            String gridscope = getCellValue(row.getCell(15));
            String comment = getCellValue(row.getCell(16));


            Stability stability = new Stability();

            stability.setRusticate(rusticate);
            stability.setGridsequence(gridsequence);
            stability.setGridpersontype(gridpersontype);
            stability.setGridpersonname(gridpersonname);
            stability.setIdcard(idcard);
            stability.setSex(sex);
            stability.setAge(age);
            stability.setGridpersonphone(gridpersonphone);
            stability.setPoliticallook(politicallook);
            stability.setEducation(education);
            stability.setMarital(marital);
            stability.setCurrentaddress(currentaddress);
            stability.setOtheridentity(otheridentity);
            stability.setManagerhouse(managerhouse);
            stability.setGridcode(gridcode);
            stability.setGridscope(gridscope);
            stability.setComment(comment);

            stability.setPolicestationid(policestationId);

            //向数据库添加数据
            service.insertSelective(stability);
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
     *
     * @param cell
     * @return
     */
    public String getCellValue(Cell cell) {
        if(cell == null){
            return "";
        }

        String value = null;
        DecimalFormat df = new DecimalFormat("0");  //格式化number String字符
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //日期格式化
        DecimalFormat df2 = new DecimalFormat("0.00");  //格式化数字

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:

                if ("General".equals(cell.getCellStyle().getDataFormatString())) {

                    //如果是整数
                    if(cell.getNumericCellValue() % 1 == 0){
                        value = df.format(cell.getNumericCellValue());
                    }else{
                        value = String.valueOf(cell.getNumericCellValue());
                    }


                } else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
                    value = sdf.format(cell.getDateCellValue());
                } else {
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
