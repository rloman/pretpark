package eu.qnh.pretpark.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Attraction implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int capacity;
    private double length;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}