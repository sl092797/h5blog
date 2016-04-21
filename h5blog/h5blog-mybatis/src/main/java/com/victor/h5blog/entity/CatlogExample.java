package com.victor.h5blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CatlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CatlogExample() {
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

        public Criteria andCatlogIdIsNull() {
            addCriterion("catlog_id is null");
            return (Criteria) this;
        }

        public Criteria andCatlogIdIsNotNull() {
            addCriterion("catlog_id is not null");
            return (Criteria) this;
        }

        public Criteria andCatlogIdEqualTo(Long value) {
            addCriterion("catlog_id =", value, "catlogId");
            return (Criteria) this;
        }

        public Criteria andCatlogIdNotEqualTo(Long value) {
            addCriterion("catlog_id <>", value, "catlogId");
            return (Criteria) this;
        }

        public Criteria andCatlogIdGreaterThan(Long value) {
            addCriterion("catlog_id >", value, "catlogId");
            return (Criteria) this;
        }

        public Criteria andCatlogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("catlog_id >=", value, "catlogId");
            return (Criteria) this;
        }

        public Criteria andCatlogIdLessThan(Long value) {
            addCriterion("catlog_id <", value, "catlogId");
            return (Criteria) this;
        }

        public Criteria andCatlogIdLessThanOrEqualTo(Long value) {
            addCriterion("catlog_id <=", value, "catlogId");
            return (Criteria) this;
        }

        public Criteria andCatlogIdIn(List<Long> values) {
            addCriterion("catlog_id in", values, "catlogId");
            return (Criteria) this;
        }

        public Criteria andCatlogIdNotIn(List<Long> values) {
            addCriterion("catlog_id not in", values, "catlogId");
            return (Criteria) this;
        }

        public Criteria andCatlogIdBetween(Long value1, Long value2) {
            addCriterion("catlog_id between", value1, value2, "catlogId");
            return (Criteria) this;
        }

        public Criteria andCatlogIdNotBetween(Long value1, Long value2) {
            addCriterion("catlog_id not between", value1, value2, "catlogId");
            return (Criteria) this;
        }

        public Criteria andCatlogFatherIdIsNull() {
            addCriterion("catlog_father_id is null");
            return (Criteria) this;
        }

        public Criteria andCatlogFatherIdIsNotNull() {
            addCriterion("catlog_father_id is not null");
            return (Criteria) this;
        }

        public Criteria andCatlogFatherIdEqualTo(Long value) {
            addCriterion("catlog_father_id =", value, "catlogFatherId");
            return (Criteria) this;
        }

        public Criteria andCatlogFatherIdNotEqualTo(Long value) {
            addCriterion("catlog_father_id <>", value, "catlogFatherId");
            return (Criteria) this;
        }

        public Criteria andCatlogFatherIdGreaterThan(Long value) {
            addCriterion("catlog_father_id >", value, "catlogFatherId");
            return (Criteria) this;
        }

        public Criteria andCatlogFatherIdGreaterThanOrEqualTo(Long value) {
            addCriterion("catlog_father_id >=", value, "catlogFatherId");
            return (Criteria) this;
        }

        public Criteria andCatlogFatherIdLessThan(Long value) {
            addCriterion("catlog_father_id <", value, "catlogFatherId");
            return (Criteria) this;
        }

        public Criteria andCatlogFatherIdLessThanOrEqualTo(Long value) {
            addCriterion("catlog_father_id <=", value, "catlogFatherId");
            return (Criteria) this;
        }

        public Criteria andCatlogFatherIdIn(List<Long> values) {
            addCriterion("catlog_father_id in", values, "catlogFatherId");
            return (Criteria) this;
        }

        public Criteria andCatlogFatherIdNotIn(List<Long> values) {
            addCriterion("catlog_father_id not in", values, "catlogFatherId");
            return (Criteria) this;
        }

        public Criteria andCatlogFatherIdBetween(Long value1, Long value2) {
            addCriterion("catlog_father_id between", value1, value2, "catlogFatherId");
            return (Criteria) this;
        }

        public Criteria andCatlogFatherIdNotBetween(Long value1, Long value2) {
            addCriterion("catlog_father_id not between", value1, value2, "catlogFatherId");
            return (Criteria) this;
        }

        public Criteria andCatlogKeyIsNull() {
            addCriterion("catlog_key is null");
            return (Criteria) this;
        }

        public Criteria andCatlogKeyIsNotNull() {
            addCriterion("catlog_key is not null");
            return (Criteria) this;
        }

        public Criteria andCatlogKeyEqualTo(String value) {
            addCriterion("catlog_key =", value, "catlogKey");
            return (Criteria) this;
        }

        public Criteria andCatlogKeyNotEqualTo(String value) {
            addCriterion("catlog_key <>", value, "catlogKey");
            return (Criteria) this;
        }

        public Criteria andCatlogKeyGreaterThan(String value) {
            addCriterion("catlog_key >", value, "catlogKey");
            return (Criteria) this;
        }

        public Criteria andCatlogKeyGreaterThanOrEqualTo(String value) {
            addCriterion("catlog_key >=", value, "catlogKey");
            return (Criteria) this;
        }

        public Criteria andCatlogKeyLessThan(String value) {
            addCriterion("catlog_key <", value, "catlogKey");
            return (Criteria) this;
        }

        public Criteria andCatlogKeyLessThanOrEqualTo(String value) {
            addCriterion("catlog_key <=", value, "catlogKey");
            return (Criteria) this;
        }

        public Criteria andCatlogKeyLike(String value) {
            addCriterion("catlog_key like", value, "catlogKey");
            return (Criteria) this;
        }

        public Criteria andCatlogKeyNotLike(String value) {
            addCriterion("catlog_key not like", value, "catlogKey");
            return (Criteria) this;
        }

        public Criteria andCatlogKeyIn(List<String> values) {
            addCriterion("catlog_key in", values, "catlogKey");
            return (Criteria) this;
        }

        public Criteria andCatlogKeyNotIn(List<String> values) {
            addCriterion("catlog_key not in", values, "catlogKey");
            return (Criteria) this;
        }

        public Criteria andCatlogKeyBetween(String value1, String value2) {
            addCriterion("catlog_key between", value1, value2, "catlogKey");
            return (Criteria) this;
        }

        public Criteria andCatlogKeyNotBetween(String value1, String value2) {
            addCriterion("catlog_key not between", value1, value2, "catlogKey");
            return (Criteria) this;
        }

        public Criteria andCatlogNameIsNull() {
            addCriterion("catlog_name is null");
            return (Criteria) this;
        }

        public Criteria andCatlogNameIsNotNull() {
            addCriterion("catlog_name is not null");
            return (Criteria) this;
        }

        public Criteria andCatlogNameEqualTo(String value) {
            addCriterion("catlog_name =", value, "catlogName");
            return (Criteria) this;
        }

        public Criteria andCatlogNameNotEqualTo(String value) {
            addCriterion("catlog_name <>", value, "catlogName");
            return (Criteria) this;
        }

        public Criteria andCatlogNameGreaterThan(String value) {
            addCriterion("catlog_name >", value, "catlogName");
            return (Criteria) this;
        }

        public Criteria andCatlogNameGreaterThanOrEqualTo(String value) {
            addCriterion("catlog_name >=", value, "catlogName");
            return (Criteria) this;
        }

        public Criteria andCatlogNameLessThan(String value) {
            addCriterion("catlog_name <", value, "catlogName");
            return (Criteria) this;
        }

        public Criteria andCatlogNameLessThanOrEqualTo(String value) {
            addCriterion("catlog_name <=", value, "catlogName");
            return (Criteria) this;
        }

        public Criteria andCatlogNameLike(String value) {
            addCriterion("catlog_name like", value, "catlogName");
            return (Criteria) this;
        }

        public Criteria andCatlogNameNotLike(String value) {
            addCriterion("catlog_name not like", value, "catlogName");
            return (Criteria) this;
        }

        public Criteria andCatlogNameIn(List<String> values) {
            addCriterion("catlog_name in", values, "catlogName");
            return (Criteria) this;
        }

        public Criteria andCatlogNameNotIn(List<String> values) {
            addCriterion("catlog_name not in", values, "catlogName");
            return (Criteria) this;
        }

        public Criteria andCatlogNameBetween(String value1, String value2) {
            addCriterion("catlog_name between", value1, value2, "catlogName");
            return (Criteria) this;
        }

        public Criteria andCatlogNameNotBetween(String value1, String value2) {
            addCriterion("catlog_name not between", value1, value2, "catlogName");
            return (Criteria) this;
        }

        public Criteria andCatlogDescIsNull() {
            addCriterion("catlog_desc is null");
            return (Criteria) this;
        }

        public Criteria andCatlogDescIsNotNull() {
            addCriterion("catlog_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCatlogDescEqualTo(String value) {
            addCriterion("catlog_desc =", value, "catlogDesc");
            return (Criteria) this;
        }

        public Criteria andCatlogDescNotEqualTo(String value) {
            addCriterion("catlog_desc <>", value, "catlogDesc");
            return (Criteria) this;
        }

        public Criteria andCatlogDescGreaterThan(String value) {
            addCriterion("catlog_desc >", value, "catlogDesc");
            return (Criteria) this;
        }

        public Criteria andCatlogDescGreaterThanOrEqualTo(String value) {
            addCriterion("catlog_desc >=", value, "catlogDesc");
            return (Criteria) this;
        }

        public Criteria andCatlogDescLessThan(String value) {
            addCriterion("catlog_desc <", value, "catlogDesc");
            return (Criteria) this;
        }

        public Criteria andCatlogDescLessThanOrEqualTo(String value) {
            addCriterion("catlog_desc <=", value, "catlogDesc");
            return (Criteria) this;
        }

        public Criteria andCatlogDescLike(String value) {
            addCriterion("catlog_desc like", value, "catlogDesc");
            return (Criteria) this;
        }

        public Criteria andCatlogDescNotLike(String value) {
            addCriterion("catlog_desc not like", value, "catlogDesc");
            return (Criteria) this;
        }

        public Criteria andCatlogDescIn(List<String> values) {
            addCriterion("catlog_desc in", values, "catlogDesc");
            return (Criteria) this;
        }

        public Criteria andCatlogDescNotIn(List<String> values) {
            addCriterion("catlog_desc not in", values, "catlogDesc");
            return (Criteria) this;
        }

        public Criteria andCatlogDescBetween(String value1, String value2) {
            addCriterion("catlog_desc between", value1, value2, "catlogDesc");
            return (Criteria) this;
        }

        public Criteria andCatlogDescNotBetween(String value1, String value2) {
            addCriterion("catlog_desc not between", value1, value2, "catlogDesc");
            return (Criteria) this;
        }

        public Criteria andCatlogCoveridIsNull() {
            addCriterion("catlog_coverId is null");
            return (Criteria) this;
        }

        public Criteria andCatlogCoveridIsNotNull() {
            addCriterion("catlog_coverId is not null");
            return (Criteria) this;
        }

        public Criteria andCatlogCoveridEqualTo(Long value) {
            addCriterion("catlog_coverId =", value, "catlogCoverid");
            return (Criteria) this;
        }

        public Criteria andCatlogCoveridNotEqualTo(Long value) {
            addCriterion("catlog_coverId <>", value, "catlogCoverid");
            return (Criteria) this;
        }

        public Criteria andCatlogCoveridGreaterThan(Long value) {
            addCriterion("catlog_coverId >", value, "catlogCoverid");
            return (Criteria) this;
        }

        public Criteria andCatlogCoveridGreaterThanOrEqualTo(Long value) {
            addCriterion("catlog_coverId >=", value, "catlogCoverid");
            return (Criteria) this;
        }

        public Criteria andCatlogCoveridLessThan(Long value) {
            addCriterion("catlog_coverId <", value, "catlogCoverid");
            return (Criteria) this;
        }

        public Criteria andCatlogCoveridLessThanOrEqualTo(Long value) {
            addCriterion("catlog_coverId <=", value, "catlogCoverid");
            return (Criteria) this;
        }

        public Criteria andCatlogCoveridIn(List<Long> values) {
            addCriterion("catlog_coverId in", values, "catlogCoverid");
            return (Criteria) this;
        }

        public Criteria andCatlogCoveridNotIn(List<Long> values) {
            addCriterion("catlog_coverId not in", values, "catlogCoverid");
            return (Criteria) this;
        }

        public Criteria andCatlogCoveridBetween(Long value1, Long value2) {
            addCriterion("catlog_coverId between", value1, value2, "catlogCoverid");
            return (Criteria) this;
        }

        public Criteria andCatlogCoveridNotBetween(Long value1, Long value2) {
            addCriterion("catlog_coverId not between", value1, value2, "catlogCoverid");
            return (Criteria) this;
        }

        public Criteria andCatlogPrivacyIsNull() {
            addCriterion("catlog_privacy is null");
            return (Criteria) this;
        }

        public Criteria andCatlogPrivacyIsNotNull() {
            addCriterion("catlog_privacy is not null");
            return (Criteria) this;
        }

        public Criteria andCatlogPrivacyEqualTo(Byte value) {
            addCriterion("catlog_privacy =", value, "catlogPrivacy");
            return (Criteria) this;
        }

        public Criteria andCatlogPrivacyNotEqualTo(Byte value) {
            addCriterion("catlog_privacy <>", value, "catlogPrivacy");
            return (Criteria) this;
        }

        public Criteria andCatlogPrivacyGreaterThan(Byte value) {
            addCriterion("catlog_privacy >", value, "catlogPrivacy");
            return (Criteria) this;
        }

        public Criteria andCatlogPrivacyGreaterThanOrEqualTo(Byte value) {
            addCriterion("catlog_privacy >=", value, "catlogPrivacy");
            return (Criteria) this;
        }

        public Criteria andCatlogPrivacyLessThan(Byte value) {
            addCriterion("catlog_privacy <", value, "catlogPrivacy");
            return (Criteria) this;
        }

        public Criteria andCatlogPrivacyLessThanOrEqualTo(Byte value) {
            addCriterion("catlog_privacy <=", value, "catlogPrivacy");
            return (Criteria) this;
        }

        public Criteria andCatlogPrivacyIn(List<Byte> values) {
            addCriterion("catlog_privacy in", values, "catlogPrivacy");
            return (Criteria) this;
        }

        public Criteria andCatlogPrivacyNotIn(List<Byte> values) {
            addCriterion("catlog_privacy not in", values, "catlogPrivacy");
            return (Criteria) this;
        }

        public Criteria andCatlogPrivacyBetween(Byte value1, Byte value2) {
            addCriterion("catlog_privacy between", value1, value2, "catlogPrivacy");
            return (Criteria) this;
        }

        public Criteria andCatlogPrivacyNotBetween(Byte value1, Byte value2) {
            addCriterion("catlog_privacy not between", value1, value2, "catlogPrivacy");
            return (Criteria) this;
        }

        public Criteria andCatlogLevelIsNull() {
            addCriterion("catlog_level is null");
            return (Criteria) this;
        }

        public Criteria andCatlogLevelIsNotNull() {
            addCriterion("catlog_level is not null");
            return (Criteria) this;
        }

        public Criteria andCatlogLevelEqualTo(Byte value) {
            addCriterion("catlog_level =", value, "catlogLevel");
            return (Criteria) this;
        }

        public Criteria andCatlogLevelNotEqualTo(Byte value) {
            addCriterion("catlog_level <>", value, "catlogLevel");
            return (Criteria) this;
        }

        public Criteria andCatlogLevelGreaterThan(Byte value) {
            addCriterion("catlog_level >", value, "catlogLevel");
            return (Criteria) this;
        }

        public Criteria andCatlogLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("catlog_level >=", value, "catlogLevel");
            return (Criteria) this;
        }

        public Criteria andCatlogLevelLessThan(Byte value) {
            addCriterion("catlog_level <", value, "catlogLevel");
            return (Criteria) this;
        }

        public Criteria andCatlogLevelLessThanOrEqualTo(Byte value) {
            addCriterion("catlog_level <=", value, "catlogLevel");
            return (Criteria) this;
        }

        public Criteria andCatlogLevelIn(List<Byte> values) {
            addCriterion("catlog_level in", values, "catlogLevel");
            return (Criteria) this;
        }

        public Criteria andCatlogLevelNotIn(List<Byte> values) {
            addCriterion("catlog_level not in", values, "catlogLevel");
            return (Criteria) this;
        }

        public Criteria andCatlogLevelBetween(Byte value1, Byte value2) {
            addCriterion("catlog_level between", value1, value2, "catlogLevel");
            return (Criteria) this;
        }

        public Criteria andCatlogLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("catlog_level not between", value1, value2, "catlogLevel");
            return (Criteria) this;
        }

        public Criteria andCatlogTagIsNull() {
            addCriterion("catlog_tag is null");
            return (Criteria) this;
        }

        public Criteria andCatlogTagIsNotNull() {
            addCriterion("catlog_tag is not null");
            return (Criteria) this;
        }

        public Criteria andCatlogTagEqualTo(String value) {
            addCriterion("catlog_tag =", value, "catlogTag");
            return (Criteria) this;
        }

        public Criteria andCatlogTagNotEqualTo(String value) {
            addCriterion("catlog_tag <>", value, "catlogTag");
            return (Criteria) this;
        }

        public Criteria andCatlogTagGreaterThan(String value) {
            addCriterion("catlog_tag >", value, "catlogTag");
            return (Criteria) this;
        }

        public Criteria andCatlogTagGreaterThanOrEqualTo(String value) {
            addCriterion("catlog_tag >=", value, "catlogTag");
            return (Criteria) this;
        }

        public Criteria andCatlogTagLessThan(String value) {
            addCriterion("catlog_tag <", value, "catlogTag");
            return (Criteria) this;
        }

        public Criteria andCatlogTagLessThanOrEqualTo(String value) {
            addCriterion("catlog_tag <=", value, "catlogTag");
            return (Criteria) this;
        }

        public Criteria andCatlogTagLike(String value) {
            addCriterion("catlog_tag like", value, "catlogTag");
            return (Criteria) this;
        }

        public Criteria andCatlogTagNotLike(String value) {
            addCriterion("catlog_tag not like", value, "catlogTag");
            return (Criteria) this;
        }

        public Criteria andCatlogTagIn(List<String> values) {
            addCriterion("catlog_tag in", values, "catlogTag");
            return (Criteria) this;
        }

        public Criteria andCatlogTagNotIn(List<String> values) {
            addCriterion("catlog_tag not in", values, "catlogTag");
            return (Criteria) this;
        }

        public Criteria andCatlogTagBetween(String value1, String value2) {
            addCriterion("catlog_tag between", value1, value2, "catlogTag");
            return (Criteria) this;
        }

        public Criteria andCatlogTagNotBetween(String value1, String value2) {
            addCriterion("catlog_tag not between", value1, value2, "catlogTag");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andChangeUserIsNull() {
            addCriterion("change_user is null");
            return (Criteria) this;
        }

        public Criteria andChangeUserIsNotNull() {
            addCriterion("change_user is not null");
            return (Criteria) this;
        }

        public Criteria andChangeUserEqualTo(String value) {
            addCriterion("change_user =", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserNotEqualTo(String value) {
            addCriterion("change_user <>", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserGreaterThan(String value) {
            addCriterion("change_user >", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserGreaterThanOrEqualTo(String value) {
            addCriterion("change_user >=", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserLessThan(String value) {
            addCriterion("change_user <", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserLessThanOrEqualTo(String value) {
            addCriterion("change_user <=", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserLike(String value) {
            addCriterion("change_user like", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserNotLike(String value) {
            addCriterion("change_user not like", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserIn(List<String> values) {
            addCriterion("change_user in", values, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserNotIn(List<String> values) {
            addCriterion("change_user not in", values, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserBetween(String value1, String value2) {
            addCriterion("change_user between", value1, value2, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserNotBetween(String value1, String value2) {
            addCriterion("change_user not between", value1, value2, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeDateIsNull() {
            addCriterion("change_date is null");
            return (Criteria) this;
        }

        public Criteria andChangeDateIsNotNull() {
            addCriterion("change_date is not null");
            return (Criteria) this;
        }

        public Criteria andChangeDateEqualTo(Date value) {
            addCriterion("change_date =", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateNotEqualTo(Date value) {
            addCriterion("change_date <>", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateGreaterThan(Date value) {
            addCriterion("change_date >", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("change_date >=", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateLessThan(Date value) {
            addCriterion("change_date <", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateLessThanOrEqualTo(Date value) {
            addCriterion("change_date <=", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateIn(List<Date> values) {
            addCriterion("change_date in", values, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateNotIn(List<Date> values) {
            addCriterion("change_date not in", values, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateBetween(Date value1, Date value2) {
            addCriterion("change_date between", value1, value2, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateNotBetween(Date value1, Date value2) {
            addCriterion("change_date not between", value1, value2, "changeDate");
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