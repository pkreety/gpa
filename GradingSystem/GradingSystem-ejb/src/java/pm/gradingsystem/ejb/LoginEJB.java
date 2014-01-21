/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.gradingsystem.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pm.gradingsystem.entity.IUser;
import pm.gradingsystem.exception.LoginFailException;

/**
 *
 * @author Tahmasebi
 */
@Stateless
@LocalBean
public class LoginEJB {

    @PersistenceContext
    private EntityManager em;

    public void login(IUser user) throws LoginFailException {
        System.out.println("loginnnn");
        try {
            findByCredentials(user);
        } catch (NoResultException ex) {
            throw new LoginFailException(ex.getMessage());
        }
    }

    public void validation(IUser user) throws LoginFailException {
        System.out.println("loginnnn");
        try {
            findByCode(user);
        } catch (NoResultException ex) {
            throw new LoginFailException(ex.getMessage());
        }
    }

    public IUser findByCode(IUser user) {
        TypedQuery<IUser> query = em.createQuery("SELECT u FROM IUser u WHERE u.username= :username AND u.securityCode = :securityCode", IUser.class);
        query.setParameter("username", user.getUsername());
        query.setParameter("securityCode", user.getSecurityCode());
        return query.getSingleResult();
    }

    public IUser findByCredentials(IUser user) {
        TypedQuery<IUser> query = em.createQuery("SELECT u FROM IUser u WHERE u.username = :username AND u.password = :password", IUser.class);
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        return query.getSingleResult();
    }
//    public IUser findByCredentials(IUser user) {
//        TypedQuery<IUser> query = em.createQuery("SELECT u FROM IUser u WHERE u.username = :username AND u.password = :password", IUser.class);
//        query.setParameter("username", user.getUsername());
//        query.setParameter("password", user.getPassword());
//        return query.getSingleResult();
//    }

    public IUser findByuseranswer(IUser user, String answer) {
        TypedQuery<IUser> query = em.createQuery("SELECT u FROM IUser u WHERE u.username = :username AND u.securitAnswer = :answer", IUser.class);
        query.setParameter("username", user.getUsername());
        query.setParameter("answer", answer);
        return query.getSingleResult();
    }

}
