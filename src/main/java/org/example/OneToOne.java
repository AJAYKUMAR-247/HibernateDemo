package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OneToOne {

    @Id
    private int otoid;
    private String name;

    public int getOtoid() {
        return otoid;
    }

    public void setOtoid(int otoid) {
        this.otoid = otoid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
