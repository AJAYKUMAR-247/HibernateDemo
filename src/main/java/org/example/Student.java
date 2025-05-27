package org.example;

import jakarta.persistence.*;

import javax.management.ObjectName;
import java.util.List;


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

    // OneToMany will create a seperate table to store the relation between its and student.
    // If you want to stop that table creation, you can use this (mappedBy = "stu"), this indicates that the table will be handled and mapped by the
    // stu variable in the OneToMany Entity, this will not create a table.    @jakarta.persistence.OneToMany(mappedBy = "stu")
    @jakarta.persistence.OneToMany
    private List<OneToMany> oneToMany;


    //ManyToMany means students have multiple object and the object will also have multiple student
    //A student can be mapped to many object basically
    //When we use ManyToMany, it will think its job to create a table, so we have to say which one is going to take care of that(mappedBy = "students")
    @jakarta.persistence.ManyToMany(mappedBy = "students")
    private List<ManyToMany> manyTOMany;


    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", laptop=" + laptop +
                ", oneToOne=" + oneToOne +
                ", oneToMany=" + oneToMany +
                ", manyTOMany=" + manyTOMany +
                '}';
    }

    public List<ManyToMany> getManyTOMany() {
        return manyTOMany;
    }

    public void setManyTOMany(List<ManyToMany> manyTOMany) {
        this.manyTOMany = manyTOMany;
    }

    public List<OneToMany> getOneToMany() {
        return oneToMany;
    }

    public void setOneToMany(List<OneToMany> oneToMany) {
        this.oneToMany = oneToMany;
    }

    public OneToOne getOneToOne() {
        return oneToOne;
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
