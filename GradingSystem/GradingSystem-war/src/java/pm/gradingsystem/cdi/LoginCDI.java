/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.gradingsystem.cdi;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import pm.gradingsystem.ejb.LoginEJB;
import pm.gradingsystem.ejb.UserManagement;
import pm.gradingsystem.entity.IUser;
import pm.gradingsystem.entity.Role;
import pm.gradingsystem.exception.LoginFailException;

@Named
@RequestScoped
public class LoginCDI {

    @EJB
    private UserManagement userService;
    private IUser user;
    private int code;
    @EJB
    private LoginEJB loginEjb;
    @Inject
    private SessionCDI session;
    private String loginMessage;
    private String passwordQ;
    private String usernameR;
    private String answerR;
    private String SecurityCode;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSecurityCode() {
        return SecurityCode;
    }

    public void setSecurityCode(String SecurityCode) {
        this.SecurityCode = SecurityCode;
    }

    public String getUsernameR() {
        return usernameR;
    }

    public void setUsernameR(String usernameR) {
        this.usernameR = usernameR;
    }

    public String getAnswerR() {
        return answerR;
    }

    public void setAnswerR(String answerR) {
        this.answerR = answerR;
    }

    public String getPasswordQ() {
        return passwordQ;
    }

    public void setPasswordQ(String passwordQ) {
        this.passwordQ = passwordQ;
    }

    /**
     * Creates a new instance of LoginCDI
     */
    public LoginCDI() {
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
        //session.setUser(user);
        return "login";
    }

    public String login() {
        String page = null;
        try {
            loginEjb.login(user);
            System.out.println("login succeed");
            System.out.println(session.getPage());
            page = session.getPage();
            user = userService.find(user.getUsername(), user.getPassword());
            session.setUser(user);
            // authorization
//            String message = "";
//            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//            request.getSession().invalidate();
//            try {
//
//                //Login via the Servlet Context
//                request.login(user.getUsername(), user.getPassword());
//
//                //Retrieve the Principal
//                Principal principal = request.getUserPrincipal();
//
//                //Display a message based on the User role
//                if (request.isUserInRole("Administrator")) {
//                    message = "Username : " + principal.getName() + " You are an Administrator";
//                } else if (request.isUserInRole("Faculty")) {
//                    message = "Username : " + principal.getName() + " You are only a Faculty";
//                } else if (request.isUserInRole("Staff")) {
//                    message = "Username : " + principal.getName() + " You're Staff";
//                } else if (request.isUserInRole("Student")) {
//                    message = "Username : " + principal.getName() + " You're Student";
//                }
//
//                //Add the welcome message to the faces context
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
//                return "success";
//            } catch (ServletException e) {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "An Error Occured: Login failed", null));
//                e.printStackTrace();
//            }
//            return "failure";
            //end of authorization
//            page="adminpage";
        } catch (LoginFailException ex) {
            //  page = session.getPage();
            loginMessage = "No such user";
        }

        return page;
    }

    public String getLoginMessage() {
        return loginMessage;
    }
//    public LoginCDI() {
//    }

    public void forgotPassword() {
        try {
            IUser foundUser = loginEjb.findByuseranswer(user, passwordQ);
            loginMessage = "Your Password is " + foundUser.getPassword();
        } catch (NoResultException ex) {
            loginMessage = "No such user";
        }
//        if (passwordQ.equals(user.getSecuritAnswer())) {
//            loginMessage = user.getPassword();
//        } else {
//            loginMessage = "No such user";
//        }
    }

    public String check() {
        String page = null;
        try {
            //this.user = userService.getUser(id);
//            IUser foundUser = loginEjb.findByuseranswer(user, passwordQ);
            //loginEjb.validation(user.getUsername(),user.getSecurityCode());
            System.out.println("user.getUsername() = " + user.getUsername());
            user = session.getUser();
            userService.findByUserCode(user.getUsername(), code);
            System.out.println("login succeed");
            System.out.println(session.getPage());
            if (user.getFirstname() == null || user.getLastname() == null || user.getAddress() == null) {
                session.setUser(user);
                return "completeregisterforuser";
            }
            for (Role role : user.getRoles()) {
                if (role.getName().equals("Admin")) {
                    return "listusers";
                } else if (role.getName().equals("Staff")) {
                    return "searchstdbyid";
                }
                if (role.getName().equals("Faculty")) {
                    return "facultydashboard";
                }
                if (role.getName().equals("Student")) {
                    return "studentdashboard";
                }
            }
        } catch (Exception ex) {
            loginMessage = "The security code is wrong";
        }
//catch (LoginFailException ex) {
//            loginMessage = "The security code is wrong";
//        }
        return page;
    }

    public String logout() {
        String page = "";
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.getSession().invalidate();
        page = "index";
        return page;
    }
}
