package com.gzj.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpiderCorpSmsSendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpiderCorpSmsSendExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDianzhangIdIsNull() {
            addCriterion("DIANZHANG_ID is null");
            return (Criteria) this;
        }

        public Criteria andDianzhangIdIsNotNull() {
            addCriterion("DIANZHANG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDianzhangIdEqualTo(Integer value) {
            addCriterion("DIANZHANG_ID =", value, "dianzhangId");
            return (Criteria) this;
        }

        public Criteria andDianzhangIdNotEqualTo(Integer value) {
            addCriterion("DIANZHANG_ID <>", value, "dianzhangId");
            return (Criteria) this;
        }

        public Criteria andDianzhangIdGreaterThan(Integer value) {
            addCriterion("DIANZHANG_ID >", value, "dianzhangId");
            return (Criteria) this;
        }

        public Criteria andDianzhangIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DIANZHANG_ID >=", value, "dianzhangId");
            return (Criteria) this;
        }

        public Criteria andDianzhangIdLessThan(Integer value) {
            addCriterion("DIANZHANG_ID <", value, "dianzhangId");
            return (Criteria) this;
        }

        public Criteria andDianzhangIdLessThanOrEqualTo(Integer value) {
            addCriterion("DIANZHANG_ID <=", value, "dianzhangId");
            return (Criteria) this;
        }

        public Criteria andDianzhangIdIn(List<Integer> values) {
            addCriterion("DIANZHANG_ID in", values, "dianzhangId");
            return (Criteria) this;
        }

        public Criteria andDianzhangIdNotIn(List<Integer> values) {
            addCriterion("DIANZHANG_ID not in", values, "dianzhangId");
            return (Criteria) this;
        }

        public Criteria andDianzhangIdBetween(Integer value1, Integer value2) {
            addCriterion("DIANZHANG_ID between", value1, value2, "dianzhangId");
            return (Criteria) this;
        }

        public Criteria andDianzhangIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DIANZHANG_ID not between", value1, value2, "dianzhangId");
            return (Criteria) this;
        }

        public Criteria andDianzhangNameIsNull() {
            addCriterion("DIANZHANG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDianzhangNameIsNotNull() {
            addCriterion("DIANZHANG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDianzhangNameEqualTo(String value) {
            addCriterion("DIANZHANG_NAME =", value, "dianzhangName");
            return (Criteria) this;
        }

        public Criteria andDianzhangNameNotEqualTo(String value) {
            addCriterion("DIANZHANG_NAME <>", value, "dianzhangName");
            return (Criteria) this;
        }

        public Criteria andDianzhangNameGreaterThan(String value) {
            addCriterion("DIANZHANG_NAME >", value, "dianzhangName");
            return (Criteria) this;
        }

        public Criteria andDianzhangNameGreaterThanOrEqualTo(String value) {
            addCriterion("DIANZHANG_NAME >=", value, "dianzhangName");
            return (Criteria) this;
        }

        public Criteria andDianzhangNameLessThan(String value) {
            addCriterion("DIANZHANG_NAME <", value, "dianzhangName");
            return (Criteria) this;
        }

        public Criteria andDianzhangNameLessThanOrEqualTo(String value) {
            addCriterion("DIANZHANG_NAME <=", value, "dianzhangName");
            return (Criteria) this;
        }

        public Criteria andDianzhangNameLike(String value) {
            addCriterion("DIANZHANG_NAME like", value, "dianzhangName");
            return (Criteria) this;
        }

        public Criteria andDianzhangNameNotLike(String value) {
            addCriterion("DIANZHANG_NAME not like", value, "dianzhangName");
            return (Criteria) this;
        }

        public Criteria andDianzhangNameIn(List<String> values) {
            addCriterion("DIANZHANG_NAME in", values, "dianzhangName");
            return (Criteria) this;
        }

        public Criteria andDianzhangNameNotIn(List<String> values) {
            addCriterion("DIANZHANG_NAME not in", values, "dianzhangName");
            return (Criteria) this;
        }

        public Criteria andDianzhangNameBetween(String value1, String value2) {
            addCriterion("DIANZHANG_NAME between", value1, value2, "dianzhangName");
            return (Criteria) this;
        }

        public Criteria andDianzhangNameNotBetween(String value1, String value2) {
            addCriterion("DIANZHANG_NAME not between", value1, value2, "dianzhangName");
            return (Criteria) this;
        }

        public Criteria andDianzhangName2IsNull() {
            addCriterion("DIANZHANG_NAME2 is null");
            return (Criteria) this;
        }

        public Criteria andDianzhangName2IsNotNull() {
            addCriterion("DIANZHANG_NAME2 is not null");
            return (Criteria) this;
        }

        public Criteria andDianzhangName2EqualTo(String value) {
            addCriterion("DIANZHANG_NAME2 =", value, "dianzhangName2");
            return (Criteria) this;
        }

        public Criteria andDianzhangName2NotEqualTo(String value) {
            addCriterion("DIANZHANG_NAME2 <>", value, "dianzhangName2");
            return (Criteria) this;
        }

        public Criteria andDianzhangName2GreaterThan(String value) {
            addCriterion("DIANZHANG_NAME2 >", value, "dianzhangName2");
            return (Criteria) this;
        }

        public Criteria andDianzhangName2GreaterThanOrEqualTo(String value) {
            addCriterion("DIANZHANG_NAME2 >=", value, "dianzhangName2");
            return (Criteria) this;
        }

        public Criteria andDianzhangName2LessThan(String value) {
            addCriterion("DIANZHANG_NAME2 <", value, "dianzhangName2");
            return (Criteria) this;
        }

        public Criteria andDianzhangName2LessThanOrEqualTo(String value) {
            addCriterion("DIANZHANG_NAME2 <=", value, "dianzhangName2");
            return (Criteria) this;
        }

        public Criteria andDianzhangName2Like(String value) {
            addCriterion("DIANZHANG_NAME2 like", value, "dianzhangName2");
            return (Criteria) this;
        }

        public Criteria andDianzhangName2NotLike(String value) {
            addCriterion("DIANZHANG_NAME2 not like", value, "dianzhangName2");
            return (Criteria) this;
        }

        public Criteria andDianzhangName2In(List<String> values) {
            addCriterion("DIANZHANG_NAME2 in", values, "dianzhangName2");
            return (Criteria) this;
        }

        public Criteria andDianzhangName2NotIn(List<String> values) {
            addCriterion("DIANZHANG_NAME2 not in", values, "dianzhangName2");
            return (Criteria) this;
        }

        public Criteria andDianzhangName2Between(String value1, String value2) {
            addCriterion("DIANZHANG_NAME2 between", value1, value2, "dianzhangName2");
            return (Criteria) this;
        }

        public Criteria andDianzhangName2NotBetween(String value1, String value2) {
            addCriterion("DIANZHANG_NAME2 not between", value1, value2, "dianzhangName2");
            return (Criteria) this;
        }

        public Criteria andDianzhangContacterIsNull() {
            addCriterion("DIANZHANG_CONTACTER is null");
            return (Criteria) this;
        }

        public Criteria andDianzhangContacterIsNotNull() {
            addCriterion("DIANZHANG_CONTACTER is not null");
            return (Criteria) this;
        }

        public Criteria andDianzhangContacterEqualTo(String value) {
            addCriterion("DIANZHANG_CONTACTER =", value, "dianzhangContacter");
            return (Criteria) this;
        }

        public Criteria andDianzhangContacterNotEqualTo(String value) {
            addCriterion("DIANZHANG_CONTACTER <>", value, "dianzhangContacter");
            return (Criteria) this;
        }

        public Criteria andDianzhangContacterGreaterThan(String value) {
            addCriterion("DIANZHANG_CONTACTER >", value, "dianzhangContacter");
            return (Criteria) this;
        }

        public Criteria andDianzhangContacterGreaterThanOrEqualTo(String value) {
            addCriterion("DIANZHANG_CONTACTER >=", value, "dianzhangContacter");
            return (Criteria) this;
        }

        public Criteria andDianzhangContacterLessThan(String value) {
            addCriterion("DIANZHANG_CONTACTER <", value, "dianzhangContacter");
            return (Criteria) this;
        }

        public Criteria andDianzhangContacterLessThanOrEqualTo(String value) {
            addCriterion("DIANZHANG_CONTACTER <=", value, "dianzhangContacter");
            return (Criteria) this;
        }

        public Criteria andDianzhangContacterLike(String value) {
            addCriterion("DIANZHANG_CONTACTER like", value, "dianzhangContacter");
            return (Criteria) this;
        }

        public Criteria andDianzhangContacterNotLike(String value) {
            addCriterion("DIANZHANG_CONTACTER not like", value, "dianzhangContacter");
            return (Criteria) this;
        }

        public Criteria andDianzhangContacterIn(List<String> values) {
            addCriterion("DIANZHANG_CONTACTER in", values, "dianzhangContacter");
            return (Criteria) this;
        }

        public Criteria andDianzhangContacterNotIn(List<String> values) {
            addCriterion("DIANZHANG_CONTACTER not in", values, "dianzhangContacter");
            return (Criteria) this;
        }

        public Criteria andDianzhangContacterBetween(String value1, String value2) {
            addCriterion("DIANZHANG_CONTACTER between", value1, value2, "dianzhangContacter");
            return (Criteria) this;
        }

        public Criteria andDianzhangContacterNotBetween(String value1, String value2) {
            addCriterion("DIANZHANG_CONTACTER not between", value1, value2, "dianzhangContacter");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpIdIsNull() {
            addCriterion("SPIDER_CORP_ID is null");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpIdIsNotNull() {
            addCriterion("SPIDER_CORP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpIdEqualTo(Integer value) {
            addCriterion("SPIDER_CORP_ID =", value, "spiderCorpId");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpIdNotEqualTo(Integer value) {
            addCriterion("SPIDER_CORP_ID <>", value, "spiderCorpId");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpIdGreaterThan(Integer value) {
            addCriterion("SPIDER_CORP_ID >", value, "spiderCorpId");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SPIDER_CORP_ID >=", value, "spiderCorpId");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpIdLessThan(Integer value) {
            addCriterion("SPIDER_CORP_ID <", value, "spiderCorpId");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpIdLessThanOrEqualTo(Integer value) {
            addCriterion("SPIDER_CORP_ID <=", value, "spiderCorpId");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpIdIn(List<Integer> values) {
            addCriterion("SPIDER_CORP_ID in", values, "spiderCorpId");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpIdNotIn(List<Integer> values) {
            addCriterion("SPIDER_CORP_ID not in", values, "spiderCorpId");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpIdBetween(Integer value1, Integer value2) {
            addCriterion("SPIDER_CORP_ID between", value1, value2, "spiderCorpId");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SPIDER_CORP_ID not between", value1, value2, "spiderCorpId");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpNameIsNull() {
            addCriterion("SPIDER_CORP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpNameIsNotNull() {
            addCriterion("SPIDER_CORP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpNameEqualTo(String value) {
            addCriterion("SPIDER_CORP_NAME =", value, "spiderCorpName");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpNameNotEqualTo(String value) {
            addCriterion("SPIDER_CORP_NAME <>", value, "spiderCorpName");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpNameGreaterThan(String value) {
            addCriterion("SPIDER_CORP_NAME >", value, "spiderCorpName");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpNameGreaterThanOrEqualTo(String value) {
            addCriterion("SPIDER_CORP_NAME >=", value, "spiderCorpName");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpNameLessThan(String value) {
            addCriterion("SPIDER_CORP_NAME <", value, "spiderCorpName");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpNameLessThanOrEqualTo(String value) {
            addCriterion("SPIDER_CORP_NAME <=", value, "spiderCorpName");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpNameLike(String value) {
            addCriterion("SPIDER_CORP_NAME like", value, "spiderCorpName");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpNameNotLike(String value) {
            addCriterion("SPIDER_CORP_NAME not like", value, "spiderCorpName");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpNameIn(List<String> values) {
            addCriterion("SPIDER_CORP_NAME in", values, "spiderCorpName");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpNameNotIn(List<String> values) {
            addCriterion("SPIDER_CORP_NAME not in", values, "spiderCorpName");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpNameBetween(String value1, String value2) {
            addCriterion("SPIDER_CORP_NAME between", value1, value2, "spiderCorpName");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpNameNotBetween(String value1, String value2) {
            addCriterion("SPIDER_CORP_NAME not between", value1, value2, "spiderCorpName");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpContacterIsNull() {
            addCriterion("SPIDER_CORP_CONTACTER is null");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpContacterIsNotNull() {
            addCriterion("SPIDER_CORP_CONTACTER is not null");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpContacterEqualTo(String value) {
            addCriterion("SPIDER_CORP_CONTACTER =", value, "spiderCorpContacter");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpContacterNotEqualTo(String value) {
            addCriterion("SPIDER_CORP_CONTACTER <>", value, "spiderCorpContacter");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpContacterGreaterThan(String value) {
            addCriterion("SPIDER_CORP_CONTACTER >", value, "spiderCorpContacter");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpContacterGreaterThanOrEqualTo(String value) {
            addCriterion("SPIDER_CORP_CONTACTER >=", value, "spiderCorpContacter");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpContacterLessThan(String value) {
            addCriterion("SPIDER_CORP_CONTACTER <", value, "spiderCorpContacter");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpContacterLessThanOrEqualTo(String value) {
            addCriterion("SPIDER_CORP_CONTACTER <=", value, "spiderCorpContacter");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpContacterLike(String value) {
            addCriterion("SPIDER_CORP_CONTACTER like", value, "spiderCorpContacter");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpContacterNotLike(String value) {
            addCriterion("SPIDER_CORP_CONTACTER not like", value, "spiderCorpContacter");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpContacterIn(List<String> values) {
            addCriterion("SPIDER_CORP_CONTACTER in", values, "spiderCorpContacter");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpContacterNotIn(List<String> values) {
            addCriterion("SPIDER_CORP_CONTACTER not in", values, "spiderCorpContacter");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpContacterBetween(String value1, String value2) {
            addCriterion("SPIDER_CORP_CONTACTER between", value1, value2, "spiderCorpContacter");
            return (Criteria) this;
        }

        public Criteria andSpiderCorpContacterNotBetween(String value1, String value2) {
            addCriterion("SPIDER_CORP_CONTACTER not between", value1, value2, "spiderCorpContacter");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andSmsContentIsNull() {
            addCriterion("SMS_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andSmsContentIsNotNull() {
            addCriterion("SMS_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andSmsContentEqualTo(String value) {
            addCriterion("SMS_CONTENT =", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentNotEqualTo(String value) {
            addCriterion("SMS_CONTENT <>", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentGreaterThan(String value) {
            addCriterion("SMS_CONTENT >", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentGreaterThanOrEqualTo(String value) {
            addCriterion("SMS_CONTENT >=", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentLessThan(String value) {
            addCriterion("SMS_CONTENT <", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentLessThanOrEqualTo(String value) {
            addCriterion("SMS_CONTENT <=", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentLike(String value) {
            addCriterion("SMS_CONTENT like", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentNotLike(String value) {
            addCriterion("SMS_CONTENT not like", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentIn(List<String> values) {
            addCriterion("SMS_CONTENT in", values, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentNotIn(List<String> values) {
            addCriterion("SMS_CONTENT not in", values, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentBetween(String value1, String value2) {
            addCriterion("SMS_CONTENT between", value1, value2, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentNotBetween(String value1, String value2) {
            addCriterion("SMS_CONTENT not between", value1, value2, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsTypeIsNull() {
            addCriterion("SMS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSmsTypeIsNotNull() {
            addCriterion("SMS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSmsTypeEqualTo(Integer value) {
            addCriterion("SMS_TYPE =", value, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeNotEqualTo(Integer value) {
            addCriterion("SMS_TYPE <>", value, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeGreaterThan(Integer value) {
            addCriterion("SMS_TYPE >", value, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SMS_TYPE >=", value, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeLessThan(Integer value) {
            addCriterion("SMS_TYPE <", value, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeLessThanOrEqualTo(Integer value) {
            addCriterion("SMS_TYPE <=", value, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeIn(List<Integer> values) {
            addCriterion("SMS_TYPE in", values, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeNotIn(List<Integer> values) {
            addCriterion("SMS_TYPE not in", values, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeBetween(Integer value1, Integer value2) {
            addCriterion("SMS_TYPE between", value1, value2, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("SMS_TYPE not between", value1, value2, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeDescIsNull() {
            addCriterion("SMS_TYPE_DESC is null");
            return (Criteria) this;
        }

        public Criteria andSmsTypeDescIsNotNull() {
            addCriterion("SMS_TYPE_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andSmsTypeDescEqualTo(String value) {
            addCriterion("SMS_TYPE_DESC =", value, "smsTypeDesc");
            return (Criteria) this;
        }

        public Criteria andSmsTypeDescNotEqualTo(String value) {
            addCriterion("SMS_TYPE_DESC <>", value, "smsTypeDesc");
            return (Criteria) this;
        }

        public Criteria andSmsTypeDescGreaterThan(String value) {
            addCriterion("SMS_TYPE_DESC >", value, "smsTypeDesc");
            return (Criteria) this;
        }

        public Criteria andSmsTypeDescGreaterThanOrEqualTo(String value) {
            addCriterion("SMS_TYPE_DESC >=", value, "smsTypeDesc");
            return (Criteria) this;
        }

        public Criteria andSmsTypeDescLessThan(String value) {
            addCriterion("SMS_TYPE_DESC <", value, "smsTypeDesc");
            return (Criteria) this;
        }

        public Criteria andSmsTypeDescLessThanOrEqualTo(String value) {
            addCriterion("SMS_TYPE_DESC <=", value, "smsTypeDesc");
            return (Criteria) this;
        }

        public Criteria andSmsTypeDescLike(String value) {
            addCriterion("SMS_TYPE_DESC like", value, "smsTypeDesc");
            return (Criteria) this;
        }

        public Criteria andSmsTypeDescNotLike(String value) {
            addCriterion("SMS_TYPE_DESC not like", value, "smsTypeDesc");
            return (Criteria) this;
        }

        public Criteria andSmsTypeDescIn(List<String> values) {
            addCriterion("SMS_TYPE_DESC in", values, "smsTypeDesc");
            return (Criteria) this;
        }

        public Criteria andSmsTypeDescNotIn(List<String> values) {
            addCriterion("SMS_TYPE_DESC not in", values, "smsTypeDesc");
            return (Criteria) this;
        }

        public Criteria andSmsTypeDescBetween(String value1, String value2) {
            addCriterion("SMS_TYPE_DESC between", value1, value2, "smsTypeDesc");
            return (Criteria) this;
        }

        public Criteria andSmsTypeDescNotBetween(String value1, String value2) {
            addCriterion("SMS_TYPE_DESC not between", value1, value2, "smsTypeDesc");
            return (Criteria) this;
        }

        public Criteria andFirstSendTimeIsNull() {
            addCriterion("FIRST_SEND_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFirstSendTimeIsNotNull() {
            addCriterion("FIRST_SEND_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSendTimeEqualTo(Date value) {
            addCriterion("FIRST_SEND_TIME =", value, "firstSendTime");
            return (Criteria) this;
        }

        public Criteria andFirstSendTimeNotEqualTo(Date value) {
            addCriterion("FIRST_SEND_TIME <>", value, "firstSendTime");
            return (Criteria) this;
        }

        public Criteria andFirstSendTimeGreaterThan(Date value) {
            addCriterion("FIRST_SEND_TIME >", value, "firstSendTime");
            return (Criteria) this;
        }

        public Criteria andFirstSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FIRST_SEND_TIME >=", value, "firstSendTime");
            return (Criteria) this;
        }

        public Criteria andFirstSendTimeLessThan(Date value) {
            addCriterion("FIRST_SEND_TIME <", value, "firstSendTime");
            return (Criteria) this;
        }

        public Criteria andFirstSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("FIRST_SEND_TIME <=", value, "firstSendTime");
            return (Criteria) this;
        }

        public Criteria andFirstSendTimeIn(List<Date> values) {
            addCriterion("FIRST_SEND_TIME in", values, "firstSendTime");
            return (Criteria) this;
        }

        public Criteria andFirstSendTimeNotIn(List<Date> values) {
            addCriterion("FIRST_SEND_TIME not in", values, "firstSendTime");
            return (Criteria) this;
        }

        public Criteria andFirstSendTimeBetween(Date value1, Date value2) {
            addCriterion("FIRST_SEND_TIME between", value1, value2, "firstSendTime");
            return (Criteria) this;
        }

        public Criteria andFirstSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("FIRST_SEND_TIME not between", value1, value2, "firstSendTime");
            return (Criteria) this;
        }

        public Criteria andSmsCountIsNull() {
            addCriterion("SMS_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andSmsCountIsNotNull() {
            addCriterion("SMS_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSmsCountEqualTo(Integer value) {
            addCriterion("SMS_COUNT =", value, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCountNotEqualTo(Integer value) {
            addCriterion("SMS_COUNT <>", value, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCountGreaterThan(Integer value) {
            addCriterion("SMS_COUNT >", value, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("SMS_COUNT >=", value, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCountLessThan(Integer value) {
            addCriterion("SMS_COUNT <", value, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCountLessThanOrEqualTo(Integer value) {
            addCriterion("SMS_COUNT <=", value, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCountIn(List<Integer> values) {
            addCriterion("SMS_COUNT in", values, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCountNotIn(List<Integer> values) {
            addCriterion("SMS_COUNT not in", values, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCountBetween(Integer value1, Integer value2) {
            addCriterion("SMS_COUNT between", value1, value2, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("SMS_COUNT not between", value1, value2, "smsCount");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNull() {
            addCriterion("JOB_NAME is null");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNotNull() {
            addCriterion("JOB_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andJobNameEqualTo(String value) {
            addCriterion("JOB_NAME =", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotEqualTo(String value) {
            addCriterion("JOB_NAME <>", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThan(String value) {
            addCriterion("JOB_NAME >", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("JOB_NAME >=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThan(String value) {
            addCriterion("JOB_NAME <", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("JOB_NAME <=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLike(String value) {
            addCriterion("JOB_NAME like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotLike(String value) {
            addCriterion("JOB_NAME not like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameIn(List<String> values) {
            addCriterion("JOB_NAME in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotIn(List<String> values) {
            addCriterion("JOB_NAME not in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameBetween(String value1, String value2) {
            addCriterion("JOB_NAME between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("JOB_NAME not between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andSendFromIsNull() {
            addCriterion("SEND_FROM is null");
            return (Criteria) this;
        }

        public Criteria andSendFromIsNotNull() {
            addCriterion("SEND_FROM is not null");
            return (Criteria) this;
        }

        public Criteria andSendFromEqualTo(Integer value) {
            addCriterion("SEND_FROM =", value, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromNotEqualTo(Integer value) {
            addCriterion("SEND_FROM <>", value, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromGreaterThan(Integer value) {
            addCriterion("SEND_FROM >", value, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEND_FROM >=", value, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromLessThan(Integer value) {
            addCriterion("SEND_FROM <", value, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromLessThanOrEqualTo(Integer value) {
            addCriterion("SEND_FROM <=", value, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromIn(List<Integer> values) {
            addCriterion("SEND_FROM in", values, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromNotIn(List<Integer> values) {
            addCriterion("SEND_FROM not in", values, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromBetween(Integer value1, Integer value2) {
            addCriterion("SEND_FROM between", value1, value2, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andSendFromNotBetween(Integer value1, Integer value2) {
            addCriterion("SEND_FROM not between", value1, value2, "sendFrom");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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