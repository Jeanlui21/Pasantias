package com.example.jeanlui21.bizlinksgto;

public class Task {

    private Integer id;

    private String taskname;

    private String taskdesc;

    private String state;

    private String evidence;

    public Task() {
    }


    public Task(Integer id, String taskname, String taskdesc, String state, String evidence) {
        this.id = id;
        this.taskname = taskname;
        this.taskdesc = taskdesc;
        this.state = state;
        this.evidence = evidence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskdesc() {
        return taskdesc;
    }

    public void setTaskdesc(String taskdesc) {
        this.taskdesc = taskdesc;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", taskname='" + taskname + '\'' +
                ", taskdesc='" + taskdesc + '\'' +
                ", state='" + state + '\'' +
                ", evidence='" + evidence + '\'' +
                '}';
    }
}