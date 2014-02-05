/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GPASystem_Services;

//import GPASystem_entities.Course;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pm.gradingsystem.entity.Course;

/**
 *
 * @author Prakriti
 */
@Stateless
@LocalBean
//@DeclareRoles({"HR", "salesDpt"})
//@RolesAllowed({"user", "employee", "admin"})
public class CourseService {

    @PersistenceContext
    private EntityManager em;

    //@RolesAllowed("salesDpt")
    public void makeCourse(Course course) {
        em.persist(course);
    }

    public List<Course> getAllCourses() {
        return em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    public Course findCourse(int id) {
        return em.find(Course.class, id);
    }

    public void UpdateFinal(Course course) {
        em.merge(course);
    }

    public void deleteCourse(Course course) {
        Course cour = em.find(Course.class, course.getId());
        em.remove(cour);
    }
}
