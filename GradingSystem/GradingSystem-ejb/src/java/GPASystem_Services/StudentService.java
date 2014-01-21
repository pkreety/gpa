/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GPASystem_Services;

//import GPASystem_entities.Course;
//import GPASystem_entities.Student;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pm.gradingsystem.entity.Student;

/**
 *
 * @author pkhanal
 */
@Stateless
@LocalBean
public class StudentService {
 @PersistenceContext
    private EntityManager em;
 
 public void makeStudent(Student std){
     em.persist(std);
 }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
