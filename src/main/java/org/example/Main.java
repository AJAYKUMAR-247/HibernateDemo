package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.Queue;

//By default java don't have a cache mechanism, But hibernate will give you that cache mechanism
//Caching basically means if you're executing the same query which you have executed before then it will not get all the data from the DB, because it will take some data from the cache
//cache will store the data, which are queried in that particular session
public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = new Student();

        OneToOne oto = new OneToOne();
        oto.setName("OneToone");
        oto.setOtoid(1);

        Laptop lap = new Laptop();
        lap.setBrand("ASUS");
        lap.setModal("Rog");
        lap.setPrice(50000);

        // Here s1 have two things, that's called OneToMany & ManyToOne.
        OneToMany otm1 = new OneToMany();
        otm1.setName("one");
        otm1.setRollno(1);
        otm1.setStu(s1);

        OneToMany otm2 = new OneToMany();
        otm2.setRollno(2);
        otm2.setName("two");
        otm2.setStu(s1);

        ManyToMany mtm1 = new ManyToMany();
        mtm1.setName("many1");
        mtm1.setRollno(1);
        mtm1.setStudents(Arrays.asList(s1, s2));

        ManyToMany mtm2 = new ManyToMany();
        mtm2.setRollno(2);
        mtm2.setName("Many1");
        mtm2.setStudents(Arrays.asList(s1, s2));

        s1.setRollno(1);
        s1.setName("Ajay");
        s1.setMarks(99);
        s1.setLaptop(lap);
        s1.setOneToOne(oto);
        s1.setOneToMany(Arrays.asList(otm1, otm2));
        s1.setManyTOMany(Arrays.asList(mtm1, mtm2));
        System.out.println(s1);

        s2.setRollno(2);
        s2.setName("Kumar");
        s2.setMarks(100);
        s2.setLaptop(lap);
        s2.setOneToOne(oto);
        s2.setOneToMany(Arrays.asList(otm1, otm2));
        s2.setManyTOMany(Arrays.asList(mtm1, mtm2));
        System.out.println(s2);

        // To configure the java code to a DB using hibernate, hibernate is providing a class called Configuration.
        Configuration cfg = new Configuration();


        // The Student class should be annotated, so that hibernate will use that
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(OneToMany.class);
        cfg.addAnnotatedClass(OneToOne.class);
        cfg.addAnnotatedClass(OneToMany.class);

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
        session.persist(otm1);
        session.persist(otm2);
        session.persist(mtm1);
        session.persist(mtm2);


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

        //Alternative of get is load, what is the diff is get is EAGER, and load is Lazy.
        //But load is a deprecated, the alternative is
        //This will also works like Lazy, will only execute the query when we're using that.
        Student stu2 = session.byId(Student.class).getReference(2);

        // To get the details from the DB using HQL,
        Query<Student> query = session.createQuery("from Student where id = 1", Student.class);
        Student stu3 = query.getSingleResult();
        System.out.println(stu3);

        //Prepared Statememt in HQL

        String stuName = "Ajay";

        // Use question mark like, as we're using commonly for the prepared statement, but you have to mention the ?along with the id, and you have to set the parameter
        Query<Student> query1 = session.createQuery("from Student where name=?1");
        query1.setParameter(1, stuName);
        Student name = query1.getSingleResult();

        System.out.println(name);


        session.remove(stu);
        session.close();
        sf.close();
    }
}