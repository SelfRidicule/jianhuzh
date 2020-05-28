/* https://github.com/orange1438 */
package com.zhongzhou.entity.system;

import java.io.Serializable;

/** 
 * 用户组表与角色表的关联表 t_sys_usergroup_role
 * @author orange1438
 * date:2018/07/19 15:55
 */
public class TSysUsergroupRole implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 7729537346509327057L;

    /** 
     */ 
    private Integer id;

    /** 
     */ 
    private Integer usergroupid;

    /** 
     */ 
    private Integer roleid;

    /** 
     * 获取 t_sys_usergroup_role.id
     * @return t_sys_usergroup_role.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 t_sys_usergroup_role.id
     * @param id t_sys_usergroup_role.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 t_sys_usergroup_role.usergroupid
     * @return t_sys_usergroup_role.usergroupid
     */
    public final Integer getUsergroupid() {
        return usergroupid;
    }

    /** 
     * 设置 t_sys_usergroup_role.usergroupid
     * @param usergroupid t_sys_usergroup_role.usergroupid
     */
    public final void setUsergroupid(Integer usergroupid) {
        this.usergroupid = usergroupid;
    }

    /** 
     * 获取 t_sys_usergroup_role.roleid
     * @return t_sys_usergroup_role.roleid
     */
    public final Integer getRoleid() {
        return roleid;
    }

    /** 
     * 设置 t_sys_usergroup_role.roleid
     * @param roleid t_sys_usergroup_role.roleid
     */
    public final void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", usergroupid=").append(usergroupid);
        sb.append(", roleid=").append(roleid);
        sb.append("]");
        return sb.toString();
    }
}