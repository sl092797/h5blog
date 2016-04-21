package com.victor.h5blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VideoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VideoExample() {
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

        public Criteria andVideoIdIsNull() {
            addCriterion("video_id is null");
            return (Criteria) this;
        }

        public Criteria andVideoIdIsNotNull() {
            addCriterion("video_id is not null");
            return (Criteria) this;
        }

        public Criteria andVideoIdEqualTo(Long value) {
            addCriterion("video_id =", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotEqualTo(Long value) {
            addCriterion("video_id <>", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdGreaterThan(Long value) {
            addCriterion("video_id >", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("video_id >=", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLessThan(Long value) {
            addCriterion("video_id <", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLessThanOrEqualTo(Long value) {
            addCriterion("video_id <=", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdIn(List<Long> values) {
            addCriterion("video_id in", values, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotIn(List<Long> values) {
            addCriterion("video_id not in", values, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdBetween(Long value1, Long value2) {
            addCriterion("video_id between", value1, value2, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotBetween(Long value1, Long value2) {
            addCriterion("video_id not between", value1, value2, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoNameIsNull() {
            addCriterion("video_name is null");
            return (Criteria) this;
        }

        public Criteria andVideoNameIsNotNull() {
            addCriterion("video_name is not null");
            return (Criteria) this;
        }

        public Criteria andVideoNameEqualTo(String value) {
            addCriterion("video_name =", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotEqualTo(String value) {
            addCriterion("video_name <>", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameGreaterThan(String value) {
            addCriterion("video_name >", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameGreaterThanOrEqualTo(String value) {
            addCriterion("video_name >=", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameLessThan(String value) {
            addCriterion("video_name <", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameLessThanOrEqualTo(String value) {
            addCriterion("video_name <=", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameLike(String value) {
            addCriterion("video_name like", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotLike(String value) {
            addCriterion("video_name not like", value, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameIn(List<String> values) {
            addCriterion("video_name in", values, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotIn(List<String> values) {
            addCriterion("video_name not in", values, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameBetween(String value1, String value2) {
            addCriterion("video_name between", value1, value2, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoNameNotBetween(String value1, String value2) {
            addCriterion("video_name not between", value1, value2, "videoName");
            return (Criteria) this;
        }

        public Criteria andVideoDescIsNull() {
            addCriterion("video_desc is null");
            return (Criteria) this;
        }

        public Criteria andVideoDescIsNotNull() {
            addCriterion("video_desc is not null");
            return (Criteria) this;
        }

        public Criteria andVideoDescEqualTo(String value) {
            addCriterion("video_desc =", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescNotEqualTo(String value) {
            addCriterion("video_desc <>", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescGreaterThan(String value) {
            addCriterion("video_desc >", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescGreaterThanOrEqualTo(String value) {
            addCriterion("video_desc >=", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescLessThan(String value) {
            addCriterion("video_desc <", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescLessThanOrEqualTo(String value) {
            addCriterion("video_desc <=", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescLike(String value) {
            addCriterion("video_desc like", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescNotLike(String value) {
            addCriterion("video_desc not like", value, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescIn(List<String> values) {
            addCriterion("video_desc in", values, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescNotIn(List<String> values) {
            addCriterion("video_desc not in", values, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescBetween(String value1, String value2) {
            addCriterion("video_desc between", value1, value2, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoDescNotBetween(String value1, String value2) {
            addCriterion("video_desc not between", value1, value2, "videoDesc");
            return (Criteria) this;
        }

        public Criteria andVideoTagIsNull() {
            addCriterion("video_tag is null");
            return (Criteria) this;
        }

        public Criteria andVideoTagIsNotNull() {
            addCriterion("video_tag is not null");
            return (Criteria) this;
        }

        public Criteria andVideoTagEqualTo(String value) {
            addCriterion("video_tag =", value, "videoTag");
            return (Criteria) this;
        }

        public Criteria andVideoTagNotEqualTo(String value) {
            addCriterion("video_tag <>", value, "videoTag");
            return (Criteria) this;
        }

        public Criteria andVideoTagGreaterThan(String value) {
            addCriterion("video_tag >", value, "videoTag");
            return (Criteria) this;
        }

        public Criteria andVideoTagGreaterThanOrEqualTo(String value) {
            addCriterion("video_tag >=", value, "videoTag");
            return (Criteria) this;
        }

        public Criteria andVideoTagLessThan(String value) {
            addCriterion("video_tag <", value, "videoTag");
            return (Criteria) this;
        }

        public Criteria andVideoTagLessThanOrEqualTo(String value) {
            addCriterion("video_tag <=", value, "videoTag");
            return (Criteria) this;
        }

        public Criteria andVideoTagLike(String value) {
            addCriterion("video_tag like", value, "videoTag");
            return (Criteria) this;
        }

        public Criteria andVideoTagNotLike(String value) {
            addCriterion("video_tag not like", value, "videoTag");
            return (Criteria) this;
        }

        public Criteria andVideoTagIn(List<String> values) {
            addCriterion("video_tag in", values, "videoTag");
            return (Criteria) this;
        }

        public Criteria andVideoTagNotIn(List<String> values) {
            addCriterion("video_tag not in", values, "videoTag");
            return (Criteria) this;
        }

        public Criteria andVideoTagBetween(String value1, String value2) {
            addCriterion("video_tag between", value1, value2, "videoTag");
            return (Criteria) this;
        }

        public Criteria andVideoTagNotBetween(String value1, String value2) {
            addCriterion("video_tag not between", value1, value2, "videoTag");
            return (Criteria) this;
        }

        public Criteria andVideoPosterpathIsNull() {
            addCriterion("video_posterPath is null");
            return (Criteria) this;
        }

        public Criteria andVideoPosterpathIsNotNull() {
            addCriterion("video_posterPath is not null");
            return (Criteria) this;
        }

        public Criteria andVideoPosterpathEqualTo(String value) {
            addCriterion("video_posterPath =", value, "videoPosterpath");
            return (Criteria) this;
        }

        public Criteria andVideoPosterpathNotEqualTo(String value) {
            addCriterion("video_posterPath <>", value, "videoPosterpath");
            return (Criteria) this;
        }

        public Criteria andVideoPosterpathGreaterThan(String value) {
            addCriterion("video_posterPath >", value, "videoPosterpath");
            return (Criteria) this;
        }

        public Criteria andVideoPosterpathGreaterThanOrEqualTo(String value) {
            addCriterion("video_posterPath >=", value, "videoPosterpath");
            return (Criteria) this;
        }

        public Criteria andVideoPosterpathLessThan(String value) {
            addCriterion("video_posterPath <", value, "videoPosterpath");
            return (Criteria) this;
        }

        public Criteria andVideoPosterpathLessThanOrEqualTo(String value) {
            addCriterion("video_posterPath <=", value, "videoPosterpath");
            return (Criteria) this;
        }

        public Criteria andVideoPosterpathLike(String value) {
            addCriterion("video_posterPath like", value, "videoPosterpath");
            return (Criteria) this;
        }

        public Criteria andVideoPosterpathNotLike(String value) {
            addCriterion("video_posterPath not like", value, "videoPosterpath");
            return (Criteria) this;
        }

        public Criteria andVideoPosterpathIn(List<String> values) {
            addCriterion("video_posterPath in", values, "videoPosterpath");
            return (Criteria) this;
        }

        public Criteria andVideoPosterpathNotIn(List<String> values) {
            addCriterion("video_posterPath not in", values, "videoPosterpath");
            return (Criteria) this;
        }

        public Criteria andVideoPosterpathBetween(String value1, String value2) {
            addCriterion("video_posterPath between", value1, value2, "videoPosterpath");
            return (Criteria) this;
        }

        public Criteria andVideoPosterpathNotBetween(String value1, String value2) {
            addCriterion("video_posterPath not between", value1, value2, "videoPosterpath");
            return (Criteria) this;
        }

        public Criteria andVideoOriginalpathIsNull() {
            addCriterion("video_originalPath is null");
            return (Criteria) this;
        }

        public Criteria andVideoOriginalpathIsNotNull() {
            addCriterion("video_originalPath is not null");
            return (Criteria) this;
        }

        public Criteria andVideoOriginalpathEqualTo(String value) {
            addCriterion("video_originalPath =", value, "videoOriginalpath");
            return (Criteria) this;
        }

        public Criteria andVideoOriginalpathNotEqualTo(String value) {
            addCriterion("video_originalPath <>", value, "videoOriginalpath");
            return (Criteria) this;
        }

        public Criteria andVideoOriginalpathGreaterThan(String value) {
            addCriterion("video_originalPath >", value, "videoOriginalpath");
            return (Criteria) this;
        }

        public Criteria andVideoOriginalpathGreaterThanOrEqualTo(String value) {
            addCriterion("video_originalPath >=", value, "videoOriginalpath");
            return (Criteria) this;
        }

        public Criteria andVideoOriginalpathLessThan(String value) {
            addCriterion("video_originalPath <", value, "videoOriginalpath");
            return (Criteria) this;
        }

        public Criteria andVideoOriginalpathLessThanOrEqualTo(String value) {
            addCriterion("video_originalPath <=", value, "videoOriginalpath");
            return (Criteria) this;
        }

        public Criteria andVideoOriginalpathLike(String value) {
            addCriterion("video_originalPath like", value, "videoOriginalpath");
            return (Criteria) this;
        }

        public Criteria andVideoOriginalpathNotLike(String value) {
            addCriterion("video_originalPath not like", value, "videoOriginalpath");
            return (Criteria) this;
        }

        public Criteria andVideoOriginalpathIn(List<String> values) {
            addCriterion("video_originalPath in", values, "videoOriginalpath");
            return (Criteria) this;
        }

        public Criteria andVideoOriginalpathNotIn(List<String> values) {
            addCriterion("video_originalPath not in", values, "videoOriginalpath");
            return (Criteria) this;
        }

        public Criteria andVideoOriginalpathBetween(String value1, String value2) {
            addCriterion("video_originalPath between", value1, value2, "videoOriginalpath");
            return (Criteria) this;
        }

        public Criteria andVideoOriginalpathNotBetween(String value1, String value2) {
            addCriterion("video_originalPath not between", value1, value2, "videoOriginalpath");
            return (Criteria) this;
        }

        public Criteria andVideoCompressedpathIsNull() {
            addCriterion("video_compressedPath is null");
            return (Criteria) this;
        }

        public Criteria andVideoCompressedpathIsNotNull() {
            addCriterion("video_compressedPath is not null");
            return (Criteria) this;
        }

        public Criteria andVideoCompressedpathEqualTo(String value) {
            addCriterion("video_compressedPath =", value, "videoCompressedpath");
            return (Criteria) this;
        }

        public Criteria andVideoCompressedpathNotEqualTo(String value) {
            addCriterion("video_compressedPath <>", value, "videoCompressedpath");
            return (Criteria) this;
        }

        public Criteria andVideoCompressedpathGreaterThan(String value) {
            addCriterion("video_compressedPath >", value, "videoCompressedpath");
            return (Criteria) this;
        }

        public Criteria andVideoCompressedpathGreaterThanOrEqualTo(String value) {
            addCriterion("video_compressedPath >=", value, "videoCompressedpath");
            return (Criteria) this;
        }

        public Criteria andVideoCompressedpathLessThan(String value) {
            addCriterion("video_compressedPath <", value, "videoCompressedpath");
            return (Criteria) this;
        }

        public Criteria andVideoCompressedpathLessThanOrEqualTo(String value) {
            addCriterion("video_compressedPath <=", value, "videoCompressedpath");
            return (Criteria) this;
        }

        public Criteria andVideoCompressedpathLike(String value) {
            addCriterion("video_compressedPath like", value, "videoCompressedpath");
            return (Criteria) this;
        }

        public Criteria andVideoCompressedpathNotLike(String value) {
            addCriterion("video_compressedPath not like", value, "videoCompressedpath");
            return (Criteria) this;
        }

        public Criteria andVideoCompressedpathIn(List<String> values) {
            addCriterion("video_compressedPath in", values, "videoCompressedpath");
            return (Criteria) this;
        }

        public Criteria andVideoCompressedpathNotIn(List<String> values) {
            addCriterion("video_compressedPath not in", values, "videoCompressedpath");
            return (Criteria) this;
        }

        public Criteria andVideoCompressedpathBetween(String value1, String value2) {
            addCriterion("video_compressedPath between", value1, value2, "videoCompressedpath");
            return (Criteria) this;
        }

        public Criteria andVideoCompressedpathNotBetween(String value1, String value2) {
            addCriterion("video_compressedPath not between", value1, value2, "videoCompressedpath");
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