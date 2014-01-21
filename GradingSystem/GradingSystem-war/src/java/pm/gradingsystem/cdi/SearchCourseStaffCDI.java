/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.gradingsystem.cdi;

import GPASystem_Services.CourseService;
import GPASystem_Services.SectionService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pm.gradingsystem.ejb.UserManagement;
import pm.gradingsystem.entity.Course;
import pm.gradingsystem.entity.IUser;
import pm.gradingsystem.entity.Section;

/**
 *
 * @author Tahmasebi
 */
@Named
@RequestScoped
public class SearchCourseStaffCDI {

    private IUser user = new IUser();
    @EJB
    private UserManagement userService;
    private List<Section> sections = new ArrayList<>();
    @Inject
    private SessionCDI session;
    private Section section;
    @EJB
    private SectionService sectionService;
    private Course course;
    @EJB
    private CourseService courseservice;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

//    public void setCourse(Course course) {
//        this.course = course;
//    }
    public Section getSection() {
        return section;
    }

    public List<Section> getSections() {
//        user = session.getUser();
//        sections = userService.findUserInfoById(user);
        return sections;
    }

    public String viewSection(long id) {
        section = sectionService.getSection(id);
        return "studentviewsection";
    }

    public void searchCourseById(int id) {
        this.course = courseservice.findCourse(id);
        this.sections = sectionService.findSectionByCourse(course);
    }

    public void searchSectionById(long id) {
        this.section = sectionService.getSection(id);
    }
//
//    public void setSections(List<Section> sections) {
//        this.sections = sections;
//    }
////    public IUser getUser() {
////        return user;
////    }
//
//    public void searchSTDById() {
//        user = session.getUser();
//        sections = userService.findUserInfoById(user);
//    }
}
