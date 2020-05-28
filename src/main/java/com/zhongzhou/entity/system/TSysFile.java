package com.zhongzhou.entity.system;

public class TSysFile {
    /**
     *
     */
    private Integer id;

    /**
     * 文件名称
     */
    private String filename;

    /**
     * 原文件名称
     */
    private String oldname;

    /**
     * 文件路径
     */
    private String filepath;

    /**
     * 文件二进制码
     */
    private byte[] fileencode;

    /**
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 文件名称
     * @return filename 文件名称
     */
    public String getFilename() {
        return filename;
    }

    /**
     * 文件名称
     * @param filename 文件名称
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * 原文件名称
     * @return oldname 原文件名称
     */
    public String getOldname() {
        return oldname;
    }

    /**
     * 原文件名称
     * @param oldname 原文件名称
     */
    public void setOldname(String oldname) {
        this.oldname = oldname;
    }

    /**
     * 文件路径
     * @return filepath 文件路径
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * 文件路径
     * @param filepath 文件路径
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    /**
     * 文件二进制码
     * @return fileencode 文件二进制码
     */
    public byte[] getFileencode() {
        return fileencode;
    }

    /**
     * 文件二进制码
     * @param fileencode 文件二进制码
     */
    public void setFileencode(byte[] fileencode) {
        this.fileencode = fileencode;
    }
}
