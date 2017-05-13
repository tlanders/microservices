package lci.biz.springboot.otrs.service;

import lci.biz.springboot.otrs.data.Repository;
import lci.biz.springboot.otrs.data.RestaurantRepository;
import lci.biz.springboot.otrs.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by tlanders on 5/9/2017.
 */
@Service("restaurantService")
public class RestaurantServiceImpl extends BaseService<Restaurant, String> implements RestaurantService {

    protected RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository repository) {
        super(repository);
        this.restaurantRepository = repository;
    }

    @Override
    public void add(Restaurant r) throws Exception {
        restaurantRepository.add(r);
    }

    @Override
    public void update(Restaurant r) throws Exception {
        restaurantRepository.update(r);
    }

    @Override
    public void delete(String id) throws Exception {
        restaurantRepository.remove(id);
    }

    @Override
    public Restaurant findById(String name) {
        return restaurantRepository.get(name);
    }

    @Override
    public Collection<Restaurant> findByName(String name) throws Exception {
        return restaurantRepository.findByName(name);
    }

    @Override
    public Collection<Restaurant> findByCriteria(Map<String, List<String>> name) throws Exception {
        //TODO
        return null;
    }
}
