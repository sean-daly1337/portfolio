package com.lit.reactive.systems.designpatternsandlambdas_1.pojos;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    double height;
    boolean citizen;

    public Person(String firstName, String lastName, int age, double height, boolean hasCitizenship) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.citizen = hasCitizenship;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isCitizen() {
        return citizen;
    }

    public void setCitizenship(boolean hasCitizenship) {
        this.citizen = hasCitizenship;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", height=" + height + ", citizen=" + citizen + '}';
    }

}
