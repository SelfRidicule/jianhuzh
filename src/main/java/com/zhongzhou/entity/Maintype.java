/* https://github.com/orange1438 */
package com.zhongzhou.entity;

import java.io.Serializable;

/** 
 * @author orange1438
 * date:2020/01/06 09:46
 */
public class Maintype implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -818312357245410006L;

    /** 
     */ 
    private Integer id;

    /** 
     * 类型名称
     */ 
    private String name;

    /** 
     * 获取 maintype.id
     * @return maintype.id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 maintype.id
     * @param id maintype.id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 类型名称 maintype.name
     * @return 类型名称
     */
    public final String getName() {
        return name;
    }

    /** 
     * 设置 类型名称 maintype.name
     * @param name 类型名称
     */
    public final void setName(String name) {
        this.name = name == null ? null : name.trim();
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
        sb.append("]");
        return sb.toString();
    }
}