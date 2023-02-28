package org.example;

public class Student extends Person{
    private Integer mathGrade;
    private Integer englishGrade;
    private Integer historyGrade;

    public Student(String id, String firstName, String secondName, Integer age, Integer mathGrade, Integer englishGrade, Integer historyGrade) {
        super(id, firstName, secondName, age);
        this.mathGrade = mathGrade;
        this.englishGrade = englishGrade;
        this.historyGrade = historyGrade;
    }

    public Integer getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(Integer mathGrade) {
        this.mathGrade = mathGrade;
    }

    public Integer getEnglishGrade() {
        return englishGrade;
    }

    public void setEnglishGrade(Integer englishGrade) {
        this.englishGrade = englishGrade;
    }

    public Integer getHistoryGrade() {
        return historyGrade;
    }

    public void setHistoryGrade(Integer historyGrade) {
        this.historyGrade = historyGrade;
    }
}
