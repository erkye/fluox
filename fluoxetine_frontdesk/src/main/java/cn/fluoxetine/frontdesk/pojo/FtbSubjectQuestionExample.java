package cn.fluoxetine.frontdesk.pojo;

import java.util.ArrayList;
import java.util.List;

public class FtbSubjectQuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FtbSubjectQuestionExample() {
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

        public Criteria andSubjectIdIsNull() {
            addCriterion("subject_id is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNotNull() {
            addCriterion("subject_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdEqualTo(Integer value) {
            addCriterion("subject_id =", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotEqualTo(Integer value) {
            addCriterion("subject_id <>", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThan(Integer value) {
            addCriterion("subject_id >", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("subject_id >=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThan(Integer value) {
            addCriterion("subject_id <", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("subject_id <=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIn(List<Integer> values) {
            addCriterion("subject_id in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotIn(List<Integer> values) {
            addCriterion("subject_id not in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdBetween(Integer value1, Integer value2) {
            addCriterion("subject_id between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("subject_id not between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNull() {
            addCriterion("question is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNotNull() {
            addCriterion("question is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionEqualTo(String value) {
            addCriterion("question =", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotEqualTo(String value) {
            addCriterion("question <>", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThan(String value) {
            addCriterion("question >", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("question >=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThan(String value) {
            addCriterion("question <", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThanOrEqualTo(String value) {
            addCriterion("question <=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLike(String value) {
            addCriterion("question like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotLike(String value) {
            addCriterion("question not like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionIn(List<String> values) {
            addCriterion("question in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotIn(List<String> values) {
            addCriterion("question not in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionBetween(String value1, String value2) {
            addCriterion("question between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotBetween(String value1, String value2) {
            addCriterion("question not between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andOptionAIsNull() {
            addCriterion("option_A is null");
            return (Criteria) this;
        }

        public Criteria andOptionAIsNotNull() {
            addCriterion("option_A is not null");
            return (Criteria) this;
        }

        public Criteria andOptionAEqualTo(Integer value) {
            addCriterion("option_A =", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionANotEqualTo(Integer value) {
            addCriterion("option_A <>", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionAGreaterThan(Integer value) {
            addCriterion("option_A >", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionAGreaterThanOrEqualTo(Integer value) {
            addCriterion("option_A >=", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionALessThan(Integer value) {
            addCriterion("option_A <", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionALessThanOrEqualTo(Integer value) {
            addCriterion("option_A <=", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionAIn(List<Integer> values) {
            addCriterion("option_A in", values, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionANotIn(List<Integer> values) {
            addCriterion("option_A not in", values, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionABetween(Integer value1, Integer value2) {
            addCriterion("option_A between", value1, value2, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionANotBetween(Integer value1, Integer value2) {
            addCriterion("option_A not between", value1, value2, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionBIsNull() {
            addCriterion("option_B is null");
            return (Criteria) this;
        }

        public Criteria andOptionBIsNotNull() {
            addCriterion("option_B is not null");
            return (Criteria) this;
        }

        public Criteria andOptionBEqualTo(Integer value) {
            addCriterion("option_B =", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBNotEqualTo(Integer value) {
            addCriterion("option_B <>", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBGreaterThan(Integer value) {
            addCriterion("option_B >", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBGreaterThanOrEqualTo(Integer value) {
            addCriterion("option_B >=", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBLessThan(Integer value) {
            addCriterion("option_B <", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBLessThanOrEqualTo(Integer value) {
            addCriterion("option_B <=", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBIn(List<Integer> values) {
            addCriterion("option_B in", values, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBNotIn(List<Integer> values) {
            addCriterion("option_B not in", values, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBBetween(Integer value1, Integer value2) {
            addCriterion("option_B between", value1, value2, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBNotBetween(Integer value1, Integer value2) {
            addCriterion("option_B not between", value1, value2, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionCIsNull() {
            addCriterion("option_C is null");
            return (Criteria) this;
        }

        public Criteria andOptionCIsNotNull() {
            addCriterion("option_C is not null");
            return (Criteria) this;
        }

        public Criteria andOptionCEqualTo(Integer value) {
            addCriterion("option_C =", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCNotEqualTo(Integer value) {
            addCriterion("option_C <>", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCGreaterThan(Integer value) {
            addCriterion("option_C >", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCGreaterThanOrEqualTo(Integer value) {
            addCriterion("option_C >=", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCLessThan(Integer value) {
            addCriterion("option_C <", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCLessThanOrEqualTo(Integer value) {
            addCriterion("option_C <=", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCIn(List<Integer> values) {
            addCriterion("option_C in", values, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCNotIn(List<Integer> values) {
            addCriterion("option_C not in", values, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCBetween(Integer value1, Integer value2) {
            addCriterion("option_C between", value1, value2, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCNotBetween(Integer value1, Integer value2) {
            addCriterion("option_C not between", value1, value2, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionDIsNull() {
            addCriterion("option_D is null");
            return (Criteria) this;
        }

        public Criteria andOptionDIsNotNull() {
            addCriterion("option_D is not null");
            return (Criteria) this;
        }

        public Criteria andOptionDEqualTo(Integer value) {
            addCriterion("option_D =", value, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDNotEqualTo(Integer value) {
            addCriterion("option_D <>", value, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDGreaterThan(Integer value) {
            addCriterion("option_D >", value, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDGreaterThanOrEqualTo(Integer value) {
            addCriterion("option_D >=", value, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDLessThan(Integer value) {
            addCriterion("option_D <", value, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDLessThanOrEqualTo(Integer value) {
            addCriterion("option_D <=", value, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDIn(List<Integer> values) {
            addCriterion("option_D in", values, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDNotIn(List<Integer> values) {
            addCriterion("option_D not in", values, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDBetween(Integer value1, Integer value2) {
            addCriterion("option_D between", value1, value2, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDNotBetween(Integer value1, Integer value2) {
            addCriterion("option_D not between", value1, value2, "optionD");
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