/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.gradingsystem.cdi;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import pm.gradingsystem.ejb.LoginEJB;
import pm.gradingsystem.entity.IUser;
import pm.gradingsystem.exception.LoginFailException;

@Named
@RequestScoped
public class CodeCDI {

    private IUser user;
    @EJB
    private LoginEJB loginEjb;
    @Inject
    private SessionCDI session;
    private String loginMessage;
    private String SecurityCode;

    

    public String getSecurityCode() {
        return SecurityCode;
    }

    public void setSecurityCode(String SecurityCode) {
        this.SecurityCode = SecurityCode;
    }

    /**
     * Creates a new instance of LoginCDI
     */
    public CodeCDI() {
        user = new IUser(null, null, null, null, null, 0, null);
    }

//    public IUser getUser() {
//        return user;
//    }
    public IUser getUser() {
//        if (user == null) {
//            Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
//            if (principal != null) {
//                user = loginEjb.findByCredentials(principal.); // Find User by j_username.
//            }
//        }
        return user;
    }

    public String login(String page) {
        session.setPage(page);
        return "login";
    }

    public String login() {
        String page = null;
        try {
            loginEjb.login(user);
            System.out.println("login succeed");
            System.out.println(session.getPage());
            page = session.getPage();
        } catch (LoginFailException ex) {
            loginMessage = "No such user";
        }

        return page;
    }

    public String getLoginMessage() {
        return loginMessage;
    }

    public void forgotPassword() {
        
         try {
           IUser foundUser= loginEjb.findByuseranswer(user,SecurityCode);
            loginMessage="Your Password is " + foundUser.getPassword();
        } catch (NoResultException ex) {
            loginMessage="No such user";
        }
//        if (SecurityCode.equals(user.getSecuritAnswer())) {
//            loginMessage = user.getPassword();
//        } else {
//            loginMessage = "No such user";
//        }
    }
//    public String check() throws LoginFailException{
//        String page=null;
//     try {
//           loginEjb.validation(user);
//           page="dashboard";
//            
//        } catch (NoResultException ex) {
//            loginMessage="THe code is wrong";
//        }
//     return page;
//    }
     public String check() {
        String page = null;
        try {
            loginEjb.validation(user);
            System.out.println("login succeed");
            System.out.println(session.getPage());
            page="dashboard";
        } catch (LoginFailException ex) {
            loginMessage = "The security code is wrong";
        }

        return page;
    }
}
