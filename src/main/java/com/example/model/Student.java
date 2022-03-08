package com.example.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="full_name")
    String fullName;

    Integer course;

    @Column(name="birth_date")
    LocalDate birthDate;

    @OneToOne
    @JoinColumn(name = "id_grant",unique = true,foreignKey = @ForeignKey(name = "fk_student_grant"))
    Grant grant;

    @OneToMany(mappedBy = "student")
    List<Resource> resources= new ArrayList<>();

    @ManyToMany(mappedBy = "students")
    List<Subject> subjects=new ArrayList<>();


    public Student() {
    }

    public Student(Long id, String fullName, Integer course, LocalDate birthDate) {
        this.id = id;
        this.fullName = fullName;
        this.course = course;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Grant getGrant() {
        return grant;
    }

    public void setGrant(Grant grant) {
        this.grant = grant;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", course=" + course +
                ", birthDate=" + birthDate +
                //", grant=" + (grant!=null?grant.getQuantity():"") +
                '}';
    }
}
