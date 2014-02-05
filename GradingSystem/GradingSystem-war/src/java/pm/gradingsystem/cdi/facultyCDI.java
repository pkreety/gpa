/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.gradingsystem.cdi;

import GPASystem_Services.FacultyService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import pm.gradingsystem.entity.IUser;
import pm.gradingsystem.entity.Section;

/**
 *
 * @author Prakriti
 */
public class facultyCDI {
   private IUser faculty;
   private List<Section> sections=new ArrayList<>();
   @EJB
   FacultyService facultyEJB;
    @Inject
    private SessionCDI session; 
   
    public IUser getFaculty() {
        return faculty;
    }

    public void setFaculty(IUser faculty) {
        this.faculty = faculty;
    }

    public List<Section> getSections() {
   //     faculty=session.getUser();
        System.out.println("faculty is"+faculty.getFirstname());
  //      setSections(facultyEJB.getSectionList(faculty));
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
   
}
