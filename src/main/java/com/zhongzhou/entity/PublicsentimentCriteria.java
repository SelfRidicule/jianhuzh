/* https://github.com/orange1438 */
package com.zhongzhou.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438
 * date:2020/05/12 10:39
 */
public class PublicsentimentCriteria {
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
    public PublicsentimentCriteria() {
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
     * publicsentiment
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

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
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

        public Criteria andCodenumIsNull() {
            addCriterion("codenum is null");
            return (Criteria) this;
        }

        public Criteria andCodenumIsNotNull() {
            addCriterion("codenum is not null");
            return (Criteria) this;
        }

        public Criteria andCodenumEqualTo(String value) {
            addCriterion("codenum =", value, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumNotEqualTo(String value) {
            addCriterion("codenum <>", value, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumGreaterThan(String value) {
            addCriterion("codenum >", value, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumGreaterThanOrEqualTo(String value) {
            addCriterion("codenum >=", value, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumLessThan(String value) {
            addCriterion("codenum <", value, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumLessThanOrEqualTo(String value) {
            addCriterion("codenum <=", value, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumLike(String value) {
            addCriterion("codenum like", value, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumNotLike(String value) {
            addCriterion("codenum not like", value, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumIn(List<String> values) {
            addCriterion("codenum in", values, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumNotIn(List<String> values) {
            addCriterion("codenum not in", values, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumBetween(String value1, String value2) {
            addCriterion("codenum between", value1, value2, "codenum");
            return (Criteria) this;
        }

        public Criteria andCodenumNotBetween(String value1, String value2) {
            addCriterion("codenum not between", value1, value2, "codenum");
            return (Criteria) this;
        }

        public Criteria andHostpositionIsNull() {
            addCriterion("hostposition is null");
            return (Criteria) this;
        }

        public Criteria andHostpositionIsNotNull() {
            addCriterion("hostposition is not null");
            return (Criteria) this;
        }

        public Criteria andHostpositionEqualTo(String value) {
            addCriterion("hostposition =", value, "hostposition");
            return (Criteria) this;
        }

        public Criteria andHostpositionNotEqualTo(String value) {
            addCriterion("hostposition <>", value, "hostposition");
            return (Criteria) this;
        }

        public Criteria andHostpositionGreaterThan(String value) {
            addCriterion("hostposition >", value, "hostposition");
            return (Criteria) this;
        }

        public Criteria andHostpositionGreaterThanOrEqualTo(String value) {
            addCriterion("hostposition >=", value, "hostposition");
            return (Criteria) this;
        }

        public Criteria andHostpositionLessThan(String value) {
            addCriterion("hostposition <", value, "hostposition");
            return (Criteria) this;
        }

        public Criteria andHostpositionLessThanOrEqualTo(String value) {
            addCriterion("hostposition <=", value, "hostposition");
            return (Criteria) this;
        }

        public Criteria andHostpositionLike(String value) {
            addCriterion("hostposition like", value, "hostposition");
            return (Criteria) this;
        }

        public Criteria andHostpositionNotLike(String value) {
            addCriterion("hostposition not like", value, "hostposition");
            return (Criteria) this;
        }

        public Criteria andHostpositionIn(List<String> values) {
            addCriterion("hostposition in", values, "hostposition");
            return (Criteria) this;
        }

        public Criteria andHostpositionNotIn(List<String> values) {
            addCriterion("hostposition not in", values, "hostposition");
            return (Criteria) this;
        }

        public Criteria andHostpositionBetween(String value1, String value2) {
            addCriterion("hostposition between", value1, value2, "hostposition");
            return (Criteria) this;
        }

        public Criteria andHostpositionNotBetween(String value1, String value2) {
            addCriterion("hostposition not between", value1, value2, "hostposition");
            return (Criteria) this;
        }

        public Criteria andMediateaddressIsNull() {
            addCriterion("mediateaddress is null");
            return (Criteria) this;
        }

        public Criteria andMediateaddressIsNotNull() {
            addCriterion("mediateaddress is not null");
            return (Criteria) this;
        }

        public Criteria andMediateaddressEqualTo(String value) {
            addCriterion("mediateaddress =", value, "mediateaddress");
            return (Criteria) this;
        }

        public Criteria andMediateaddressNotEqualTo(String value) {
            addCriterion("mediateaddress <>", value, "mediateaddress");
            return (Criteria) this;
        }

        public Criteria andMediateaddressGreaterThan(String value) {
            addCriterion("mediateaddress >", value, "mediateaddress");
            return (Criteria) this;
        }

        public Criteria andMediateaddressGreaterThanOrEqualTo(String value) {
            addCriterion("mediateaddress >=", value, "mediateaddress");
            return (Criteria) this;
        }

        public Criteria andMediateaddressLessThan(String value) {
            addCriterion("mediateaddress <", value, "mediateaddress");
            return (Criteria) this;
        }

        public Criteria andMediateaddressLessThanOrEqualTo(String value) {
            addCriterion("mediateaddress <=", value, "mediateaddress");
            return (Criteria) this;
        }

        public Criteria andMediateaddressLike(String value) {
            addCriterion("mediateaddress like", value, "mediateaddress");
            return (Criteria) this;
        }

        public Criteria andMediateaddressNotLike(String value) {
            addCriterion("mediateaddress not like", value, "mediateaddress");
            return (Criteria) this;
        }

        public Criteria andMediateaddressIn(List<String> values) {
            addCriterion("mediateaddress in", values, "mediateaddress");
            return (Criteria) this;
        }

        public Criteria andMediateaddressNotIn(List<String> values) {
            addCriterion("mediateaddress not in", values, "mediateaddress");
            return (Criteria) this;
        }

        public Criteria andMediateaddressBetween(String value1, String value2) {
            addCriterion("mediateaddress between", value1, value2, "mediateaddress");
            return (Criteria) this;
        }

        public Criteria andMediateaddressNotBetween(String value1, String value2) {
            addCriterion("mediateaddress not between", value1, value2, "mediateaddress");
            return (Criteria) this;
        }

        public Criteria andMainmactsIsNull() {
            addCriterion("mainmacts is null");
            return (Criteria) this;
        }

        public Criteria andMainmactsIsNotNull() {
            addCriterion("mainmacts is not null");
            return (Criteria) this;
        }

        public Criteria andMainmactsEqualTo(String value) {
            addCriterion("mainmacts =", value, "mainmacts");
            return (Criteria) this;
        }

        public Criteria andMainmactsNotEqualTo(String value) {
            addCriterion("mainmacts <>", value, "mainmacts");
            return (Criteria) this;
        }

        public Criteria andMainmactsGreaterThan(String value) {
            addCriterion("mainmacts >", value, "mainmacts");
            return (Criteria) this;
        }

        public Criteria andMainmactsGreaterThanOrEqualTo(String value) {
            addCriterion("mainmacts >=", value, "mainmacts");
            return (Criteria) this;
        }

        public Criteria andMainmactsLessThan(String value) {
            addCriterion("mainmacts <", value, "mainmacts");
            return (Criteria) this;
        }

        public Criteria andMainmactsLessThanOrEqualTo(String value) {
            addCriterion("mainmacts <=", value, "mainmacts");
            return (Criteria) this;
        }

        public Criteria andMainmactsLike(String value) {
            addCriterion("mainmacts like", value, "mainmacts");
            return (Criteria) this;
        }

        public Criteria andMainmactsNotLike(String value) {
            addCriterion("mainmacts not like", value, "mainmacts");
            return (Criteria) this;
        }

        public Criteria andMainmactsIn(List<String> values) {
            addCriterion("mainmacts in", values, "mainmacts");
            return (Criteria) this;
        }

        public Criteria andMainmactsNotIn(List<String> values) {
            addCriterion("mainmacts not in", values, "mainmacts");
            return (Criteria) this;
        }

        public Criteria andMainmactsBetween(String value1, String value2) {
            addCriterion("mainmacts between", value1, value2, "mainmacts");
            return (Criteria) this;
        }

        public Criteria andMainmactsNotBetween(String value1, String value2) {
            addCriterion("mainmacts not between", value1, value2, "mainmacts");
            return (Criteria) this;
        }

        public Criteria andAgreementIsNull() {
            addCriterion("agreement is null");
            return (Criteria) this;
        }

        public Criteria andAgreementIsNotNull() {
            addCriterion("agreement is not null");
            return (Criteria) this;
        }

        public Criteria andAgreementEqualTo(String value) {
            addCriterion("agreement =", value, "agreement");
            return (Criteria) this;
        }

        public Criteria andAgreementNotEqualTo(String value) {
            addCriterion("agreement <>", value, "agreement");
            return (Criteria) this;
        }

        public Criteria andAgreementGreaterThan(String value) {
            addCriterion("agreement >", value, "agreement");
            return (Criteria) this;
        }

        public Criteria andAgreementGreaterThanOrEqualTo(String value) {
            addCriterion("agreement >=", value, "agreement");
            return (Criteria) this;
        }

        public Criteria andAgreementLessThan(String value) {
            addCriterion("agreement <", value, "agreement");
            return (Criteria) this;
        }

        public Criteria andAgreementLessThanOrEqualTo(String value) {
            addCriterion("agreement <=", value, "agreement");
            return (Criteria) this;
        }

        public Criteria andAgreementLike(String value) {
            addCriterion("agreement like", value, "agreement");
            return (Criteria) this;
        }

        public Criteria andAgreementNotLike(String value) {
            addCriterion("agreement not like", value, "agreement");
            return (Criteria) this;
        }

        public Criteria andAgreementIn(List<String> values) {
            addCriterion("agreement in", values, "agreement");
            return (Criteria) this;
        }

        public Criteria andAgreementNotIn(List<String> values) {
            addCriterion("agreement not in", values, "agreement");
            return (Criteria) this;
        }

        public Criteria andAgreementBetween(String value1, String value2) {
            addCriterion("agreement between", value1, value2, "agreement");
            return (Criteria) this;
        }

        public Criteria andAgreementNotBetween(String value1, String value2) {
            addCriterion("agreement not between", value1, value2, "agreement");
            return (Criteria) this;
        }

        public Criteria andMediatedateIsNull() {
            addCriterion("mediatedate is null");
            return (Criteria) this;
        }

        public Criteria andMediatedateIsNotNull() {
            addCriterion("mediatedate is not null");
            return (Criteria) this;
        }

        public Criteria andMediatedateEqualTo(String value) {
            addCriterion("mediatedate =", value, "mediatedate");
            return (Criteria) this;
        }

        public Criteria andMediatedateNotEqualTo(String value) {
            addCriterion("mediatedate <>", value, "mediatedate");
            return (Criteria) this;
        }

        public Criteria andMediatedateGreaterThan(String value) {
            addCriterion("mediatedate >", value, "mediatedate");
            return (Criteria) this;
        }

        public Criteria andMediatedateGreaterThanOrEqualTo(String value) {
            addCriterion("mediatedate >=", value, "mediatedate");
            return (Criteria) this;
        }

        public Criteria andMediatedateLessThan(String value) {
            addCriterion("mediatedate <", value, "mediatedate");
            return (Criteria) this;
        }

        public Criteria andMediatedateLessThanOrEqualTo(String value) {
            addCriterion("mediatedate <=", value, "mediatedate");
            return (Criteria) this;
        }

        public Criteria andMediatedateLike(String value) {
            addCriterion("mediatedate like", value, "mediatedate");
            return (Criteria) this;
        }

        public Criteria andMediatedateNotLike(String value) {
            addCriterion("mediatedate not like", value, "mediatedate");
            return (Criteria) this;
        }

        public Criteria andMediatedateIn(List<String> values) {
            addCriterion("mediatedate in", values, "mediatedate");
            return (Criteria) this;
        }

        public Criteria andMediatedateNotIn(List<String> values) {
            addCriterion("mediatedate not in", values, "mediatedate");
            return (Criteria) this;
        }

        public Criteria andMediatedateBetween(String value1, String value2) {
            addCriterion("mediatedate between", value1, value2, "mediatedate");
            return (Criteria) this;
        }

        public Criteria andMediatedateNotBetween(String value1, String value2) {
            addCriterion("mediatedate not between", value1, value2, "mediatedate");
            return (Criteria) this;
        }

        public Criteria andOnehostnameIsNull() {
            addCriterion("onehostname is null");
            return (Criteria) this;
        }

        public Criteria andOnehostnameIsNotNull() {
            addCriterion("onehostname is not null");
            return (Criteria) this;
        }

        public Criteria andOnehostnameEqualTo(String value) {
            addCriterion("onehostname =", value, "onehostname");
            return (Criteria) this;
        }

        public Criteria andOnehostnameNotEqualTo(String value) {
            addCriterion("onehostname <>", value, "onehostname");
            return (Criteria) this;
        }

        public Criteria andOnehostnameGreaterThan(String value) {
            addCriterion("onehostname >", value, "onehostname");
            return (Criteria) this;
        }

        public Criteria andOnehostnameGreaterThanOrEqualTo(String value) {
            addCriterion("onehostname >=", value, "onehostname");
            return (Criteria) this;
        }

        public Criteria andOnehostnameLessThan(String value) {
            addCriterion("onehostname <", value, "onehostname");
            return (Criteria) this;
        }

        public Criteria andOnehostnameLessThanOrEqualTo(String value) {
            addCriterion("onehostname <=", value, "onehostname");
            return (Criteria) this;
        }

        public Criteria andOnehostnameLike(String value) {
            addCriterion("onehostname like", value, "onehostname");
            return (Criteria) this;
        }

        public Criteria andOnehostnameNotLike(String value) {
            addCriterion("onehostname not like", value, "onehostname");
            return (Criteria) this;
        }

        public Criteria andOnehostnameIn(List<String> values) {
            addCriterion("onehostname in", values, "onehostname");
            return (Criteria) this;
        }

        public Criteria andOnehostnameNotIn(List<String> values) {
            addCriterion("onehostname not in", values, "onehostname");
            return (Criteria) this;
        }

        public Criteria andOnehostnameBetween(String value1, String value2) {
            addCriterion("onehostname between", value1, value2, "onehostname");
            return (Criteria) this;
        }

        public Criteria andOnehostnameNotBetween(String value1, String value2) {
            addCriterion("onehostname not between", value1, value2, "onehostname");
            return (Criteria) this;
        }

        public Criteria andTwohostnameIsNull() {
            addCriterion("twohostname is null");
            return (Criteria) this;
        }

        public Criteria andTwohostnameIsNotNull() {
            addCriterion("twohostname is not null");
            return (Criteria) this;
        }

        public Criteria andTwohostnameEqualTo(String value) {
            addCriterion("twohostname =", value, "twohostname");
            return (Criteria) this;
        }

        public Criteria andTwohostnameNotEqualTo(String value) {
            addCriterion("twohostname <>", value, "twohostname");
            return (Criteria) this;
        }

        public Criteria andTwohostnameGreaterThan(String value) {
            addCriterion("twohostname >", value, "twohostname");
            return (Criteria) this;
        }

        public Criteria andTwohostnameGreaterThanOrEqualTo(String value) {
            addCriterion("twohostname >=", value, "twohostname");
            return (Criteria) this;
        }

        public Criteria andTwohostnameLessThan(String value) {
            addCriterion("twohostname <", value, "twohostname");
            return (Criteria) this;
        }

        public Criteria andTwohostnameLessThanOrEqualTo(String value) {
            addCriterion("twohostname <=", value, "twohostname");
            return (Criteria) this;
        }

        public Criteria andTwohostnameLike(String value) {
            addCriterion("twohostname like", value, "twohostname");
            return (Criteria) this;
        }

        public Criteria andTwohostnameNotLike(String value) {
            addCriterion("twohostname not like", value, "twohostname");
            return (Criteria) this;
        }

        public Criteria andTwohostnameIn(List<String> values) {
            addCriterion("twohostname in", values, "twohostname");
            return (Criteria) this;
        }

        public Criteria andTwohostnameNotIn(List<String> values) {
            addCriterion("twohostname not in", values, "twohostname");
            return (Criteria) this;
        }

        public Criteria andTwohostnameBetween(String value1, String value2) {
            addCriterion("twohostname between", value1, value2, "twohostname");
            return (Criteria) this;
        }

        public Criteria andTwohostnameNotBetween(String value1, String value2) {
            addCriterion("twohostname not between", value1, value2, "twohostname");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnameIsNull() {
            addCriterion("onecurrentname is null");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnameIsNotNull() {
            addCriterion("onecurrentname is not null");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnameEqualTo(String value) {
            addCriterion("onecurrentname =", value, "onecurrentname");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnameNotEqualTo(String value) {
            addCriterion("onecurrentname <>", value, "onecurrentname");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnameGreaterThan(String value) {
            addCriterion("onecurrentname >", value, "onecurrentname");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnameGreaterThanOrEqualTo(String value) {
            addCriterion("onecurrentname >=", value, "onecurrentname");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnameLessThan(String value) {
            addCriterion("onecurrentname <", value, "onecurrentname");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnameLessThanOrEqualTo(String value) {
            addCriterion("onecurrentname <=", value, "onecurrentname");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnameLike(String value) {
            addCriterion("onecurrentname like", value, "onecurrentname");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnameNotLike(String value) {
            addCriterion("onecurrentname not like", value, "onecurrentname");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnameIn(List<String> values) {
            addCriterion("onecurrentname in", values, "onecurrentname");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnameNotIn(List<String> values) {
            addCriterion("onecurrentname not in", values, "onecurrentname");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnameBetween(String value1, String value2) {
            addCriterion("onecurrentname between", value1, value2, "onecurrentname");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnameNotBetween(String value1, String value2) {
            addCriterion("onecurrentname not between", value1, value2, "onecurrentname");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnameIsNull() {
            addCriterion("twocurrentname is null");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnameIsNotNull() {
            addCriterion("twocurrentname is not null");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnameEqualTo(String value) {
            addCriterion("twocurrentname =", value, "twocurrentname");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnameNotEqualTo(String value) {
            addCriterion("twocurrentname <>", value, "twocurrentname");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnameGreaterThan(String value) {
            addCriterion("twocurrentname >", value, "twocurrentname");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnameGreaterThanOrEqualTo(String value) {
            addCriterion("twocurrentname >=", value, "twocurrentname");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnameLessThan(String value) {
            addCriterion("twocurrentname <", value, "twocurrentname");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnameLessThanOrEqualTo(String value) {
            addCriterion("twocurrentname <=", value, "twocurrentname");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnameLike(String value) {
            addCriterion("twocurrentname like", value, "twocurrentname");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnameNotLike(String value) {
            addCriterion("twocurrentname not like", value, "twocurrentname");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnameIn(List<String> values) {
            addCriterion("twocurrentname in", values, "twocurrentname");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnameNotIn(List<String> values) {
            addCriterion("twocurrentname not in", values, "twocurrentname");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnameBetween(String value1, String value2) {
            addCriterion("twocurrentname between", value1, value2, "twocurrentname");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnameNotBetween(String value1, String value2) {
            addCriterion("twocurrentname not between", value1, value2, "twocurrentname");
            return (Criteria) this;
        }

        public Criteria andOnecurrentsexIsNull() {
            addCriterion("onecurrentsex is null");
            return (Criteria) this;
        }

        public Criteria andOnecurrentsexIsNotNull() {
            addCriterion("onecurrentsex is not null");
            return (Criteria) this;
        }

        public Criteria andOnecurrentsexEqualTo(String value) {
            addCriterion("onecurrentsex =", value, "onecurrentsex");
            return (Criteria) this;
        }

        public Criteria andOnecurrentsexNotEqualTo(String value) {
            addCriterion("onecurrentsex <>", value, "onecurrentsex");
            return (Criteria) this;
        }

        public Criteria andOnecurrentsexGreaterThan(String value) {
            addCriterion("onecurrentsex >", value, "onecurrentsex");
            return (Criteria) this;
        }

        public Criteria andOnecurrentsexGreaterThanOrEqualTo(String value) {
            addCriterion("onecurrentsex >=", value, "onecurrentsex");
            return (Criteria) this;
        }

        public Criteria andOnecurrentsexLessThan(String value) {
            addCriterion("onecurrentsex <", value, "onecurrentsex");
            return (Criteria) this;
        }

        public Criteria andOnecurrentsexLessThanOrEqualTo(String value) {
            addCriterion("onecurrentsex <=", value, "onecurrentsex");
            return (Criteria) this;
        }

        public Criteria andOnecurrentsexLike(String value) {
            addCriterion("onecurrentsex like", value, "onecurrentsex");
            return (Criteria) this;
        }

        public Criteria andOnecurrentsexNotLike(String value) {
            addCriterion("onecurrentsex not like", value, "onecurrentsex");
            return (Criteria) this;
        }

        public Criteria andOnecurrentsexIn(List<String> values) {
            addCriterion("onecurrentsex in", values, "onecurrentsex");
            return (Criteria) this;
        }

        public Criteria andOnecurrentsexNotIn(List<String> values) {
            addCriterion("onecurrentsex not in", values, "onecurrentsex");
            return (Criteria) this;
        }

        public Criteria andOnecurrentsexBetween(String value1, String value2) {
            addCriterion("onecurrentsex between", value1, value2, "onecurrentsex");
            return (Criteria) this;
        }

        public Criteria andOnecurrentsexNotBetween(String value1, String value2) {
            addCriterion("onecurrentsex not between", value1, value2, "onecurrentsex");
            return (Criteria) this;
        }

        public Criteria andTwocurrentsexIsNull() {
            addCriterion("twocurrentsex is null");
            return (Criteria) this;
        }

        public Criteria andTwocurrentsexIsNotNull() {
            addCriterion("twocurrentsex is not null");
            return (Criteria) this;
        }

        public Criteria andTwocurrentsexEqualTo(String value) {
            addCriterion("twocurrentsex =", value, "twocurrentsex");
            return (Criteria) this;
        }

        public Criteria andTwocurrentsexNotEqualTo(String value) {
            addCriterion("twocurrentsex <>", value, "twocurrentsex");
            return (Criteria) this;
        }

        public Criteria andTwocurrentsexGreaterThan(String value) {
            addCriterion("twocurrentsex >", value, "twocurrentsex");
            return (Criteria) this;
        }

        public Criteria andTwocurrentsexGreaterThanOrEqualTo(String value) {
            addCriterion("twocurrentsex >=", value, "twocurrentsex");
            return (Criteria) this;
        }

        public Criteria andTwocurrentsexLessThan(String value) {
            addCriterion("twocurrentsex <", value, "twocurrentsex");
            return (Criteria) this;
        }

        public Criteria andTwocurrentsexLessThanOrEqualTo(String value) {
            addCriterion("twocurrentsex <=", value, "twocurrentsex");
            return (Criteria) this;
        }

        public Criteria andTwocurrentsexLike(String value) {
            addCriterion("twocurrentsex like", value, "twocurrentsex");
            return (Criteria) this;
        }

        public Criteria andTwocurrentsexNotLike(String value) {
            addCriterion("twocurrentsex not like", value, "twocurrentsex");
            return (Criteria) this;
        }

        public Criteria andTwocurrentsexIn(List<String> values) {
            addCriterion("twocurrentsex in", values, "twocurrentsex");
            return (Criteria) this;
        }

        public Criteria andTwocurrentsexNotIn(List<String> values) {
            addCriterion("twocurrentsex not in", values, "twocurrentsex");
            return (Criteria) this;
        }

        public Criteria andTwocurrentsexBetween(String value1, String value2) {
            addCriterion("twocurrentsex between", value1, value2, "twocurrentsex");
            return (Criteria) this;
        }

        public Criteria andTwocurrentsexNotBetween(String value1, String value2) {
            addCriterion("twocurrentsex not between", value1, value2, "twocurrentsex");
            return (Criteria) this;
        }

        public Criteria andOnecurrentageIsNull() {
            addCriterion("onecurrentage is null");
            return (Criteria) this;
        }

        public Criteria andOnecurrentageIsNotNull() {
            addCriterion("onecurrentage is not null");
            return (Criteria) this;
        }

        public Criteria andOnecurrentageEqualTo(String value) {
            addCriterion("onecurrentage =", value, "onecurrentage");
            return (Criteria) this;
        }

        public Criteria andOnecurrentageNotEqualTo(String value) {
            addCriterion("onecurrentage <>", value, "onecurrentage");
            return (Criteria) this;
        }

        public Criteria andOnecurrentageGreaterThan(String value) {
            addCriterion("onecurrentage >", value, "onecurrentage");
            return (Criteria) this;
        }

        public Criteria andOnecurrentageGreaterThanOrEqualTo(String value) {
            addCriterion("onecurrentage >=", value, "onecurrentage");
            return (Criteria) this;
        }

        public Criteria andOnecurrentageLessThan(String value) {
            addCriterion("onecurrentage <", value, "onecurrentage");
            return (Criteria) this;
        }

        public Criteria andOnecurrentageLessThanOrEqualTo(String value) {
            addCriterion("onecurrentage <=", value, "onecurrentage");
            return (Criteria) this;
        }

        public Criteria andOnecurrentageLike(String value) {
            addCriterion("onecurrentage like", value, "onecurrentage");
            return (Criteria) this;
        }

        public Criteria andOnecurrentageNotLike(String value) {
            addCriterion("onecurrentage not like", value, "onecurrentage");
            return (Criteria) this;
        }

        public Criteria andOnecurrentageIn(List<String> values) {
            addCriterion("onecurrentage in", values, "onecurrentage");
            return (Criteria) this;
        }

        public Criteria andOnecurrentageNotIn(List<String> values) {
            addCriterion("onecurrentage not in", values, "onecurrentage");
            return (Criteria) this;
        }

        public Criteria andOnecurrentageBetween(String value1, String value2) {
            addCriterion("onecurrentage between", value1, value2, "onecurrentage");
            return (Criteria) this;
        }

        public Criteria andOnecurrentageNotBetween(String value1, String value2) {
            addCriterion("onecurrentage not between", value1, value2, "onecurrentage");
            return (Criteria) this;
        }

        public Criteria andTwocurrentageIsNull() {
            addCriterion("twocurrentage is null");
            return (Criteria) this;
        }

        public Criteria andTwocurrentageIsNotNull() {
            addCriterion("twocurrentage is not null");
            return (Criteria) this;
        }

        public Criteria andTwocurrentageEqualTo(String value) {
            addCriterion("twocurrentage =", value, "twocurrentage");
            return (Criteria) this;
        }

        public Criteria andTwocurrentageNotEqualTo(String value) {
            addCriterion("twocurrentage <>", value, "twocurrentage");
            return (Criteria) this;
        }

        public Criteria andTwocurrentageGreaterThan(String value) {
            addCriterion("twocurrentage >", value, "twocurrentage");
            return (Criteria) this;
        }

        public Criteria andTwocurrentageGreaterThanOrEqualTo(String value) {
            addCriterion("twocurrentage >=", value, "twocurrentage");
            return (Criteria) this;
        }

        public Criteria andTwocurrentageLessThan(String value) {
            addCriterion("twocurrentage <", value, "twocurrentage");
            return (Criteria) this;
        }

        public Criteria andTwocurrentageLessThanOrEqualTo(String value) {
            addCriterion("twocurrentage <=", value, "twocurrentage");
            return (Criteria) this;
        }

        public Criteria andTwocurrentageLike(String value) {
            addCriterion("twocurrentage like", value, "twocurrentage");
            return (Criteria) this;
        }

        public Criteria andTwocurrentageNotLike(String value) {
            addCriterion("twocurrentage not like", value, "twocurrentage");
            return (Criteria) this;
        }

        public Criteria andTwocurrentageIn(List<String> values) {
            addCriterion("twocurrentage in", values, "twocurrentage");
            return (Criteria) this;
        }

        public Criteria andTwocurrentageNotIn(List<String> values) {
            addCriterion("twocurrentage not in", values, "twocurrentage");
            return (Criteria) this;
        }

        public Criteria andTwocurrentageBetween(String value1, String value2) {
            addCriterion("twocurrentage between", value1, value2, "twocurrentage");
            return (Criteria) this;
        }

        public Criteria andTwocurrentageNotBetween(String value1, String value2) {
            addCriterion("twocurrentage not between", value1, value2, "twocurrentage");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnationIsNull() {
            addCriterion("onecurrentnation is null");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnationIsNotNull() {
            addCriterion("onecurrentnation is not null");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnationEqualTo(String value) {
            addCriterion("onecurrentnation =", value, "onecurrentnation");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnationNotEqualTo(String value) {
            addCriterion("onecurrentnation <>", value, "onecurrentnation");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnationGreaterThan(String value) {
            addCriterion("onecurrentnation >", value, "onecurrentnation");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnationGreaterThanOrEqualTo(String value) {
            addCriterion("onecurrentnation >=", value, "onecurrentnation");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnationLessThan(String value) {
            addCriterion("onecurrentnation <", value, "onecurrentnation");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnationLessThanOrEqualTo(String value) {
            addCriterion("onecurrentnation <=", value, "onecurrentnation");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnationLike(String value) {
            addCriterion("onecurrentnation like", value, "onecurrentnation");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnationNotLike(String value) {
            addCriterion("onecurrentnation not like", value, "onecurrentnation");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnationIn(List<String> values) {
            addCriterion("onecurrentnation in", values, "onecurrentnation");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnationNotIn(List<String> values) {
            addCriterion("onecurrentnation not in", values, "onecurrentnation");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnationBetween(String value1, String value2) {
            addCriterion("onecurrentnation between", value1, value2, "onecurrentnation");
            return (Criteria) this;
        }

        public Criteria andOnecurrentnationNotBetween(String value1, String value2) {
            addCriterion("onecurrentnation not between", value1, value2, "onecurrentnation");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnationIsNull() {
            addCriterion("twocurrentnation is null");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnationIsNotNull() {
            addCriterion("twocurrentnation is not null");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnationEqualTo(String value) {
            addCriterion("twocurrentnation =", value, "twocurrentnation");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnationNotEqualTo(String value) {
            addCriterion("twocurrentnation <>", value, "twocurrentnation");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnationGreaterThan(String value) {
            addCriterion("twocurrentnation >", value, "twocurrentnation");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnationGreaterThanOrEqualTo(String value) {
            addCriterion("twocurrentnation >=", value, "twocurrentnation");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnationLessThan(String value) {
            addCriterion("twocurrentnation <", value, "twocurrentnation");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnationLessThanOrEqualTo(String value) {
            addCriterion("twocurrentnation <=", value, "twocurrentnation");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnationLike(String value) {
            addCriterion("twocurrentnation like", value, "twocurrentnation");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnationNotLike(String value) {
            addCriterion("twocurrentnation not like", value, "twocurrentnation");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnationIn(List<String> values) {
            addCriterion("twocurrentnation in", values, "twocurrentnation");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnationNotIn(List<String> values) {
            addCriterion("twocurrentnation not in", values, "twocurrentnation");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnationBetween(String value1, String value2) {
            addCriterion("twocurrentnation between", value1, value2, "twocurrentnation");
            return (Criteria) this;
        }

        public Criteria andTwocurrentnationNotBetween(String value1, String value2) {
            addCriterion("twocurrentnation not between", value1, value2, "twocurrentnation");
            return (Criteria) this;
        }

        public Criteria andOnecurrentbirthdateIsNull() {
            addCriterion("onecurrentbirthdate is null");
            return (Criteria) this;
        }

        public Criteria andOnecurrentbirthdateIsNotNull() {
            addCriterion("onecurrentbirthdate is not null");
            return (Criteria) this;
        }

        public Criteria andOnecurrentbirthdateEqualTo(String value) {
            addCriterion("onecurrentbirthdate =", value, "onecurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andOnecurrentbirthdateNotEqualTo(String value) {
            addCriterion("onecurrentbirthdate <>", value, "onecurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andOnecurrentbirthdateGreaterThan(String value) {
            addCriterion("onecurrentbirthdate >", value, "onecurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andOnecurrentbirthdateGreaterThanOrEqualTo(String value) {
            addCriterion("onecurrentbirthdate >=", value, "onecurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andOnecurrentbirthdateLessThan(String value) {
            addCriterion("onecurrentbirthdate <", value, "onecurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andOnecurrentbirthdateLessThanOrEqualTo(String value) {
            addCriterion("onecurrentbirthdate <=", value, "onecurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andOnecurrentbirthdateLike(String value) {
            addCriterion("onecurrentbirthdate like", value, "onecurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andOnecurrentbirthdateNotLike(String value) {
            addCriterion("onecurrentbirthdate not like", value, "onecurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andOnecurrentbirthdateIn(List<String> values) {
            addCriterion("onecurrentbirthdate in", values, "onecurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andOnecurrentbirthdateNotIn(List<String> values) {
            addCriterion("onecurrentbirthdate not in", values, "onecurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andOnecurrentbirthdateBetween(String value1, String value2) {
            addCriterion("onecurrentbirthdate between", value1, value2, "onecurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andOnecurrentbirthdateNotBetween(String value1, String value2) {
            addCriterion("onecurrentbirthdate not between", value1, value2, "onecurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andTwocurrentbirthdateIsNull() {
            addCriterion("twocurrentbirthdate is null");
            return (Criteria) this;
        }

        public Criteria andTwocurrentbirthdateIsNotNull() {
            addCriterion("twocurrentbirthdate is not null");
            return (Criteria) this;
        }

        public Criteria andTwocurrentbirthdateEqualTo(String value) {
            addCriterion("twocurrentbirthdate =", value, "twocurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andTwocurrentbirthdateNotEqualTo(String value) {
            addCriterion("twocurrentbirthdate <>", value, "twocurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andTwocurrentbirthdateGreaterThan(String value) {
            addCriterion("twocurrentbirthdate >", value, "twocurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andTwocurrentbirthdateGreaterThanOrEqualTo(String value) {
            addCriterion("twocurrentbirthdate >=", value, "twocurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andTwocurrentbirthdateLessThan(String value) {
            addCriterion("twocurrentbirthdate <", value, "twocurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andTwocurrentbirthdateLessThanOrEqualTo(String value) {
            addCriterion("twocurrentbirthdate <=", value, "twocurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andTwocurrentbirthdateLike(String value) {
            addCriterion("twocurrentbirthdate like", value, "twocurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andTwocurrentbirthdateNotLike(String value) {
            addCriterion("twocurrentbirthdate not like", value, "twocurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andTwocurrentbirthdateIn(List<String> values) {
            addCriterion("twocurrentbirthdate in", values, "twocurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andTwocurrentbirthdateNotIn(List<String> values) {
            addCriterion("twocurrentbirthdate not in", values, "twocurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andTwocurrentbirthdateBetween(String value1, String value2) {
            addCriterion("twocurrentbirthdate between", value1, value2, "twocurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andTwocurrentbirthdateNotBetween(String value1, String value2) {
            addCriterion("twocurrentbirthdate not between", value1, value2, "twocurrentbirthdate");
            return (Criteria) this;
        }

        public Criteria andOnecurrentidcardIsNull() {
            addCriterion("onecurrentidcard is null");
            return (Criteria) this;
        }

        public Criteria andOnecurrentidcardIsNotNull() {
            addCriterion("onecurrentidcard is not null");
            return (Criteria) this;
        }

        public Criteria andOnecurrentidcardEqualTo(String value) {
            addCriterion("onecurrentidcard =", value, "onecurrentidcard");
            return (Criteria) this;
        }

        public Criteria andOnecurrentidcardNotEqualTo(String value) {
            addCriterion("onecurrentidcard <>", value, "onecurrentidcard");
            return (Criteria) this;
        }

        public Criteria andOnecurrentidcardGreaterThan(String value) {
            addCriterion("onecurrentidcard >", value, "onecurrentidcard");
            return (Criteria) this;
        }

        public Criteria andOnecurrentidcardGreaterThanOrEqualTo(String value) {
            addCriterion("onecurrentidcard >=", value, "onecurrentidcard");
            return (Criteria) this;
        }

        public Criteria andOnecurrentidcardLessThan(String value) {
            addCriterion("onecurrentidcard <", value, "onecurrentidcard");
            return (Criteria) this;
        }

        public Criteria andOnecurrentidcardLessThanOrEqualTo(String value) {
            addCriterion("onecurrentidcard <=", value, "onecurrentidcard");
            return (Criteria) this;
        }

        public Criteria andOnecurrentidcardLike(String value) {
            addCriterion("onecurrentidcard like", value, "onecurrentidcard");
            return (Criteria) this;
        }

        public Criteria andOnecurrentidcardNotLike(String value) {
            addCriterion("onecurrentidcard not like", value, "onecurrentidcard");
            return (Criteria) this;
        }

        public Criteria andOnecurrentidcardIn(List<String> values) {
            addCriterion("onecurrentidcard in", values, "onecurrentidcard");
            return (Criteria) this;
        }

        public Criteria andOnecurrentidcardNotIn(List<String> values) {
            addCriterion("onecurrentidcard not in", values, "onecurrentidcard");
            return (Criteria) this;
        }

        public Criteria andOnecurrentidcardBetween(String value1, String value2) {
            addCriterion("onecurrentidcard between", value1, value2, "onecurrentidcard");
            return (Criteria) this;
        }

        public Criteria andOnecurrentidcardNotBetween(String value1, String value2) {
            addCriterion("onecurrentidcard not between", value1, value2, "onecurrentidcard");
            return (Criteria) this;
        }

        public Criteria andTwocurrentidcardIsNull() {
            addCriterion("twocurrentidcard is null");
            return (Criteria) this;
        }

        public Criteria andTwocurrentidcardIsNotNull() {
            addCriterion("twocurrentidcard is not null");
            return (Criteria) this;
        }

        public Criteria andTwocurrentidcardEqualTo(String value) {
            addCriterion("twocurrentidcard =", value, "twocurrentidcard");
            return (Criteria) this;
        }

        public Criteria andTwocurrentidcardNotEqualTo(String value) {
            addCriterion("twocurrentidcard <>", value, "twocurrentidcard");
            return (Criteria) this;
        }

        public Criteria andTwocurrentidcardGreaterThan(String value) {
            addCriterion("twocurrentidcard >", value, "twocurrentidcard");
            return (Criteria) this;
        }

        public Criteria andTwocurrentidcardGreaterThanOrEqualTo(String value) {
            addCriterion("twocurrentidcard >=", value, "twocurrentidcard");
            return (Criteria) this;
        }

        public Criteria andTwocurrentidcardLessThan(String value) {
            addCriterion("twocurrentidcard <", value, "twocurrentidcard");
            return (Criteria) this;
        }

        public Criteria andTwocurrentidcardLessThanOrEqualTo(String value) {
            addCriterion("twocurrentidcard <=", value, "twocurrentidcard");
            return (Criteria) this;
        }

        public Criteria andTwocurrentidcardLike(String value) {
            addCriterion("twocurrentidcard like", value, "twocurrentidcard");
            return (Criteria) this;
        }

        public Criteria andTwocurrentidcardNotLike(String value) {
            addCriterion("twocurrentidcard not like", value, "twocurrentidcard");
            return (Criteria) this;
        }

        public Criteria andTwocurrentidcardIn(List<String> values) {
            addCriterion("twocurrentidcard in", values, "twocurrentidcard");
            return (Criteria) this;
        }

        public Criteria andTwocurrentidcardNotIn(List<String> values) {
            addCriterion("twocurrentidcard not in", values, "twocurrentidcard");
            return (Criteria) this;
        }

        public Criteria andTwocurrentidcardBetween(String value1, String value2) {
            addCriterion("twocurrentidcard between", value1, value2, "twocurrentidcard");
            return (Criteria) this;
        }

        public Criteria andTwocurrentidcardNotBetween(String value1, String value2) {
            addCriterion("twocurrentidcard not between", value1, value2, "twocurrentidcard");
            return (Criteria) this;
        }

        public Criteria andOnecurrentcompanyIsNull() {
            addCriterion("onecurrentcompany is null");
            return (Criteria) this;
        }

        public Criteria andOnecurrentcompanyIsNotNull() {
            addCriterion("onecurrentcompany is not null");
            return (Criteria) this;
        }

        public Criteria andOnecurrentcompanyEqualTo(String value) {
            addCriterion("onecurrentcompany =", value, "onecurrentcompany");
            return (Criteria) this;
        }

        public Criteria andOnecurrentcompanyNotEqualTo(String value) {
            addCriterion("onecurrentcompany <>", value, "onecurrentcompany");
            return (Criteria) this;
        }

        public Criteria andOnecurrentcompanyGreaterThan(String value) {
            addCriterion("onecurrentcompany >", value, "onecurrentcompany");
            return (Criteria) this;
        }

        public Criteria andOnecurrentcompanyGreaterThanOrEqualTo(String value) {
            addCriterion("onecurrentcompany >=", value, "onecurrentcompany");
            return (Criteria) this;
        }

        public Criteria andOnecurrentcompanyLessThan(String value) {
            addCriterion("onecurrentcompany <", value, "onecurrentcompany");
            return (Criteria) this;
        }

        public Criteria andOnecurrentcompanyLessThanOrEqualTo(String value) {
            addCriterion("onecurrentcompany <=", value, "onecurrentcompany");
            return (Criteria) this;
        }

        public Criteria andOnecurrentcompanyLike(String value) {
            addCriterion("onecurrentcompany like", value, "onecurrentcompany");
            return (Criteria) this;
        }

        public Criteria andOnecurrentcompanyNotLike(String value) {
            addCriterion("onecurrentcompany not like", value, "onecurrentcompany");
            return (Criteria) this;
        }

        public Criteria andOnecurrentcompanyIn(List<String> values) {
            addCriterion("onecurrentcompany in", values, "onecurrentcompany");
            return (Criteria) this;
        }

        public Criteria andOnecurrentcompanyNotIn(List<String> values) {
            addCriterion("onecurrentcompany not in", values, "onecurrentcompany");
            return (Criteria) this;
        }

        public Criteria andOnecurrentcompanyBetween(String value1, String value2) {
            addCriterion("onecurrentcompany between", value1, value2, "onecurrentcompany");
            return (Criteria) this;
        }

        public Criteria andOnecurrentcompanyNotBetween(String value1, String value2) {
            addCriterion("onecurrentcompany not between", value1, value2, "onecurrentcompany");
            return (Criteria) this;
        }

        public Criteria andTwocurrentcompanyIsNull() {
            addCriterion("twocurrentcompany is null");
            return (Criteria) this;
        }

        public Criteria andTwocurrentcompanyIsNotNull() {
            addCriterion("twocurrentcompany is not null");
            return (Criteria) this;
        }

        public Criteria andTwocurrentcompanyEqualTo(String value) {
            addCriterion("twocurrentcompany =", value, "twocurrentcompany");
            return (Criteria) this;
        }

        public Criteria andTwocurrentcompanyNotEqualTo(String value) {
            addCriterion("twocurrentcompany <>", value, "twocurrentcompany");
            return (Criteria) this;
        }

        public Criteria andTwocurrentcompanyGreaterThan(String value) {
            addCriterion("twocurrentcompany >", value, "twocurrentcompany");
            return (Criteria) this;
        }

        public Criteria andTwocurrentcompanyGreaterThanOrEqualTo(String value) {
            addCriterion("twocurrentcompany >=", value, "twocurrentcompany");
            return (Criteria) this;
        }

        public Criteria andTwocurrentcompanyLessThan(String value) {
            addCriterion("twocurrentcompany <", value, "twocurrentcompany");
            return (Criteria) this;
        }

        public Criteria andTwocurrentcompanyLessThanOrEqualTo(String value) {
            addCriterion("twocurrentcompany <=", value, "twocurrentcompany");
            return (Criteria) this;
        }

        public Criteria andTwocurrentcompanyLike(String value) {
            addCriterion("twocurrentcompany like", value, "twocurrentcompany");
            return (Criteria) this;
        }

        public Criteria andTwocurrentcompanyNotLike(String value) {
            addCriterion("twocurrentcompany not like", value, "twocurrentcompany");
            return (Criteria) this;
        }

        public Criteria andTwocurrentcompanyIn(List<String> values) {
            addCriterion("twocurrentcompany in", values, "twocurrentcompany");
            return (Criteria) this;
        }

        public Criteria andTwocurrentcompanyNotIn(List<String> values) {
            addCriterion("twocurrentcompany not in", values, "twocurrentcompany");
            return (Criteria) this;
        }

        public Criteria andTwocurrentcompanyBetween(String value1, String value2) {
            addCriterion("twocurrentcompany between", value1, value2, "twocurrentcompany");
            return (Criteria) this;
        }

        public Criteria andTwocurrentcompanyNotBetween(String value1, String value2) {
            addCriterion("twocurrentcompany not between", value1, value2, "twocurrentcompany");
            return (Criteria) this;
        }

        public Criteria andOnecurrentpositionIsNull() {
            addCriterion("onecurrentposition is null");
            return (Criteria) this;
        }

        public Criteria andOnecurrentpositionIsNotNull() {
            addCriterion("onecurrentposition is not null");
            return (Criteria) this;
        }

        public Criteria andOnecurrentpositionEqualTo(String value) {
            addCriterion("onecurrentposition =", value, "onecurrentposition");
            return (Criteria) this;
        }

        public Criteria andOnecurrentpositionNotEqualTo(String value) {
            addCriterion("onecurrentposition <>", value, "onecurrentposition");
            return (Criteria) this;
        }

        public Criteria andOnecurrentpositionGreaterThan(String value) {
            addCriterion("onecurrentposition >", value, "onecurrentposition");
            return (Criteria) this;
        }

        public Criteria andOnecurrentpositionGreaterThanOrEqualTo(String value) {
            addCriterion("onecurrentposition >=", value, "onecurrentposition");
            return (Criteria) this;
        }

        public Criteria andOnecurrentpositionLessThan(String value) {
            addCriterion("onecurrentposition <", value, "onecurrentposition");
            return (Criteria) this;
        }

        public Criteria andOnecurrentpositionLessThanOrEqualTo(String value) {
            addCriterion("onecurrentposition <=", value, "onecurrentposition");
            return (Criteria) this;
        }

        public Criteria andOnecurrentpositionLike(String value) {
            addCriterion("onecurrentposition like", value, "onecurrentposition");
            return (Criteria) this;
        }

        public Criteria andOnecurrentpositionNotLike(String value) {
            addCriterion("onecurrentposition not like", value, "onecurrentposition");
            return (Criteria) this;
        }

        public Criteria andOnecurrentpositionIn(List<String> values) {
            addCriterion("onecurrentposition in", values, "onecurrentposition");
            return (Criteria) this;
        }

        public Criteria andOnecurrentpositionNotIn(List<String> values) {
            addCriterion("onecurrentposition not in", values, "onecurrentposition");
            return (Criteria) this;
        }

        public Criteria andOnecurrentpositionBetween(String value1, String value2) {
            addCriterion("onecurrentposition between", value1, value2, "onecurrentposition");
            return (Criteria) this;
        }

        public Criteria andOnecurrentpositionNotBetween(String value1, String value2) {
            addCriterion("onecurrentposition not between", value1, value2, "onecurrentposition");
            return (Criteria) this;
        }

        public Criteria andTwocurrentpositionIsNull() {
            addCriterion("twocurrentposition is null");
            return (Criteria) this;
        }

        public Criteria andTwocurrentpositionIsNotNull() {
            addCriterion("twocurrentposition is not null");
            return (Criteria) this;
        }

        public Criteria andTwocurrentpositionEqualTo(String value) {
            addCriterion("twocurrentposition =", value, "twocurrentposition");
            return (Criteria) this;
        }

        public Criteria andTwocurrentpositionNotEqualTo(String value) {
            addCriterion("twocurrentposition <>", value, "twocurrentposition");
            return (Criteria) this;
        }

        public Criteria andTwocurrentpositionGreaterThan(String value) {
            addCriterion("twocurrentposition >", value, "twocurrentposition");
            return (Criteria) this;
        }

        public Criteria andTwocurrentpositionGreaterThanOrEqualTo(String value) {
            addCriterion("twocurrentposition >=", value, "twocurrentposition");
            return (Criteria) this;
        }

        public Criteria andTwocurrentpositionLessThan(String value) {
            addCriterion("twocurrentposition <", value, "twocurrentposition");
            return (Criteria) this;
        }

        public Criteria andTwocurrentpositionLessThanOrEqualTo(String value) {
            addCriterion("twocurrentposition <=", value, "twocurrentposition");
            return (Criteria) this;
        }

        public Criteria andTwocurrentpositionLike(String value) {
            addCriterion("twocurrentposition like", value, "twocurrentposition");
            return (Criteria) this;
        }

        public Criteria andTwocurrentpositionNotLike(String value) {
            addCriterion("twocurrentposition not like", value, "twocurrentposition");
            return (Criteria) this;
        }

        public Criteria andTwocurrentpositionIn(List<String> values) {
            addCriterion("twocurrentposition in", values, "twocurrentposition");
            return (Criteria) this;
        }

        public Criteria andTwocurrentpositionNotIn(List<String> values) {
            addCriterion("twocurrentposition not in", values, "twocurrentposition");
            return (Criteria) this;
        }

        public Criteria andTwocurrentpositionBetween(String value1, String value2) {
            addCriterion("twocurrentposition between", value1, value2, "twocurrentposition");
            return (Criteria) this;
        }

        public Criteria andTwocurrentpositionNotBetween(String value1, String value2) {
            addCriterion("twocurrentposition not between", value1, value2, "twocurrentposition");
            return (Criteria) this;
        }

        public Criteria andOnecurrentfamilyIsNull() {
            addCriterion("onecurrentfamily is null");
            return (Criteria) this;
        }

        public Criteria andOnecurrentfamilyIsNotNull() {
            addCriterion("onecurrentfamily is not null");
            return (Criteria) this;
        }

        public Criteria andOnecurrentfamilyEqualTo(String value) {
            addCriterion("onecurrentfamily =", value, "onecurrentfamily");
            return (Criteria) this;
        }

        public Criteria andOnecurrentfamilyNotEqualTo(String value) {
            addCriterion("onecurrentfamily <>", value, "onecurrentfamily");
            return (Criteria) this;
        }

        public Criteria andOnecurrentfamilyGreaterThan(String value) {
            addCriterion("onecurrentfamily >", value, "onecurrentfamily");
            return (Criteria) this;
        }

        public Criteria andOnecurrentfamilyGreaterThanOrEqualTo(String value) {
            addCriterion("onecurrentfamily >=", value, "onecurrentfamily");
            return (Criteria) this;
        }

        public Criteria andOnecurrentfamilyLessThan(String value) {
            addCriterion("onecurrentfamily <", value, "onecurrentfamily");
            return (Criteria) this;
        }

        public Criteria andOnecurrentfamilyLessThanOrEqualTo(String value) {
            addCriterion("onecurrentfamily <=", value, "onecurrentfamily");
            return (Criteria) this;
        }

        public Criteria andOnecurrentfamilyLike(String value) {
            addCriterion("onecurrentfamily like", value, "onecurrentfamily");
            return (Criteria) this;
        }

        public Criteria andOnecurrentfamilyNotLike(String value) {
            addCriterion("onecurrentfamily not like", value, "onecurrentfamily");
            return (Criteria) this;
        }

        public Criteria andOnecurrentfamilyIn(List<String> values) {
            addCriterion("onecurrentfamily in", values, "onecurrentfamily");
            return (Criteria) this;
        }

        public Criteria andOnecurrentfamilyNotIn(List<String> values) {
            addCriterion("onecurrentfamily not in", values, "onecurrentfamily");
            return (Criteria) this;
        }

        public Criteria andOnecurrentfamilyBetween(String value1, String value2) {
            addCriterion("onecurrentfamily between", value1, value2, "onecurrentfamily");
            return (Criteria) this;
        }

        public Criteria andOnecurrentfamilyNotBetween(String value1, String value2) {
            addCriterion("onecurrentfamily not between", value1, value2, "onecurrentfamily");
            return (Criteria) this;
        }

        public Criteria andTwocurrentfamilyIsNull() {
            addCriterion("twocurrentfamily is null");
            return (Criteria) this;
        }

        public Criteria andTwocurrentfamilyIsNotNull() {
            addCriterion("twocurrentfamily is not null");
            return (Criteria) this;
        }

        public Criteria andTwocurrentfamilyEqualTo(String value) {
            addCriterion("twocurrentfamily =", value, "twocurrentfamily");
            return (Criteria) this;
        }

        public Criteria andTwocurrentfamilyNotEqualTo(String value) {
            addCriterion("twocurrentfamily <>", value, "twocurrentfamily");
            return (Criteria) this;
        }

        public Criteria andTwocurrentfamilyGreaterThan(String value) {
            addCriterion("twocurrentfamily >", value, "twocurrentfamily");
            return (Criteria) this;
        }

        public Criteria andTwocurrentfamilyGreaterThanOrEqualTo(String value) {
            addCriterion("twocurrentfamily >=", value, "twocurrentfamily");
            return (Criteria) this;
        }

        public Criteria andTwocurrentfamilyLessThan(String value) {
            addCriterion("twocurrentfamily <", value, "twocurrentfamily");
            return (Criteria) this;
        }

        public Criteria andTwocurrentfamilyLessThanOrEqualTo(String value) {
            addCriterion("twocurrentfamily <=", value, "twocurrentfamily");
            return (Criteria) this;
        }

        public Criteria andTwocurrentfamilyLike(String value) {
            addCriterion("twocurrentfamily like", value, "twocurrentfamily");
            return (Criteria) this;
        }

        public Criteria andTwocurrentfamilyNotLike(String value) {
            addCriterion("twocurrentfamily not like", value, "twocurrentfamily");
            return (Criteria) this;
        }

        public Criteria andTwocurrentfamilyIn(List<String> values) {
            addCriterion("twocurrentfamily in", values, "twocurrentfamily");
            return (Criteria) this;
        }

        public Criteria andTwocurrentfamilyNotIn(List<String> values) {
            addCriterion("twocurrentfamily not in", values, "twocurrentfamily");
            return (Criteria) this;
        }

        public Criteria andTwocurrentfamilyBetween(String value1, String value2) {
            addCriterion("twocurrentfamily between", value1, value2, "twocurrentfamily");
            return (Criteria) this;
        }

        public Criteria andTwocurrentfamilyNotBetween(String value1, String value2) {
            addCriterion("twocurrentfamily not between", value1, value2, "twocurrentfamily");
            return (Criteria) this;
        }

        public Criteria andOneformnameIsNull() {
            addCriterion("oneformname is null");
            return (Criteria) this;
        }

        public Criteria andOneformnameIsNotNull() {
            addCriterion("oneformname is not null");
            return (Criteria) this;
        }

        public Criteria andOneformnameEqualTo(String value) {
            addCriterion("oneformname =", value, "oneformname");
            return (Criteria) this;
        }

        public Criteria andOneformnameNotEqualTo(String value) {
            addCriterion("oneformname <>", value, "oneformname");
            return (Criteria) this;
        }

        public Criteria andOneformnameGreaterThan(String value) {
            addCriterion("oneformname >", value, "oneformname");
            return (Criteria) this;
        }

        public Criteria andOneformnameGreaterThanOrEqualTo(String value) {
            addCriterion("oneformname >=", value, "oneformname");
            return (Criteria) this;
        }

        public Criteria andOneformnameLessThan(String value) {
            addCriterion("oneformname <", value, "oneformname");
            return (Criteria) this;
        }

        public Criteria andOneformnameLessThanOrEqualTo(String value) {
            addCriterion("oneformname <=", value, "oneformname");
            return (Criteria) this;
        }

        public Criteria andOneformnameLike(String value) {
            addCriterion("oneformname like", value, "oneformname");
            return (Criteria) this;
        }

        public Criteria andOneformnameNotLike(String value) {
            addCriterion("oneformname not like", value, "oneformname");
            return (Criteria) this;
        }

        public Criteria andOneformnameIn(List<String> values) {
            addCriterion("oneformname in", values, "oneformname");
            return (Criteria) this;
        }

        public Criteria andOneformnameNotIn(List<String> values) {
            addCriterion("oneformname not in", values, "oneformname");
            return (Criteria) this;
        }

        public Criteria andOneformnameBetween(String value1, String value2) {
            addCriterion("oneformname between", value1, value2, "oneformname");
            return (Criteria) this;
        }

        public Criteria andOneformnameNotBetween(String value1, String value2) {
            addCriterion("oneformname not between", value1, value2, "oneformname");
            return (Criteria) this;
        }

        public Criteria andTwoformnameIsNull() {
            addCriterion("twoformname is null");
            return (Criteria) this;
        }

        public Criteria andTwoformnameIsNotNull() {
            addCriterion("twoformname is not null");
            return (Criteria) this;
        }

        public Criteria andTwoformnameEqualTo(String value) {
            addCriterion("twoformname =", value, "twoformname");
            return (Criteria) this;
        }

        public Criteria andTwoformnameNotEqualTo(String value) {
            addCriterion("twoformname <>", value, "twoformname");
            return (Criteria) this;
        }

        public Criteria andTwoformnameGreaterThan(String value) {
            addCriterion("twoformname >", value, "twoformname");
            return (Criteria) this;
        }

        public Criteria andTwoformnameGreaterThanOrEqualTo(String value) {
            addCriterion("twoformname >=", value, "twoformname");
            return (Criteria) this;
        }

        public Criteria andTwoformnameLessThan(String value) {
            addCriterion("twoformname <", value, "twoformname");
            return (Criteria) this;
        }

        public Criteria andTwoformnameLessThanOrEqualTo(String value) {
            addCriterion("twoformname <=", value, "twoformname");
            return (Criteria) this;
        }

        public Criteria andTwoformnameLike(String value) {
            addCriterion("twoformname like", value, "twoformname");
            return (Criteria) this;
        }

        public Criteria andTwoformnameNotLike(String value) {
            addCriterion("twoformname not like", value, "twoformname");
            return (Criteria) this;
        }

        public Criteria andTwoformnameIn(List<String> values) {
            addCriterion("twoformname in", values, "twoformname");
            return (Criteria) this;
        }

        public Criteria andTwoformnameNotIn(List<String> values) {
            addCriterion("twoformname not in", values, "twoformname");
            return (Criteria) this;
        }

        public Criteria andTwoformnameBetween(String value1, String value2) {
            addCriterion("twoformname between", value1, value2, "twoformname");
            return (Criteria) this;
        }

        public Criteria andTwoformnameNotBetween(String value1, String value2) {
            addCriterion("twoformname not between", value1, value2, "twoformname");
            return (Criteria) this;
        }

        public Criteria andOnerepresentIsNull() {
            addCriterion("onerepresent is null");
            return (Criteria) this;
        }

        public Criteria andOnerepresentIsNotNull() {
            addCriterion("onerepresent is not null");
            return (Criteria) this;
        }

        public Criteria andOnerepresentEqualTo(String value) {
            addCriterion("onerepresent =", value, "onerepresent");
            return (Criteria) this;
        }

        public Criteria andOnerepresentNotEqualTo(String value) {
            addCriterion("onerepresent <>", value, "onerepresent");
            return (Criteria) this;
        }

        public Criteria andOnerepresentGreaterThan(String value) {
            addCriterion("onerepresent >", value, "onerepresent");
            return (Criteria) this;
        }

        public Criteria andOnerepresentGreaterThanOrEqualTo(String value) {
            addCriterion("onerepresent >=", value, "onerepresent");
            return (Criteria) this;
        }

        public Criteria andOnerepresentLessThan(String value) {
            addCriterion("onerepresent <", value, "onerepresent");
            return (Criteria) this;
        }

        public Criteria andOnerepresentLessThanOrEqualTo(String value) {
            addCriterion("onerepresent <=", value, "onerepresent");
            return (Criteria) this;
        }

        public Criteria andOnerepresentLike(String value) {
            addCriterion("onerepresent like", value, "onerepresent");
            return (Criteria) this;
        }

        public Criteria andOnerepresentNotLike(String value) {
            addCriterion("onerepresent not like", value, "onerepresent");
            return (Criteria) this;
        }

        public Criteria andOnerepresentIn(List<String> values) {
            addCriterion("onerepresent in", values, "onerepresent");
            return (Criteria) this;
        }

        public Criteria andOnerepresentNotIn(List<String> values) {
            addCriterion("onerepresent not in", values, "onerepresent");
            return (Criteria) this;
        }

        public Criteria andOnerepresentBetween(String value1, String value2) {
            addCriterion("onerepresent between", value1, value2, "onerepresent");
            return (Criteria) this;
        }

        public Criteria andOnerepresentNotBetween(String value1, String value2) {
            addCriterion("onerepresent not between", value1, value2, "onerepresent");
            return (Criteria) this;
        }

        public Criteria andTworepresentIsNull() {
            addCriterion("tworepresent is null");
            return (Criteria) this;
        }

        public Criteria andTworepresentIsNotNull() {
            addCriterion("tworepresent is not null");
            return (Criteria) this;
        }

        public Criteria andTworepresentEqualTo(String value) {
            addCriterion("tworepresent =", value, "tworepresent");
            return (Criteria) this;
        }

        public Criteria andTworepresentNotEqualTo(String value) {
            addCriterion("tworepresent <>", value, "tworepresent");
            return (Criteria) this;
        }

        public Criteria andTworepresentGreaterThan(String value) {
            addCriterion("tworepresent >", value, "tworepresent");
            return (Criteria) this;
        }

        public Criteria andTworepresentGreaterThanOrEqualTo(String value) {
            addCriterion("tworepresent >=", value, "tworepresent");
            return (Criteria) this;
        }

        public Criteria andTworepresentLessThan(String value) {
            addCriterion("tworepresent <", value, "tworepresent");
            return (Criteria) this;
        }

        public Criteria andTworepresentLessThanOrEqualTo(String value) {
            addCriterion("tworepresent <=", value, "tworepresent");
            return (Criteria) this;
        }

        public Criteria andTworepresentLike(String value) {
            addCriterion("tworepresent like", value, "tworepresent");
            return (Criteria) this;
        }

        public Criteria andTworepresentNotLike(String value) {
            addCriterion("tworepresent not like", value, "tworepresent");
            return (Criteria) this;
        }

        public Criteria andTworepresentIn(List<String> values) {
            addCriterion("tworepresent in", values, "tworepresent");
            return (Criteria) this;
        }

        public Criteria andTworepresentNotIn(List<String> values) {
            addCriterion("tworepresent not in", values, "tworepresent");
            return (Criteria) this;
        }

        public Criteria andTworepresentBetween(String value1, String value2) {
            addCriterion("tworepresent between", value1, value2, "tworepresent");
            return (Criteria) this;
        }

        public Criteria andTworepresentNotBetween(String value1, String value2) {
            addCriterion("tworepresent not between", value1, value2, "tworepresent");
            return (Criteria) this;
        }

        public Criteria andOnejobIsNull() {
            addCriterion("onejob is null");
            return (Criteria) this;
        }

        public Criteria andOnejobIsNotNull() {
            addCriterion("onejob is not null");
            return (Criteria) this;
        }

        public Criteria andOnejobEqualTo(String value) {
            addCriterion("onejob =", value, "onejob");
            return (Criteria) this;
        }

        public Criteria andOnejobNotEqualTo(String value) {
            addCriterion("onejob <>", value, "onejob");
            return (Criteria) this;
        }

        public Criteria andOnejobGreaterThan(String value) {
            addCriterion("onejob >", value, "onejob");
            return (Criteria) this;
        }

        public Criteria andOnejobGreaterThanOrEqualTo(String value) {
            addCriterion("onejob >=", value, "onejob");
            return (Criteria) this;
        }

        public Criteria andOnejobLessThan(String value) {
            addCriterion("onejob <", value, "onejob");
            return (Criteria) this;
        }

        public Criteria andOnejobLessThanOrEqualTo(String value) {
            addCriterion("onejob <=", value, "onejob");
            return (Criteria) this;
        }

        public Criteria andOnejobLike(String value) {
            addCriterion("onejob like", value, "onejob");
            return (Criteria) this;
        }

        public Criteria andOnejobNotLike(String value) {
            addCriterion("onejob not like", value, "onejob");
            return (Criteria) this;
        }

        public Criteria andOnejobIn(List<String> values) {
            addCriterion("onejob in", values, "onejob");
            return (Criteria) this;
        }

        public Criteria andOnejobNotIn(List<String> values) {
            addCriterion("onejob not in", values, "onejob");
            return (Criteria) this;
        }

        public Criteria andOnejobBetween(String value1, String value2) {
            addCriterion("onejob between", value1, value2, "onejob");
            return (Criteria) this;
        }

        public Criteria andOnejobNotBetween(String value1, String value2) {
            addCriterion("onejob not between", value1, value2, "onejob");
            return (Criteria) this;
        }

        public Criteria andTwojobIsNull() {
            addCriterion("twojob is null");
            return (Criteria) this;
        }

        public Criteria andTwojobIsNotNull() {
            addCriterion("twojob is not null");
            return (Criteria) this;
        }

        public Criteria andTwojobEqualTo(String value) {
            addCriterion("twojob =", value, "twojob");
            return (Criteria) this;
        }

        public Criteria andTwojobNotEqualTo(String value) {
            addCriterion("twojob <>", value, "twojob");
            return (Criteria) this;
        }

        public Criteria andTwojobGreaterThan(String value) {
            addCriterion("twojob >", value, "twojob");
            return (Criteria) this;
        }

        public Criteria andTwojobGreaterThanOrEqualTo(String value) {
            addCriterion("twojob >=", value, "twojob");
            return (Criteria) this;
        }

        public Criteria andTwojobLessThan(String value) {
            addCriterion("twojob <", value, "twojob");
            return (Criteria) this;
        }

        public Criteria andTwojobLessThanOrEqualTo(String value) {
            addCriterion("twojob <=", value, "twojob");
            return (Criteria) this;
        }

        public Criteria andTwojobLike(String value) {
            addCriterion("twojob like", value, "twojob");
            return (Criteria) this;
        }

        public Criteria andTwojobNotLike(String value) {
            addCriterion("twojob not like", value, "twojob");
            return (Criteria) this;
        }

        public Criteria andTwojobIn(List<String> values) {
            addCriterion("twojob in", values, "twojob");
            return (Criteria) this;
        }

        public Criteria andTwojobNotIn(List<String> values) {
            addCriterion("twojob not in", values, "twojob");
            return (Criteria) this;
        }

        public Criteria andTwojobBetween(String value1, String value2) {
            addCriterion("twojob between", value1, value2, "twojob");
            return (Criteria) this;
        }

        public Criteria andTwojobNotBetween(String value1, String value2) {
            addCriterion("twojob not between", value1, value2, "twojob");
            return (Criteria) this;
        }
    }

    /**
     * publicsentiment的映射实体
     */
    public static class Criteria extends BaseCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * publicsentiment的动态SQL对象.
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