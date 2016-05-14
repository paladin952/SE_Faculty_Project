package com.se.database.dao.model.academic.grants;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="scholarship")
public class ScholarshipVO implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="ScholarshipID")
    private int id;

    @Column(name="Name")
    private String name;

    @Column(name="Award")
    private float sum;

    public ScholarshipVO(int id, String name, float sum) {
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
        return "ScholarshipVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sum=" + sum +
                '}';
    }
}
