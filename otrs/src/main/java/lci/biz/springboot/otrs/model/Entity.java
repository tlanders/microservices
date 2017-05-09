package lci.biz.springboot.otrs.model;

/**
 * Created by tlanders on 5/8/2017.
 */
public abstract class Entity<T> {
    protected T id;
    protected String name;

    public T getId() {
        return id;
    }

    public Entity(T id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
