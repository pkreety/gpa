/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.gradingsystem.entity;
import java.io.Serializable;
//import java.sql.Date;
//import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

/**
 * 
 * @author Prakriti
 */
@Entity
public class Grade implements Serializable  {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private IUser student_id;
     @OneToOne
    private Section section;
    private float gpa;
    
  //  @Temporal(TemporalType.Date)
//    @Temporal(javax.persistence.TemporalType.DATE)
//    Date datetime;
//
//    public Date getDatetime() {
//        return datetime;
//    }
//
//    public void setDatetime(Date datetime) {
//        this.datetime = datetime;
//    }
    
//    @Transient
//    Date datetime;
//
//    public Date getDatetime() {
//        return datetime;
//    }
//
//    public void setDatetime(Date datetime) {
//        this.datetime = datetime;
//    }
    public IUser getStudent_id() {
        return student_id;
    }

    public void setStudent_id(IUser student_id) {
        this.student_id = student_id;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
   
    public int getId() {
        return id;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
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
        if (!(object instanceof Grade)) {
            return false;
        }
        Grade other = (Grade) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GPASystem_entities.Grade[ id=" + id + " ]";
    }

}