/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GPASystem_Services;

//import GPASystem_entities.Course;
//import GPASystem_entities.Role;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pm.gradingsystem.entity.Role;

/**
 *
 * @author pkhanal
 */
@Stateless
@LocalBean
public class AdminService {
@PersistenceContext
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public void makeRole(Role role){
     em.persist(role);
 }
    public List<Role> getAllRoles() {
        return em.createQuery("SELECT c FROM Role c", Role.class).getResultList();
    }

    public Role getaRole(int i) {
        return em.find(Role.class,i);
    }
}
