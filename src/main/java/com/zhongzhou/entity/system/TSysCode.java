/* https://github.com/orange1438 */
package com.zhongzhou.entity.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/** 
 * @author orange1438
 * date:2018/07/19 15:55
 */
public class TSysCode implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 5545863452116200879L;

    /** 
     */ 
    private Integer id;

    /** 
     * 字段类型
     */ 
    private String codetype;

    /** 
     * 字段 名字
     */ 
    private String codename;

    /** 
     * 字段值
     */ 
    private String codevalue;

    /** 
     * 启用状态 1启用 2禁用  默认：1
     */ 
    private String status;

    /** 
     */ 
    private Date createtime;

    /** 
     * 获取 t_sys_code.id
     * @return t_sys_code.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 t_sys_code.id
     * @param id t_sys_code.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 字段类型 t_sys_code.codetype
     * @return 字段类型
     */
    public final String getCodetype() {
        return codetype;
    }

    /** 
     * 设置 字段类型 t_sys_code.codetype
     * @param codetype 字段类型
     */
    public final void setCodetype(String codetype) {
        this.codetype = codetype == null ? null : codetype.trim();
    }

    /** 
     * 获取 字段 名字 t_sys_code.codename
     * @return 字段 名字
     */
    public final String getCodename() {
        return codename;
    }

    /** 
     * 设置 字段 名字 t_sys_code.codename
     * @param codename 字段 名字
     */
    public final void setCodename(String codename) {
        this.codename = codename == null ? null : codename.trim();
    }

    /** 
     * 获取 字段值 t_sys_code.codevalue
     * @return 字段值
     */
    public final String getCodevalue() {
        return codevalue;
    }

    /** 
     * 设置 字段值 t_sys_code.codevalue
     * @param codevalue 字段值
     */
    public final void setCodevalue(String codevalue) {
        this.codevalue = codevalue == null ? null : codevalue.trim();
    }

    /** 
     * 获取 启用状态 1启用 2禁用 t_sys_code.status
     * @return 启用状态 1启用 2禁用
     */
    public final String getStatus() {
        return status;
    }

    /** 
     * 设置 启用状态 1启用 2禁用 t_sys_code.status
     * @param status 启用状态 1启用 2禁用
     */
    public final void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /** 
     * 获取 t_sys_code.createtime
     * @return t_sys_code.createtime
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public final Date getCreatetime() {
        return createtime;
    }

    /** 
     * 设置 t_sys_code.createtime
     * @param createtime t_sys_code.createtime
     */
    public final void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", codetype=").append(codetype);
        sb.append(", codename=").append(codename);
        sb.append(", codevalue=").append(codevalue);
        sb.append(", status=").append(status);
        sb.append(", createtime=").append(createtime);
        sb.append("]");
        return sb.toString();
    }
}