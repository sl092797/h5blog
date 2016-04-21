package com.victor.h5blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhotoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PhotoExample() {
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

        public Criteria andPhotoIdIsNull() {
            addCriterion("photo_id is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIdIsNotNull() {
            addCriterion("photo_id is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoIdEqualTo(Long value) {
            addCriterion("photo_id =", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotEqualTo(Long value) {
            addCriterion("photo_id <>", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdGreaterThan(Long value) {
            addCriterion("photo_id >", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("photo_id >=", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdLessThan(Long value) {
            addCriterion("photo_id <", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdLessThanOrEqualTo(Long value) {
            addCriterion("photo_id <=", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdIn(List<Long> values) {
            addCriterion("photo_id in", values, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotIn(List<Long> values) {
            addCriterion("photo_id not in", values, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdBetween(Long value1, Long value2) {
            addCriterion("photo_id between", value1, value2, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotBetween(Long value1, Long value2) {
            addCriterion("photo_id not between", value1, value2, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoNameIsNull() {
            addCriterion("photo_name is null");
            return (Criteria) this;
        }

        public Criteria andPhotoNameIsNotNull() {
            addCriterion("photo_name is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoNameEqualTo(String value) {
            addCriterion("photo_name =", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotEqualTo(String value) {
            addCriterion("photo_name <>", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameGreaterThan(String value) {
            addCriterion("photo_name >", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameGreaterThanOrEqualTo(String value) {
            addCriterion("photo_name >=", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameLessThan(String value) {
            addCriterion("photo_name <", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameLessThanOrEqualTo(String value) {
            addCriterion("photo_name <=", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameLike(String value) {
            addCriterion("photo_name like", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotLike(String value) {
            addCriterion("photo_name not like", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameIn(List<String> values) {
            addCriterion("photo_name in", values, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotIn(List<String> values) {
            addCriterion("photo_name not in", values, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameBetween(String value1, String value2) {
            addCriterion("photo_name between", value1, value2, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotBetween(String value1, String value2) {
            addCriterion("photo_name not between", value1, value2, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoDescIsNull() {
            addCriterion("photo_desc is null");
            return (Criteria) this;
        }

        public Criteria andPhotoDescIsNotNull() {
            addCriterion("photo_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoDescEqualTo(String value) {
            addCriterion("photo_desc =", value, "photoDesc");
            return (Criteria) this;
        }

        public Criteria andPhotoDescNotEqualTo(String value) {
            addCriterion("photo_desc <>", value, "photoDesc");
            return (Criteria) this;
        }

        public Criteria andPhotoDescGreaterThan(String value) {
            addCriterion("photo_desc >", value, "photoDesc");
            return (Criteria) this;
        }

        public Criteria andPhotoDescGreaterThanOrEqualTo(String value) {
            addCriterion("photo_desc >=", value, "photoDesc");
            return (Criteria) this;
        }

        public Criteria andPhotoDescLessThan(String value) {
            addCriterion("photo_desc <", value, "photoDesc");
            return (Criteria) this;
        }

        public Criteria andPhotoDescLessThanOrEqualTo(String value) {
            addCriterion("photo_desc <=", value, "photoDesc");
            return (Criteria) this;
        }

        public Criteria andPhotoDescLike(String value) {
            addCriterion("photo_desc like", value, "photoDesc");
            return (Criteria) this;
        }

        public Criteria andPhotoDescNotLike(String value) {
            addCriterion("photo_desc not like", value, "photoDesc");
            return (Criteria) this;
        }

        public Criteria andPhotoDescIn(List<String> values) {
            addCriterion("photo_desc in", values, "photoDesc");
            return (Criteria) this;
        }

        public Criteria andPhotoDescNotIn(List<String> values) {
            addCriterion("photo_desc not in", values, "photoDesc");
            return (Criteria) this;
        }

        public Criteria andPhotoDescBetween(String value1, String value2) {
            addCriterion("photo_desc between", value1, value2, "photoDesc");
            return (Criteria) this;
        }

        public Criteria andPhotoDescNotBetween(String value1, String value2) {
            addCriterion("photo_desc not between", value1, value2, "photoDesc");
            return (Criteria) this;
        }

        public Criteria andPhotoPathIsNull() {
            addCriterion("photo_path is null");
            return (Criteria) this;
        }

        public Criteria andPhotoPathIsNotNull() {
            addCriterion("photo_path is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoPathEqualTo(String value) {
            addCriterion("photo_path =", value, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathNotEqualTo(String value) {
            addCriterion("photo_path <>", value, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathGreaterThan(String value) {
            addCriterion("photo_path >", value, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathGreaterThanOrEqualTo(String value) {
            addCriterion("photo_path >=", value, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathLessThan(String value) {
            addCriterion("photo_path <", value, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathLessThanOrEqualTo(String value) {
            addCriterion("photo_path <=", value, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathLike(String value) {
            addCriterion("photo_path like", value, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathNotLike(String value) {
            addCriterion("photo_path not like", value, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathIn(List<String> values) {
            addCriterion("photo_path in", values, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathNotIn(List<String> values) {
            addCriterion("photo_path not in", values, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathBetween(String value1, String value2) {
            addCriterion("photo_path between", value1, value2, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathNotBetween(String value1, String value2) {
            addCriterion("photo_path not between", value1, value2, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoTagIsNull() {
            addCriterion("photo_tag is null");
            return (Criteria) this;
        }

        public Criteria andPhotoTagIsNotNull() {
            addCriterion("photo_tag is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoTagEqualTo(String value) {
            addCriterion("photo_tag =", value, "photoTag");
            return (Criteria) this;
        }

        public Criteria andPhotoTagNotEqualTo(String value) {
            addCriterion("photo_tag <>", value, "photoTag");
            return (Criteria) this;
        }

        public Criteria andPhotoTagGreaterThan(String value) {
            addCriterion("photo_tag >", value, "photoTag");
            return (Criteria) this;
        }

        public Criteria andPhotoTagGreaterThanOrEqualTo(String value) {
            addCriterion("photo_tag >=", value, "photoTag");
            return (Criteria) this;
        }

        public Criteria andPhotoTagLessThan(String value) {
            addCriterion("photo_tag <", value, "photoTag");
            return (Criteria) this;
        }

        public Criteria andPhotoTagLessThanOrEqualTo(String value) {
            addCriterion("photo_tag <=", value, "photoTag");
            return (Criteria) this;
        }

        public Criteria andPhotoTagLike(String value) {
            addCriterion("photo_tag like", value, "photoTag");
            return (Criteria) this;
        }

        public Criteria andPhotoTagNotLike(String value) {
            addCriterion("photo_tag not like", value, "photoTag");
            return (Criteria) this;
        }

        public Criteria andPhotoTagIn(List<String> values) {
            addCriterion("photo_tag in", values, "photoTag");
            return (Criteria) this;
        }

        public Criteria andPhotoTagNotIn(List<String> values) {
            addCriterion("photo_tag not in", values, "photoTag");
            return (Criteria) this;
        }

        public Criteria andPhotoTagBetween(String value1, String value2) {
            addCriterion("photo_tag between", value1, value2, "photoTag");
            return (Criteria) this;
        }

        public Criteria andPhotoTagNotBetween(String value1, String value2) {
            addCriterion("photo_tag not between", value1, value2, "photoTag");
            return (Criteria) this;
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