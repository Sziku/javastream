package org.example;

public class Person {

    private String id;
    private String firstName;
    private String secondName;
    private Integer age;

    public Person(String id, String firstName, String secondName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
