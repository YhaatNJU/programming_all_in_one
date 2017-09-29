package com.yha.designPattern.behavioral.memento;

/**
 * @author www
 * @Description: 用来存储备份数据的类，只能存储，不能修改
 * @create 2017/9/29
 */
public class Storage {

    private Memento memento;

    public Storage(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    public static void main(String[] args){

        //创建原始类
        Original original = new Original("12345","ABCDE");
        //创建备份
        Memento memento = original.getMemento();
        Storage storage = new Storage(memento);

        //修改元素类的信息
        original.setName("54321");
        original.setValue("EDCBA");

        //恢复原始类的状态
        original.restoreMenmeto(storage.getMemento());

        System.out.println(original);


    }
}
