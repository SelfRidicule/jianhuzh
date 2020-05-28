/* https://github.com/orange1438 */
package com.zhongzhou.entity;

import java.io.Serializable;

/** 
 * @author orange1438
 * date:2019/12/31 13:38
 */
public class Policestation implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -2718904765767421873L;

    /** 
     */ 
    private Integer id;

    /** 
     * 派出所名称
     */ 
    private String name;

    /** 
     * 派出所代码
     */ 
    private String code;

    /** 
     * 派出所简称
     */ 
    private String aliasname;

    /** 
     * 登录账号
     */ 
    private String account;

    /** 
     * 登录密码
     */ 
    private String password;

    /** 
     * 服务编码
     */ 
    private String servicecode;

    /** 
     * 连接
     */ 
    private String linkurl;

    /** 
     * 经度
     */ 
    private String longitude;

    /** 
     * 纬度
     */ 
    private String latitude;

    /** 
     * 获取 policestation.id
     * @return policestation.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 policestation.id
     * @param id policestation.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 派出所名称 policestation.name
     * @return 派出所名称
     */
    public final String getName() {
        return name;
    }

    /** 
     * 设置 派出所名称 policestation.name
     * @param name 派出所名称
     */
    public final void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /** 
     * 获取 派出所代码 policestation.code
     * @return 派出所代码
     */
    public final String getCode() {
        return code;
    }

    /** 
     * 设置 派出所代码 policestation.code
     * @param code 派出所代码
     */
    public final void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /** 
     * 获取 派出所简称 policestation.aliasname
     * @return 派出所简称
     */
    public final String getAliasname() {
        return aliasname;
    }

    /** 
     * 设置 派出所简称 policestation.aliasname
     * @param aliasname 派出所简称
     */
    public final void setAliasname(String aliasname) {
        this.aliasname = aliasname == null ? null : aliasname.trim();
    }

    /** 
     * 获取 登录账号 policestation.account
     * @return 登录账号
     */
    public final String getAccount() {
        return account;
    }

    /** 
     * 设置 登录账号 policestation.account
     * @param account 登录账号
     */
    public final void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /** 
     * 获取 登录密码 policestation.password
     * @return 登录密码
     */
    public final String getPassword() {
        return password;
    }

    /** 
     * 设置 登录密码 policestation.password
     * @param password 登录密码
     */
    public final void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /** 
     * 获取 服务编码 policestation.servicecode
     * @return 服务编码
     */
    public final String getServicecode() {
        return servicecode;
    }

    /** 
     * 设置 服务编码 policestation.servicecode
     * @param servicecode 服务编码
     */
    public final void setServicecode(String servicecode) {
        this.servicecode = servicecode == null ? null : servicecode.trim();
    }

    /** 
     * 获取 连接 policestation.linkurl
     * @return 连接
     */
    public final String getLinkurl() {
        return linkurl;
    }

    /** 
     * 设置 连接 policestation.linkurl
     * @param linkurl 连接
     */
    public final void setLinkurl(String linkurl) {
        this.linkurl = linkurl == null ? null : linkurl.trim();
    }

    /** 
     * 获取 经度 policestation.longitude
     * @return 经度
     */
    public final String getLongitude() {
        return longitude;
    }

    /** 
     * 设置 经度 policestation.longitude
     * @param longitude 经度
     */
    public final void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /** 
     * 获取 纬度 policestation.latitude
     * @return 纬度
     */
    public final String getLatitude() {
        return latitude;
    }

    /** 
     * 设置 纬度 policestation.latitude
     * @param latitude 纬度
     */
    public final void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
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
        sb.append(", code=").append(code);
        sb.append(", aliasname=").append(aliasname);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", servicecode=").append(servicecode);
        sb.append(", linkurl=").append(linkurl);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append("]");
        return sb.toString();
    }
}