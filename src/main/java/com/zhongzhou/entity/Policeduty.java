/* https://github.com/orange1438 */
package com.zhongzhou.entity;

import java.io.Serializable;

/** 
 * @author orange1438
 * date:2019/12/24 14:31
 */
public class Policeduty implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -4545828378866476645L;

    /** 
     */ 
    private Integer id;

    /** 
     * 姓名
     */ 
    private String name;

    /** 
     * 身份证
     */ 
    private String identity;

    /** 
     * 单位
     */ 
    private String company;

    /** 
     * 号码
     */ 
    private String phone;

    /** 
     * 性别
     */ 
    private String sex;

    /** 
     * 职务
     */ 
    private String duties;

    /** 
     * policestationid
     */ 
    private Integer policestationid;

    /** 
     * 1值班 0不值班
     */ 
    private Integer status;

    /** 
     * 获取 policeduty.id
     * @return policeduty.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 policeduty.id
     * @param id policeduty.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 姓名 policeduty.name
     * @return 姓名
     */
    public final String getName() {
        return name;
    }

    /** 
     * 设置 姓名 policeduty.name
     * @param name 姓名
     */
    public final void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /** 
     * 获取 身份证 policeduty.identity
     * @return 身份证
     */
    public final String getIdentity() {
        return identity;
    }

    /** 
     * 设置 身份证 policeduty.identity
     * @param identity 身份证
     */
    public final void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    /** 
     * 获取 单位 policeduty.company
     * @return 单位
     */
    public final String getCompany() {
        return company;
    }

    /** 
     * 设置 单位 policeduty.company
     * @param company 单位
     */
    public final void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    /** 
     * 获取 号码 policeduty.phone
     * @return 号码
     */
    public final String getPhone() {
        return phone;
    }

    /** 
     * 设置 号码 policeduty.phone
     * @param phone 号码
     */
    public final void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /** 
     * 获取 性别 policeduty.sex
     * @return 性别
     */
    public final String getSex() {
        return sex;
    }

    /** 
     * 设置 性别 policeduty.sex
     * @param sex 性别
     */
    public final void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /** 
     * 获取 职务 policeduty.duties
     * @return 职务
     */
    public final String getDuties() {
        return duties;
    }

    /** 
     * 设置 职务 policeduty.duties
     * @param duties 职务
     */
    public final void setDuties(String duties) {
        this.duties = duties == null ? null : duties.trim();
    }

    /** 
     * 获取 policestationid policeduty.policestationid
     * @return policestationid
     */
    public final Integer getPolicestationid() {
        return policestationid;
    }

    /** 
     * 设置 policestationid policeduty.policestationid
     * @param policestationid policestationid
     */
    public final void setPolicestationid(Integer policestationid) {
        this.policestationid = policestationid;
    }

    /** 
     * 获取 1值班 0不值班 policeduty.status
     * @return 1值班 0不值班
     */
    public final Integer getStatus() {
        return status;
    }

    /** 
     * 设置 1值班 0不值班 policeduty.status
     * @param status 1值班 0不值班
     */
    public final void setStatus(Integer status) {
        this.status = status;
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
        sb.append(", identity=").append(identity);
        sb.append(", company=").append(company);
        sb.append(", phone=").append(phone);
        sb.append(", sex=").append(sex);
        sb.append(", duties=").append(duties);
        sb.append(", policestationid=").append(policestationid);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}