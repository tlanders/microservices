package lci.biz.springboot.resources;

import lci.biz.springboot.model.Calculation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tlanders on 5/3/2017.
 */
@RestController
@RequestMapping("/calculation")
public class CalculationController {
    private static final String PATTERN = "^-?+\\d+\\.?+\\d*$";

    @RequestMapping("/power")
    public Calculation pow(@RequestParam(value = "base") String b, @RequestParam(value = "exponent") String exp) {
        List<String> input = new ArrayList<>();
        input.add(b);
        input.add(exp);

        List<String> output = new ArrayList<>();
        if(b != null  && exp != null && b.matches(PATTERN) && exp.matches(PATTERN)) {
            output.add(String.valueOf(Math.pow(Double.valueOf(b), Double.valueOf(exp))));
        } else {
            output.add("base and/or exponent are not numeric");
        }
        return new Calculation("power", input, output);
    }
}
