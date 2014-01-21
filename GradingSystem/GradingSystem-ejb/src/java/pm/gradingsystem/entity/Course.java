/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.gradingsystem.entity;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author Prakriti
 */
@Entity
public class Course {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String coursename;
    @OneToMany(mappedBy = "course" )
    private List<Section> sections= new ArrayList<>();
    private String course_code;
    private int credit;

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getCoursename() {
        return coursename;
    }

    public String getCourse_code() {
        return course_code;
    }

    public int getCredit() {
        return credit;
    }

    public Course() {
    }

    public Course(String coursename, String course_code, int credit) {
        this.coursename = coursename;
        this.course_code = course_code;
        this.credit = credit;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GPASystem_entities.Course[ id=" + id + " ]";
    }

}
