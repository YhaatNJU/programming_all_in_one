package com.yha.designPattern.structural.bridge;

/**
 * @author yha
 * @decription 链接器基类
 * @create 2017-09-26 16:43
 **/
public abstract class Bridge {

    private SourceInterface source;

    public abstract void method();

    public SourceInterface getSource() {
        return source;
    }

    public void setSource(SourceInterface source) {
        this.source = source;
    }
}
