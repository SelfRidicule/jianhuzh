package com.zhongzhou.dto;

/**
 * 警情dto
 */
public class PoliceMessageDto {


    public PoliceMessageDto() {
    }

    //时间
    private String time;

    //警情内容
    private String content;

    //电话号码
    private String phone;

    //简要警情及处理结果
    private String shortContent;

    //处警地址X坐标
    private String GIS_X;

    //处警地址Y坐标
    private String GIS_Y;

    //处警接警单编号
    private String jjdbh;


    /**
     *
     * @return
     */
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getGIS_X() {
        return GIS_X;
    }

    public void setGIS_X(String GIS_X) {
        this.GIS_X = GIS_X;
    }

    public String getGIS_Y() {
        return GIS_Y;
    }

    public void setGIS_Y(String GIS_Y) {
        this.GIS_Y = GIS_Y;
    }

    public String getJjdbh() {
        return jjdbh;
    }

    public void setJjdbh(String jjdbh) {
        this.jjdbh = jjdbh;
    }
}
