/* https://github.com/orange1438 */
package com.zhongzhou.entity.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/** 
 * 用户组表 t_sys_usergroup
 *  t_sys_usergroup
 * 用户组包含多个角色 t_sys_usergroup
 * @author orange1438
 * date:2018/07/19 15:55
 */
public class TSysUsergroup implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 5799991812430075873L;

    /** 
     */ 
    private Integer id;

    /** 
     * 用户组名称
     */ 
    private String usergroupname;

    /**
     * 包含的角色
     */
    private String rolenames;
    /** 
     */ 
    private Date createtime;

    /** 
     * 获取 t_sys_usergroup.id
     * @return t_sys_usergroup.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 t_sys_usergroup.id
     * @param id t_sys_usergroup.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 用户组名称 t_sys_usergroup.usergroupname
     * @return 用户组名称
     */
    public final String getUsergroupname() {
        return usergroupname;
    }

    /** 
     * 设置 用户组名称 t_sys_usergroup.usergroupname
     * @param usergroupname 用户组名称
     */
    public final void setUsergroupname(String usergroupname) {
        this.usergroupname = usergroupname == null ? null : usergroupname.trim();
    }

    /** 
     * 获取 t_sys_usergroup.createtime
     * @return t_sys_usergroup.createtime
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public final Date getCreatetime() {
        return createtime;
    }

    /** 
     * 设置 t_sys_usergroup.createtime
     * @param createtime t_sys_usergroup.createtime
     */
    public final void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }


    public String getRolenames() {
        return rolenames;
    }

    public void setRolenames(String rolenames) {
        this.rolenames = rolenames;
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", usergroupname=").append(usergroupname);
        sb.append(", createtime=").append(createtime);
        sb.append("]");
        return sb.toString();
    }
}