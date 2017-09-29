package com.yha.designPattern.behavioral.memento;

/**
 * @author www
 * @Description: 备忘录类
 * @create 2017/9/29
 */
public class Memento {

    private String name;
    private String value;

    public Memento(String name, String value) {
        this.name = name;
        this.value = value;
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
