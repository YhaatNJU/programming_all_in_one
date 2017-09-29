package com.yha.designPattern.behavioral.state;

/**
 * @author www
 * @Description: A状态(醉酒状态)
 * @create 2017/9/29
 */
public class StateA implements State {

    @Override
    public void operation() {
        System.out.println("我喝酒了，我只能步行回家。");
    }
}
