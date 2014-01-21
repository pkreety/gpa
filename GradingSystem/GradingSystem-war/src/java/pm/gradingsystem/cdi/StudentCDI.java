/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.gradingsystem.cdi;

import GPASystem_Services.StudentService;
//import GPASystem_entities.Student;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import pm.gradingsystem.entity.Student;

/**
 * 
 * @author Prakriti
 */
@Named
@RequestScoped
public class StudentCDI {
private Student student;
   @EJB
   private StudentService studentservice;
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
 public String createStudent(){
     studentservice.makeStudent(student);
     return "result";
 }
}
