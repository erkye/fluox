package cn.fluoxetine.frontdesk.pojo;

import java.io.Serializable;

public class FtbSubjectQuestion implements Serializable {
    private Integer id;

    private Integer subjectId;

    private String question;

    private Integer optionA;

    private Integer optionB;

    private Integer optionC;

    private Integer optionD;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public Integer getOptionA() {
        return optionA;
    }

    public void setOptionA(Integer optionA) {
        this.optionA = optionA;
    }

    public Integer getOptionB() {
        return optionB;
    }

    public void setOptionB(Integer optionB) {
        this.optionB = optionB;
    }

    public Integer getOptionC() {
        return optionC;
    }

    public void setOptionC(Integer optionC) {
        this.optionC = optionC;
    }

    public Integer getOptionD() {
        return optionD;
    }

    public void setOptionD(Integer optionD) {
        this.optionD = optionD;
    }
}