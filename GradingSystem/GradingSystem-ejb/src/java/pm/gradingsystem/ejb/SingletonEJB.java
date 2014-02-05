/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.gradingsystem.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pm.gradingsystem.entity.IUser;

/**
 *
 * @author Tahmasebi
 */
@Startup
@Singleton
@LocalBean
public class SingletonEJB {

    @PersistenceContext
    private EntityManager em;

//    public IUser getUser(int id) {
//        IUser user = em.find(IUser.class, id);
//        return user;
//    }
//    @PostConstruct
//    public void create() {
//        em.persist(new IUser("john", "Green", "admin@admin.com", "admin", "4th St", 1234, "Delfi"));
//    }
}
