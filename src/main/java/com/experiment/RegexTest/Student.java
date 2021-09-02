package com.experiment.RegexTest;

public class Student {

    private String name;

    private String fullName;

    private String contactNo;

    private String emailId;

    private String salary;

    public Student(String name, String fullName, String contactNo,
                   String emailId, String salary) {
        this.name = name;
        this.fullName = fullName;
        this.contactNo = contactNo;
        this.emailId = emailId;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", emailId='" + emailId + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
