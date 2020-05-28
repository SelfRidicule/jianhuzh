/* https://github.com/orange1438 */
package com.zhongzhou.entity.system;

import java.io.Serializable;

/** 
 * 角色与菜单的联系表 t_sys_role_menu
 * @author orange1438
 * date:2018/07/19 15:55
 */
public class TSysRoleMenu implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 5669245555109681952L;

    /** 
     */ 
    private Integer id;

    /** 
     */ 
    private Integer roleid;

    /** 
     */ 
    private Integer menuid;

    /** 
     * 获取 t_sys_role_menu.id
     * @return t_sys_role_menu.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 t_sys_role_menu.id
     * @param id t_sys_role_menu.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 t_sys_role_menu.roleid
     * @return t_sys_role_menu.roleid
     */
    public final Integer getRoleid() {
        return roleid;
    }

    /** 
     * 设置 t_sys_role_menu.roleid
     * @param roleid t_sys_role_menu.roleid
     */
    public final void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /** 
     * 获取 t_sys_role_menu.menuid
     * @return t_sys_role_menu.menuid
     */
    public final Integer getMenuid() {
        return menuid;
    }

    /** 
     * 设置 t_sys_role_menu.menuid
     * @param menuid t_sys_role_menu.menuid
     */
    public final void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", roleid=").append(roleid);
        sb.append(", menuid=").append(menuid);
        sb.append("]");
        return sb.toString();
    }
}