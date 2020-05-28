package com.zhongzhou.controller;

import com.zhongzhou.entity.Publicsentiment;
import com.zhongzhou.entity.PublicsentimentCriteria;
import com.zhongzhou.entity.Videosurveillance;
import com.zhongzhou.entity.system.TSysUser;
import com.zhongzhou.service.PublicsentimentService;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;
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
@RequestMapping(value = "/publicsentiment")
public class PublicsentimentController {
    /**
     * 舆情（网上调解）
     */
    @Autowired
    private PublicsentimentService service;



    /**
     * 后台 数据列表
     */
    @RequestMapping(value = "/dataList", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public HttpResult dataList(HttpServletRequest request, HttpSession session, Integer pageNum, Integer pageSize, String keyword, Integer policestationid) {


        TSysUser user = (TSysUser) request.getSession().getAttribute("user");

        return service.dataPageList(keyword, pageNum, pageSize, policestationid);
    }


    /**
     * 后台 添加
     */
    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public HttpResult add(HttpServletRequest request, HttpSession session, Publicsentiment publicsentiment) {


        service.insertSelective(publicsentiment);


        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");
        result.setData(publicsentiment);

        return result;
    }


    /**
     * 后台 查询id
     */
    @RequestMapping(value = "/queryId", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public HttpResult queryId(HttpServletRequest request, HttpSession session, Integer id) {

        PublicsentimentCriteria criteria = new PublicsentimentCriteria();
        criteria.createCriteria().andIdEqualTo(id);
        Publicsentiment publicsentiment = service.selectByExample(criteria).get(0);


        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");
        result.setData(publicsentiment);

        return result;
    }


    /**
     * 后台 修改
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public HttpResult update(HttpServletRequest request, HttpSession session, Publicsentiment publicsentiment) {


        service.updateByPrimaryKeySelective(publicsentiment);


        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");
        result.setData(publicsentiment);

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
            String title = getCellValue(row.getCell(0));
            String content = getCellValue(row.getCell(1));
            String time = getCellValue(row.getCell(2));

            //==================================================

            //编号
            String codenum = getCellValue(row.getCell(0));

            //主持人单位及职务
            String hostposition = getCellValue(row.getCell(1));

            //调解地点
            String mediateaddress = getCellValue(row.getCell(2));

            //主要事实
            String mainmacts = getCellValue(row.getCell(3));

            //达成协议
            String agreement = getCellValue(row.getCell(4));

            //调解日期
            String mediatedate = getCellValue(row.getCell(5));

            //1主持人姓名
            String onehostname = getCellValue(row.getCell(6));

            //1当事人姓名
            String onecurrentname = getCellValue(row.getCell(7));

            //2当事人姓名
            String twocurrentname = getCellValue(row.getCell(8));

            //1当事人性别
            String onecurrentsex = getCellValue(row.getCell(9));

            //2当事人性别
            String twocurrentsex = getCellValue(row.getCell(10));

            //1当事人年龄
            String onecurrentage = getCellValue(row.getCell(11));

            //2当事人年龄
            String twocurrentage = getCellValue(row.getCell(12));

            //1当事人民族
            String onecurrentnation = getCellValue(row.getCell(13));

            //2当事人民族
            String twocurrentnation = getCellValue(row.getCell(14));

            //1当事人出生年月
            String onecurrentbirthdate = getCellValue(row.getCell(15));

            //2当事人出生年月
            String twocurrentbirthdate = getCellValue(row.getCell(16));

            //1当事人身份证号码
            String onecurrentidcard = getCellValue(row.getCell(17));

            //2当事人身份证号码
            String twocurrentidcard = getCellValue(row.getCell(18));

            //1当事人单位
            String onecurrentcompany = getCellValue(row.getCell(19));

            //2当事人单位
            String twocurrentcompany = getCellValue(row.getCell(20));

            //1当事人职业或职务
            String onecurrentposition = getCellValue(row.getCell(21));

            //2当事人职业或职务
            String twocurrentposition = getCellValue(row.getCell(22));

            //1当事人家庭住址
            String onecurrentfamily = getCellValue(row.getCell(23));

            //2当事人家庭住址
            String twocurrentfamily = getCellValue(row.getCell(24));

            //1当事法人或其他组织名称
            String oneformname = getCellValue(row.getCell(25));

            //2当事法人或其他组织名称
            String twoformname = getCellValue(row.getCell(26));

            //1当事法定代表人
            String onerepresent = getCellValue(row.getCell(27));

            //2当事法定代表人
            String tworepresent = getCellValue(row.getCell(28));

            //1当事负责人职务
            String onejob = getCellValue(row.getCell(29));

            //2当事负责人职务
            String twojob = getCellValue(row.getCell(30));

            //==================================================


            Publicsentiment publicsentiment = new Publicsentiment();
            publicsentiment.setPolicestationid(policestationId);


            publicsentiment.setCodenum(codenum) ;
            publicsentiment.setHostposition(hostposition) ;
            publicsentiment.setMediateaddress(mediateaddress) ;
            publicsentiment.setMainmacts(mainmacts) ;
            publicsentiment.setAgreement(agreement) ;
            publicsentiment.setMediatedate(mediatedate) ;
            publicsentiment.setOnehostname(onehostname) ;
            publicsentiment.setOnecurrentname(onecurrentname) ;
            publicsentiment.setTwocurrentname(twocurrentname) ;
            publicsentiment.setOnecurrentsex(onecurrentsex) ;
            publicsentiment.setTwocurrentsex(twocurrentsex) ;
            publicsentiment.setOnecurrentage(onecurrentage) ;
            publicsentiment.setTwocurrentage(twocurrentage) ;
            publicsentiment.setOnecurrentnation(onecurrentnation) ;
            publicsentiment.setTwocurrentnation(twocurrentnation) ;
            publicsentiment.setOnecurrentbirthdate(onecurrentbirthdate) ;
            publicsentiment.setTwocurrentbirthdate(twocurrentbirthdate) ;
            publicsentiment.setOnecurrentidcard(onecurrentidcard) ;
            publicsentiment.setTwocurrentidcard(twocurrentidcard) ;
            publicsentiment.setOnecurrentcompany(onecurrentcompany) ;
            publicsentiment.setTwocurrentcompany(twocurrentcompany) ;
            publicsentiment.setOnecurrentposition(onecurrentposition) ;
            publicsentiment.setTwocurrentposition(twocurrentposition) ;
            publicsentiment.setOnecurrentfamily(onecurrentfamily) ;
            publicsentiment.setTwocurrentfamily(twocurrentfamily) ;
            publicsentiment.setOneformname(oneformname) ;
            publicsentiment.setTwoformname(twoformname) ;
            publicsentiment.setOnerepresent(onerepresent) ;
            publicsentiment.setTworepresent(tworepresent) ;
            publicsentiment.setOnejob(onejob) ;
            publicsentiment.setTwojob(twojob) ;


            //向数据库添加数据
            service.insertSelective(publicsentiment);
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
        String value = null;
        DecimalFormat df = new DecimalFormat("0");  //格式化number String字符
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //日期格式化
        DecimalFormat df2 = new DecimalFormat("0.00");  //格式化数字

        if(cell == null){
           return "";
        }

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
