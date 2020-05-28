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
public class TSysPermission implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -2537160528376632848L;

    /** 
     */ 
    private Integer id;

    /** 
     */ 
    private String permissionname;

    /** 
     */ 
    private Date createtime;

    /** 
     * 获取 t_sys_permission.id
     * @return t_sys_permission.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 t_sys_permission.id
     * @param id t_sys_permission.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 t_sys_permission.permissionname
     * @return t_sys_permission.permissionname
     */
    public final String getPermissionname() {
        return permissionname;
    }

    /** 
     * 设置 t_sys_permission.permissionname
     * @param permissionname t_sys_permission.permissionname
     */
    public final void setPermissionname(String permissionname) {
        this.permissionname = permissionname == null ? null : permissionname.trim();
    }

    /** 
     * 获取 t_sys_permission.createtime
     * @return t_sys_permission.createtime
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public final Date getCreatetime() {
        return createtime;
    }

    /** 
     * 设置 t_sys_permission.createtime
     * @param createtime t_sys_permission.createtime
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
        sb.append(", permissionname=").append(permissionname);
        sb.append(", createtime=").append(createtime);
        sb.append("]");
        return sb.toString();
    }
}