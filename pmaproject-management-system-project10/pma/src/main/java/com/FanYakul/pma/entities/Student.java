package com.FanYakul.pma.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq",sequenceName = "student_seq",allocationSize = 1)
    private long studentId;

    @NotBlank(message = "*姓名不可以为空")
    @Size(min = 2,max = 50, message = "*姓名长度必须大于2")
    private String name;

    @NotBlank(message = "*微信号不可以为空")
    @Size(min = 1,max = 50, message = "*微信号长度必须大于2")
    private String wechatId;

    @NotBlank(message = "*电子邮箱不可以为空")
    @Email(message = "*必须提供合法电子邮箱")
    private String email;

    @ManyToMany(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST},
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "project_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;

    public Student() {
    }

    public Student(String name, String wechatId, String email) {
        this.name = name;
        this.wechatId = wechatId;
        this.email = email;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", wechatId='" + wechatId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
