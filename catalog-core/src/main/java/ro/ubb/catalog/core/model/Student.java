package ro.ubb.catalog.core.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="students")

public class Student extends BaseEntity<Long>{

    @Column(name="firsname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    private int grade;



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }




    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grade=" + grade +
                ", id=" + id +
                '}';
    }
}
