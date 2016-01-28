package com.victor.h5blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PageComValExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PageComValExample() {
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
            addCriterion("PG_COM_VAL_ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("PG_COM_VAL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("PG_COM_VAL_ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("PG_COM_VAL_ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("PG_COM_VAL_ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PG_COM_VAL_ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("PG_COM_VAL_ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("PG_COM_VAL_ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("PG_COM_VAL_ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("PG_COM_VAL_ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("PG_COM_VAL_ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("PG_COM_VAL_ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPgComDefIdIsNull() {
            addCriterion("PG_COM_DEF_ID is null");
            return (Criteria) this;
        }

        public Criteria andPgComDefIdIsNotNull() {
            addCriterion("PG_COM_DEF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPgComDefIdEqualTo(Long value) {
            addCriterion("PG_COM_DEF_ID =", value, "pgComDefId");
            return (Criteria) this;
        }

        public Criteria andPgComDefIdNotEqualTo(Long value) {
            addCriterion("PG_COM_DEF_ID <>", value, "pgComDefId");
            return (Criteria) this;
        }

        public Criteria andPgComDefIdGreaterThan(Long value) {
            addCriterion("PG_COM_DEF_ID >", value, "pgComDefId");
            return (Criteria) this;
        }

        public Criteria andPgComDefIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PG_COM_DEF_ID >=", value, "pgComDefId");
            return (Criteria) this;
        }

        public Criteria andPgComDefIdLessThan(Long value) {
            addCriterion("PG_COM_DEF_ID <", value, "pgComDefId");
            return (Criteria) this;
        }

        public Criteria andPgComDefIdLessThanOrEqualTo(Long value) {
            addCriterion("PG_COM_DEF_ID <=", value, "pgComDefId");
            return (Criteria) this;
        }

        public Criteria andPgComDefIdIn(List<Long> values) {
            addCriterion("PG_COM_DEF_ID in", values, "pgComDefId");
            return (Criteria) this;
        }

        public Criteria andPgComDefIdNotIn(List<Long> values) {
            addCriterion("PG_COM_DEF_ID not in", values, "pgComDefId");
            return (Criteria) this;
        }

        public Criteria andPgComDefIdBetween(Long value1, Long value2) {
            addCriterion("PG_COM_DEF_ID between", value1, value2, "pgComDefId");
            return (Criteria) this;
        }

        public Criteria andPgComDefIdNotBetween(Long value1, Long value2) {
            addCriterion("PG_COM_DEF_ID not between", value1, value2, "pgComDefId");
            return (Criteria) this;
        }

        public Criteria andPgComVarIdIsNull() {
            addCriterion("PG_COM_VAR_ID is null");
            return (Criteria) this;
        }

        public Criteria andPgComVarIdIsNotNull() {
            addCriterion("PG_COM_VAR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPgComVarIdEqualTo(Long value) {
            addCriterion("PG_COM_VAR_ID =", value, "pgComVarId");
            return (Criteria) this;
        }

        public Criteria andPgComVarIdNotEqualTo(Long value) {
            addCriterion("PG_COM_VAR_ID <>", value, "pgComVarId");
            return (Criteria) this;
        }

        public Criteria andPgComVarIdGreaterThan(Long value) {
            addCriterion("PG_COM_VAR_ID >", value, "pgComVarId");
            return (Criteria) this;
        }

        public Criteria andPgComVarIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PG_COM_VAR_ID >=", value, "pgComVarId");
            return (Criteria) this;
        }

        public Criteria andPgComVarIdLessThan(Long value) {
            addCriterion("PG_COM_VAR_ID <", value, "pgComVarId");
            return (Criteria) this;
        }

        public Criteria andPgComVarIdLessThanOrEqualTo(Long value) {
            addCriterion("PG_COM_VAR_ID <=", value, "pgComVarId");
            return (Criteria) this;
        }

        public Criteria andPgComVarIdIn(List<Long> values) {
            addCriterion("PG_COM_VAR_ID in", values, "pgComVarId");
            return (Criteria) this;
        }

        public Criteria andPgComVarIdNotIn(List<Long> values) {
            addCriterion("PG_COM_VAR_ID not in", values, "pgComVarId");
            return (Criteria) this;
        }

        public Criteria andPgComVarIdBetween(Long value1, Long value2) {
            addCriterion("PG_COM_VAR_ID between", value1, value2, "pgComVarId");
            return (Criteria) this;
        }

        public Criteria andPgComVarIdNotBetween(Long value1, Long value2) {
            addCriterion("PG_COM_VAR_ID not between", value1, value2, "pgComVarId");
            return (Criteria) this;
        }

        public Criteria andPgComCodeIsNull() {
            addCriterion("PG_COM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPgComCodeIsNotNull() {
            addCriterion("PG_COM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPgComCodeEqualTo(String value) {
            addCriterion("PG_COM_CODE =", value, "pgComCode");
            return (Criteria) this;
        }

        public Criteria andPgComCodeNotEqualTo(String value) {
            addCriterion("PG_COM_CODE <>", value, "pgComCode");
            return (Criteria) this;
        }

        public Criteria andPgComCodeGreaterThan(String value) {
            addCriterion("PG_COM_CODE >", value, "pgComCode");
            return (Criteria) this;
        }

        public Criteria andPgComCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PG_COM_CODE >=", value, "pgComCode");
            return (Criteria) this;
        }

        public Criteria andPgComCodeLessThan(String value) {
            addCriterion("PG_COM_CODE <", value, "pgComCode");
            return (Criteria) this;
        }

        public Criteria andPgComCodeLessThanOrEqualTo(String value) {
            addCriterion("PG_COM_CODE <=", value, "pgComCode");
            return (Criteria) this;
        }

        public Criteria andPgComCodeLike(String value) {
            addCriterion("PG_COM_CODE like", value, "pgComCode");
            return (Criteria) this;
        }

        public Criteria andPgComCodeNotLike(String value) {
            addCriterion("PG_COM_CODE not like", value, "pgComCode");
            return (Criteria) this;
        }

        public Criteria andPgComCodeIn(List<String> values) {
            addCriterion("PG_COM_CODE in", values, "pgComCode");
            return (Criteria) this;
        }

        public Criteria andPgComCodeNotIn(List<String> values) {
            addCriterion("PG_COM_CODE not in", values, "pgComCode");
            return (Criteria) this;
        }

        public Criteria andPgComCodeBetween(String value1, String value2) {
            addCriterion("PG_COM_CODE between", value1, value2, "pgComCode");
            return (Criteria) this;
        }

        public Criteria andPgComCodeNotBetween(String value1, String value2) {
            addCriterion("PG_COM_CODE not between", value1, value2, "pgComCode");
            return (Criteria) this;
        }

        public Criteria andPgComValueIsNull() {
            addCriterion("PG_COM_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andPgComValueIsNotNull() {
            addCriterion("PG_COM_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andPgComValueEqualTo(String value) {
            addCriterion("PG_COM_VALUE =", value, "pgComValue");
            return (Criteria) this;
        }

        public Criteria andPgComValueNotEqualTo(String value) {
            addCriterion("PG_COM_VALUE <>", value, "pgComValue");
            return (Criteria) this;
        }

        public Criteria andPgComValueGreaterThan(String value) {
            addCriterion("PG_COM_VALUE >", value, "pgComValue");
            return (Criteria) this;
        }

        public Criteria andPgComValueGreaterThanOrEqualTo(String value) {
            addCriterion("PG_COM_VALUE >=", value, "pgComValue");
            return (Criteria) this;
        }

        public Criteria andPgComValueLessThan(String value) {
            addCriterion("PG_COM_VALUE <", value, "pgComValue");
            return (Criteria) this;
        }

        public Criteria andPgComValueLessThanOrEqualTo(String value) {
            addCriterion("PG_COM_VALUE <=", value, "pgComValue");
            return (Criteria) this;
        }

        public Criteria andPgComValueLike(String value) {
            addCriterion("PG_COM_VALUE like", value, "pgComValue");
            return (Criteria) this;
        }

        public Criteria andPgComValueNotLike(String value) {
            addCriterion("PG_COM_VALUE not like", value, "pgComValue");
            return (Criteria) this;
        }

        public Criteria andPgComValueIn(List<String> values) {
            addCriterion("PG_COM_VALUE in", values, "pgComValue");
            return (Criteria) this;
        }

        public Criteria andPgComValueNotIn(List<String> values) {
            addCriterion("PG_COM_VALUE not in", values, "pgComValue");
            return (Criteria) this;
        }

        public Criteria andPgComValueBetween(String value1, String value2) {
            addCriterion("PG_COM_VALUE between", value1, value2, "pgComValue");
            return (Criteria) this;
        }

        public Criteria andPgComValueNotBetween(String value1, String value2) {
            addCriterion("PG_COM_VALUE not between", value1, value2, "pgComValue");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("CREATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("CREATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("CREATE_USER =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("CREATE_USER <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("CREATE_USER >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("CREATE_USER <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("CREATE_USER like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("CREATE_USER not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("CREATE_USER in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("CREATE_USER not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("CREATE_USER between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andChangeUserIsNull() {
            addCriterion("CHANGE_USER is null");
            return (Criteria) this;
        }

        public Criteria andChangeUserIsNotNull() {
            addCriterion("CHANGE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andChangeUserEqualTo(String value) {
            addCriterion("CHANGE_USER =", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserNotEqualTo(String value) {
            addCriterion("CHANGE_USER <>", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserGreaterThan(String value) {
            addCriterion("CHANGE_USER >", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserGreaterThanOrEqualTo(String value) {
            addCriterion("CHANGE_USER >=", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserLessThan(String value) {
            addCriterion("CHANGE_USER <", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserLessThanOrEqualTo(String value) {
            addCriterion("CHANGE_USER <=", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserLike(String value) {
            addCriterion("CHANGE_USER like", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserNotLike(String value) {
            addCriterion("CHANGE_USER not like", value, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserIn(List<String> values) {
            addCriterion("CHANGE_USER in", values, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserNotIn(List<String> values) {
            addCriterion("CHANGE_USER not in", values, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserBetween(String value1, String value2) {
            addCriterion("CHANGE_USER between", value1, value2, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeUserNotBetween(String value1, String value2) {
            addCriterion("CHANGE_USER not between", value1, value2, "changeUser");
            return (Criteria) this;
        }

        public Criteria andChangeDateIsNull() {
            addCriterion("CHANGE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andChangeDateIsNotNull() {
            addCriterion("CHANGE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andChangeDateEqualTo(Date value) {
            addCriterion("CHANGE_DATE =", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateNotEqualTo(Date value) {
            addCriterion("CHANGE_DATE <>", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateGreaterThan(Date value) {
            addCriterion("CHANGE_DATE >", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CHANGE_DATE >=", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateLessThan(Date value) {
            addCriterion("CHANGE_DATE <", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateLessThanOrEqualTo(Date value) {
            addCriterion("CHANGE_DATE <=", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateIn(List<Date> values) {
            addCriterion("CHANGE_DATE in", values, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateNotIn(List<Date> values) {
            addCriterion("CHANGE_DATE not in", values, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateBetween(Date value1, Date value2) {
            addCriterion("CHANGE_DATE between", value1, value2, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateNotBetween(Date value1, Date value2) {
            addCriterion("CHANGE_DATE not between", value1, value2, "changeDate");
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