/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.gradingsystem.cdi;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Named;
import pm.gradingsystem.ejb.UserManagement;
import pm.gradingsystem.entity.IUser;

@Named
@RequestScoped
public class UpdateCDI {

    @EJB
    private UserManagement ejb;

    private List<IUser> users;
    private IUser user;
    private HtmlDataTable datatableUsers;

    public HtmlDataTable getDatatableUsers() {
        return datatableUsers;
    }

    public void setDatatableUsers(HtmlDataTable datatableUsers) {
        this.datatableUsers = datatableUsers;
    }

    public IUser getUser() {
        if (user == null) {
            user = new IUser();
        }
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }

    public List<IUser> getUsers() {
        return ejb.getUsers();
    }

    public void setUsers(List<IUser> users) {
        this.users = users;
    }

    public String readUpdate() {
        String page = "";
       // System.out.println(user.getId());
        user = ejb.getUser(user.getId());
        page = "editpage";
        return page;
    }

    public String update() {
        String page = "";
//        System.out.println(user.getId());
//        try {
        ejb.update(user);
//        } catch (OptimisticLockException e) {
//            user = ejb.getIUser(user.getId());
        page = "list";
//        }
        return page;
    }

    public UpdateCDI() {
    }
}
