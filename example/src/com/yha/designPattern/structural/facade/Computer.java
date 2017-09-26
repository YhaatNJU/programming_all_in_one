package com.yha.designPattern.structural.facade;

/**
 * @author yha
 * @decription 门面类
 * @create 2017-09-26 16:34
 **/
public class Computer {

    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer() {
        cpu = new CPU();
        memory = new Memory();
        disk = new Disk();
    }

    public void startup(){
        System.out.println("Begin to start the computer.");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("Start computer finished.");
    }

    public void shutdown(){
        System.out.println("Begin to close the computer.");
        cpu.shotdown();
        memory.shotdown();
        disk.shotdown();
        System.out.println("The computer closed.");
    }

    public static void main(String[] args){

        Computer computer = new Computer();
        computer.startup();

        computer.shutdown();
    }
}
