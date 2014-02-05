/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GPASystem_Services;

//import GPASystem_entities.Section;
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
import pm.gradingsystem.entity.Course;
import pm.gradingsystem.entity.Course_;
import pm.gradingsystem.entity.Grade;
import pm.gradingsystem.entity.Section;
import pm.gradingsystem.entity.Section_;
import pm.gradingsystem.entity.IUser;
import pm.gradingsystem.entity.IUser_;

/**
 *
 * @author Prakriti
 */
@Stateless
@LocalBean
public class SectionService {

    @PersistenceContext
    EntityManager em;

    public void makeSection(Section section) {
        em.persist(section);
    }

    public void deleteSection(long i) {
        Section section = em.find(Section.class, i);
        em.remove(section);
    }

    public void updateIt(Section section) {
        em.merge(section);
    }

    public Section getSection(long i) {
        return em.find(Section.class, i);
    }

    public List<Section> getSectionList() {
        return em.createQuery("Select s from Section s").getResultList();
    }

    public List<Section> findSectionByCourse(Course course) {
//        TypedQuery<Section> query=em.createQuery("Select s from Section s WHERE s.course:= course",Section.class);
//        query.setParameter("course", course);
//        
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criQuery = builder.createQuery(Section.class);
        Root<Section> root = criQuery.from(Section.class);
        Join<Section, Course> join = root.join(Section_.course);
        criQuery.where(builder.equal(join.get(Course_.id), course.getId()));
        TypedQuery<Section> query = em.createQuery(criQuery);
        List<Section> sections = query.getResultList();
        return sections;
    }

    public List<Section> findSectionById(long id) {
        TypedQuery<Section> query = em.createQuery("Select s from Section s WHERE s.id:= id", Section.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Section> findSectionByFaculty(IUser user) {
//        TypedQuery<Section> query = em.createQuery("SELECT s FROM Section s JOIN s.students t WHERE t.username= : username", Section.class);
//        query.setParameter("username", user.getUsername());
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criQuery = builder.createQuery(Section.class);
        Root<Section> root = criQuery.from(Section.class);
        Join<Section, IUser> join = root.join(Section_.faculty);
        criQuery.where(builder.equal(join.get(IUser_.username), user.getUsername()));
        TypedQuery<Section> query = em.createQuery(criQuery);
        List<Section> sections = query.getResultList();
        return sections;
    }

    public List<Grade> findTransactions() {
        return em.createQuery("Select g from Grade g", Grade.class).getResultList();
    }
}
