package org.api.friend.model;


import lombok.*;


public class Friend {
    //TODO LOMBOK DONT WORK???!
    private String name;
    private Integer age;
    private Integer priority;
    private String hobby;

    public Friend(String name, Integer age, Integer priority, String hobby) {
        this.name = name;
        this.age = age;
        this.priority = priority;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public Integer getPriority() {
        return priority;
    }

    public Integer getAge() {
        return age;
    }

    public String getHobby() {
        return hobby;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", priority=" + priority +
                ", hobby='" + hobby + '\'' +
                '}';
    }


}

