/* https://github.com/orange1438 */
package com.zhongzhou.entity;

import java.io.Serializable;

/** 
 * @author orange1438
 * date:2020/05/12 10:39
 */
public class Publicsentiment implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 1080178526169574450L;

    /** 
     * 主键id
     */ 
    private Integer id;

    /** 
     * 标题
     */ 
    private String title;

    /** 
     * 内容
     */ 
    private String content;

    /** 
     * 来源
     */ 
    private String source;

    /** 
     * 关联id
     */ 
    private Integer policestationid;

    /** 
     * 时间
     */ 
    private String time;

    /** 
     * 编号
     */ 
    private String codenum;

    /** 
     * 主持人单位及职务
     */ 
    private String hostposition;

    /** 
     * 调解地点
     */ 
    private String mediateaddress;

    /** 
     * 主要事实
     */ 
    private String mainmacts;

    /** 
     * 达成协议
     */ 
    private String agreement;

    /** 
     * 调解日期
     */ 
    private String mediatedate;

    /** 
     * 1主持人姓名
     */ 
    private String onehostname;

    /** 
     * 2主持人姓名
     */ 
    private String twohostname;

    /** 
     * 1当事人姓名
     */ 
    private String onecurrentname;

    /** 
     * 2当事人姓名
     */ 
    private String twocurrentname;

    /** 
     * 1当事人性别
     */ 
    private String onecurrentsex;

    /** 
     * 2当事人性别
     */ 
    private String twocurrentsex;

    /** 
     * 1当事人年龄
     */ 
    private String onecurrentage;

    /** 
     * 2当事人年龄
     */ 
    private String twocurrentage;

    /** 
     * 1当事人民族
     */ 
    private String onecurrentnation;

    /** 
     * 2当事人民族
     */ 
    private String twocurrentnation;

    /** 
     * 1当事人出生年月
     */ 
    private String onecurrentbirthdate;

    /** 
     * 2当事人出生年月
     */ 
    private String twocurrentbirthdate;

    /** 
     * 1当事人身份证号码
     */ 
    private String onecurrentidcard;

    /** 
     * 2当事人身份证号码
     */ 
    private String twocurrentidcard;

    /** 
     * 1当事人单位
     */ 
    private String onecurrentcompany;

    /** 
     * 2当事人单位
     */ 
    private String twocurrentcompany;

    /** 
     * 1当事人职业或职务
     */ 
    private String onecurrentposition;

    /** 
     * 2当事人职业或职务
     */ 
    private String twocurrentposition;

    /** 
     * 1当事人家庭住址
     */ 
    private String onecurrentfamily;

    /** 
     * 2当事人家庭住址
     */ 
    private String twocurrentfamily;

    /** 
     * 1当事法人或其他组织名称
     */ 
    private String oneformname;

    /** 
     * 2当事法人或其他组织名称
     */ 
    private String twoformname;

    /** 
     * 1当事法定代表人
     */ 
    private String onerepresent;

    /** 
     * 2当事法定代表人
     */ 
    private String tworepresent;

    /** 
     * 1当事负责人职务
     */ 
    private String onejob;

    /** 
     * 2当事负责人职务
     */ 
    private String twojob;

    /** 
     * 获取 主键id publicsentiment.id
     * @return 主键id
     */
    public final Integer getId() {
        return id;
    }

    /** 
     * 设置 主键id publicsentiment.id
     * @param id 主键id
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取 标题 publicsentiment.title
     * @return 标题
     */
    public final String getTitle() {
        return title;
    }

    /** 
     * 设置 标题 publicsentiment.title
     * @param title 标题
     */
    public final void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /** 
     * 获取 内容 publicsentiment.content
     * @return 内容
     */
    public final String getContent() {
        return content;
    }

    /** 
     * 设置 内容 publicsentiment.content
     * @param content 内容
     */
    public final void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /** 
     * 获取 来源 publicsentiment.source
     * @return 来源
     */
    public final String getSource() {
        return source;
    }

    /** 
     * 设置 来源 publicsentiment.source
     * @param source 来源
     */
    public final void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /** 
     * 获取 关联id publicsentiment.policestationid
     * @return 关联id
     */
    public final Integer getPolicestationid() {
        return policestationid;
    }

    /** 
     * 设置 关联id publicsentiment.policestationid
     * @param policestationid 关联id
     */
    public final void setPolicestationid(Integer policestationid) {
        this.policestationid = policestationid;
    }

    /** 
     * 获取 时间 publicsentiment.time
     * @return 时间
     */
    public final String getTime() {
        return time;
    }

    /** 
     * 设置 时间 publicsentiment.time
     * @param time 时间
     */
    public final void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    /** 
     * 获取 编号 publicsentiment.codenum
     * @return 编号
     */
    public final String getCodenum() {
        return codenum;
    }

    /** 
     * 设置 编号 publicsentiment.codenum
     * @param codenum 编号
     */
    public final void setCodenum(String codenum) {
        this.codenum = codenum == null ? null : codenum.trim();
    }

    /** 
     * 获取 主持人单位及职务 publicsentiment.hostposition
     * @return 主持人单位及职务
     */
    public final String getHostposition() {
        return hostposition;
    }

    /** 
     * 设置 主持人单位及职务 publicsentiment.hostposition
     * @param hostposition 主持人单位及职务
     */
    public final void setHostposition(String hostposition) {
        this.hostposition = hostposition == null ? null : hostposition.trim();
    }

    /** 
     * 获取 调解地点 publicsentiment.mediateaddress
     * @return 调解地点
     */
    public final String getMediateaddress() {
        return mediateaddress;
    }

    /** 
     * 设置 调解地点 publicsentiment.mediateaddress
     * @param mediateaddress 调解地点
     */
    public final void setMediateaddress(String mediateaddress) {
        this.mediateaddress = mediateaddress == null ? null : mediateaddress.trim();
    }

    /** 
     * 获取 主要事实 publicsentiment.mainmacts
     * @return 主要事实
     */
    public final String getMainmacts() {
        return mainmacts;
    }

    /** 
     * 设置 主要事实 publicsentiment.mainmacts
     * @param mainmacts 主要事实
     */
    public final void setMainmacts(String mainmacts) {
        this.mainmacts = mainmacts == null ? null : mainmacts.trim();
    }

    /** 
     * 获取 达成协议 publicsentiment.agreement
     * @return 达成协议
     */
    public final String getAgreement() {
        return agreement;
    }

    /** 
     * 设置 达成协议 publicsentiment.agreement
     * @param agreement 达成协议
     */
    public final void setAgreement(String agreement) {
        this.agreement = agreement == null ? null : agreement.trim();
    }

    /** 
     * 获取 调解日期 publicsentiment.mediatedate
     * @return 调解日期
     */
    public final String getMediatedate() {
        return mediatedate;
    }

    /** 
     * 设置 调解日期 publicsentiment.mediatedate
     * @param mediatedate 调解日期
     */
    public final void setMediatedate(String mediatedate) {
        this.mediatedate = mediatedate == null ? null : mediatedate.trim();
    }

    /** 
     * 获取 1主持人姓名 publicsentiment.onehostname
     * @return 1主持人姓名
     */
    public final String getOnehostname() {
        return onehostname;
    }

    /** 
     * 设置 1主持人姓名 publicsentiment.onehostname
     * @param onehostname 1主持人姓名
     */
    public final void setOnehostname(String onehostname) {
        this.onehostname = onehostname == null ? null : onehostname.trim();
    }

    /** 
     * 获取 2主持人姓名 publicsentiment.twohostname
     * @return 2主持人姓名
     */
    public final String getTwohostname() {
        return twohostname;
    }

    /** 
     * 设置 2主持人姓名 publicsentiment.twohostname
     * @param twohostname 2主持人姓名
     */
    public final void setTwohostname(String twohostname) {
        this.twohostname = twohostname == null ? null : twohostname.trim();
    }

    /** 
     * 获取 1当事人姓名 publicsentiment.onecurrentname
     * @return 1当事人姓名
     */
    public final String getOnecurrentname() {
        return onecurrentname;
    }

    /** 
     * 设置 1当事人姓名 publicsentiment.onecurrentname
     * @param onecurrentname 1当事人姓名
     */
    public final void setOnecurrentname(String onecurrentname) {
        this.onecurrentname = onecurrentname == null ? null : onecurrentname.trim();
    }

    /** 
     * 获取 2当事人姓名 publicsentiment.twocurrentname
     * @return 2当事人姓名
     */
    public final String getTwocurrentname() {
        return twocurrentname;
    }

    /** 
     * 设置 2当事人姓名 publicsentiment.twocurrentname
     * @param twocurrentname 2当事人姓名
     */
    public final void setTwocurrentname(String twocurrentname) {
        this.twocurrentname = twocurrentname == null ? null : twocurrentname.trim();
    }

    /** 
     * 获取 1当事人性别 publicsentiment.onecurrentsex
     * @return 1当事人性别
     */
    public final String getOnecurrentsex() {
        return onecurrentsex;
    }

    /** 
     * 设置 1当事人性别 publicsentiment.onecurrentsex
     * @param onecurrentsex 1当事人性别
     */
    public final void setOnecurrentsex(String onecurrentsex) {
        this.onecurrentsex = onecurrentsex == null ? null : onecurrentsex.trim();
    }

    /** 
     * 获取 2当事人性别 publicsentiment.twocurrentsex
     * @return 2当事人性别
     */
    public final String getTwocurrentsex() {
        return twocurrentsex;
    }

    /** 
     * 设置 2当事人性别 publicsentiment.twocurrentsex
     * @param twocurrentsex 2当事人性别
     */
    public final void setTwocurrentsex(String twocurrentsex) {
        this.twocurrentsex = twocurrentsex == null ? null : twocurrentsex.trim();
    }

    /** 
     * 获取 1当事人年龄 publicsentiment.onecurrentage
     * @return 1当事人年龄
     */
    public final String getOnecurrentage() {
        return onecurrentage;
    }

    /** 
     * 设置 1当事人年龄 publicsentiment.onecurrentage
     * @param onecurrentage 1当事人年龄
     */
    public final void setOnecurrentage(String onecurrentage) {
        this.onecurrentage = onecurrentage == null ? null : onecurrentage.trim();
    }

    /** 
     * 获取 2当事人年龄 publicsentiment.twocurrentage
     * @return 2当事人年龄
     */
    public final String getTwocurrentage() {
        return twocurrentage;
    }

    /** 
     * 设置 2当事人年龄 publicsentiment.twocurrentage
     * @param twocurrentage 2当事人年龄
     */
    public final void setTwocurrentage(String twocurrentage) {
        this.twocurrentage = twocurrentage == null ? null : twocurrentage.trim();
    }

    /** 
     * 获取 1当事人民族 publicsentiment.onecurrentnation
     * @return 1当事人民族
     */
    public final String getOnecurrentnation() {
        return onecurrentnation;
    }

    /** 
     * 设置 1当事人民族 publicsentiment.onecurrentnation
     * @param onecurrentnation 1当事人民族
     */
    public final void setOnecurrentnation(String onecurrentnation) {
        this.onecurrentnation = onecurrentnation == null ? null : onecurrentnation.trim();
    }

    /** 
     * 获取 2当事人民族 publicsentiment.twocurrentnation
     * @return 2当事人民族
     */
    public final String getTwocurrentnation() {
        return twocurrentnation;
    }

    /** 
     * 设置 2当事人民族 publicsentiment.twocurrentnation
     * @param twocurrentnation 2当事人民族
     */
    public final void setTwocurrentnation(String twocurrentnation) {
        this.twocurrentnation = twocurrentnation == null ? null : twocurrentnation.trim();
    }

    /** 
     * 获取 1当事人出生年月 publicsentiment.onecurrentbirthdate
     * @return 1当事人出生年月
     */
    public final String getOnecurrentbirthdate() {
        return onecurrentbirthdate;
    }

    /** 
     * 设置 1当事人出生年月 publicsentiment.onecurrentbirthdate
     * @param onecurrentbirthdate 1当事人出生年月
     */
    public final void setOnecurrentbirthdate(String onecurrentbirthdate) {
        this.onecurrentbirthdate = onecurrentbirthdate == null ? null : onecurrentbirthdate.trim();
    }

    /** 
     * 获取 2当事人出生年月 publicsentiment.twocurrentbirthdate
     * @return 2当事人出生年月
     */
    public final String getTwocurrentbirthdate() {
        return twocurrentbirthdate;
    }

    /** 
     * 设置 2当事人出生年月 publicsentiment.twocurrentbirthdate
     * @param twocurrentbirthdate 2当事人出生年月
     */
    public final void setTwocurrentbirthdate(String twocurrentbirthdate) {
        this.twocurrentbirthdate = twocurrentbirthdate == null ? null : twocurrentbirthdate.trim();
    }

    /** 
     * 获取 1当事人身份证号码 publicsentiment.onecurrentidcard
     * @return 1当事人身份证号码
     */
    public final String getOnecurrentidcard() {
        return onecurrentidcard;
    }

    /** 
     * 设置 1当事人身份证号码 publicsentiment.onecurrentidcard
     * @param onecurrentidcard 1当事人身份证号码
     */
    public final void setOnecurrentidcard(String onecurrentidcard) {
        this.onecurrentidcard = onecurrentidcard == null ? null : onecurrentidcard.trim();
    }

    /** 
     * 获取 2当事人身份证号码 publicsentiment.twocurrentidcard
     * @return 2当事人身份证号码
     */
    public final String getTwocurrentidcard() {
        return twocurrentidcard;
    }

    /** 
     * 设置 2当事人身份证号码 publicsentiment.twocurrentidcard
     * @param twocurrentidcard 2当事人身份证号码
     */
    public final void setTwocurrentidcard(String twocurrentidcard) {
        this.twocurrentidcard = twocurrentidcard == null ? null : twocurrentidcard.trim();
    }

    /** 
     * 获取 1当事人单位 publicsentiment.onecurrentcompany
     * @return 1当事人单位
     */
    public final String getOnecurrentcompany() {
        return onecurrentcompany;
    }

    /** 
     * 设置 1当事人单位 publicsentiment.onecurrentcompany
     * @param onecurrentcompany 1当事人单位
     */
    public final void setOnecurrentcompany(String onecurrentcompany) {
        this.onecurrentcompany = onecurrentcompany == null ? null : onecurrentcompany.trim();
    }

    /** 
     * 获取 2当事人单位 publicsentiment.twocurrentcompany
     * @return 2当事人单位
     */
    public final String getTwocurrentcompany() {
        return twocurrentcompany;
    }

    /** 
     * 设置 2当事人单位 publicsentiment.twocurrentcompany
     * @param twocurrentcompany 2当事人单位
     */
    public final void setTwocurrentcompany(String twocurrentcompany) {
        this.twocurrentcompany = twocurrentcompany == null ? null : twocurrentcompany.trim();
    }

    /** 
     * 获取 1当事人职业或职务 publicsentiment.onecurrentposition
     * @return 1当事人职业或职务
     */
    public final String getOnecurrentposition() {
        return onecurrentposition;
    }

    /** 
     * 设置 1当事人职业或职务 publicsentiment.onecurrentposition
     * @param onecurrentposition 1当事人职业或职务
     */
    public final void setOnecurrentposition(String onecurrentposition) {
        this.onecurrentposition = onecurrentposition == null ? null : onecurrentposition.trim();
    }

    /** 
     * 获取 2当事人职业或职务 publicsentiment.twocurrentposition
     * @return 2当事人职业或职务
     */
    public final String getTwocurrentposition() {
        return twocurrentposition;
    }

    /** 
     * 设置 2当事人职业或职务 publicsentiment.twocurrentposition
     * @param twocurrentposition 2当事人职业或职务
     */
    public final void setTwocurrentposition(String twocurrentposition) {
        this.twocurrentposition = twocurrentposition == null ? null : twocurrentposition.trim();
    }

    /** 
     * 获取 1当事人家庭住址 publicsentiment.onecurrentfamily
     * @return 1当事人家庭住址
     */
    public final String getOnecurrentfamily() {
        return onecurrentfamily;
    }

    /** 
     * 设置 1当事人家庭住址 publicsentiment.onecurrentfamily
     * @param onecurrentfamily 1当事人家庭住址
     */
    public final void setOnecurrentfamily(String onecurrentfamily) {
        this.onecurrentfamily = onecurrentfamily == null ? null : onecurrentfamily.trim();
    }

    /** 
     * 获取 2当事人家庭住址 publicsentiment.twocurrentfamily
     * @return 2当事人家庭住址
     */
    public final String getTwocurrentfamily() {
        return twocurrentfamily;
    }

    /** 
     * 设置 2当事人家庭住址 publicsentiment.twocurrentfamily
     * @param twocurrentfamily 2当事人家庭住址
     */
    public final void setTwocurrentfamily(String twocurrentfamily) {
        this.twocurrentfamily = twocurrentfamily == null ? null : twocurrentfamily.trim();
    }

    /** 
     * 获取 1当事法人或其他组织名称 publicsentiment.oneformname
     * @return 1当事法人或其他组织名称
     */
    public final String getOneformname() {
        return oneformname;
    }

    /** 
     * 设置 1当事法人或其他组织名称 publicsentiment.oneformname
     * @param oneformname 1当事法人或其他组织名称
     */
    public final void setOneformname(String oneformname) {
        this.oneformname = oneformname == null ? null : oneformname.trim();
    }

    /** 
     * 获取 2当事法人或其他组织名称 publicsentiment.twoformname
     * @return 2当事法人或其他组织名称
     */
    public final String getTwoformname() {
        return twoformname;
    }

    /** 
     * 设置 2当事法人或其他组织名称 publicsentiment.twoformname
     * @param twoformname 2当事法人或其他组织名称
     */
    public final void setTwoformname(String twoformname) {
        this.twoformname = twoformname == null ? null : twoformname.trim();
    }

    /** 
     * 获取 1当事法定代表人 publicsentiment.onerepresent
     * @return 1当事法定代表人
     */
    public final String getOnerepresent() {
        return onerepresent;
    }

    /** 
     * 设置 1当事法定代表人 publicsentiment.onerepresent
     * @param onerepresent 1当事法定代表人
     */
    public final void setOnerepresent(String onerepresent) {
        this.onerepresent = onerepresent == null ? null : onerepresent.trim();
    }

    /** 
     * 获取 2当事法定代表人 publicsentiment.tworepresent
     * @return 2当事法定代表人
     */
    public final String getTworepresent() {
        return tworepresent;
    }

    /** 
     * 设置 2当事法定代表人 publicsentiment.tworepresent
     * @param tworepresent 2当事法定代表人
     */
    public final void setTworepresent(String tworepresent) {
        this.tworepresent = tworepresent == null ? null : tworepresent.trim();
    }

    /** 
     * 获取 1当事负责人职务 publicsentiment.onejob
     * @return 1当事负责人职务
     */
    public final String getOnejob() {
        return onejob;
    }

    /** 
     * 设置 1当事负责人职务 publicsentiment.onejob
     * @param onejob 1当事负责人职务
     */
    public final void setOnejob(String onejob) {
        this.onejob = onejob == null ? null : onejob.trim();
    }

    /** 
     * 获取 2当事负责人职务 publicsentiment.twojob
     * @return 2当事负责人职务
     */
    public final String getTwojob() {
        return twojob;
    }

    /** 
     * 设置 2当事负责人职务 publicsentiment.twojob
     * @param twojob 2当事负责人职务
     */
    public final void setTwojob(String twojob) {
        this.twojob = twojob == null ? null : twojob.trim();
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", source=").append(source);
        sb.append(", policestationid=").append(policestationid);
        sb.append(", time=").append(time);
        sb.append(", codenum=").append(codenum);
        sb.append(", hostposition=").append(hostposition);
        sb.append(", mediateaddress=").append(mediateaddress);
        sb.append(", mainmacts=").append(mainmacts);
        sb.append(", agreement=").append(agreement);
        sb.append(", mediatedate=").append(mediatedate);
        sb.append(", onehostname=").append(onehostname);
        sb.append(", twohostname=").append(twohostname);
        sb.append(", onecurrentname=").append(onecurrentname);
        sb.append(", twocurrentname=").append(twocurrentname);
        sb.append(", onecurrentsex=").append(onecurrentsex);
        sb.append(", twocurrentsex=").append(twocurrentsex);
        sb.append(", onecurrentage=").append(onecurrentage);
        sb.append(", twocurrentage=").append(twocurrentage);
        sb.append(", onecurrentnation=").append(onecurrentnation);
        sb.append(", twocurrentnation=").append(twocurrentnation);
        sb.append(", onecurrentbirthdate=").append(onecurrentbirthdate);
        sb.append(", twocurrentbirthdate=").append(twocurrentbirthdate);
        sb.append(", onecurrentidcard=").append(onecurrentidcard);
        sb.append(", twocurrentidcard=").append(twocurrentidcard);
        sb.append(", onecurrentcompany=").append(onecurrentcompany);
        sb.append(", twocurrentcompany=").append(twocurrentcompany);
        sb.append(", onecurrentposition=").append(onecurrentposition);
        sb.append(", twocurrentposition=").append(twocurrentposition);
        sb.append(", onecurrentfamily=").append(onecurrentfamily);
        sb.append(", twocurrentfamily=").append(twocurrentfamily);
        sb.append(", oneformname=").append(oneformname);
        sb.append(", twoformname=").append(twoformname);
        sb.append(", onerepresent=").append(onerepresent);
        sb.append(", tworepresent=").append(tworepresent);
        sb.append(", onejob=").append(onejob);
        sb.append(", twojob=").append(twojob);
        sb.append("]");
        return sb.toString();
    }
}