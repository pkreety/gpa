/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.gradingsystem.cdi;

//import GPASystem_Services.FacultyService;
import GPASystem_Services.FacultyService;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import javax.inject.Named;
import pm.gradingsystem.entity.Grade;
import pm.gradingsystem.entity.IUser;
import pm.gradingsystem.entity.Section;

@Named
@SessionScoped
public class SectionStudentCDI implements Serializable {

    private float gradept;
   private String gradeMessage;
    private IUser user;

    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }
    public String getGradeMessage() {
        return gradeMessage;
    }

    public void setGradeMessage(String gradeMessage) {
        this.gradeMessage = gradeMessage;
    }
    public void setGradept(float gradept) {
        this.gradept = gradept;
    }
    private Section section;
//    public void setGradept(String gradept) {
//        this.gradept = gradept;
//    }
    @Inject
    SessionCDI session;
    @Inject
    FacultySectionCDI facultyCDI;
    @EJB
    FacultyService facultyEJB;
    private float grade;
    
    

   public Section getSection() {
       return section;
   }

    public void setSection(Section section) {
        this.section = section;
    }
    public float getGradept() {
        return gradept;
    }

//    public void setGradept(String gradept) {
//        this.gradept = gradept;
//    }
//    private List<IUser> students;
    public FacultySectionCDI getFacultyCDI() {
        return facultyCDI;
    }

    public void setFacultyCDI(FacultySectionCDI facultyCDI) {
        this.facultyCDI = facultyCDI;
    }

//    public List<IUser> getStudents() {
//
//          this.section=section;
//        this.students = section.getStudents();
//
//       return "facultysectionstd";
//        return students;
//    }
    public String test() {

        facultyEJB.findgrade(null, null);
        return "result";
    }

    public String saveUser(IUser student) {
        
        System.out.println(gradept);
        Grade gd = new Grade();
        //SimpleDate sdf=new SimpleDateFormat("mm/dd/yyyy");
      //  Date dt = new Date();
      //  sdf.parse(new Date());
        if (facultyEJB.findgrade(facultyCDI.getSection(), student) == null) {
            
              System.out.println("grade" + gradept);
            gd.setGpa(gradept);
            gd.setSection(facultyCDI.getSection());
            gd.setStudent_id(student);
           // gd.setDatetime(dt);
            facultyEJB.saveGrade(gd);
            System.out.println("tfgghuhu  " + gradept);
           gradeMessage= "  Grade Saved ";
        } else {
            Grade g = facultyEJB.findgrade(facultyCDI.getSection(), student);
            g.setGpa(gradept);
          //  g.setDatetime(dt);
            facultyEJB.edit(g);
             gradeMessage= "  Grade Updated";
       }
        return "facultysectionstd";
    }
    public String addGradePage(IUser student){
        this.user=student;
        return "add_editGrade";
    }
    public float getGrade(IUser user) {
         
        if(facultyEJB.findgrade(section, user)!=null)
        {
             return facultyEJB.findgrade(section, user).getGpa();
        }
      
        else
            return 0.0f;
       
      //  return grade;
    }
}
