package lci.biz.springboot.otrs.data;

import lci.biz.springboot.otrs.model.Restaurant;

import java.util.Collection;

/**
 * Created by tlanders on 5/9/2017.
 */
public interface RestaurantRepository extends Repository<Restaurant, String> {
    boolean containsName(String name);
    Collection<Restaurant> findByName(String name) throws Exception;
}
