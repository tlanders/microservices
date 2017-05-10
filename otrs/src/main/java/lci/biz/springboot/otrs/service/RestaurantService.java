package lci.biz.springboot.otrs.service;

import lci.biz.springboot.otrs.model.Restaurant;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by tlanders on 5/9/2017.
 */
public interface RestaurantService {
    void add(Restaurant r) throws Exception;
    void update(Restaurant r) throws Exception;
    void delete(String id) throws Exception;
    Restaurant findById(String name) throws Exception;
    Collection<Restaurant> findByName(String name) throws Exception;
    Collection<Restaurant> findByCriteria(Map<String, List<String>> name) throws Exception;
}
