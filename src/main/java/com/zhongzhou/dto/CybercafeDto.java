package com.zhongzhou.dto;


/**
 * 网吧 dto
 */
public class CybercafeDto {

    public CybercafeDto() {
    }

    //网吧名称
    private String name;

    //地址
    private String address;

    //总机数
    private String count;

    //上网人数
    private String personCount;


    /**
     * get set
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPersonCount() {
        return personCount;
    }

    public void setPersonCount(String personCount) {
        this.personCount = personCount;
    }
}
