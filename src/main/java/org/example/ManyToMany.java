package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class ManyToMany {
    @Id
    private int rollno;
    private String name;

    @jakarta.persistence.ManyToMany
    private List<Student> students;


    @Override
    public String toString() {
        return "ManyToMany{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", students=" + students +
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


}
