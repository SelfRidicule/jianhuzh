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
public class TSysUser implements Serializable {
    /**
     * 串行版本ID
     */
    private static final long serialVersionUID = -6576141844740882727L;

    /**
     */
    private Integer id;

    /**
     */
    private String username;

    /**
     */
    private String phone;

    /**
     */
    private String email;

    /**
     */
    private Integer sex;

    /**
     */
    private Date birthday;

    /**
     */
    private Integer departid;

    /**
     */
    private Integer usergroupid;

    /**
     * 登录账户
     */
    private String account;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 启用状态 1启用 2禁用  默认：1
     */
    private String status;
    
    private String weixinid;  //微信id
    private String avatar;	//微信头像
    
    /**
     *	角色id
     */
    private Integer roleid;


    /**
     * 审核角色
     */
    private Integer roleper;


    /**
     * 派出所code
     */
    private String policecode;




    public String getPolicecode() {
        return policecode;
    }

    public void setPolicecode(String policecode) {
        this.policecode = policecode;
    }

    public String getWeixinid() {
		return weixinid;
	}

	public void setWeixinid(String weixinid) {
		this.weixinid = weixinid;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
     * 获取 t_sys_user.id
     * @return t_sys_user.id
     */
    public final Integer getId() {
        return id;
    }

    /**
     * 设置 t_sys_user.id
     * @param id t_sys_user.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 t_sys_user.username
     * @return t_sys_user.username
     */
    public final String getUsername() {
        return username;
    }

    /**
     * 设置 t_sys_user.username
     * @param username t_sys_user.username
     */
    public final void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取 t_sys_user.phone
     * @return t_sys_user.phone
     */
    public final String getPhone() {
        return phone;
    }

    /**
     * 设置 t_sys_user.phone
     * @param phone t_sys_user.phone
     */
    public final void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取 t_sys_user.email
     * @return t_sys_user.email
     */
    public final String getEmail() {
        return email;
    }

    /**
     * 设置 t_sys_user.email
     * @param email t_sys_user.email
     */
    public final void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取 t_sys_user.sex
     * @return t_sys_user.sex
     */
    public final Integer getSex() {
        return sex;
    }

    /**
     * 设置 t_sys_user.sex
     * @param sex t_sys_user.sex
     */
    public final void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取 t_sys_user.birthday
     * @return t_sys_user.birthday
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public final Date getBirthday() {
        return birthday;
    }

    /**
     * 设置 t_sys_user.birthday
     * @param birthday t_sys_user.birthday
     */
    public final void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取 t_sys_user.departid
     * @return t_sys_user.departid
     */
    public final Integer getDepartid() {
        return departid;
    }

    /**
     * 设置 t_sys_user.departid
     * @param departid t_sys_user.departid
     */
    public final void setDepartid(Integer departid) {
        this.departid = departid;
    }

    /**
     * 获取 t_sys_user.usergroupid
     * @return t_sys_user.usergroupid
     */
    public final Integer getUsergroupid() {
        return usergroupid;
    }

    /**
     * 设置 t_sys_user.usergroupid
     * @param usergroupid t_sys_user.usergroupid
     */
    public final void setUsergroupid(Integer usergroupid) {
        this.usergroupid = usergroupid;
    }

    /**
     * 获取 登录账户 t_sys_user.account
     * @return 登录账户
     */
    public final String getAccount() {
        return account;
    }

    /**
     * 设置 登录账户 t_sys_user.account
     * @param account 登录账户
     */
    public final void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 获取 登录密码 t_sys_user.password
     * @return 登录密码
     */
    public final String getPassword() {
        return password;
    }

    /**
     * 设置 登录密码 t_sys_user.password
     * @param password 登录密码
     */
    public final void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取 启用状态 1启用 2禁用 t_sys_user.status
     * @return 启用状态 1启用 2禁用
     */
    public final String getStatus() {
        return status;
    }

    /**
     * 设置 启用状态 1启用 2禁用 t_sys_user.status
     * @param status 启用状态 1启用 2禁用
     */
    public final void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", departid=").append(departid);
        sb.append(", usergroupid=").append(usergroupid);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRoleper() {
        return roleper;
    }

    public void setRoleper(Integer roleper) {
        this.roleper = roleper;
    }
}