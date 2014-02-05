/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GPASystem_Services;

//import GPASystem_entities.IUser;
//import GPASystem_entities.IUser_;
//import GPASystem_entities.Role;
//import GPASystem_entities.Role_;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pm.gradingsystem.entity.IUser;

/**
 *
 * @author pkhanal
 */
@Stateless
@LocalBean
public class UserService {
@PersistenceContext
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     public List<IUser> getAllUsers() {
        return em.createQuery("SELECT c FROM IUser c", IUser.class).getResultList();
    }

    public void createUser(IUser user) {
       em.persist(user);
    }
// new added
    public List<IUser> getFacultyUsers() {
        return em.createQuery("SELECT c FROM IUser c LEFT JOIN c.roles r WHERE r.name='Faculty'", IUser.class).getResultList();
   //   List<IUser> users= em.createQuery("SELECT r FROM Role r WHERE r.id=1",Role.class).getSingleResult().getUsers();
     //   return em.createQuery("SELECT c FROM IUser c", IUser.class).getResultList();
  //     int[] uid=new int[];
//               em.createQuery("SELECT c FROM IUser c", IUser.class).getResultList();
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<IUser> criteriaQuery = builder.createQuery(IUser.class);
//        Root<IUser> user = criteriaQuery.from(IUser.class);
//        Join<IUser, Role> role = user.join(IUser_.roles);
//        criteriaQuery.where(builder.equal(role.get(Role_.name), "Faculty"));
//        
//        return em.createQuery(criteriaQuery).getResultList();
//        String name="Faculty";
//                TypedQuery<IUser> query = em.createQuery(
//        "SELECT c FROM IUser c WHERE c.roles.name = :name", IUser.class);
//    return query.setParameter("Faculty", name).getResultList();
//        "SELECT u FROM IUser u where(SELECt)"

    }
}