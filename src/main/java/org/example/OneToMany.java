package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OneToMany {

    @Id
    private int rollno;
    private String name;

    //This ManyToOne annotation will create a column in this table to map with the student
    @ManyToOne
    private Student stu;

    @Override
    public String toString() {
        return "OneToMany{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", stu=" + stu +
                '}';
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStu(Student s1) {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }
}
