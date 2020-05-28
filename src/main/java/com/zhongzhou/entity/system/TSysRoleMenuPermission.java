/* https://github.com/orange1438 */
package com.zhongzhou.entity.system;

import java.io.Serializable;

/** 
 *  权限关联 t_sys_role_menu_permission
 *  t_sys_role_menu_permission
 * 角色,菜单,权限,关联 t_sys_role_menu_permission
 * 即  t_sys_role_menu_permission
 * 管理员拥有人员管理菜单的 新增权限 t_sys_role_menu_permission
 * @author orange1438
 * date:2018/07/19 15:55
 */
public class TSysRoleMenuPermission implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 7712363276704248819L;

    /** 
     */ 
    private Integer id;

    /** 
     */ 
    private Integer roleid;

    /** 
     */ 
    private Integer permissionid;

    /** 
     */ 
    private Integer menuid;

    /** 
     * 获取 t_sys_role_menu_permission.id
     * @return t_sys_role_menu_permission.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 t_sys_role_menu_permission.id
     * @param id t_sys_role_menu_permission.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 t_sys_role_menu_permission.roleid
     * @return t_sys_role_menu_permission.roleid
     */
    public final Integer getRoleid() {
        return roleid;
    }

    /** 
     * 设置 t_sys_role_menu_permission.roleid
     * @param roleid t_sys_role_menu_permission.roleid
     */
    public final void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /** 
     * 获取 t_sys_role_menu_permission.permissionid
     * @return t_sys_role_menu_permission.permissionid
     */
    public final Integer getPermissionid() {
        return permissionid;
    }

    /** 
     * 设置 t_sys_role_menu_permission.permissionid
     * @param permissionid t_sys_role_menu_permission.permissionid
     */
    public final void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    /** 
     * 获取 t_sys_role_menu_permission.menuid
     * @return t_sys_role_menu_permission.menuid
     */
    public final Integer getMenuid() {
        return menuid;
    }

    /** 
     * 设置 t_sys_role_menu_permission.menuid
     * @param menuid t_sys_role_menu_permission.menuid
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
        sb.append(", permissionid=").append(permissionid);
        sb.append(", menuid=").append(menuid);
        sb.append("]");
        return sb.toString();
    }
}