/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GPASystem_Services;

//import GPASystem_entities.Course;
//import GPASystem_entities.Faculty;
//import GPASystem_entities.IUser;
//import GPASystem_entities.Section;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import pm.gradingsystem.entity.Grade;
import pm.gradingsystem.entity.Grade_;
import pm.gradingsystem.entity.IUser;
import pm.gradingsystem.entity.Section;
import pm.gradingsystem.entity.Section_;

/**
 *
 * @author pkhanal
 */
@Stateless
@LocalBean
public class FacultyService {
    @PersistenceContext
    private EntityManager em;
 //   Faculty faculty=new Faculty();

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public IUser findFaculty(int id){
       return em.find(IUser.class,id);
   } 

   
    public List<Section> getSectionList(IUser faculty) {
      TypedQuery<Section> query= em.createQuery("SELECT c FROM Section c where c.faculty.id=:id", Section.class);
          return query.setParameter("id", faculty.getId()).getResultList();
      // return null;
    }

    public void saveGrade(Grade grade){
//                float p = 4f;
//                p.divide(2f); 
//                BigDecimal bd = new BigDecimal("4.0");
//                bd.divide(new BigDecimal(p));
               em.persist(grade);
           }
    

    public Grade findgrade(Section section, IUser student) {
//       TypedQuery<Grade> query= em.createQuery("SELECT g FROM Grade g INNER JOIN g.section s INNER JOIN g.student_id i WHERE s.id = :section AND i.id=:stud",Grade.class);
//       query.setParameter("section", section.getId() );
//       query.setParameter("stud", student.getId());
        Grade foundedgrade=null;
         CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Grade> criQuery = builder.createQuery(Grade.class);
        Root<Grade> root = criQuery.from(Grade.class);
        Join<Grade, Section> join=root.join(Grade_.section);
        criQuery.where(builder.equal(join.get(Section_.id), section.getId()));
        TypedQuery<Grade> query=em.createQuery(criQuery);
        List<Grade> grades=query.getResultList();
        for(Grade grade:grades) {
        if(grade.getStudent_id().equals(student)) {
            return grade;
       
        }
        }return null;
      //  return foundedgrade;
//       int x = query.getFirstResult();
//       if(x == 0)
//           return null;
//       return query.getSingleResult();
    }

    public void edit(Grade gradenew) {
       em.merge(gradenew);
    }
    
   public List<Grade> getGradeForReport(IUser user){
       TypedQuery<Grade> query= em.createQuery("SELECT c FROM Grade c where c.student_id.id=:id", Grade.class);
          return query.setParameter("id", user.getId()).getResultList();
   }
}
