package com.company;

public class SplittedParameters {
    public String name;
    public String value;

    public SplittedParameters(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public SplittedParameters() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
