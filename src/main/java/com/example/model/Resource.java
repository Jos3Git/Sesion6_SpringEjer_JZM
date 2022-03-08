package com.example.model;

import javax.persistence.*;

@Entity
@Table(name="resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String description;

    Boolean broken;

    @ManyToOne
    @JoinColumn(name = "id_student")
    Student student;

    public Resource() {
    }

    public Resource(Long id, String description, Boolean broken) {
        this.id = id;
        this.description = description;
        this.broken = broken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getBroken() {
        return broken;
    }

    public void setBroken(Boolean broken) {
        this.broken = broken;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", broken=" + broken +
                ", student=" + student.getId() +
                '}';
    }
}
