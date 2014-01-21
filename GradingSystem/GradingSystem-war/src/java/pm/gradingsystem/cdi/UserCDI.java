/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.gradingsystem.cdi;

import GPASystem_Services.AdminService;
import GPASystem_Services.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pm.gradingsystem.ejb.LoginEJB;
import pm.gradingsystem.ejb.UserManagement;
import pm.gradingsystem.entity.IUser;
import pm.gradingsystem.entity.Role;
import pm.gradingsystem.exception.LoginFailException;

/**
 *
 * @author Tahmasebi
 */
@Named
@RequestScoped
public class UserCDI {

    private IUser user = new IUser();
    private List<String> rolesStrList;
    private List<IUser> users = new ArrayList<>();
    @EJB
    private UserManagement userService;
    @EJB
    private LoginEJB loginEjb;
    @Inject
    private SessionCDI session;
    private String loginMessage;
    private String SecurityCode;

    @EJB
    AdminService adm;
    @EJB
    UserService userEJB;

    private List<Role> rolesSelected = new ArrayList();
    private int[] num;

    public int[] getNum() {
        num = new int[roles.size()];
        for (int i = 0; i < roles.size(); i++) {
            num[i] = roles.get(i).getId();
            System.out.println(num[i]);

        }
        return num;
        //  return num;
    }

    public void setNum(int[] num) {
        this.num = num;
    }

    public List<Role> getRolesSelected() {
        return rolesSelected;
    }

    public void setRolesSelected(List<Role> rolesSelected) {
        this.rolesSelected = rolesSelected;
    }

    private List<Role> roles = new ArrayList<>();

    public List<Role> getRoles() {
        //adm.createRoles();
        setRoles(adm.getAllRoles());
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    public String getSecurityCode() {
        return SecurityCode;
    }

    public void setSecurityCode(String SecurityCode) {
        this.SecurityCode = SecurityCode;
    }

    public List<IUser> getUsers() {
        setUsers(userService.getUsers());
        rolesStrList = new ArrayList<>();
        for (IUser iUser : users) {
            String rolesStr = "";
            for (Role role : iUser.getRoles()) {
                rolesStr += role.getName() + "  ";
            }
            iUser.setRolesStr(rolesStr);
        }
        return users;
    }

    public void setUsers(List<IUser> users) {
        this.users = users;
    }

    public IUser getUser() {
        return user;
    }

//    public void setUser(IUser user) {
//        this.user = user;
//    }
    public UserCDI() {
    }

    public String updateUser(int id) {
        this.user = userService.getUser(id);
        return "editpage";
    }

    public String finalUpdate(int id) {
        // this.user=userService.getUser(id);
        List<Role> troles = new ArrayList(user.getNum().length);

        for (int i : user.getNum()) {
            troles.add(userService.findRoles(i));
        }
        user.setRoles(troles);
        userService.update(user);
        return "listusers";
    }

    public void delete(int id) {
        String page = "";
        //  this.user = userService.getUser(id);
        userService.delete(id);
//        page = "deletepage";
//        return page;
    }
//
//    public String check(int id) {
//        String page = null;
//        try {
//            this.user = userService.getUser(id);
//            loginEjb.validation(user);
//            System.out.println("login succeed");
//            System.out.println(session.getPage());
//            page = "dashboard";
//        } catch (LoginFailException ex) {
//            loginMessage = "The security code is wrong";
//        }
//
//        return page;
//    }
}
