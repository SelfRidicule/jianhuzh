package com.zhongzhou.dto;

/**
 * 涉案物品 dto
 */
public class SawpDto {

    public SawpDto() {
    }

    public SawpDto(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /**
     *
     */
    private String name;
    private String value;


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
