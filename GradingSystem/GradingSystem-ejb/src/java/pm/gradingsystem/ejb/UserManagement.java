/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.gradingsystem.ejb;

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
import pm.gradingsystem.entity.IUser;
import pm.gradingsystem.entity.IUser_;
import pm.gradingsystem.entity.Role;
import pm.gradingsystem.entity.Role_;
import pm.gradingsystem.entity.Section;
import pm.gradingsystem.entity.Section_;

/**
 *
 * @author Tahmasebi
 */
@Stateless
@LocalBean
public class UserManagement {

    @PersistenceContext
    private EntityManager em;

    public List<IUser> findStd() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criQuery = builder.createQuery(IUser.class);
        Root<IUser> root = criQuery.from(IUser.class);
        Join<IUser, Role> join = root.join(IUser_.roles);
        criQuery.where(builder.equal(join.get(Role_.name), "Student"));
        TypedQuery<IUser> query = em.createQuery(criQuery);
        List<IUser> students = query.getResultList();
        return students;
    }

    public IUser find(String username, String password) {
        TypedQuery<IUser> query = em.createQuery("SELECT u FROM IUser u WHERE u.username = :username AND u.password = :password", IUser.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getSingleResult();
    }

    public IUser findByUserCode(String username, int securityCode) {
        TypedQuery<IUser> query = em.createQuery("SELECT u FROM IUser u WHERE u.username = :username AND u.securityCode = :securityCode", IUser.class);
        query.setParameter("username", username);
        query.setParameter("securityCode", securityCode);
        return query.getSingleResult();
    }

    public Role findRoles(int id) {
        TypedQuery<Role> query = em.createQuery("SELECT u FROM Role u WHERE u.id = :id", Role.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public IUser getUser(int id) {
        IUser user = em.find(IUser.class, id);
        return user;
    }

    public List<Section> findUserInfoById(IUser user) {
//        TypedQuery<Section> query = em.createQuery("SELECT s FROM Section s JOIN s.students t WHERE t.username= : username", Section.class);
//        query.setParameter("username", user.getUsername());
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criQuery = builder.createQuery(Section.class);
        Root<Section> root = criQuery.from(Section.class);
        Join<Section, IUser> join = root.join(Section_.students);
        criQuery.where(builder.equal(join.get(IUser_.username), user.getUsername()));
        TypedQuery<Section> query = em.createQuery(criQuery);
        List<Section> sections = query.getResultList();
        return sections;
    }

    public void create(IUser user) {
        em.persist(user);
    }

    public List<IUser> getUsers() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<IUser> criQuery = builder.createQuery(IUser.class);
        Root<IUser> root = criQuery.from(IUser.class);
        criQuery.select(root);
        TypedQuery<IUser> query = em.createQuery(criQuery);
        List<IUser> users = query.getResultList();
        return users;
    }

    public void update(IUser edituser) {
        //user = em.find(IUser.class, user.getId());
        em.merge(edituser);
    }

    public void delete(int id) {
        IUser foundUser = em.find(IUser.class, id);
        em.remove(foundUser);
    }
}
