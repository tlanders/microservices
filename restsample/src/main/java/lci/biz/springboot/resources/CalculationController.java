package lci.biz.springboot.resources;

import lci.biz.springboot.model.Calculation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tlanders on 5/3/2017.
 */
@RestController
@RequestMapping("/calculation")
public class CalculationController {
    private static final String PATTERN = "^-?+\\d+\\.?+\\d*$";

    @RequestMapping(value = "/power", method = RequestMethod.GET)
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

    @RequestMapping(value = "/sqrt/{num:.+}", method = RequestMethod.GET)
    public Calculation sqrt(@PathVariable(value = "num") String num) {
        List<String> input = new ArrayList<>();
        input.add(num);

        List<String> output = new ArrayList<>();
        if(num != null  && num.matches(PATTERN)) {
            try {
                output.add(String.valueOf(Math.sqrt(Double.valueOf(num))));
            } catch(Exception ex) {
                output.add("num is negative");
            }
        } else {
            output.add("num is not numeric");
        }
        return new Calculation("sqrt", input, output);
    }
}
