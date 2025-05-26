package org.example;

import jakarta.persistence.*;

import javax.management.ObjectName;


// We have to add the @Entity annotation to the class, so that hibernate will use this class to create a entity(table)
@Entity
// If you want to change the entity name --> use @Entity(name="newName")

// If you want to change only the table name, not the entity name then use
@Table(name = "newName")
public class Student {

    @Id // Each entity should have a primaryKey
    private int rollno;

    // If you want ot change the column name
    @Column(name = "studentname")
    private String name;

    // @Transient is used to stop saving the field into the DB, it will be useful when you want some fields for processing but really don't want to save.
    @Transient
    private int marks;

    private Laptop laptop;

    // Means the each student will have a only one relationship with the OnetoOne obj
    @jakarta.persistence.OneToOne
    private OneToOne oneToOne;

    public OneToOne getOneToOne() {
        return oneToOne;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", laptop=" + laptop +
                ", oneToOne=" + oneToOne +
                '}';
    }

    public void setOneToOne(OneToOne oneToOne) {
        this.oneToOne = oneToOne;
    }


    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
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

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

}
