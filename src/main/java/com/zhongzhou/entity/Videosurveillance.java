/* https://github.com/orange1438 */
package com.zhongzhou.entity;

import java.io.Serializable;

/** 
 * @author orange1438
 * date:2019/12/26 09:23
 */
public class Videosurveillance implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -6298119913688580516L;

    /** 
     */ 
    private Integer id;

    /** 
     */ 
    private String username;

    /** 
     */ 
    private String password;

    /** 
     */ 
    private String ip;

    /** 
     */ 
    private String longitude;

    /** 
     */ 
    private String latitude;

    /** 
     */ 
    private Integer policestationid;

    /** 
     */ 
    private String cameraname;

    /** 
     */ 
    private String cameracode;

    /** 
     * 获取 videosurveillance.id
     * @return videosurveillance.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 videosurveillance.id
     * @param id videosurveillance.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 videosurveillance.username
     * @return videosurveillance.username
     */
    public final String getUsername() {
        return username;
    }

    /** 
     * 设置 videosurveillance.username
     * @param username videosurveillance.username
     */
    public final void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /** 
     * 获取 videosurveillance.password
     * @return videosurveillance.password
     */
    public final String getPassword() {
        return password;
    }

    /** 
     * 设置 videosurveillance.password
     * @param password videosurveillance.password
     */
    public final void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /** 
     * 获取 videosurveillance.ip
     * @return videosurveillance.ip
     */
    public final String getIp() {
        return ip;
    }

    /** 
     * 设置 videosurveillance.ip
     * @param ip videosurveillance.ip
     */
    public final void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /** 
     * 获取 videosurveillance.longitude
     * @return videosurveillance.longitude
     */
    public final String getLongitude() {
        return longitude;
    }

    /** 
     * 设置 videosurveillance.longitude
     * @param longitude videosurveillance.longitude
     */
    public final void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /** 
     * 获取 videosurveillance.latitude
     * @return videosurveillance.latitude
     */
    public final String getLatitude() {
        return latitude;
    }

    /** 
     * 设置 videosurveillance.latitude
     * @param latitude videosurveillance.latitude
     */
    public final void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /** 
     * 获取 videosurveillance.policestationid
     * @return videosurveillance.policestationid
     */
    public final Integer getPolicestationid() {
        return policestationid;
    }

    /** 
     * 设置 videosurveillance.policestationid
     * @param policestationid videosurveillance.policestationid
     */
    public final void setPolicestationid(Integer policestationid) {
        this.policestationid = policestationid;
    }

    /** 
     * 获取 videosurveillance.cameraname
     * @return videosurveillance.cameraname
     */
    public final String getCameraname() {
        return cameraname;
    }

    /** 
     * 设置 videosurveillance.cameraname
     * @param cameraname videosurveillance.cameraname
     */
    public final void setCameraname(String cameraname) {
        this.cameraname = cameraname == null ? null : cameraname.trim();
    }

    /** 
     * 获取 videosurveillance.cameracode
     * @return videosurveillance.cameracode
     */
    public final String getCameracode() {
        return cameracode;
    }

    /** 
     * 设置 videosurveillance.cameracode
     * @param cameracode videosurveillance.cameracode
     */
    public final void setCameracode(String cameracode) {
        this.cameracode = cameracode == null ? null : cameracode.trim();
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
        sb.append(", password=").append(password);
        sb.append(", ip=").append(ip);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", policestationid=").append(policestationid);
        sb.append(", cameraname=").append(cameraname);
        sb.append(", cameracode=").append(cameracode);
        sb.append("]");
        return sb.toString();
    }
}