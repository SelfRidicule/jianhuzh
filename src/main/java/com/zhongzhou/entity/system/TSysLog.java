/* https://github.com/orange1438 */
package com.zhongzhou.entity.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/** 
 * @author orange1438
 * date:2018/07/20 17:47
 */
public class TSysLog implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 4178573997584090278L;

    /** 
     */ 
    private Long id;

    /** 
     */ 
    private String username;

    /** 
     */ 
    private String userid;

    /** 
     */ 
    private Date createtime;

    /** 
     * 日志模块名称
     */ 
    private String logmodel;

    /** 
     * 日志操作类型
     */ 
    private String logtype;

    /** 
     * 登录ip
     */ 
    private String loginip;

    /** 
     * 备注
     */ 
    private String remake;

    /** 
     * 获取 t_sys_log.id
     * @return t_sys_log.id
     */
    public final Long getId() {
        return id;
    }

    /** 
     * 设置 t_sys_log.id
     * @param id t_sys_log.id
     */
    public final void setId(Long id) {
        this.id = id;
    }

    /** 
     * 获取 t_sys_log.username
     * @return t_sys_log.username
     */
    public final String getUsername() {
        return username;
    }

    /** 
     * 设置 t_sys_log.username
     * @param username t_sys_log.username
     */
    public final void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /** 
     * 获取 t_sys_log.userid
     * @return t_sys_log.userid
     */
    public final String getUserid() {
        return userid;
    }

    /** 
     * 设置 t_sys_log.userid
     * @param userid t_sys_log.userid
     */
    public final void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /** 
     * 获取 t_sys_log.createtime
     * @return t_sys_log.createtime
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public final Date getCreatetime() {
        return createtime;
    }

    /** 
     * 设置 t_sys_log.createtime
     * @param createtime t_sys_log.createtime
     */
    public final void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /** 
     * 获取 日志模块名称 t_sys_log.logmodel
     * @return 日志模块名称
     */
    public final String getLogmodel() {
        return logmodel;
    }

    /** 
     * 设置 日志模块名称 t_sys_log.logmodel
     * @param logmodel 日志模块名称
     */
    public final void setLogmodel(String logmodel) {
        this.logmodel = logmodel == null ? null : logmodel.trim();
    }

    /** 
     * 获取 日志操作类型 t_sys_log.logtype
     * @return 日志操作类型
     */
    public final String getLogtype() {
        return logtype;
    }

    /** 
     * 设置 日志操作类型 t_sys_log.logtype
     * @param logtype 日志操作类型
     */
    public final void setLogtype(String logtype) {
        this.logtype = logtype == null ? null : logtype.trim();
    }

    /** 
     * 获取 登录ip t_sys_log.loginip
     * @return 登录ip
     */
    public final String getLoginip() {
        return loginip;
    }

    /** 
     * 设置 登录ip t_sys_log.loginip
     * @param loginip 登录ip
     */
    public final void setLoginip(String loginip) {
        this.loginip = loginip == null ? null : loginip.trim();
    }

    /** 
     * 获取 备注 t_sys_log.remake
     * @return 备注
     */
    public final String getRemake() {
        return remake;
    }

    /** 
     * 设置 备注 t_sys_log.remake
     * @param remake 备注
     */
    public final void setRemake(String remake) {
        this.remake = remake == null ? null : remake.trim();
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", userid=").append(userid);
        sb.append(", createtime=").append(createtime);
        sb.append(", logmodel=").append(logmodel);
        sb.append(", logtype=").append(logtype);
        sb.append(", loginip=").append(loginip);
        sb.append(", remake=").append(remake);
        sb.append("]");
        return sb.toString();
    }
}