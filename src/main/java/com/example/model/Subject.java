package com.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String description;

    @ManyToMany
    @JoinTable(name = "rel_subject_student",
            joinColumns=@JoinColumn(name="id_subject",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_student",referencedColumnName ="id")
    )
    List<Student> students=new ArrayList<Student>();

    public Subject() {
    }

    public Subject(Long id, String description) {
        this.id = id;
        this.description = description;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
