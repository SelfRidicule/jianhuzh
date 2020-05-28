/* https://github.com/orange1438 */
package com.zhongzhou.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438
 * date:2020/05/09 15:55
 */
public class StabilityCriteria {
    /** 
     * 排序字段
    */
    protected String orderByClause;

    /** 
     * 过滤重复数据
    */
    protected boolean distinct;

    /** 
     * 查询条件
    */
    protected List<Criteria> oredCriteria;

    /** 
     * 构造查询条件
     */
    public StabilityCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /** 
     * 设置排序字段
     * @param orderByClause 排序字段
     */
    public final void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /** 
     * 获取排序字段
     */
    public final String getOrderByClause() {
        return orderByClause;
    }

    /** 
     * 设置过滤重复数据
     * @param distinct 是否过滤重复数据
     */
    public final void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /** 
     * 是否过滤重复数据
     */
    public final boolean isDistinct() {
        return distinct;
    }

    /** 
     * 获取当前的查询条件实例
     */
    public final List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /** 
     * 增加或者的查询条件,用于构建或者查询
     * @param criteria 过滤条件实例
     */
    public final void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /** 
     * 创建一个新的或者查询条件
     */
    public final Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /** 
     * 创建一个查询条件
     */
    public final Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /** 
     * 内部构建查询条件对象
     */
    protected final Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /** 
     * 清除查询条件
     */
    public final void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * stability
     */
    protected abstract static class BaseCriteria {
        protected List<Criterion> criteria;

        protected BaseCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andPolicestationidIsNull() {
            addCriterion("policestationid is null");
            return (Criteria) this;
        }

        public Criteria andPolicestationidIsNotNull() {
            addCriterion("policestationid is not null");
            return (Criteria) this;
        }

        public Criteria andPolicestationidEqualTo(Integer value) {
            addCriterion("policestationid =", value, "policestationid");
            return (Criteria) this;
        }

        public Criteria andPolicestationidNotEqualTo(Integer value) {
            addCriterion("policestationid <>", value, "policestationid");
            return (Criteria) this;
        }

        public Criteria andPolicestationidGreaterThan(Integer value) {
            addCriterion("policestationid >", value, "policestationid");
            return (Criteria) this;
        }

        public Criteria andPolicestationidGreaterThanOrEqualTo(Integer value) {
            addCriterion("policestationid >=", value, "policestationid");
            return (Criteria) this;
        }

        public Criteria andPolicestationidLessThan(Integer value) {
            addCriterion("policestationid <", value, "policestationid");
            return (Criteria) this;
        }

        public Criteria andPolicestationidLessThanOrEqualTo(Integer value) {
            addCriterion("policestationid <=", value, "policestationid");
            return (Criteria) this;
        }

        public Criteria andPolicestationidIn(List<Integer> values) {
            addCriterion("policestationid in", values, "policestationid");
            return (Criteria) this;
        }

        public Criteria andPolicestationidNotIn(List<Integer> values) {
            addCriterion("policestationid not in", values, "policestationid");
            return (Criteria) this;
        }

        public Criteria andPolicestationidBetween(Integer value1, Integer value2) {
            addCriterion("policestationid between", value1, value2, "policestationid");
            return (Criteria) this;
        }

        public Criteria andPolicestationidNotBetween(Integer value1, Integer value2) {
            addCriterion("policestationid not between", value1, value2, "policestationid");
            return (Criteria) this;
        }

        public Criteria andGridnameIsNull() {
            addCriterion("gridname is null");
            return (Criteria) this;
        }

        public Criteria andGridnameIsNotNull() {
            addCriterion("gridname is not null");
            return (Criteria) this;
        }

        public Criteria andGridnameEqualTo(String value) {
            addCriterion("gridname =", value, "gridname");
            return (Criteria) this;
        }

        public Criteria andGridnameNotEqualTo(String value) {
            addCriterion("gridname <>", value, "gridname");
            return (Criteria) this;
        }

        public Criteria andGridnameGreaterThan(String value) {
            addCriterion("gridname >", value, "gridname");
            return (Criteria) this;
        }

        public Criteria andGridnameGreaterThanOrEqualTo(String value) {
            addCriterion("gridname >=", value, "gridname");
            return (Criteria) this;
        }

        public Criteria andGridnameLessThan(String value) {
            addCriterion("gridname <", value, "gridname");
            return (Criteria) this;
        }

        public Criteria andGridnameLessThanOrEqualTo(String value) {
            addCriterion("gridname <=", value, "gridname");
            return (Criteria) this;
        }

        public Criteria andGridnameLike(String value) {
            addCriterion("gridname like", value, "gridname");
            return (Criteria) this;
        }

        public Criteria andGridnameNotLike(String value) {
            addCriterion("gridname not like", value, "gridname");
            return (Criteria) this;
        }

        public Criteria andGridnameIn(List<String> values) {
            addCriterion("gridname in", values, "gridname");
            return (Criteria) this;
        }

        public Criteria andGridnameNotIn(List<String> values) {
            addCriterion("gridname not in", values, "gridname");
            return (Criteria) this;
        }

        public Criteria andGridnameBetween(String value1, String value2) {
            addCriterion("gridname between", value1, value2, "gridname");
            return (Criteria) this;
        }

        public Criteria andGridnameNotBetween(String value1, String value2) {
            addCriterion("gridname not between", value1, value2, "gridname");
            return (Criteria) this;
        }

        public Criteria andRusticateIsNull() {
            addCriterion("rusticate is null");
            return (Criteria) this;
        }

        public Criteria andRusticateIsNotNull() {
            addCriterion("rusticate is not null");
            return (Criteria) this;
        }

        public Criteria andRusticateEqualTo(String value) {
            addCriterion("rusticate =", value, "rusticate");
            return (Criteria) this;
        }

        public Criteria andRusticateNotEqualTo(String value) {
            addCriterion("rusticate <>", value, "rusticate");
            return (Criteria) this;
        }

        public Criteria andRusticateGreaterThan(String value) {
            addCriterion("rusticate >", value, "rusticate");
            return (Criteria) this;
        }

        public Criteria andRusticateGreaterThanOrEqualTo(String value) {
            addCriterion("rusticate >=", value, "rusticate");
            return (Criteria) this;
        }

        public Criteria andRusticateLessThan(String value) {
            addCriterion("rusticate <", value, "rusticate");
            return (Criteria) this;
        }

        public Criteria andRusticateLessThanOrEqualTo(String value) {
            addCriterion("rusticate <=", value, "rusticate");
            return (Criteria) this;
        }

        public Criteria andRusticateLike(String value) {
            addCriterion("rusticate like", value, "rusticate");
            return (Criteria) this;
        }

        public Criteria andRusticateNotLike(String value) {
            addCriterion("rusticate not like", value, "rusticate");
            return (Criteria) this;
        }

        public Criteria andRusticateIn(List<String> values) {
            addCriterion("rusticate in", values, "rusticate");
            return (Criteria) this;
        }

        public Criteria andRusticateNotIn(List<String> values) {
            addCriterion("rusticate not in", values, "rusticate");
            return (Criteria) this;
        }

        public Criteria andRusticateBetween(String value1, String value2) {
            addCriterion("rusticate between", value1, value2, "rusticate");
            return (Criteria) this;
        }

        public Criteria andRusticateNotBetween(String value1, String value2) {
            addCriterion("rusticate not between", value1, value2, "rusticate");
            return (Criteria) this;
        }

        public Criteria andGridsequenceIsNull() {
            addCriterion("gridsequence is null");
            return (Criteria) this;
        }

        public Criteria andGridsequenceIsNotNull() {
            addCriterion("gridsequence is not null");
            return (Criteria) this;
        }

        public Criteria andGridsequenceEqualTo(String value) {
            addCriterion("gridsequence =", value, "gridsequence");
            return (Criteria) this;
        }

        public Criteria andGridsequenceNotEqualTo(String value) {
            addCriterion("gridsequence <>", value, "gridsequence");
            return (Criteria) this;
        }

        public Criteria andGridsequenceGreaterThan(String value) {
            addCriterion("gridsequence >", value, "gridsequence");
            return (Criteria) this;
        }

        public Criteria andGridsequenceGreaterThanOrEqualTo(String value) {
            addCriterion("gridsequence >=", value, "gridsequence");
            return (Criteria) this;
        }

        public Criteria andGridsequenceLessThan(String value) {
            addCriterion("gridsequence <", value, "gridsequence");
            return (Criteria) this;
        }

        public Criteria andGridsequenceLessThanOrEqualTo(String value) {
            addCriterion("gridsequence <=", value, "gridsequence");
            return (Criteria) this;
        }

        public Criteria andGridsequenceLike(String value) {
            addCriterion("gridsequence like", value, "gridsequence");
            return (Criteria) this;
        }

        public Criteria andGridsequenceNotLike(String value) {
            addCriterion("gridsequence not like", value, "gridsequence");
            return (Criteria) this;
        }

        public Criteria andGridsequenceIn(List<String> values) {
            addCriterion("gridsequence in", values, "gridsequence");
            return (Criteria) this;
        }

        public Criteria andGridsequenceNotIn(List<String> values) {
            addCriterion("gridsequence not in", values, "gridsequence");
            return (Criteria) this;
        }

        public Criteria andGridsequenceBetween(String value1, String value2) {
            addCriterion("gridsequence between", value1, value2, "gridsequence");
            return (Criteria) this;
        }

        public Criteria andGridsequenceNotBetween(String value1, String value2) {
            addCriterion("gridsequence not between", value1, value2, "gridsequence");
            return (Criteria) this;
        }

        public Criteria andGridpersontypeIsNull() {
            addCriterion("gridpersontype is null");
            return (Criteria) this;
        }

        public Criteria andGridpersontypeIsNotNull() {
            addCriterion("gridpersontype is not null");
            return (Criteria) this;
        }

        public Criteria andGridpersontypeEqualTo(String value) {
            addCriterion("gridpersontype =", value, "gridpersontype");
            return (Criteria) this;
        }

        public Criteria andGridpersontypeNotEqualTo(String value) {
            addCriterion("gridpersontype <>", value, "gridpersontype");
            return (Criteria) this;
        }

        public Criteria andGridpersontypeGreaterThan(String value) {
            addCriterion("gridpersontype >", value, "gridpersontype");
            return (Criteria) this;
        }

        public Criteria andGridpersontypeGreaterThanOrEqualTo(String value) {
            addCriterion("gridpersontype >=", value, "gridpersontype");
            return (Criteria) this;
        }

        public Criteria andGridpersontypeLessThan(String value) {
            addCriterion("gridpersontype <", value, "gridpersontype");
            return (Criteria) this;
        }

        public Criteria andGridpersontypeLessThanOrEqualTo(String value) {
            addCriterion("gridpersontype <=", value, "gridpersontype");
            return (Criteria) this;
        }

        public Criteria andGridpersontypeLike(String value) {
            addCriterion("gridpersontype like", value, "gridpersontype");
            return (Criteria) this;
        }

        public Criteria andGridpersontypeNotLike(String value) {
            addCriterion("gridpersontype not like", value, "gridpersontype");
            return (Criteria) this;
        }

        public Criteria andGridpersontypeIn(List<String> values) {
            addCriterion("gridpersontype in", values, "gridpersontype");
            return (Criteria) this;
        }

        public Criteria andGridpersontypeNotIn(List<String> values) {
            addCriterion("gridpersontype not in", values, "gridpersontype");
            return (Criteria) this;
        }

        public Criteria andGridpersontypeBetween(String value1, String value2) {
            addCriterion("gridpersontype between", value1, value2, "gridpersontype");
            return (Criteria) this;
        }

        public Criteria andGridpersontypeNotBetween(String value1, String value2) {
            addCriterion("gridpersontype not between", value1, value2, "gridpersontype");
            return (Criteria) this;
        }

        public Criteria andGridpersonnameIsNull() {
            addCriterion("gridpersonname is null");
            return (Criteria) this;
        }

        public Criteria andGridpersonnameIsNotNull() {
            addCriterion("gridpersonname is not null");
            return (Criteria) this;
        }

        public Criteria andGridpersonnameEqualTo(String value) {
            addCriterion("gridpersonname =", value, "gridpersonname");
            return (Criteria) this;
        }

        public Criteria andGridpersonnameNotEqualTo(String value) {
            addCriterion("gridpersonname <>", value, "gridpersonname");
            return (Criteria) this;
        }

        public Criteria andGridpersonnameGreaterThan(String value) {
            addCriterion("gridpersonname >", value, "gridpersonname");
            return (Criteria) this;
        }

        public Criteria andGridpersonnameGreaterThanOrEqualTo(String value) {
            addCriterion("gridpersonname >=", value, "gridpersonname");
            return (Criteria) this;
        }

        public Criteria andGridpersonnameLessThan(String value) {
            addCriterion("gridpersonname <", value, "gridpersonname");
            return (Criteria) this;
        }

        public Criteria andGridpersonnameLessThanOrEqualTo(String value) {
            addCriterion("gridpersonname <=", value, "gridpersonname");
            return (Criteria) this;
        }

        public Criteria andGridpersonnameLike(String value) {
            addCriterion("gridpersonname like", value, "gridpersonname");
            return (Criteria) this;
        }

        public Criteria andGridpersonnameNotLike(String value) {
            addCriterion("gridpersonname not like", value, "gridpersonname");
            return (Criteria) this;
        }

        public Criteria andGridpersonnameIn(List<String> values) {
            addCriterion("gridpersonname in", values, "gridpersonname");
            return (Criteria) this;
        }

        public Criteria andGridpersonnameNotIn(List<String> values) {
            addCriterion("gridpersonname not in", values, "gridpersonname");
            return (Criteria) this;
        }

        public Criteria andGridpersonnameBetween(String value1, String value2) {
            addCriterion("gridpersonname between", value1, value2, "gridpersonname");
            return (Criteria) this;
        }

        public Criteria andGridpersonnameNotBetween(String value1, String value2) {
            addCriterion("gridpersonname not between", value1, value2, "gridpersonname");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNull() {
            addCriterion("idcard is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("idcard is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            addCriterion("idcard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("idcard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("idcard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("idcard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("idcard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("idcard <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            addCriterion("idcard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("idcard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(List<String> values) {
            addCriterion("idcard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("idcard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("idcard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("idcard not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(String value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(String value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(String value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(String value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(String value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(String value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLike(String value) {
            addCriterion("age like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotLike(String value) {
            addCriterion("age not like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<String> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<String> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(String value1, String value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(String value1, String value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andGridpersonphoneIsNull() {
            addCriterion("gridpersonphone is null");
            return (Criteria) this;
        }

        public Criteria andGridpersonphoneIsNotNull() {
            addCriterion("gridpersonphone is not null");
            return (Criteria) this;
        }

        public Criteria andGridpersonphoneEqualTo(String value) {
            addCriterion("gridpersonphone =", value, "gridpersonphone");
            return (Criteria) this;
        }

        public Criteria andGridpersonphoneNotEqualTo(String value) {
            addCriterion("gridpersonphone <>", value, "gridpersonphone");
            return (Criteria) this;
        }

        public Criteria andGridpersonphoneGreaterThan(String value) {
            addCriterion("gridpersonphone >", value, "gridpersonphone");
            return (Criteria) this;
        }

        public Criteria andGridpersonphoneGreaterThanOrEqualTo(String value) {
            addCriterion("gridpersonphone >=", value, "gridpersonphone");
            return (Criteria) this;
        }

        public Criteria andGridpersonphoneLessThan(String value) {
            addCriterion("gridpersonphone <", value, "gridpersonphone");
            return (Criteria) this;
        }

        public Criteria andGridpersonphoneLessThanOrEqualTo(String value) {
            addCriterion("gridpersonphone <=", value, "gridpersonphone");
            return (Criteria) this;
        }

        public Criteria andGridpersonphoneLike(String value) {
            addCriterion("gridpersonphone like", value, "gridpersonphone");
            return (Criteria) this;
        }

        public Criteria andGridpersonphoneNotLike(String value) {
            addCriterion("gridpersonphone not like", value, "gridpersonphone");
            return (Criteria) this;
        }

        public Criteria andGridpersonphoneIn(List<String> values) {
            addCriterion("gridpersonphone in", values, "gridpersonphone");
            return (Criteria) this;
        }

        public Criteria andGridpersonphoneNotIn(List<String> values) {
            addCriterion("gridpersonphone not in", values, "gridpersonphone");
            return (Criteria) this;
        }

        public Criteria andGridpersonphoneBetween(String value1, String value2) {
            addCriterion("gridpersonphone between", value1, value2, "gridpersonphone");
            return (Criteria) this;
        }

        public Criteria andGridpersonphoneNotBetween(String value1, String value2) {
            addCriterion("gridpersonphone not between", value1, value2, "gridpersonphone");
            return (Criteria) this;
        }

        public Criteria andPoliticallookIsNull() {
            addCriterion("politicallook is null");
            return (Criteria) this;
        }

        public Criteria andPoliticallookIsNotNull() {
            addCriterion("politicallook is not null");
            return (Criteria) this;
        }

        public Criteria andPoliticallookEqualTo(String value) {
            addCriterion("politicallook =", value, "politicallook");
            return (Criteria) this;
        }

        public Criteria andPoliticallookNotEqualTo(String value) {
            addCriterion("politicallook <>", value, "politicallook");
            return (Criteria) this;
        }

        public Criteria andPoliticallookGreaterThan(String value) {
            addCriterion("politicallook >", value, "politicallook");
            return (Criteria) this;
        }

        public Criteria andPoliticallookGreaterThanOrEqualTo(String value) {
            addCriterion("politicallook >=", value, "politicallook");
            return (Criteria) this;
        }

        public Criteria andPoliticallookLessThan(String value) {
            addCriterion("politicallook <", value, "politicallook");
            return (Criteria) this;
        }

        public Criteria andPoliticallookLessThanOrEqualTo(String value) {
            addCriterion("politicallook <=", value, "politicallook");
            return (Criteria) this;
        }

        public Criteria andPoliticallookLike(String value) {
            addCriterion("politicallook like", value, "politicallook");
            return (Criteria) this;
        }

        public Criteria andPoliticallookNotLike(String value) {
            addCriterion("politicallook not like", value, "politicallook");
            return (Criteria) this;
        }

        public Criteria andPoliticallookIn(List<String> values) {
            addCriterion("politicallook in", values, "politicallook");
            return (Criteria) this;
        }

        public Criteria andPoliticallookNotIn(List<String> values) {
            addCriterion("politicallook not in", values, "politicallook");
            return (Criteria) this;
        }

        public Criteria andPoliticallookBetween(String value1, String value2) {
            addCriterion("politicallook between", value1, value2, "politicallook");
            return (Criteria) this;
        }

        public Criteria andPoliticallookNotBetween(String value1, String value2) {
            addCriterion("politicallook not between", value1, value2, "politicallook");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(String value) {
            addCriterion("education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(String value) {
            addCriterion("education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(String value) {
            addCriterion("education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(String value) {
            addCriterion("education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(String value) {
            addCriterion("education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(String value) {
            addCriterion("education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLike(String value) {
            addCriterion("education like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotLike(String value) {
            addCriterion("education not like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<String> values) {
            addCriterion("education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<String> values) {
            addCriterion("education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(String value1, String value2) {
            addCriterion("education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(String value1, String value2) {
            addCriterion("education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andMaritalIsNull() {
            addCriterion("marital is null");
            return (Criteria) this;
        }

        public Criteria andMaritalIsNotNull() {
            addCriterion("marital is not null");
            return (Criteria) this;
        }

        public Criteria andMaritalEqualTo(String value) {
            addCriterion("marital =", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalNotEqualTo(String value) {
            addCriterion("marital <>", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalGreaterThan(String value) {
            addCriterion("marital >", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalGreaterThanOrEqualTo(String value) {
            addCriterion("marital >=", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalLessThan(String value) {
            addCriterion("marital <", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalLessThanOrEqualTo(String value) {
            addCriterion("marital <=", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalLike(String value) {
            addCriterion("marital like", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalNotLike(String value) {
            addCriterion("marital not like", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalIn(List<String> values) {
            addCriterion("marital in", values, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalNotIn(List<String> values) {
            addCriterion("marital not in", values, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalBetween(String value1, String value2) {
            addCriterion("marital between", value1, value2, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalNotBetween(String value1, String value2) {
            addCriterion("marital not between", value1, value2, "marital");
            return (Criteria) this;
        }

        public Criteria andCurrentaddressIsNull() {
            addCriterion("currentaddress is null");
            return (Criteria) this;
        }

        public Criteria andCurrentaddressIsNotNull() {
            addCriterion("currentaddress is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentaddressEqualTo(String value) {
            addCriterion("currentaddress =", value, "currentaddress");
            return (Criteria) this;
        }

        public Criteria andCurrentaddressNotEqualTo(String value) {
            addCriterion("currentaddress <>", value, "currentaddress");
            return (Criteria) this;
        }

        public Criteria andCurrentaddressGreaterThan(String value) {
            addCriterion("currentaddress >", value, "currentaddress");
            return (Criteria) this;
        }

        public Criteria andCurrentaddressGreaterThanOrEqualTo(String value) {
            addCriterion("currentaddress >=", value, "currentaddress");
            return (Criteria) this;
        }

        public Criteria andCurrentaddressLessThan(String value) {
            addCriterion("currentaddress <", value, "currentaddress");
            return (Criteria) this;
        }

        public Criteria andCurrentaddressLessThanOrEqualTo(String value) {
            addCriterion("currentaddress <=", value, "currentaddress");
            return (Criteria) this;
        }

        public Criteria andCurrentaddressLike(String value) {
            addCriterion("currentaddress like", value, "currentaddress");
            return (Criteria) this;
        }

        public Criteria andCurrentaddressNotLike(String value) {
            addCriterion("currentaddress not like", value, "currentaddress");
            return (Criteria) this;
        }

        public Criteria andCurrentaddressIn(List<String> values) {
            addCriterion("currentaddress in", values, "currentaddress");
            return (Criteria) this;
        }

        public Criteria andCurrentaddressNotIn(List<String> values) {
            addCriterion("currentaddress not in", values, "currentaddress");
            return (Criteria) this;
        }

        public Criteria andCurrentaddressBetween(String value1, String value2) {
            addCriterion("currentaddress between", value1, value2, "currentaddress");
            return (Criteria) this;
        }

        public Criteria andCurrentaddressNotBetween(String value1, String value2) {
            addCriterion("currentaddress not between", value1, value2, "currentaddress");
            return (Criteria) this;
        }

        public Criteria andOtheridentityIsNull() {
            addCriterion("otheridentity is null");
            return (Criteria) this;
        }

        public Criteria andOtheridentityIsNotNull() {
            addCriterion("otheridentity is not null");
            return (Criteria) this;
        }

        public Criteria andOtheridentityEqualTo(String value) {
            addCriterion("otheridentity =", value, "otheridentity");
            return (Criteria) this;
        }

        public Criteria andOtheridentityNotEqualTo(String value) {
            addCriterion("otheridentity <>", value, "otheridentity");
            return (Criteria) this;
        }

        public Criteria andOtheridentityGreaterThan(String value) {
            addCriterion("otheridentity >", value, "otheridentity");
            return (Criteria) this;
        }

        public Criteria andOtheridentityGreaterThanOrEqualTo(String value) {
            addCriterion("otheridentity >=", value, "otheridentity");
            return (Criteria) this;
        }

        public Criteria andOtheridentityLessThan(String value) {
            addCriterion("otheridentity <", value, "otheridentity");
            return (Criteria) this;
        }

        public Criteria andOtheridentityLessThanOrEqualTo(String value) {
            addCriterion("otheridentity <=", value, "otheridentity");
            return (Criteria) this;
        }

        public Criteria andOtheridentityLike(String value) {
            addCriterion("otheridentity like", value, "otheridentity");
            return (Criteria) this;
        }

        public Criteria andOtheridentityNotLike(String value) {
            addCriterion("otheridentity not like", value, "otheridentity");
            return (Criteria) this;
        }

        public Criteria andOtheridentityIn(List<String> values) {
            addCriterion("otheridentity in", values, "otheridentity");
            return (Criteria) this;
        }

        public Criteria andOtheridentityNotIn(List<String> values) {
            addCriterion("otheridentity not in", values, "otheridentity");
            return (Criteria) this;
        }

        public Criteria andOtheridentityBetween(String value1, String value2) {
            addCriterion("otheridentity between", value1, value2, "otheridentity");
            return (Criteria) this;
        }

        public Criteria andOtheridentityNotBetween(String value1, String value2) {
            addCriterion("otheridentity not between", value1, value2, "otheridentity");
            return (Criteria) this;
        }

        public Criteria andManagerhouseIsNull() {
            addCriterion("managerhouse is null");
            return (Criteria) this;
        }

        public Criteria andManagerhouseIsNotNull() {
            addCriterion("managerhouse is not null");
            return (Criteria) this;
        }

        public Criteria andManagerhouseEqualTo(String value) {
            addCriterion("managerhouse =", value, "managerhouse");
            return (Criteria) this;
        }

        public Criteria andManagerhouseNotEqualTo(String value) {
            addCriterion("managerhouse <>", value, "managerhouse");
            return (Criteria) this;
        }

        public Criteria andManagerhouseGreaterThan(String value) {
            addCriterion("managerhouse >", value, "managerhouse");
            return (Criteria) this;
        }

        public Criteria andManagerhouseGreaterThanOrEqualTo(String value) {
            addCriterion("managerhouse >=", value, "managerhouse");
            return (Criteria) this;
        }

        public Criteria andManagerhouseLessThan(String value) {
            addCriterion("managerhouse <", value, "managerhouse");
            return (Criteria) this;
        }

        public Criteria andManagerhouseLessThanOrEqualTo(String value) {
            addCriterion("managerhouse <=", value, "managerhouse");
            return (Criteria) this;
        }

        public Criteria andManagerhouseLike(String value) {
            addCriterion("managerhouse like", value, "managerhouse");
            return (Criteria) this;
        }

        public Criteria andManagerhouseNotLike(String value) {
            addCriterion("managerhouse not like", value, "managerhouse");
            return (Criteria) this;
        }

        public Criteria andManagerhouseIn(List<String> values) {
            addCriterion("managerhouse in", values, "managerhouse");
            return (Criteria) this;
        }

        public Criteria andManagerhouseNotIn(List<String> values) {
            addCriterion("managerhouse not in", values, "managerhouse");
            return (Criteria) this;
        }

        public Criteria andManagerhouseBetween(String value1, String value2) {
            addCriterion("managerhouse between", value1, value2, "managerhouse");
            return (Criteria) this;
        }

        public Criteria andManagerhouseNotBetween(String value1, String value2) {
            addCriterion("managerhouse not between", value1, value2, "managerhouse");
            return (Criteria) this;
        }

        public Criteria andGridcodeIsNull() {
            addCriterion("gridcode is null");
            return (Criteria) this;
        }

        public Criteria andGridcodeIsNotNull() {
            addCriterion("gridcode is not null");
            return (Criteria) this;
        }

        public Criteria andGridcodeEqualTo(String value) {
            addCriterion("gridcode =", value, "gridcode");
            return (Criteria) this;
        }

        public Criteria andGridcodeNotEqualTo(String value) {
            addCriterion("gridcode <>", value, "gridcode");
            return (Criteria) this;
        }

        public Criteria andGridcodeGreaterThan(String value) {
            addCriterion("gridcode >", value, "gridcode");
            return (Criteria) this;
        }

        public Criteria andGridcodeGreaterThanOrEqualTo(String value) {
            addCriterion("gridcode >=", value, "gridcode");
            return (Criteria) this;
        }

        public Criteria andGridcodeLessThan(String value) {
            addCriterion("gridcode <", value, "gridcode");
            return (Criteria) this;
        }

        public Criteria andGridcodeLessThanOrEqualTo(String value) {
            addCriterion("gridcode <=", value, "gridcode");
            return (Criteria) this;
        }

        public Criteria andGridcodeLike(String value) {
            addCriterion("gridcode like", value, "gridcode");
            return (Criteria) this;
        }

        public Criteria andGridcodeNotLike(String value) {
            addCriterion("gridcode not like", value, "gridcode");
            return (Criteria) this;
        }

        public Criteria andGridcodeIn(List<String> values) {
            addCriterion("gridcode in", values, "gridcode");
            return (Criteria) this;
        }

        public Criteria andGridcodeNotIn(List<String> values) {
            addCriterion("gridcode not in", values, "gridcode");
            return (Criteria) this;
        }

        public Criteria andGridcodeBetween(String value1, String value2) {
            addCriterion("gridcode between", value1, value2, "gridcode");
            return (Criteria) this;
        }

        public Criteria andGridcodeNotBetween(String value1, String value2) {
            addCriterion("gridcode not between", value1, value2, "gridcode");
            return (Criteria) this;
        }

        public Criteria andGridscopeIsNull() {
            addCriterion("gridscope is null");
            return (Criteria) this;
        }

        public Criteria andGridscopeIsNotNull() {
            addCriterion("gridscope is not null");
            return (Criteria) this;
        }

        public Criteria andGridscopeEqualTo(String value) {
            addCriterion("gridscope =", value, "gridscope");
            return (Criteria) this;
        }

        public Criteria andGridscopeNotEqualTo(String value) {
            addCriterion("gridscope <>", value, "gridscope");
            return (Criteria) this;
        }

        public Criteria andGridscopeGreaterThan(String value) {
            addCriterion("gridscope >", value, "gridscope");
            return (Criteria) this;
        }

        public Criteria andGridscopeGreaterThanOrEqualTo(String value) {
            addCriterion("gridscope >=", value, "gridscope");
            return (Criteria) this;
        }

        public Criteria andGridscopeLessThan(String value) {
            addCriterion("gridscope <", value, "gridscope");
            return (Criteria) this;
        }

        public Criteria andGridscopeLessThanOrEqualTo(String value) {
            addCriterion("gridscope <=", value, "gridscope");
            return (Criteria) this;
        }

        public Criteria andGridscopeLike(String value) {
            addCriterion("gridscope like", value, "gridscope");
            return (Criteria) this;
        }

        public Criteria andGridscopeNotLike(String value) {
            addCriterion("gridscope not like", value, "gridscope");
            return (Criteria) this;
        }

        public Criteria andGridscopeIn(List<String> values) {
            addCriterion("gridscope in", values, "gridscope");
            return (Criteria) this;
        }

        public Criteria andGridscopeNotIn(List<String> values) {
            addCriterion("gridscope not in", values, "gridscope");
            return (Criteria) this;
        }

        public Criteria andGridscopeBetween(String value1, String value2) {
            addCriterion("gridscope between", value1, value2, "gridscope");
            return (Criteria) this;
        }

        public Criteria andGridscopeNotBetween(String value1, String value2) {
            addCriterion("gridscope not between", value1, value2, "gridscope");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }
    }

    /**
     * stability的映射实体
     */
    public static class Criteria extends BaseCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * stability的动态SQL对象.
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}