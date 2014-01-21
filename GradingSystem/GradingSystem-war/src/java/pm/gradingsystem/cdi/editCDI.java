/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.gradingsystem.cdi;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import pm.gradingsystem.ejb.UserManagement;
import pm.gradingsystem.entity.IUser;

@Named
@RequestScoped
public class editCDI {
    
    private boolean editable = false;
    
    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
    public boolean isEditable() {
        return editable;
    }
    @EJB
    private UserManagement userManagement;
    
    private List<IUser> users;
    private IUser user;
    
//    public IUser getUser() {
//        if (user == null) {
//            user = new IUser();
//        }
//        return user;
//    }
        public IUser getUser() {
        return user;
    }
    
    public void setUser(IUser user) {
       // this.user = user;
//        this.user=userManagement.
    }
    
    public List<IUser> getUsers() {
        return userManagement.getUsers();
    }
    
    public void setUsers(List<IUser> users) {
        this.users = users;
    }
    
    public void update() {
        userManagement.update(user);
    }

    public void delete() {
        userManagement.delete(user.getId());
    }

    public editCDI() {
        user = new IUser(null, null, null, null, null, 0, null);
    }
    
}
