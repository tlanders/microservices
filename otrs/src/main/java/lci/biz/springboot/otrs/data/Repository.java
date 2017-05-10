package lci.biz.springboot.otrs.data;

/**
 * Created by tlanders on 5/9/2017.
 */
public interface Repository<TE, T> extends ReadOnlyRepository<TE, T> {
    void add(TE entity);
    void remove(T id);
    void update(TE entity);
}
