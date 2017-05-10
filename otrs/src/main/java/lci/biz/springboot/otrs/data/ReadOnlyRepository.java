package lci.biz.springboot.otrs.data;

import lci.biz.springboot.otrs.model.Entity;

import java.util.Collection;

/**
 * Created by tlanders on 5/9/2017.
 */
public interface ReadOnlyRepository<TE, T> {
    boolean contains(T id);
    Entity get(T id);
    Collection<TE> getAll();
}
