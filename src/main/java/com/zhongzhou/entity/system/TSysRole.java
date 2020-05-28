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
public class TSysRole implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -2563630417876938096L;

    /** 
     */ 
    private Integer id;

    /** 
     */ 
    private String rolename;

    /** 
     */ 
    private Date createtime;

    /** 
     * 获取 t_sys_role.id
     * @return t_sys_role.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 t_sys_role.id
     * @param id t_sys_role.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 t_sys_role.rolename
     * @return t_sys_role.rolename
     */
    public final String getRolename() {
        return rolename;
    }

    /** 
     * 设置 t_sys_role.rolename
     * @param rolename t_sys_role.rolename
     */
    public final void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    /** 
     * 获取 t_sys_role.createtime
     * @return t_sys_role.createtime
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public final Date getCreatetime() {
        return createtime;
    }

    /** 
     * 设置 t_sys_role.createtime
     * @param createtime t_sys_role.createtime
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
        sb.append(", rolename=").append(rolename);
        sb.append(", createtime=").append(createtime);
        sb.append("]");
        return sb.toString();
    }
}