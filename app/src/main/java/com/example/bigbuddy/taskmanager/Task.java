package com.example.bigbuddy.taskmanager;

/**
 * Created by trong on 10/15/2016.
 */

public class Task {
    private String name;
    private int timeWork;
    private int timeBreak;
    private int times;

    public Task( String name, int timeWork, int timeBreak, int times) {
        this.name = name;
        this.timeWork = timeWork;
        this.timeBreak = timeBreak;
        this.times = times;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(int timeWork) {
        this.timeWork = timeWork;
    }

    public int getTimeBreak() {
        return timeBreak;
    }

    public void setTimeBreak(int timeBreak) {
        this.timeBreak = timeBreak;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
