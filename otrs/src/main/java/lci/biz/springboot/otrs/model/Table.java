package lci.biz.springboot.otrs.model;

import java.math.BigInteger;

/**
 * Created by tlanders on 5/8/2017.
 */
public class Table extends Entity<BigInteger> {
    protected int capacity;

    public Table(BigInteger id, String name) {
        super(id, name);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", isModified='" + isModified + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
