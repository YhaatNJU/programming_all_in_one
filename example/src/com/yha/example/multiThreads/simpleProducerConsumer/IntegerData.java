package com.yha.example.multiThreads.simpleProducerConsumer;

/**
 * @author yha
 * @decription 生产者和消费者之间传递的数据，使用不变模式实现
 * @create 2017-10-04 12:10
 **/
public final class IntegerData {
    private final int intData;
    public IntegerData(int intData) {
        this.intData = intData;
    }

    @Override
    public String toString() {
        return "data:" + intData;
    }

    public int getIntData() {
        return intData;
    }
}
