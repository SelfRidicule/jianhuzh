/* https://github.com/orange1438 */
package com.zhongzhou.entity;

import java.io.Serializable;

/** 
 * @author orange1438
 * date:2020/01/06 09:46
 */
public class Mainperson implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 5464269432101077379L;

    /** 
     */ 
    private Integer id;

    /** 
     * 名称
     */ 
    private String name;

    /** 
     * 性别
     */ 
    private String sex;

    /** 
     * 地址
     */ 
    private String address;

    /** 
     * 电话
     */ 
    private String phone;

    /** 
     * 身份证
     */ 
    private String idcard;

    /** 
     * 派出所code
     */ 
    private String policecode;

    /** 
     * 重点类型id
     */ 
    private Integer maintypeid;

    /**
     * 重点类型名称
     */
    private String maintypeName;

    /** 
     * 获取 mainperson.id
     * @return mainperson.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 mainperson.id
     * @param id mainperson.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 名称 mainperson.name
     * @return 名称
     */
    public final String getName() {
        return name;
    }

    /** 
     * 设置 名称 mainperson.name
     * @param name 名称
     */
    public final void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /** 
     * 获取 性别 mainperson.sex
     * @return 性别
     */
    public final String getSex() {
        return sex;
    }

    /** 
     * 设置 性别 mainperson.sex
     * @param sex 性别
     */
    public final void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /** 
     * 获取 地址 mainperson.address
     * @return 地址
     */
    public final String getAddress() {
        return address;
    }

    /** 
     * 设置 地址 mainperson.address
     * @param address 地址
     */
    public final void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /** 
     * 获取 电话 mainperson.phone
     * @return 电话
     */
    public final String getPhone() {
        return phone;
    }

    /** 
     * 设置 电话 mainperson.phone
     * @param phone 电话
     */
    public final void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /** 
     * 获取 身份证 mainperson.idcard
     * @return 身份证
     */
    public final String getIdcard() {
        return idcard;
    }

    /** 
     * 设置 身份证 mainperson.idcard
     * @param idcard 身份证
     */
    public final void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    /** 
     * 获取 派出所code mainperson.policecode
     * @return 派出所code
     */
    public final String getPolicecode() {
        return policecode;
    }

    /** 
     * 设置 派出所code mainperson.policecode
     * @param policecode 派出所code
     */
    public final void setPolicecode(String policecode) {
        this.policecode = policecode == null ? null : policecode.trim();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMaintypeName() {
        return maintypeName;
    }

    public void setMaintypeName(String maintypeName) {
        this.maintypeName = maintypeName;
    }

    /**
     * 获取 重点类型id mainperson.maintypeid
     * @return 重点类型id
     */
    public final Integer getMaintypeid() {
        return maintypeid;
    }

    /** 
     * 设置 重点类型id mainperson.maintypeid
     * @param maintypeid 重点类型id
     */
    public final void setMaintypeid(Integer maintypeid) {
        this.maintypeid = maintypeid;
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", address=").append(address);
        sb.append(", phone=").append(phone);
        sb.append(", idcard=").append(idcard);
        sb.append(", policecode=").append(policecode);
        sb.append(", maintypeid=").append(maintypeid);
        sb.append("]");
        return sb.toString();
    }
}