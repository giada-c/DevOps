package ch.supsi.assignment2.model;

import javax.persistence.*;

@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private float grade;

    private int course;

    public Exam(float grade, int courseId) {
        this.grade = grade;
        this.course = courseId;
    }

    public Exam() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int courseId) {
        this.course = courseId;
    }
}
