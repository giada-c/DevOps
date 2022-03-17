package ch.supsi.assignment2.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    @OneToMany(mappedBy = "course")
    private List<Exam> exams;

    public Course(String name, Set<Student> studentSet, List<Exam> examList) {
        this.name = name;
        this.students = studentSet;
        this.exams = examList;
    }

    public Course() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> studentSet) {
        this.students = studentSet;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> examList) {
        this.exams = examList;
    }
}
