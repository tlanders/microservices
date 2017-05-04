package lci.biz.springboot.model;

import java.util.List;

/**
 * Created by tlanders on 5/3/2017.
 */
public class Calculation {
    private String function;
    private List<String> input;
    private List<String> output;

    public Calculation(String function, List<String> input, List<String> output) {
        this.function = function;
        this.input = input;
        this.output = output;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public List<String> getInput() {
        return input;
    }

    public void setInput(List<String> input) {
        this.input = input;
    }

    public List<String> getOutput() {
        return output;
    }

    public void setOutput(List<String> output) {
        this.output = output;
    }
}
