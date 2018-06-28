package ru.otus.hm1.domain;


public class Student {
    private String name;
    private String surname;
    private int result;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Студент " + name + " " + surname + "," + "Вы дали " + result + " верных ответов из 5";
    }
}
