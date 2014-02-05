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
import javax.inject.Named;
import pm.gradingsystem.ejb.UserManagement;
import pm.gradingsystem.entity.IUser;
import pm.gradingsystem.entity.Role;

@Named
@RequestScoped
public class CreateUserCDI {

    @EJB
    private UserManagement userManagement;

    private List<IUser> users;
    private IUser user;
    private boolean editable = false;
    @EJB
    AdminService adm;
    @EJB
    UserService userEJB;
    private String confpassword;
    private String loginMessage;

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }
    
    

    public String getConfpassword() {
        return confpassword;
    }

    public void setConfpassword(String confpassword) {
        this.confpassword = confpassword;
    }
    

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isEditable() {
        return editable;
    }

    public List<IUser> getUsers() {
        return userManagement.getUsers();
    }

    public void setUsers(List<IUser> users) {
        this.users = users;
    }

    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }

    private List<Role> rolesSelected = new ArrayList();
    private int[] num;

    public int[] getNum() {
        return num;
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

//List<IUser> users=new ArrayList<>();
    public String create() {
        String page = "";
        List<Role> rolenew = new ArrayList();
        for (int i = 0; i < num.length; i++) {

            rolenew.add(adm.getaRole(num[i]));

        }
        user.setRoles(rolenew);
        if(!user.getPassword().equals(confpassword)) {
        loginMessage="The Confirm password is not the same as password";
        return "";
        }
        userManagement.create(user);
        page = "listusers";
        return page;
    }

    public CreateUserCDI() {
        user = new IUser();
        
    }

    public void update() {
        userManagement.update(user);
    }
}
