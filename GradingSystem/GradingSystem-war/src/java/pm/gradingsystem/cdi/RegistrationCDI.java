/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.gradingsystem.cdi;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pm.gradingsystem.ejb.UserManagement;
import pm.gradingsystem.entity.IUser;
import pm.gradingsystem.entity.Role;

@Named
@RequestScoped
public class RegistrationCDI {
    private IUser user = new IUser();
    private List<IUser> users = new ArrayList<>();
    @EJB
    private UserManagement userService;
    @Inject
    private SessionCDI session;
    private String loginMessage;
    private List<String> rolesStrList;

    public List<String> getRolesStrList() {
        return rolesStrList;
    }

    public void setRolesStrList(List<String> rolesStrList) {
        this.rolesStrList = rolesStrList;
    }
    
    public IUser getUser() {
        this.user = session.getUser();
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
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

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }

public String finalUpdatestd(int id) {
        List<Role> troles = new ArrayList(user.getNum().length);

        for (int i : user.getNum()) {
            troles.add(userService.findRoles(i));
        }
        user.setRoles(troles);
        userService.update(user);
        String page = null;
        try {
            System.out.println("user.getUsername() = " + user.getUsername());
            user = session.getUser();
            System.out.println("login succeed");
            System.out.println(session.getPage());
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
        return page;
    }
    public RegistrationCDI() {
    }
    
}
