package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        OneToOne oto = new OneToOne();
        oto.setName("OneToone");
        oto.setOtoid(1);

        Laptop lap = new Laptop();
        lap.setBrand("ASUS");
        lap.setModal("Rog");
        lap.setPrice(50000);

        Student s1 = new Student();
        s1.setRollno(1);
        s1.setName("Ajay");
        s1.setMarks(99);
        s1.setLaptop(lap);
        s1.setOneToOne(oto);
        System.out.println(s1);

        // To configure the java code to a DB using hibernate, hibernate is providing a class called Configuration.
        Configuration cfg = new Configuration();


        // The Student class should be annotated, so that hibernate will use that
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(Student.class);

        //After creating the Configuration obj, configure it.
        //But with which DB, which table it will configure, to give that please add that configuration xml file in the resources
        cfg.configure();

        // SessionFactory is also a interface, so we can't create a object, but the Configuration class is providing a method buildSessionFactory which will give a
        //object of a SessionFactory.
        SessionFactory sf = cfg.buildSessionFactory();

        //We have to store the Session, to do that we have to create a session obj, but session is a interface we can't create a object directly
        //But we can get a session obj from the SessionFactory
        Session session = sf.openSession();//We have to openSession to get the object of the class

        //Transaction is a interface, to get the transaction object use session
        // This Transaction only require,if you're ,manipulating the data means when yoy're  creating, updating and delete. Not necessary when you're reading
        Transaction transaction = session.beginTransaction();

        // After creating the object, using the persist method we can save that.
        session.persist(s1);
        session.persist(oto);

        //Everytime when we're trying to save the data it ia a transaction, so after each transaction we have to commit that otherwise it will not save.
        //commit belongs to transaction
        transaction.commit();

        // To Fetch the saved data
        // To get the data, there is a get method which takes two arguments, the 1st one is return type and the second argument is primary key
        session.get(Student.class, 1);


        // Methods to update the data
        // This method will update the data, if the data is there or else it will insert a new data into the table
        session.merge(s1);

        // Methods to delete the data
        // To delete a data 1st you have to fetch first and then you have to delete it.
        Student stu = session.get(Student.class, 1);
        session.remove(stu);
        session.close();
        sf.close();


    }
}