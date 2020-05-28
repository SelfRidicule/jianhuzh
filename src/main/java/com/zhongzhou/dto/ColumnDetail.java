package com.zhongzhou.dto;

public class ColumnDetail {

    public ColumnDetail() {
    }

    private String column  ;

    private String aliasName ;

    private String type  ;

    private String content ;


    /**
     *
     */
    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
