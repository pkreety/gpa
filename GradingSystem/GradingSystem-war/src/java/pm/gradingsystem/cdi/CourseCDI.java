/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.gradingsystem.cdi;

import GPASystem_Services.CourseService;
//import GPASystem_entities.Course;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import pm.gradingsystem.entity.Course;

/**
 *
 * @author pkhanal
 */
@Named
@RequestScoped
public class CourseCDI {

    private Course course = new Course();
    private List<Course> courses = new ArrayList<>();
    private List<SelectItem> coursesItemList;
    private int courseId;
    @EJB
    private CourseService courseService;

    public List<Course> getCourses() {
        setCourses(courseService.getAllCourses());
      
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * Creates a new instance of CourseCDI
     */
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public CourseCDI() {
    }

    /**
     *
     * @return
     */
    public String makeCourse() {
        courseService.makeCourse(course);
        return "courseManagement";
    }

    public String displaylist() {
        //   courseService.displaylist();
        return "courselist";
    }

    public String updateCourse(int id) {
        this.course = courseService.findCourse(id);
        return "updatePage";
    }

    public String finalUpdate() {
        courseService.UpdateFinal(course);
        return "courseManagement";
    }

    public String deleteCourse() {
        courseService.deleteCourse(course);
        return "courseManagement";
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public List<SelectItem> getCoursesItemList() {
        coursesItemList = new ArrayList<>();
        getCourses();
        for (Course course1 : courses) {
            SelectItem item = new SelectItem(course1.getId(), course1.getCoursename());
            coursesItemList.add(item);
        }
        return coursesItemList;
    }

    public void setCoursesItemList(List<SelectItem> coursesItemList) {
        this.coursesItemList = coursesItemList;
    }
  public void deleteCourse(Course course) {
        String page = "";
        //  this.user = userService.getUser(id);
        courseService.deleteCourse(course);
//        page = "deletepage";
//        return page;
    }
}
