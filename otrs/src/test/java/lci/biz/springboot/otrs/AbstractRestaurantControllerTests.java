package lci.biz.springboot.otrs;

import lci.biz.springboot.otrs.controller.RestaurantController;
import lci.biz.springboot.otrs.model.Restaurant;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.logging.Logger;

/**
 * Created by tlanders on 5/13/2017.
 */
public abstract class AbstractRestaurantControllerTests {
    protected static final String RESTAURANT = "1";
    protected static final String RESTAURANT_NAME = "Big-O Restaurant";

    @Autowired
    protected RestaurantController restaurantController;

    @Test
    public void validRestaurantById() {
        Logger.getGlobal().info("Start validRestaurantById test");

        ResponseEntity<Restaurant> r = restaurantController.get(RESTAURANT);
        Assert.assertEquals(HttpStatus.OK, r.getStatusCode());
        Assert.assertTrue(r.hasBody());
        Assert.assertEquals(RESTAURANT, r.getBody().getId());
    }

    @Test
    public void validRestaurantAdd() {
        Logger.getGlobal().info("Start validRestaurantAdd test");

        Restaurant r = new Restaurant("11", "Diner 11");

        ResponseEntity<Restaurant> response = restaurantController.add(r);
        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assert.assertFalse(response.hasBody());
//        Assert.assertEquals(RESTAURANT, r.getBody().getId());
    }
}
