package com.yha.algorithm.string.sort;

/**
 * @author yha
 * @decription 描述学生分组学习的实体类
 * @create 2017-10-30 21:52
 **/
public class StudentEntity implements IIndex{

    private int key; //分组编号
    private String name; //学习姓名

    public StudentEntity(int key, String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * 获取学生分组编号
     * @return
     */
    public int key(){
        return key;
    }

    /**
     * 获取学生姓名
     * @return
     */
    public String name(){
        return name;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "key=" + key +
                ", name='" + name + '\'' +
                '}';
    }
}
