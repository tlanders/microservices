package lci.biz.springboot.otrs.data;

import lci.biz.springboot.otrs.model.Entity;
import lci.biz.springboot.otrs.model.Restaurant;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * Created by tlanders on 5/9/2017.
 */
@org.springframework.stereotype.Repository("restaurantRepository")
public class InMemRestaurantRepository implements RestaurantRepository {
    protected Map<String, Restaurant> restaurantMap = new HashMap<>();

    public InMemRestaurantRepository() {
        restaurantMap.put("1", new Restaurant("1", "Cafe One"));
        restaurantMap.put("2", new Restaurant("2", "Diner Two"));
    }

    @Override
    public void add(Restaurant entity) {
        restaurantMap.put(entity.getId(), entity);
    }

    @Override
    public void remove(String id) {
        restaurantMap.remove(id);
    }

    @Override
    public void update(Restaurant entity) {
        if(entity != null && restaurantMap.containsKey(entity.getId())) {
            restaurantMap.put(entity.getId(), entity);
        }
    }

    @Override
    public boolean contains(String id) {
        return restaurantMap.containsKey(id);
    }

    @Override
    public Restaurant get(String id) {
        return restaurantMap.get(id);
    }

    @Override
    public boolean containsName(String name) {
        try {
            return findByName(name).size() > 0;
        } catch(Exception ex) {
            return false;
        }
    }

    @Override
    public Collection<Restaurant> getAll() {
        return restaurantMap.values();
    }

    @Override
    public Collection<Restaurant> findByName(String name) throws Exception {
        List<Restaurant> restaurants = new ArrayList<>();
        String searchName = name.toLowerCase();
        restaurantMap.forEach((id, r) -> {
            if(r.getName().toLowerCase().contains(searchName)) {
                restaurants.add(r);
            }
        });
        return restaurants;
    }
}
