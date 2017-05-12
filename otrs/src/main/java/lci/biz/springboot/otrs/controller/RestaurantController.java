package lci.biz.springboot.otrs.controller;

import lci.biz.springboot.otrs.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
