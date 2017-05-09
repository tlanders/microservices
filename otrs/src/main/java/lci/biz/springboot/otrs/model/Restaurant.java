package lci.biz.springboot.otrs.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tlanders on 5/8/2017.
 */
public class Restaurant extends Entity<String> {
    protected List<Table> tables = new ArrayList<>();

    public Restaurant(String id, String name) {
        super(id, name);
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tables=" + tables +
                '}';
    }
}
