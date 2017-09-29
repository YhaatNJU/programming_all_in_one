package com.yha.designPattern.behavioral.state;

/**
 * @author www
 * @Description: 状态B(正常状态)
 * @create 2017/9/29
 */
public class StateB implements State{

    @Override
    public void operation() {
        System.out.println("我没有饮酒，可以开车回家。");
    }
}
