package com.yha.designPattern.behavioral.memento;

/**
 * @author www
 * @Description: 原始类文件，被备份的类，包含获取自身备份的方法和从备份中恢复的方法
 * @create 2017/9/29
 */
public class Original {

    private String name;

    private String value;

    public Original(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Memento getMemento(){
        return new Memento(name, value);
    }

    public void restoreMenmeto(Memento memento){
        this.name = memento.getName();
        this.value = memento.getValue();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Original{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
