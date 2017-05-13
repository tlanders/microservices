package lci.biz.springboot.otrs.controller;

import lci.biz.springboot.otrs.model.Restaurant;
import lci.biz.springboot.otrs.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by tlanders on 5/11/2017.
 */
@RestController
@RequestMapping("/v1/restaurants")
public class RestaurantController {
    protected Logger logger = Logger.getLogger(RestaurantController.class.getName());

    protected RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Restaurant>> findByName(@RequestParam("name") String name) {
        logger.info("findByName, name=" + name);
        Collection<Restaurant> restaurants;
        try {
            restaurants = restaurantService.findByName(name.toLowerCase());
        } catch(Exception ex)  {
            logger.log(Level.SEVERE, "Exception calling findByName, name=" + name, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return (restaurants != null && restaurants.size() > 0)
                ? new ResponseEntity<>(restaurants, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{rId}", method = RequestMethod.GET)
    public ResponseEntity<Restaurant> get(@PathVariable("rId") String rId) {
        logger.info("get, rId=" + rId);
        Restaurant r;
        try {
            r = restaurantService.findById(rId.trim());
        } catch(Exception ex) {
            logger.log(Level.SEVERE, "Exception calling findById, rId=" + rId);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return (r != null)
                ? new ResponseEntity<>(r, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Restaurant> add(@RequestBody Restaurant r) {
        logger.info("add, r=" + r);

        try {
            restaurantService.add(r);
        } catch(Exception ex) {
            logger.log(Level.SEVERE, "Exception calling add, r=" + r);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Restaurant>(HttpStatus.CREATED);
    }
}
