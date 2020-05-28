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
public class TSysDepart implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 5332495702101946370L;

    /** 
     */ 
    private Integer id;

    /** 
     */ 
    private String departname;

    /** 
     * 上一级部门  默认：0
     */ 
    private Integer upid;

    /** 
     */ 
    private Date createtime;

    /** 
     */ 
    private String type;

    /** 
     * 获取 t_sys_depart.id
     * @return t_sys_depart.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 t_sys_depart.id
     * @param id t_sys_depart.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 t_sys_depart.departname
     * @return t_sys_depart.departname
     */
    public final String getDepartname() {
        return departname;
    }

    /** 
     * 设置 t_sys_depart.departname
     * @param departname t_sys_depart.departname
     */
    public final void setDepartname(String departname) {
        this.departname = departname == null ? null : departname.trim();
    }

    /** 
     * 获取 上一级部门 t_sys_depart.upid
     * @return 上一级部门
     */
    public final Integer getUpid() {
        return upid;
    }

    /** 
     * 设置 上一级部门 t_sys_depart.upid
     * @param upid 上一级部门
     */
    public final void setUpid(Integer upid) {
        this.upid = upid;
    }

    /** 
     * 获取 t_sys_depart.createtime
     * @return t_sys_depart.createtime
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public final Date getCreatetime() {
        return createtime;
    }

    /** 
     * 设置 t_sys_depart.createtime
     * @param createtime t_sys_depart.createtime
     */
    public final void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /** 
     * 获取 t_sys_depart.type
     * @return t_sys_depart.type
     */
    public final String getType() {
        return type;
    }

    /** 
     * 设置 t_sys_depart.type
     * @param type t_sys_depart.type
     */
    public final void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", departname=").append(departname);
        sb.append(", upid=").append(upid);
        sb.append(", createtime=").append(createtime);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}