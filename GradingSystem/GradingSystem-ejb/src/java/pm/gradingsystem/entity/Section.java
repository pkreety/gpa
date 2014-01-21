/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.gradingsystem.entity;

import GPASystem_misc.SectionPeriod;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;



/**
 * 
 * @author Prakriti
 */
@Entity
public class Section  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne  
    private Course course;
    @OneToOne  
    private IUser faculty;
    @OneToMany
    private List<IUser> students=new ArrayList<>();
    private SectionPeriod sp;
    private String section_name;

   
    
   public IUser getFaculty() {
        return faculty;
    }

    public void setFaculty(IUser faculty) {
        this.faculty = faculty;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public int getDatetime() {
        return datetime;
    }

    public void setDatetime(int datetime) {
        this.datetime = datetime;
    }
  
   
    private int datetime;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<IUser> getStudents() {
        return students;
    }

    public void setStudents(List<IUser> students) {
        this.students = students;
    }
   

    public SectionPeriod getSp() {
        return sp;
    }

    public void setSp(SectionPeriod sp) {
        this.sp = sp;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Section)) {
            return false;
        }
        Section other = (Section) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GPASystem_entities.Professor[ id=" + id + " ]";
    }

}
