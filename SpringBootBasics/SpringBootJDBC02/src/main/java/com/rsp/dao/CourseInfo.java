package com.rsp.dao;



public class CourseInfo {
    private Integer cid;
    private String cname;

    public CourseInfo(){
        System.out.println("Course info zero param constructor");
    }

    public CourseInfo(Integer cid, String cname){
        this.cid=cid;
        this.cname=cname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
