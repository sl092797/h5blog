package com.victor.h5blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogExample() {
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

        public Criteria andBlogIdIsNull() {
            addCriterion("blog_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNotNull() {
            addCriterion("blog_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogIdEqualTo(Long value) {
            addCriterion("blog_id =", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotEqualTo(Long value) {
            addCriterion("blog_id <>", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThan(Long value) {
            addCriterion("blog_id >", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("blog_id >=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThan(Long value) {
            addCriterion("blog_id <", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThanOrEqualTo(Long value) {
            addCriterion("blog_id <=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdIn(List<Long> values) {
            addCriterion("blog_id in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotIn(List<Long> values) {
            addCriterion("blog_id not in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdBetween(Long value1, Long value2) {
            addCriterion("blog_id between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotBetween(Long value1, Long value2) {
            addCriterion("blog_id not between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogNameIsNull() {
            addCriterion("blog_name is null");
            return (Criteria) this;
        }

        public Criteria andBlogNameIsNotNull() {
            addCriterion("blog_name is not null");
            return (Criteria) this;
        }

        public Criteria andBlogNameEqualTo(String value) {
            addCriterion("blog_name =", value, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameNotEqualTo(String value) {
            addCriterion("blog_name <>", value, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameGreaterThan(String value) {
            addCriterion("blog_name >", value, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameGreaterThanOrEqualTo(String value) {
            addCriterion("blog_name >=", value, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameLessThan(String value) {
            addCriterion("blog_name <", value, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameLessThanOrEqualTo(String value) {
            addCriterion("blog_name <=", value, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameLike(String value) {
            addCriterion("blog_name like", value, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameNotLike(String value) {
            addCriterion("blog_name not like", value, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameIn(List<String> values) {
            addCriterion("blog_name in", values, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameNotIn(List<String> values) {
            addCriterion("blog_name not in", values, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameBetween(String value1, String value2) {
            addCriterion("blog_name between", value1, value2, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameNotBetween(String value1, String value2) {
            addCriterion("blog_name not between", value1, value2, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogDescIsNull() {
            addCriterion("blog_desc is null");
            return (Criteria) this;
        }

        public Criteria andBlogDescIsNotNull() {
            addCriterion("blog_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBlogDescEqualTo(String value) {
            addCriterion("blog_desc =", value, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescNotEqualTo(String value) {
            addCriterion("blog_desc <>", value, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescGreaterThan(String value) {
            addCriterion("blog_desc >", value, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescGreaterThanOrEqualTo(String value) {
            addCriterion("blog_desc >=", value, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescLessThan(String value) {
            addCriterion("blog_desc <", value, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescLessThanOrEqualTo(String value) {
            addCriterion("blog_desc <=", value, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescLike(String value) {
            addCriterion("blog_desc like", value, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescNotLike(String value) {
            addCriterion("blog_desc not like", value, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescIn(List<String> values) {
            addCriterion("blog_desc in", values, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescNotIn(List<String> values) {
            addCriterion("blog_desc not in", values, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescBetween(String value1, String value2) {
            addCriterion("blog_desc between", value1, value2, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescNotBetween(String value1, String value2) {
            addCriterion("blog_desc not between", value1, value2, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogTagIsNull() {
            addCriterion("blog_tag is null");
            return (Criteria) this;
        }

        public Criteria andBlogTagIsNotNull() {
            addCriterion("blog_tag is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTagEqualTo(String value) {
            addCriterion("blog_tag =", value, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagNotEqualTo(String value) {
            addCriterion("blog_tag <>", value, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagGreaterThan(String value) {
            addCriterion("blog_tag >", value, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagGreaterThanOrEqualTo(String value) {
            addCriterion("blog_tag >=", value, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagLessThan(String value) {
            addCriterion("blog_tag <", value, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagLessThanOrEqualTo(String value) {
            addCriterion("blog_tag <=", value, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagLike(String value) {
            addCriterion("blog_tag like", value, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagNotLike(String value) {
            addCriterion("blog_tag not like", value, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagIn(List<String> values) {
            addCriterion("blog_tag in", values, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagNotIn(List<String> values) {
            addCriterion("blog_tag not in", values, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagBetween(String value1, String value2) {
            addCriterion("blog_tag between", value1, value2, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogTagNotBetween(String value1, String value2) {
            addCriterion("blog_tag not between", value1, value2, "blogTag");
            return (Criteria) this;
        }

        public Criteria andBlogCheckIsNull() {
            addCriterion("blog_check is null");
            return (Criteria) this;
        }

        public Criteria andBlogCheckIsNotNull() {
            addCriterion("blog_check is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCheckEqualTo(Byte value) {
            addCriterion("blog_check =", value, "blogCheck");
            return (Criteria) this;
        }

        public Criteria andBlogCheckNotEqualTo(Byte value) {
            addCriterion("blog_check <>", value, "blogCheck");
            return (Criteria) this;
        }

        public Criteria andBlogCheckGreaterThan(Byte value) {
            addCriterion("blog_check >", value, "blogCheck");
            return (Criteria) this;
        }

        public Criteria andBlogCheckGreaterThanOrEqualTo(Byte value) {
            addCriterion("blog_check >=", value, "blogCheck");
            return (Criteria) this;
        }

        public Criteria andBlogCheckLessThan(Byte value) {
            addCriterion("blog_check <", value, "blogCheck");
            return (Criteria) this;
        }

        public Criteria andBlogCheckLessThanOrEqualTo(Byte value) {
            addCriterion("blog_check <=", value, "blogCheck");
            return (Criteria) this;
        }

        public Criteria andBlogCheckIn(List<Byte> values) {
            addCriterion("blog_check in", values, "blogCheck");
            return (Criteria) this;
        }

        public Criteria andBlogCheckNotIn(List<Byte> values) {
            addCriterion("blog_check not in", values, "blogCheck");
            return (Criteria) this;
        }

        public Criteria andBlogCheckBetween(Byte value1, Byte value2) {
            addCriterion("blog_check between", value1, value2, "blogCheck");
            return (Criteria) this;
        }

        public Criteria andBlogCheckNotBetween(Byte value1, Byte value2) {
            addCriterion("blog_check not between", value1, value2, "blogCheck");
            return (Criteria) this;
        }

        public Criteria andBlogStatusIsNull() {
            addCriterion("blog_status is null");
            return (Criteria) this;
        }

        public Criteria andBlogStatusIsNotNull() {
            addCriterion("blog_status is not null");
            return (Criteria) this;
        }

        public Criteria andBlogStatusEqualTo(Byte value) {
            addCriterion("blog_status =", value, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogStatusNotEqualTo(Byte value) {
            addCriterion("blog_status <>", value, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogStatusGreaterThan(Byte value) {
            addCriterion("blog_status >", value, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("blog_status >=", value, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogStatusLessThan(Byte value) {
            addCriterion("blog_status <", value, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogStatusLessThanOrEqualTo(Byte value) {
            addCriterion("blog_status <=", value, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogStatusIn(List<Byte> values) {
            addCriterion("blog_status in", values, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogStatusNotIn(List<Byte> values) {
            addCriterion("blog_status not in", values, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogStatusBetween(Byte value1, Byte value2) {
            addCriterion("blog_status between", value1, value2, "blogStatus");
            return (Criteria) this;
        }

        public Criteria andBlogStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("blog_status not between", value1, value2, "blogStatus");
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