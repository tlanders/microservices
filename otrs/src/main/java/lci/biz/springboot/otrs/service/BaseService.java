package lci.biz.springboot.otrs.service;

import lci.biz.springboot.otrs.data.Repository;

/**
 * Created by tlanders on 5/9/2017.
 */
public abstract class BaseService<TE, T> {
    protected Repository<TE, T> repository;

    public BaseService(Repository<TE, T> repository) {
        this.repository = repository;
    }

    public TE findById(T id) {
        return repository.get(id);
    }
}
