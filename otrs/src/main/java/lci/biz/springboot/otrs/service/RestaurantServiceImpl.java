package lci.biz.springboot.otrs.service;

import lci.biz.springboot.otrs.data.Repository;
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

    @Autowired
    public RestaurantServiceImpl(Repository<Restaurant, String> repository) {
        super(repository);
    }

    @Override
    public void add(Restaurant r) throws Exception {
        repository.add(r);
    }

    @Override
    public void update(Restaurant r) throws Exception {
        repository.update(r);
    }

    @Override
    public void delete(String id) throws Exception {
        repository.remove(id);
    }

    @Override
    public Restaurant findById(String name) {
        return repository.get(name);
    }

    @Override
    public Collection<Restaurant> findByName(String name) throws Exception {
        //TODO
        return null;
    }

    @Override
    public Collection<Restaurant> findByCriteria(Map<String, List<String>> name) throws Exception {
        //TODO
        return null;
    }
}
