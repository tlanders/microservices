package lci.biz.springboot.otrs.service;

import lci.biz.springboot.otrs.data.RestaurantRepository;
import lci.biz.springboot.otrs.model.Restaurant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by tlanders on 5/25/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantServiceTest {
    @MockBean
    protected RestaurantRepository restaurantRepository;

    protected RestaurantService restaurantService;

    @Before
    public void setup() throws Exception {
        List<Restaurant> rl = new ArrayList<>();
        rl.add(new Restaurant("1", "Cafe abc"));
        when(restaurantRepository.findByName("abc")).thenReturn(rl);

        restaurantService = new RestaurantServiceImpl(restaurantRepository);
    }

    @Test
    public void testOne() throws Exception {
        assertThat(restaurantService.findByName("abc")).size().isEqualTo(1);
    }
}
