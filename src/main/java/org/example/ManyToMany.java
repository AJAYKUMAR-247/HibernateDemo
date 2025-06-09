package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class ManyToMany {
    @Id
    private int rollno;
    private String name;


    // By default in hibernate, FetchType will be always LAZY (FetchType.LAZY), why because if the stored data is huge then it is waste to Fetch all the data
    // that's why by default it is Lazy, means it will cal the require data whenever we're using it.
    // If you want to Fetch all the details, use FetchType.EAGER
    @jakarta.persistence.ManyToMany(fetch = FetchType.EAGER)
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
