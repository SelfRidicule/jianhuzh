package com.zhongzhou.entity.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** 
 * @author orange1438
 * date:2018/07/19 15:55
 */
public class TSysMenu implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -3401245713670445400L;

    /** 
     */ 
    private Integer id;

    /** 
     * 上一级菜单  默认：0
     */ 
    private Integer upmenuid;

    /** 
     */ 
    private String menuname;

    /** 
     * 菜单路径
     */ 
    private String menuurl;

    /** 
     * 菜单图标路径
     */ 
    private String menuicon;

    /** 
     * 启用状态 1启用 2禁用  默认：1
     */ 
    private String status;

    /** 
     * 菜单排序  默认：0
     */ 
    private Integer weight;

    /** 
     * 备注
     */ 
    private String remark;



    private List<TSysPermission> permissionList = new ArrayList<TSysPermission>();

    private String rolehas;

    /** 
     * 获取 t_sys_menu.id
     * @return t_sys_menu.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 t_sys_menu.id
     * @param id t_sys_menu.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 上一级菜单 t_sys_menu.upmenuid
     * @return 上一级菜单
     */
    public final Integer getUpmenuid() {
        return upmenuid;
    }

    /** 
     * 设置 上一级菜单 t_sys_menu.upmenuid
     * @param upmenuid 上一级菜单
     */
    public final void setUpmenuid(Integer upmenuid) {
        this.upmenuid = upmenuid;
    }

    /** 
     * 获取 t_sys_menu.menuname
     * @return t_sys_menu.menuname
     */
    public final String getMenuname() {
        return menuname;
    }

    /** 
     * 设置 t_sys_menu.menuname
     * @param menuname t_sys_menu.menuname
     */
    public final void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    /** 
     * 获取 菜单路径 t_sys_menu.menuurl
     * @return 菜单路径
     */
    public final String getMenuurl() {
        return menuurl;
    }

    /** 
     * 设置 菜单路径 t_sys_menu.menuurl
     * @param menuurl 菜单路径
     */
    public final void setMenuurl(String menuurl) {
        this.menuurl = menuurl == null ? null : menuurl.trim();
    }

    /** 
     * 获取 菜单图标路径 t_sys_menu.menuicon
     * @return 菜单图标路径
     */
    public final String getMenuicon() {
        return menuicon;
    }

    /** 
     * 设置 菜单图标路径 t_sys_menu.menuicon
     * @param menuicon 菜单图标路径
     */
    public final void setMenuicon(String menuicon) {
        this.menuicon = menuicon == null ? null : menuicon.trim();
    }

    /** 
     * 获取 启用状态 1启用 2禁用 t_sys_menu.status
     * @return 启用状态 1启用 2禁用
     */
    public final String getStatus() {
        return status;
    }

    /** 
     * 设置 启用状态 1启用 2禁用 t_sys_menu.status
     * @param status 启用状态 1启用 2禁用
     */
    public final void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /** 
     * 获取 菜单排序 t_sys_menu.weight
     * @return 菜单排序
     */
    public final Integer getWeight() {
        return weight;
    }

    /** 
     * 设置 菜单排序 t_sys_menu.weight
     * @param weight 菜单排序
     */
    public final void setWeight(Integer weight) {
        this.weight = weight;
    }

    /** 
     * 获取 备注 t_sys_menu.remark
     * @return 备注
     */
    public final String getRemark() {
        return remark;
    }

    /** 
     * 设置 备注 t_sys_menu.remark
     * @param remark 备注
     */
    public final void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }


    public List<TSysPermission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<TSysPermission> permissionList) {
        this.permissionList = permissionList;
    }

    public String getRolehas() {
        return rolehas;
    }

    public void setRolehas(String rolehas) {
        this.rolehas = rolehas;
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", upmenuid=").append(upmenuid);
        sb.append(", menuname=").append(menuname);
        sb.append(", menuurl=").append(menuurl);
        sb.append(", menuicon=").append(menuicon);
        sb.append(", status=").append(status);
        sb.append(", weight=").append(weight);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}