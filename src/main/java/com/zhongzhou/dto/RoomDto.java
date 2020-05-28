package com.zhongzhou.dto;

/**
 * 酒店 dto
 */
public class RoomDto {

    public RoomDto() {
    }


    //名称
    private String name;

    //地址
    private String address;

    //总床位
    private String count;

    //今日开房
    private String nowCount;



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

    public String getNowCount() {
        return nowCount;
    }

    public void setNowCount(String nowCount) {
        this.nowCount = nowCount;
    }
}
