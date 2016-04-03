package com.se.model.academic.grants;

import java.io.Serializable;

/**
 * Created by Catalin on 03-Apr-16.
 */
public class Grant implements Serializable {

    private int id;

    private String name;

    private float sum;

    public Grant(int id, String name, float sum) {
        this.id = id;
        this.name = name;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Grant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sum=" + sum +
                '}';
    }
}
