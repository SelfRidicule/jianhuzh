/* https://github.com/orange1438 */
package com.zhongzhou.entity;

import java.io.Serializable;

/** 
 * @author orange1438
 * date:2020/05/09 15:55
 */
public class Stability implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -4269587991472580565L;

    /** 
     * 主键id
     */ 
    private Integer id;

    /** 
     * 标题
     */ 
    private String title;

    /** 
     * 时间
     */ 
    private String time;

    /** 
     * 关联id
     */ 
    private Integer policestationid;

    /** 
     * 网格名称
     */ 
    private String gridname;

    /** 
     * 村居
     */ 
    private String rusticate;

    /** 
     * 网格序列
     */ 
    private String gridsequence;

    /** 
     * 网格人员类别
     */ 
    private String gridpersontype;

    /** 
     * 网格员姓名
     */ 
    private String gridpersonname;

    /** 
     * 身份证
     */ 
    private String idcard;

    /** 
     * 性别
     */ 
    private String sex;

    /** 
     * 年龄
     */ 
    private String age;

    /** 
     * 网格员联系方式
     */ 
    private String gridpersonphone;

    /** 
     * 政治面貌
     */ 
    private String politicallook;

    /** 
     * 文化程度
     */ 
    private String education;

    /** 
     * 婚姻状况
     */ 
    private String marital;

    /** 
     * 现居住地址
     */ 
    private String currentaddress;

    /** 
     * 其他身份
     */ 
    private String otheridentity;

    /** 
     * 管理户数
     */ 
    private String managerhouse;

    /** 
     * 网格编码
     */ 
    private String gridcode;

    /** 
     * 网格范围
     */ 
    private String gridscope;

    /** 
     * 备注
     */ 
    private String comment;

    /** 
     * 获取 主键id stability.id
     * @return 主键id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 主键id stability.id
     * @param id 主键id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 标题 stability.title
     * @return 标题
     */
    public final String getTitle() {
        return title;
    }

    /** 
     * 设置 标题 stability.title
     * @param title 标题
     */
    public final void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /** 
     * 获取 时间 stability.time
     * @return 时间
     */
    public final String getTime() {
        return time;
    }

    /** 
     * 设置 时间 stability.time
     * @param time 时间
     */
    public final void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    /** 
     * 获取 关联id stability.policestationid
     * @return 关联id
     */
    public final Integer getPolicestationid() {
        return policestationid;
    }

    /** 
     * 设置 关联id stability.policestationid
     * @param policestationid 关联id
     */
    public final void setPolicestationid(Integer policestationid) {
        this.policestationid = policestationid;
    }

    /** 
     * 获取 网格名称 stability.gridname
     * @return 网格名称
     */
    public final String getGridname() {
        return gridname;
    }

    /** 
     * 设置 网格名称 stability.gridname
     * @param gridname 网格名称
     */
    public final void setGridname(String gridname) {
        this.gridname = gridname == null ? null : gridname.trim();
    }

    /** 
     * 获取 村居 stability.rusticate
     * @return 村居
     */
    public final String getRusticate() {
        return rusticate;
    }

    /** 
     * 设置 村居 stability.rusticate
     * @param rusticate 村居
     */
    public final void setRusticate(String rusticate) {
        this.rusticate = rusticate == null ? null : rusticate.trim();
    }

    /** 
     * 获取 网格序列 stability.gridsequence
     * @return 网格序列
     */
    public final String getGridsequence() {
        return gridsequence;
    }

    /** 
     * 设置 网格序列 stability.gridsequence
     * @param gridsequence 网格序列
     */
    public final void setGridsequence(String gridsequence) {
        this.gridsequence = gridsequence == null ? null : gridsequence.trim();
    }

    /** 
     * 获取 网格人员类别 stability.gridpersontype
     * @return 网格人员类别
     */
    public final String getGridpersontype() {
        return gridpersontype;
    }

    /** 
     * 设置 网格人员类别 stability.gridpersontype
     * @param gridpersontype 网格人员类别
     */
    public final void setGridpersontype(String gridpersontype) {
        this.gridpersontype = gridpersontype == null ? null : gridpersontype.trim();
    }

    /** 
     * 获取 网格员姓名 stability.gridpersonname
     * @return 网格员姓名
     */
    public final String getGridpersonname() {
        return gridpersonname;
    }

    /** 
     * 设置 网格员姓名 stability.gridpersonname
     * @param gridpersonname 网格员姓名
     */
    public final void setGridpersonname(String gridpersonname) {
        this.gridpersonname = gridpersonname == null ? null : gridpersonname.trim();
    }

    /** 
     * 获取 身份证 stability.idcard
     * @return 身份证
     */
    public final String getIdcard() {
        return idcard;
    }

    /** 
     * 设置 身份证 stability.idcard
     * @param idcard 身份证
     */
    public final void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    /** 
     * 获取 性别 stability.sex
     * @return 性别
     */
    public final String getSex() {
        return sex;
    }

    /** 
     * 设置 性别 stability.sex
     * @param sex 性别
     */
    public final void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /** 
     * 获取 年龄 stability.age
     * @return 年龄
     */
    public final String getAge() {
        return age;
    }

    /** 
     * 设置 年龄 stability.age
     * @param age 年龄
     */
    public final void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    /** 
     * 获取 网格员联系方式 stability.gridpersonphone
     * @return 网格员联系方式
     */
    public final String getGridpersonphone() {
        return gridpersonphone;
    }

    /** 
     * 设置 网格员联系方式 stability.gridpersonphone
     * @param gridpersonphone 网格员联系方式
     */
    public final void setGridpersonphone(String gridpersonphone) {
        this.gridpersonphone = gridpersonphone == null ? null : gridpersonphone.trim();
    }

    /** 
     * 获取 政治面貌 stability.politicallook
     * @return 政治面貌
     */
    public final String getPoliticallook() {
        return politicallook;
    }

    /** 
     * 设置 政治面貌 stability.politicallook
     * @param politicallook 政治面貌
     */
    public final void setPoliticallook(String politicallook) {
        this.politicallook = politicallook == null ? null : politicallook.trim();
    }

    /** 
     * 获取 文化程度 stability.education
     * @return 文化程度
     */
    public final String getEducation() {
        return education;
    }

    /** 
     * 设置 文化程度 stability.education
     * @param education 文化程度
     */
    public final void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    /** 
     * 获取 婚姻状况 stability.marital
     * @return 婚姻状况
     */
    public final String getMarital() {
        return marital;
    }

    /** 
     * 设置 婚姻状况 stability.marital
     * @param marital 婚姻状况
     */
    public final void setMarital(String marital) {
        this.marital = marital == null ? null : marital.trim();
    }

    /** 
     * 获取 现居住地址 stability.currentaddress
     * @return 现居住地址
     */
    public final String getCurrentaddress() {
        return currentaddress;
    }

    /** 
     * 设置 现居住地址 stability.currentaddress
     * @param currentaddress 现居住地址
     */
    public final void setCurrentaddress(String currentaddress) {
        this.currentaddress = currentaddress == null ? null : currentaddress.trim();
    }

    /** 
     * 获取 其他身份 stability.otheridentity
     * @return 其他身份
     */
    public final String getOtheridentity() {
        return otheridentity;
    }

    /** 
     * 设置 其他身份 stability.otheridentity
     * @param otheridentity 其他身份
     */
    public final void setOtheridentity(String otheridentity) {
        this.otheridentity = otheridentity == null ? null : otheridentity.trim();
    }

    /** 
     * 获取 管理户数 stability.managerhouse
     * @return 管理户数
     */
    public final String getManagerhouse() {
        return managerhouse;
    }

    /** 
     * 设置 管理户数 stability.managerhouse
     * @param managerhouse 管理户数
     */
    public final void setManagerhouse(String managerhouse) {
        this.managerhouse = managerhouse == null ? null : managerhouse.trim();
    }

    /** 
     * 获取 网格编码 stability.gridcode
     * @return 网格编码
     */
    public final String getGridcode() {
        return gridcode;
    }

    /** 
     * 设置 网格编码 stability.gridcode
     * @param gridcode 网格编码
     */
    public final void setGridcode(String gridcode) {
        this.gridcode = gridcode == null ? null : gridcode.trim();
    }

    /** 
     * 获取 网格范围 stability.gridscope
     * @return 网格范围
     */
    public final String getGridscope() {
        return gridscope;
    }

    /** 
     * 设置 网格范围 stability.gridscope
     * @param gridscope 网格范围
     */
    public final void setGridscope(String gridscope) {
        this.gridscope = gridscope == null ? null : gridscope.trim();
    }

    /** 
     * 获取 备注 stability.comment
     * @return 备注
     */
    public final String getComment() {
        return comment;
    }

    /** 
     * 设置 备注 stability.comment
     * @param comment 备注
     */
    public final void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", time=").append(time);
        sb.append(", policestationid=").append(policestationid);
        sb.append(", gridname=").append(gridname);
        sb.append(", rusticate=").append(rusticate);
        sb.append(", gridsequence=").append(gridsequence);
        sb.append(", gridpersontype=").append(gridpersontype);
        sb.append(", gridpersonname=").append(gridpersonname);
        sb.append(", idcard=").append(idcard);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", gridpersonphone=").append(gridpersonphone);
        sb.append(", politicallook=").append(politicallook);
        sb.append(", education=").append(education);
        sb.append(", marital=").append(marital);
        sb.append(", currentaddress=").append(currentaddress);
        sb.append(", otheridentity=").append(otheridentity);
        sb.append(", managerhouse=").append(managerhouse);
        sb.append(", gridcode=").append(gridcode);
        sb.append(", gridscope=").append(gridscope);
        sb.append(", comment=").append(comment);
        sb.append("]");
        return sb.toString();
    }
}