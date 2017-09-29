package com.yha.designPattern.behavioral.state;

/**
 * @author www
 * @Description: 上下文类，负责状态切换和动作的执行
 * @create 2017/9/29
 */
public class Context {

    private State state;

    public State getState() {
        return state;
    }

    public void action(){
        state.operation();
    }

    public void setState(State state) {
        this.state = state;
    }

    public Context(State state) {

        this.state = state;
    }

    public static void main(String[] args){

        //初始状态为正常状态
        State state = new StateB();
        Context person = new Context(state);
        person.action();

        //变为饮酒状态
        state = new StateA();
        person.setState(state);
        person.action();
    }
}
