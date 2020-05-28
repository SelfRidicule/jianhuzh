package com.zhongzhou.dto;

/**
 * 作案特点 dto
 */
public class ZatdDto {

    public ZatdDto() {
    }


    public ZatdDto(String name, String value ) {
        this.value = value;
        this.name = name;
    }

    /**
     *
     */
    private String value;
    private String name;

    /**
     * @return
     */
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
